package ru.ifmo.ctddev.swapyourbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ru.ifmo.ctddev.swapyourbook.dao.UserDAO;
import ru.ifmo.ctddev.swapyourbook.helpers.MyLoggable;

/**
 * Created by root on 1/7/15.
 */
public class MyController implements MyLoggable{

    @Autowired
    private UserDAO userDAO;
    protected ru.ifmo.ctddev.swapyourbook.mybatis.gen.model.User getCurrentUser() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        Object o = a.getPrincipal();
        if(o instanceof User){
            return userDAO.getUser(((User) o).getUsername());
        } else return null;
    }
}
