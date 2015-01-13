package ru.ifmo.ctddev.swapyourbook.controller;

//import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.BookDAO;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserOffer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 12/30/14.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController extends MyController implements MyLoggable {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUserPage(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("user.jsp");
    }

    @RequestMapping(value = "/addBookForm", method = RequestMethod.POST)
    public ModelAndView getBookAddForm(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("book/book_add.jsp");
        mav.addObject("user", getCurrentUser());
        return mav;
    }

    @RequestMapping(value = "/editBookForm", method = RequestMethod.GET)
    public ModelAndView getBookEditForm(@RequestParam("userOfferID") int userOfferID,
                                        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav;
        UserOffer book = bookDAO.getUserOffer(userOfferID);
        User user = getCurrentUser();
        if (book!=null&&user.getUserid().equals(book.getOwner())) {
            mav = new ModelAndView("book/book_edit.jsp");
            mav.addObject("book", book);
        } else {
            mav = new ModelAndView("redirect:/user");
        }
        return mav;
    }

    @RequestMapping(value = "/deleteUserOffer", method = RequestMethod.GET)
    public String deleteBook(@RequestParam("userOfferID") int userOfferID,
                             HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        bookDAO.deleteUserOffer(userOfferID);
        return "redirect:/user";
    }

    @RequestMapping(value = "/editUserOffer", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public
    @ResponseBody
    String editBook(@RequestParam("bookTitle") String title,
                    @RequestParam("authorName") String author,
                    @RequestParam("bookID") Integer bookID,
                    @RequestParam("bookDescription") String description,
                    @RequestParam(value = "bookThumbnail", required = false) MultipartFile thumbnail,
                    MultipartHttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = 1;
        byte[] image = thumbnail != null ? thumbnail.getBytes() : null;
        bookDAO.tryToEditBook(userID, bookID, title, author, description, image);
        return "OK";
    }

    @RequestMapping(value = "/addBookWishForm", method = RequestMethod.POST)
    public ModelAndView getBookWishAddForm(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("book/book_wish_add.jsp");
        mav.addObject("user", getCurrentUser());
        return mav;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public
    @ResponseBody
    byte[] getImage(@RequestParam("imageID") int imageID) throws IOException {
        return userDAO.getImageByID(imageID);
    }
}
