package com.ly.provider.sys.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class LoginController {
    @GetMapping("/authentication/login")
    public String authenticationLogin() throws IOException {
        return "login";
    }
}
