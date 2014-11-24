package ru.ifmo.ctddev.test;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.dao.CommonDAO;
import ru.ifmo.ctddev.web.controller.HelloController;

import java.util.Set;

import static junit.framework.Assert.assertTrue;

/**
 * Created by root on 11/24/14.
 */
public class DatabaseConnectionTest extends TestCase{

    public void testDatabaseConnection() throws Exception{
        CommonDAO commonDAO = new CommonDAO(true);
        Set<String> usernames = commonDAO.getAllUserNames();
        assertTrue(usernames.contains("isaev"));
        assertTrue(usernames.contains("mazin"));
    }
}
