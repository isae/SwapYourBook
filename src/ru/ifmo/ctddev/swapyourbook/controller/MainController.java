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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController implements MyLoggable{
    @Autowired
    SearchDAO searchDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/main.jsp");
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
            // todo mb remove tags -> only strings
            List<Tag> tags = new ArrayList<>(suggestions.size());
            for (int i = 0; i < suggestions.size(); ++i) {
                tags.add(new Tag(i, suggestions.get(i)));
            }

            return mapper.writeValueAsString(tags);
        } catch (IOException e) {
            logger.error("IO error:",e);
        }

        return null;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    String search(@RequestParam("requestedString") String requestedString,
                          @RequestParam("isByAuthor") boolean isByAuthor,
                          @RequestParam("isWithImages") boolean isWithImages,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        logger.warn(requestedString);
        List<SearchItem> list = searchDAO.getSearchList(requestedString, isByAuthor, isWithImages);
        // todo int result = (new SearchDAO()).getNumberOfIntersectingStrings(requestedString);
        // todo писать new SearchDAO не нужно :)
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(mapper);
        } catch (JsonMappingException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
