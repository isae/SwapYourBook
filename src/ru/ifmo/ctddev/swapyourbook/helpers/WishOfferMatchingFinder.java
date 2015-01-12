package ru.ifmo.ctddev.swapyourbook.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ru.ifmo.ctddev.swapyourbook.dao.BookDAO;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserOffer;
import ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.UserWish;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by root on 1/11/15.
 */
public class WishOfferMatchingFinder implements MyLoggable {
    private static final int RATE = 60*60;//every hour
    private static final int DELAY = 1;
    private static final String EMAIL_TOPIC = "Мы нашли людей, у которых есть та книга, которая вам нужна!";
    private static final String EMAIL_BODY = " <!DOCTYPE html>\n" +
            "<html>\n" +
            " <head>\n" +
            "  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n" +
            "  <title>%s</title>\n" +
            " </head>\n" +
            " <body>\n" +
            "<p>Вы можете написать этим людям по поводу %s: \"%s\":</p>" +
            "%s" +
            " </body>\n" +
            "</html>";

    private static final String USER_MAILTO = "<h4><a href=\"mailto:%s\">%s</a></h4>";

    @Autowired
    BookDAO bookDAO;
    @Autowired
    UserDAO userDAO;

    @Scheduled(initialDelay = DELAY * 1000, fixedRate = RATE * 1000)
    public void sendMailsAboutFindingMatch() {
        List<UserWish> wishes = bookDAO.getAllPendingWishes();
        for (UserWish wish : wishes) {
            try {
                User toSend = userDAO.getUser(wish.getOwner());
                List<User> users = bookDAO.findUsersWithMatchingBooks(wish);
                if(!users.isEmpty()){
                StringBuilder mailTos = new StringBuilder();
                for (User user : users) {
                    mailTos.append(String.format(USER_MAILTO, user.getEmail(), user.getUsername()));
                }
                Mailer.send(toSend.getEmail(),
                        EMAIL_TOPIC,
                        String.format(EMAIL_BODY, EMAIL_TOPIC, wish.getAuthor(), wish.getTitle(), mailTos));
                wish.setMessageSent(wish.getMessageSent()+1);
                bookDAO.updateWish(wish);}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
