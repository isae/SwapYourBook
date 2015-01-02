package ru.ifmo.ctddev.swapyourbook.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by root on 12/30/14.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController implements MyLoggable {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    ServletContext servletContext;

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
        User user = userDAO.getUser(1);
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping(value="/addBookWishForm",method = RequestMethod.POST)
    public  ModelAndView  getBookWishAdd(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("book_add.jsp");
        User user = userDAO.getUser(1);
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping(value = "/image", method=RequestMethod.GET)
    public @ResponseBody
    byte[] getImage(@RequestParam("imageID") int imageID) throws IOException {
        return userDAO.getImageByID(imageID);
    }
}
