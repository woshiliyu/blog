package com.ly.provider.config.authentication;



import com.ly.provider.sys.Service.TtUserService;
import com.ly.provider.sys.Service.UserService;
import com.ly.provider.sys.entity.Role;
import com.ly.provider.sys.entity.TtUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.List;
/**
 * 功能：根据前端页面传入的username来查询数据的用户以及角色
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
   // private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
    @Autowired
   TtUserService ttUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //数据库的用户
        TtUser ttUser;
        try {
            ttUser = ttUserService.selectUserByUserName(username);
           // logger.info("服务器用户名为="+userEntity.getUserName());
        } catch (Exception e) {
            throw new UsernameNotFoundException("查询报错");
        }
        if(ttUser == null)
        {
            throw new UsernameNotFoundException("用户不存在");
        }
        else
        {
            try {

                List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority("admin"));

                return new User(ttUser.getUserName(), ttUser.getPassword(), simpleGrantedAuthorities);
            } catch (Exception e) {
                throw new UsernameNotFoundException("查询用户权限报错");
            }

        }
    }
    /**
     * 权限字符串转化
     *
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     */
    private List<SimpleGrantedAuthority> createAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }
}
