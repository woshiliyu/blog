package com.ly.provider.config.authentication;//package com.ly.provider.config.authentication;



import com.ly.provider.config.authentication.filter.ValidateCodefilter;
import com.ly.provider.config.authentication.session.MySessionInformationExpiredStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationProvider provider;//自定义验证

    @Autowired
    private MyUserDetailsService myUserDetailsService;//自定义用户服务

    @Autowired
    private MySessionInformationExpiredStrategy mySessionInformationExpiredStrategy;//登录被踢掉时的自定义操作

    @Autowired
    private DataSource dataSource;

    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;//认证失败处理器

    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;//认证成功处理器

    @Autowired
    ValidateCodefilter validateCodefilter;//验证码过滤器

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }
    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login","/session/invalid","/imageCode")// 不需要登录就可以访问
//                .permitAll()
////               .antMatchers("/user/**").hasRole("USER")
////                .antMatchers("/ws").hasRole("USER")
//                .and()
//                .formLogin().loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//               // .defaultSuccessUrl("/ws")
//                .permitAll()
//                .failureHandler(myAuthenticationFailureHandler)
//                .successHandler(myAuthenticationSuccessHandler)
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
//
//                //记住我开始,场景：有这样一个场景——有个用户初访并登录了你的网站，
//                // 然而第二天他又来了，却必须再次登录。于是就有了“记住我”这样的功能来方便用户使用
//                .and()
//                .rememberMe()
////                .tokenRepository(persistentTokenRepository())//设置操作表的Repository
////                .tokenValiditySeconds(60 * 60 * 24 * 7)//设置记住我的时间为7天
////                .userDetailsService(myUserDetailsService)//设置userDetailsService
//
//                //记住我结束
//                .and()
//                .logout()
//                .logoutUrl("/signOut")//自定义退出的地址
//                .logoutSuccessUrl("/login")//退出之后跳转到注册页面
//                .deleteCookies("JSESSIONID")//删除当前的JSESSIONID
//                .and()
////               // session管理开始
//                .sessionManagement()
//                .invalidSessionUrl("/error");//session失效后会跳转到invalid
//              //  .maximumSessions(1);//最大session并发数量1
////                .maxSessionsPreventsLogin(false)//false之后登录踢掉之前登录,true则不允许之后登录
////               .expiredSessionStrategy(mySessionInformationExpiredStrategy);//登录被踢掉时的自定义操作
//
//
//
//
//        // 加http.csrf().disable()是为了防止报这个错Whitelabel Error Page
//       //This application has no explicit mapping for /error, so you are seeing this as a fallback.
//        http.csrf().disable();
//        http.addFilterBefore(validateCodefilter,UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(validateCodefilter, UsernamePasswordAuthenticationFilter.class) // 将ImageCodeFilter过滤器设置在UsernamePasswordAuthenticationFilter之前
                .authorizeRequests()
                .antMatchers("/authentication/*","/login/*","/imageCode","sys/article/list?__ajax=json") // 不需要登录就可以访问
                .permitAll()
                .antMatchers("/user/**").hasAnyRole("USER") // 需要具有ROLE_USER角色才能访问
                .antMatchers("/admin/**").hasAnyRole("ADMIN") // 需要具有ROLE_ADMIN角色才能访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/authentication/login") // 访问需要登录才能访问的页面，如果未登录，会跳转到该地址来
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                ;

    }
    // 密码加密方式
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(myUserDetailsService);
        builder.authenticationProvider(provider);
    }
}
