package ru.ifmo.ctddev.swapyourbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.helpers.GoogleBooksSearcher;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/20/14.
 */
@Controller
@RequestMapping("/books_search")
public class GoogleBooksController implements MyLoggable{

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getBooks(@RequestParam(value = "author",required = false) String author,
                                 @RequestParam(value = "title",required = false) String title,
            HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("books_search.jsp");
        List<ExtendedBook> books = new ArrayList<>();
        books.addAll(GoogleBooksSearcher.queryGoogleBooks(author,null,null));
        logger.warn("Returning books view");
        mv.addObject("books", books);
        return mv;
    }
}
