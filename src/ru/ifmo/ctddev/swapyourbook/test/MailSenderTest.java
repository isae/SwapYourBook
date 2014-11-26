package ru.ifmo.ctddev.swapyourbook.test;

import junit.framework.TestCase;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.ctddev.swapyourbook.controller.HelloController;
import ru.ifmo.ctddev.swapyourbook.helpers.Mailer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Created by root on 11/26/14.
 */
public class MailSenderTest extends TestCase {

    public void testMailSending() {
//todo do not push that to our repo
        /*try {
            Mailer.send("ilyha.hackmorda", "olo547OLO", "kim@rain.ifmo.ru", "This is test message", "Hello, little fucker!");
        } catch (MessagingException e) {
            e.printStackTrace();
            assertTrue("Mailer thrown an Exception",false);
        }*/
    }
}
