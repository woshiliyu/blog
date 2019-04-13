package com.ly.provider.config.authentication.session;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liyu on 2018/5/12.
 * 功能：登录被踢掉时的自定义操作
 */
@Component
public class MySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    private static final Logger logger = LoggerFactory.getLogger(MySessionInformationExpiredStrategy.class);
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        logger.info("并发登陆，不好意思，你被踢出登陆了");
        HttpServletResponse response=  sessionInformationExpiredEvent.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("并发登陆，不好意思，你被踢出登陆了");
    }
}
