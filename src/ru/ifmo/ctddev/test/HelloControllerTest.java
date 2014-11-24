package ru.ifmo.ctddev.test;

import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.ifmo.ctddev.dao.CommonDAO;
import ru.ifmo.ctddev.web.controller.HelloController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by root on 11/23/14.
 */
public class HelloControllerTest extends TestCase {

    public void testHandleRequestView() throws Exception {
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello.jsp", modelAndView.getViewName());
    }
}
