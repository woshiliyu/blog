package com.ly.provider.config.authentication.filter;


import com.ly.provider.config.authentication.image.ImageCode;
import com.ly.provider.config.authentication.validate.code.image.ImageCodeException;
import com.ly.provider.util.rest.support.HttpKit;



import org.apache.commons.lang3.StringUtils;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ValidateCodefilter extends OncePerRequestFilter {

    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
       String uri= request.getRequestURI();
        //如果为get请求并且请求uri为/login（也就是我们登录表单的form的action地址）
        String  aa= request.getMethod();
        if( StringUtils.equalsIgnoreCase(request.getMethod(),"post") && StringUtils.containsIgnoreCase(request.getRequestURI(),"/authentication/form"))
        {
            try {
                logger.info("ValidateCodefilter执行了----" + "request.getRequestURI()=" + uri);
                //这里需要验证前端传过来的验证码是否和session里面存的一致，并且要判断是否过期
                HttpKit.getRequest().getSession().getAttribute("imageCode");
//            (ImageCode)sessionStrategy.getAttribute(new ServletWebRequest(request) ,"imageCode");
                logger.info( HttpKit.getRequest().getSession().getAttribute("imageCode"));
                validateCode(new ServletWebRequest(request));
            } catch (ServletRequestBindingException e) {
                e.printStackTrace();
                return;
            }

        }

        filterChain.doFilter(request,response);
    }

    /**
     * 验证用户输入的验证码和session中存的是否一致
     * @param request
     */
    private void validateCode(ServletWebRequest request) throws ServletRequestBindingException {
     ImageCode codeInSerssion =(ImageCode) sessionStrategy.getAttribute(request,"imageCode");
      String codeInRequest=  ServletRequestUtils.getStringParameter(request.getRequest(),"imageCode");

      if(StringUtils.isBlank(codeInRequest)){
          throw  new ImageCodeException("验证码不能为空");
      }
      if(codeInSerssion ==null ){
          throw  new ImageCodeException("验证码不存在");
      }
      if(!(codeInSerssion.getCode().equals(codeInRequest)) ){
            throw  new ImageCodeException("验证码不正确");
      }
//      if(){
//          sessionStrategy.removeAttribute(request,"imageCode");
//          System.out.println("验证码过期");
//      }

        sessionStrategy.removeAttribute(request,"imageCode");
    }


}
