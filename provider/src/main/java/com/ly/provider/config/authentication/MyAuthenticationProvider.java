package com.ly.provider.config.authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *功能：springSecurity验证前端输入的用户和数据库用户是否匹配
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try{
            // 根据用户输入的用户名获取该用户名已经在服务器上存在的用户详情，如果没有则返回null
            UserDetails userDetails =  this.myUserDetailsService.loadUserByUsername(authentication.getName());
            logger.info("数据库服务器上已经保存的用户名是：" + userDetails.getUsername());
            logger.info("数据库服务器上保存的该用户名对应的密码是： " + userDetails.getPassword());
            logger.info("数据库服务器上保存的该用户对应的权限是：" + userDetails.getAuthorities());

            //判断用户输入的密码和服务器上已经保存的密码是否一致
            if(authentication.getCredentials().equals(userDetails.getPassword())){
                logger.info("author success");
                //如果验证通过，将返回一个UsernamePasswordAuthenticaionToken对象
                return new UsernamePasswordAuthenticationToken(userDetails,
                        authentication.getCredentials(), userDetails.getAuthorities());
            }
        }catch (Exception e){
            logger.error("author failed, the error message is: " + e);

            throw e;
        }
        //如果验证不通过将抛出异常或者返回null
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }


}
