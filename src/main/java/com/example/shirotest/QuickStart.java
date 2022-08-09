package com.example.shirotest;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuickStart {
//    Todo:Finish the run() function with this class

    private static Logger log = LoggerFactory.getLogger(QuickStart.class);

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private  SimpleService simpleService;

    public void run(){

        Subject subject = SecurityUtils.getSubject();

        Assert.isTrue(!subject.isAuthenticated());


    }

}
