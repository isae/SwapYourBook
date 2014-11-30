package ru.ifmo.ctddev.swapyourbook.test;

import junit.framework.TestCase;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.controller.HelloController;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by root on 11/23/14.
 */
public class HelloControllerTest extends TestCase {

    public void testHandleRequestView() {
        HelloController controller = new HelloController();
        ModelAndView modelAndView = null;
        try {
            modelAndView = controller.handleRequest(null, null);
            assertEquals("index.jsp", modelAndView.getViewName());
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            assertTrue("Controller thrown an Exception",false);
        }
    }
}
