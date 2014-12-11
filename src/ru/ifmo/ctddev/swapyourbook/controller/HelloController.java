package ru.ifmo.ctddev.swapyourbook.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController implements MyLoggable{

    @RequestMapping(value ="/hello.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning hello view");
        return new ModelAndView("index.jsp");
    }
}
