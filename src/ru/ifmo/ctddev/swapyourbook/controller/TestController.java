package ru.ifmo.ctddev.swapyourbook.controller;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.helpers.Shop;
import ru.ifmo.ctddev.swapyourbook.helpers.Tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/test.jsp");
        // mv.addObject("pageName", "Login page");
        //logger.warn("Returning main view");
        return mv;
    }

    @RequestMapping(value = "getTags", method = RequestMethod.GET)
    public
    @ResponseBody
    String autocompleteRequestedString(@RequestParam String tagName) {
        System.out.println("########### REQUESTED STRING:" + tagName + " ############");

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(simulateSearchResult(tagName));
        } catch (JsonMappingException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Tag> simulateSearchResult(String tagName) {

        List<Tag> data = new ArrayList<Tag>();
        data.add(new Tag(1, "ruby"));
        data.add(new Tag(2, "rails"));
        data.add(new Tag(3, "c / c++"));
        data.add(new Tag(4, ".net"));
        data.add(new Tag(5, "python"));
        data.add(new Tag(6, "java"));
        data.add(new Tag(7, "javascript"));
        data.add(new Tag(8, "jscript"));

        List<Tag> result = new ArrayList<Tag>();

        // iterate a list and filter by tagName
        for (Tag tag : data) {
            if (tag.getTagName().contains(tagName)) {
                result.add(tag);
            }
        }

        return result;
    }

}
