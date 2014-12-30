package ru.ifmo.ctddev.swapyourbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 12/30/14.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController implements MyLoggable {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUserPage(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("user.jsp");
    }

    @RequestMapping(value="/myBooks",method = RequestMethod.POST)
    public  ModelAndView  getUserBooks(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_books.jsp");
        return mav;
    }

    @RequestMapping(value="/myWishes",method = RequestMethod.POST)
    public ModelAndView getUserWishes(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_wishes.jsp");
        return mav;
    }

    @RequestMapping(value="/myOffers",method = RequestMethod.POST)
    public ModelAndView getUserOffers(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_offers.jsp");
        return mav;
    }

    @RequestMapping(value="/mySaved",method = RequestMethod.POST)
    public ModelAndView getUserSaved(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_saved.jsp");
        return mav;
    }
    @RequestMapping(value="/mySettings",method = RequestMethod.POST)
    public ModelAndView getUserSettings(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user_page/user_settings.jsp");
        return mav;
    }
}
