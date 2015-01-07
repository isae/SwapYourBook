package ru.ifmo.ctddev.swapyourbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;

import javax.mail.Multipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
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

    @RequestMapping(value = "/myBooks", method = RequestMethod.POST)
    public ModelAndView getUserBooks(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_books.jsp");
        return mav;
    }

    @RequestMapping(value = "/myWishes", method = RequestMethod.POST)
    public ModelAndView getUserWishes(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_wishes.jsp");
        return mav;
    }

    @RequestMapping(value = "/myOffers", method = RequestMethod.POST)
    public ModelAndView getUserOffers(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_offers.jsp");
        mav.addObject("userBooks", userDAO.getBooksByUserID(getCurrentUser().getUserid()));
        return mav;
    }

    @RequestMapping(value = "/mySaved", method = RequestMethod.POST)
    public ModelAndView getUserSaved(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_saved.jsp");
        return mav;
    }

    @RequestMapping(value = "/mySettings", method = RequestMethod.POST)
    public ModelAndView getUserSettings(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_settings.jsp");
        return mav;
    }

    @RequestMapping(value = "/addBook", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public String addBookToUser(@RequestParam("bookTitle") String title,
                                @RequestParam("authorName") String author,
                                @RequestParam("userID") Integer userID,
                                @RequestParam("bookDescription") String description,
                                @RequestParam("bookThumbnail") MultipartFile thumbnail,
                                MultipartHttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean result = bookDAO.addBookToUser(userID, author, title, description, thumbnail.getBytes());
        return String.valueOf(result);
    }
}
