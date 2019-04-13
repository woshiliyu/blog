package com.ly.provider.config.authentication.validate.code.image;

import org.springframework.security.core.AuthenticationException;

public class ImageCodeException extends AuthenticationException {
    public ImageCodeException(String msg) {
        super(msg);
    }
}
