package com.ly.provider.config.authentication;//package com.ly.provider.config.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
* 功能：自定义认证成功处理器
*/

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        PrintWriter out = httpServletResponse.getWriter();
//        String s = "{\"status\":\"success\",\"msg\":\"登录认证成功\"}";
//        out.write(s);
//        out.flush();
//        out.close();

        httpServletResponse.sendRedirect("/sys/article/list?page=1&limit=10");

    }
}
