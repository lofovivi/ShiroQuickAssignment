package com.example.shirotest2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;


@Component
public class QuickStart {

    private static Logger log = LoggerFactory.getLogger(QuickStart.class);

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private SimpleService simpleService;

    public void run() {

        Subject subject = SecurityUtils.getSubject();

//        UsernamePasswordToken token = new UsernamePasswordToken("joe", "password");
        UsernamePasswordToken token = new UsernamePasswordToken("Frank", "12345");
        subject.login(token);
        simpleService.read();
        simpleService.writer();

        subject.logout();

        token = new UsernamePasswordToken("vivi", "12345");

        subject.login(token);
        simpleService.read();
        try {
            simpleService.writer();
        } catch (AuthorizationException e) {
            log.info("you have no permission to write");
        }

        subject.logout();
        Assert.isTrue(!subject.isAuthenticated());

    }

    @PostConstruct
    private void initStaticSecurityManager() {
        SecurityUtils.setSecurityManager(securityManager);
    }
}
