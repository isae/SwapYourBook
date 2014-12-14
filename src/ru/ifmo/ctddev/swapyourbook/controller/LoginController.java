package ru.ifmo.ctddev.swapyourbook.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.CommonDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 10/30/14.
 */
@Controller
@RequestMapping("/login")
public class LoginController implements MyLoggable{

    private CommonDAO commonDAO = new CommonDAO(true);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/login.jsp");
        mv.addObject("pageName", "Login page");
        logger.warn("Returning hello view");
        return mv;
    }

    @RequestMapping(value = "checkUsernameAvailable", method = RequestMethod.POST)
    public @ResponseBody String checkUsernameAvailable(@RequestParam("username") String username,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        boolean result = commonDAO.isUsernameAvailable(username);
        logger.warn("checkUsernameAvailable result is: "+result);
        return String.valueOf(result);
    }
}
