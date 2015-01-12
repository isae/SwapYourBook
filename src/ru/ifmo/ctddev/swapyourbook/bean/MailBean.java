package ru.ifmo.ctddev.swapyourbook.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.Mailer;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;

import javax.mail.MessagingException;
import java.math.BigInteger;
import java.util.Random;

/**
 * Created by root on 12/20/14.
 */
@Component
public class MailBean implements MyLoggable {
    @Autowired
    UserDAO userDAO;

    private Random random = new Random();

    private String generateAuthToken(){
        return new BigInteger(130, random).toString(32);
    }
    private static final String EMAIL_BODY = " <!DOCTYPE html>\n" +
            "<html>\n" +
            " <head>\n" +
            "  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n" +
            "  <title>Пожалуйста, подтвердите регистрацию на SwapYourBook</title>\n" +
            " </head>\n" +
            " <body>\n" +
            "<p>Пройдите по этой ссылке: <a href='%s'>ссылка</a></p>" +
            " </body>\n" +
            "</html>";

    public boolean sendAuthToken(String email, String username, String password) {
        String token = generateAuthToken();
        logger.warn("Generated token is:"+token);
        String link = "http://178.62.246.183:8080/SwapYourBook/login/handleAuthToken?authToken="+token;
        userDAO.addAuthToken(token,email,username,password);
        try {
            Mailer.send(email,
                    "Пожалуйста, подтвердите регистрацию на SwapYourBook",String.format(EMAIL_BODY,link));
        } catch (MessagingException e) {
            logger.error("Error during execution Mailer.send()",e);
            return false;
        }
        return true;
    }
}
