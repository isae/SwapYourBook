package ru.ifmo.ctddev.swapyourbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(value = "/book")
public class BookController implements MyLoggable {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUserPage(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("user.jsp");
    }

    @RequestMapping(value="/addBook",method = RequestMethod.POST)
    public  ModelAndView  getUserBooks(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("book_add.jsp");
        return mav;
    }
}
