package ru.ifmo.ctddev.swapyourbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.ifmo.ctddev.swapyourbook.bean.MailBean;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 10/30/14.
 */
@Controller
@RequestMapping("/login")
public class LoginController implements MyLoggable {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private MailBean mailBean;

    @Autowired
    @Qualifier("authenticationManager")
    AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier("securityContextRepository")
    SecurityContextRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/login.jsp");
        mv.addObject("pageName", "Login page");
        logger.warn("Returning hello view");
        return mv;
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/test.jsp");
        return mv;
    }

    @RequestMapping(value = "checkUsernameAvailable", method = RequestMethod.POST)
    public
    @ResponseBody
    String checkUsernameAvailable(@RequestParam("username") String username,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        boolean result = userDAO.isUsernameAvailable(username);
        logger.warn("checkUsernameAvailable result is: " + result);
        return String.valueOf(result);
    }

    @RequestMapping(value = "sendAuthToken", method = RequestMethod.POST)
    public
    @ResponseBody
    String sendAuthToken(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("username") String password,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        boolean result = mailBean.sendAuthToken(email, username, password);
        logger.warn("sendAuthToken result is: " + result);
        return String.valueOf(result);
    }

    @RequestMapping(value = "handleAuthToken", method = RequestMethod.GET)
    public RedirectView handleAuthToken(@RequestParam("authToken") String token,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        RedirectView redirectView = new RedirectView();
        User user = userDAO.processAuthToken(token);
        redirectView.setUrl("../login_user?username="+user.getUsername()+"&password="+user.getPassword());
        return redirectView;
    }
}
