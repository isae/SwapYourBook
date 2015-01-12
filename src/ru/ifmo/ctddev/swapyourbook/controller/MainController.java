package ru.ifmo.ctddev.swapyourbook.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
// import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.SearchDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.*;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController extends MyController{
    @Autowired
    SearchDAO searchDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/main.jsp");
        mv.addObject("user", getCurrentUser());
        logger.warn("Returning main view");
        return mv;
    }


    @RequestMapping(value = "autocomplete", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String autocomplete(@RequestParam String requestedString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<String> suggestions = searchDAO.getAutocompleteList(requestedString);

            return mapper.writeValueAsString(suggestions);
        } catch (IOException e) {
            logger.error("IO error:", e);
        }

        return null;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    ModelAndView search(@RequestParam("requestedString") String requestedString,
                          @RequestParam("isByAuthor") boolean isByAuthor,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        logger.warn(requestedString);

        List<SearchItem> bookItems = searchDAO.getSearchList(requestedString, isByAuthor);
        ModelAndView mv = new ModelAndView("search_elements/main_search.jsp");

        logger.warn("Returning search books view");
        mv.addObject("bookItems", bookItems);
        return mv;
    }

}
