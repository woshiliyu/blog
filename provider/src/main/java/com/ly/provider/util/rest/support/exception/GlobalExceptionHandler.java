package com.ly.provider.util.rest.support.exception;


import com.ly.common.utils.rest.Result;
import com.ly.provider.util.rest.support.ServletUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public  Object  exceptionHandler(HttpServletRequest request , HttpServletResponse response ,Exception e){
        // 如果是ajax请求
        if (ServletUtils.isAjaxRequest(request)) {
            Result result = new Result();
            result.setRetCode(Result.RECODE_ERROR);
            result.setErrMsg(e.getMessage());
            return ServletUtils.renderString(response,result.toString());
        }
        else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("err", e);
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.setViewName("err");

            return modelAndView;
        }
    }

}
