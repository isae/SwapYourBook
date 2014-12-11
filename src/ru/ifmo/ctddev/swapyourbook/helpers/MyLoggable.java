package ru.ifmo.ctddev.swapyourbook.helpers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by root on 12/5/14.
 */
public interface MyLoggable {
    final Log logger = LogFactory.getLog(MyLoggable.class);
}
