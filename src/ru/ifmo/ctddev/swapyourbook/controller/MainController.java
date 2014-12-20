package ru.ifmo.ctddev.swapyourbook.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.SearchDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/main")
public class MainController {
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/main.jsp");
        // mv.addObject("pageName", "Login page");
        logger.warn("Returning main view");
        return mv;
    }

    @RequestMapping(value = "searchRequestedString", method = RequestMethod.POST)
    public
    @ResponseBody
    String searchRequestedString(@RequestParam("reqString") String requestedString,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        logger.warn("Gonna do it");
        logger.warn(requestedString);

        int result = (new SearchDAO()).getNumberOfIntersectingStrings(requestedString);

        logger.warn("searchRequestedString result is: " + result);
        return String.valueOf(result);
    }
}
