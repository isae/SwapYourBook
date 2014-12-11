package ru.ifmo.ctddev.swapyourbook.test;

import junit.framework.TestCase;
import org.springframework.stereotype.Component;
import ru.ifmo.ctddev.swapyourbook.dao.CommonDAO;

import java.util.Set;

import static junit.framework.Assert.assertTrue;

/**
 * Created by root on 11/24/14.
 */
@Component
public class DatabaseConnectionTest extends TestCase{

    public void testDatabaseConnection() {
        CommonDAO commonDAO = new CommonDAO(true);
        Set<String> usernames = commonDAO.getAllUserNames();
        assertTrue(usernames.contains("isaev"));
        assertTrue(usernames.contains("mazin"));
    }
}
