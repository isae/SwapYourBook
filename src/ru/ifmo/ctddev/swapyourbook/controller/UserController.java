package ru.ifmo.ctddev.swapyourbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.BookDAO;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.helpers.Tag;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 12/30/14.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends MyController implements MyLoggable {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookDAO bookDAO;



    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUserPage(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user.jsp");
        User user = getCurrentUser();
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteCurrentUser(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userDAO.deleteUser(getCurrentUser());
        return "redirect:/logout_user";
    }

    @RequestMapping(value = "/myWishes", method = RequestMethod.POST)
    public ModelAndView getUserWishes(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_wishes.jsp");
        return mav;
    }

    @RequestMapping(value = "/addBookWish", method = RequestMethod.POST)
    public @ResponseBody String addUserWish(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        return "success";
    }

    @RequestMapping(value = "/myOffers", method = RequestMethod.POST)
    public ModelAndView getUserOffers(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_offers.jsp");
        mav.addObject("userOffers", userDAO.getOffersByUserID(getCurrentUser().getUserid()));
        return mav;
    }

    @RequestMapping(value = "/mySettings", method = RequestMethod.POST)
    public ModelAndView getUserSettings(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_settings.jsp");
        User user = getCurrentUser();
        mav.addObject("user", user);
        mav.addObject("city", bookDAO.getCityByID(user.getCityid()));
        return mav;
    }

    @RequestMapping(value = "/addOffer", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public String addOfferToUser(@RequestParam("bookTitle") String title,
                                 @RequestParam("authorName") String author,
                                 @RequestParam("userID") Integer userID,
                                 @RequestParam("bookDescription") String description,
                                 @RequestParam("bookThumbnail") MultipartFile thumbnail,
                                 MultipartHttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean result = bookDAO.addOfferToUser(userID, author, title, description, thumbnail.getBytes());
        return String.valueOf(result);
    }

    @RequestMapping(value = "/editUser", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public
    @ResponseBody
    String editBook(@RequestParam(value = "userFirstName", required = false, defaultValue = "") String userFirstName,
                    @RequestParam(value = "userLastName", required = false, defaultValue = "") String userLastName,
                    @RequestParam(value = "userEMail") String userEmail,
                    @RequestParam(value = "userCity", required = false, defaultValue = "") String userCity,
                    @RequestParam(value = "cityID") Integer cityID,
                    @RequestParam(value = "userAvatar", required = false) MultipartFile avatar,
                    MultipartHttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        byte[] bytes = avatar != null ? avatar.getBytes() : null;
        userDAO.editUser(getCurrentUser(), userFirstName, userLastName, userEmail, userCity, cityID, bytes);
        return "success";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String,Object> changePassword(@RequestParam(value = "oldPassword", required = false, defaultValue = "") String oldPassword,
                    @RequestParam(value = "newPassword", required = false, defaultValue = "") String newPassword,
                    @RequestParam(value = "confirmPassword", required = false, defaultValue = "") String confirmPassword,
                    HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> result = new HashMap<>();
        User user = getCurrentUser();
        boolean mustUpdate = true;
        if(newPassword.isEmpty()){
            result.put("key","error");
            result.put("value", "Пароль не может быть пустым");
            mustUpdate = false;
        }
        if(!newPassword.equals(confirmPassword)){
            result.put("key","error");
            result.put("value", "Пароли не совпадают");
            mustUpdate = false;
        }
        if(!user.getPassword().equals(oldPassword)){
            result.put("key","error");
            result.put("value", "Неверно указан старый пароль");
            mustUpdate = false;
        }
        if(mustUpdate){
            result.put("key","info");
            result.put("value", "Пароль успешно изменён");
            userDAO.changePassword(user,newPassword);
        }
        return result;
    }

    @RequestMapping(value = "/addOffer/authorAutocomplete", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String authorAutocomplete(@RequestParam String requestedString) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<String> suggestions = userDAO.getAutocompleteList(requestedString, true);

            for (int i = 0; i < suggestions.size(); ++i) {
                System.out.println("##" + i + " " + suggestions.get(i));
            }

            // todo mb remove tags -> only strings
            List<Tag> tags = new ArrayList<>(suggestions.size());
            for (int i = 0; i < suggestions.size(); ++i) {
                tags.add(new Tag(i, suggestions.get(i)));
            }

            return mapper.writeValueAsString(tags);
        } catch (IOException e) {
            logger.error("IO error:", e);
        }

        return null;
    }

    @RequestMapping(value = "/addOffer/titleAutocomplete", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String titleAutocomplete(@RequestParam String requestedString) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<String> suggestions = userDAO.getAutocompleteList(requestedString, false);

            for (int i = 0; i < suggestions.size(); ++i) {
                System.out.println("##" + i + " " + suggestions.get(i));
            }

            // todo mb remove tags -> only strings
            List<Tag> tags = new ArrayList<>(suggestions.size());
            for (int i = 0; i < suggestions.size(); ++i) {
                tags.add(new Tag(i, suggestions.get(i)));
            }

            return mapper.writeValueAsString(tags);
        } catch (IOException e) {
            logger.error("IO error:", e);
        }

        return null;
    }

    @RequestMapping(value = "/addOffer/cityAutocomplete", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String cityAutocomplete(@RequestParam String requestedString) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<String> suggestions = userDAO.getAutocompleteListByCities(requestedString);

            for (int i = 0; i < suggestions.size(); ++i) {
                System.out.println("##" + i + " " + suggestions.get(i));
            }

            // todo mb remove tags -> only strings
            List<Tag> tags = new ArrayList<>(suggestions.size());
            for (int i = 0; i < suggestions.size(); ++i) {
                tags.add(new Tag(i, suggestions.get(i)));
            }

            return mapper.writeValueAsString(tags);
        } catch (IOException e) {
            logger.error("IO error:", e);
        }

        return null;
    }
}
