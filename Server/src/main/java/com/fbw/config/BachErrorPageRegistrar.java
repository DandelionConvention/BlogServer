package com.fbw.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class BachErrorPageRegistrar implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage[] errorPages = new ErrorPage[]{
          new ErrorPage(HttpStatus.FORBIDDEN,"/static/error/403.html"),
          new ErrorPage(HttpStatus.NOT_FOUND,"/static/error/404.html"),
          new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/static/error/500.html")
        };

        registry.addErrorPages(errorPages);
    }
}
