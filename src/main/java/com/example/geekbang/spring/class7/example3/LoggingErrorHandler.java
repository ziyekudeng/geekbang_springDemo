package com.example.geekbang.spring.class7.example3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ErrorHandler;

/**
 * @program: geekbang_springDemo
 * @description: 最终事件的执行是由同一个线程按顺序来完成的，任何一个报错，都会导致后续的监听器执行不了。
 * @author: gao wei
 * @create: 2022-01-27 13:54
 */
public class LoggingErrorHandler {

    public static final ErrorHandler LOG_AND_SUPPRESS_ERROR_HANDLER = new MyLoggingErrorHandler();

    private static class MyLoggingErrorHandler implements ErrorHandler {

        private final Log logger = LogFactory.getLog(LoggingErrorHandler.class);

        @Override
        public void handleError(Throwable t) {
            logger.error("Unexpected error occurred in scheduled task", t);
        }
    }
}
