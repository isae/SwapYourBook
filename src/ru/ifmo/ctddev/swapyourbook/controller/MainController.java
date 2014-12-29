package ru.ifmo.ctddev.swapyourbook.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.dao.SearchDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.Shop;
import ru.ifmo.ctddev.swapyourbook.helpers.SuggestionItem;
import ru.ifmo.ctddev.swapyourbook.helpers.SuggestionList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

        logger.warn(requestedString);

        int result = (new SearchDAO()).getNumberOfIntersectingStrings(requestedString);

        logger.warn("searchRequestedString result is: " + result);
        return String.valueOf(result);
    }

    // TODO (POST -> GET)
    @RequestMapping(value = "autocomplete", produces = "text/html",method = RequestMethod.GET)
    public
    @ResponseBody
    String autocompleteRequestedString(@RequestParam String requestedString,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {

        System.out.println("########### REQUESTED STRING:" + requestedString + " ############");
        //return (new SearchDAO()).getSuggestionListForRequest(requestedString);
        String[] a = {"a", "b"};
        Shop shop = new Shop();
        shop.setName("MrChicken");
        shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(shop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
