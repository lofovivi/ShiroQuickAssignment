package com.example.shirotest2;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleService {

    private static Logger log = LoggerFactory.getLogger((SimpleService.class));

    @RequiresPermissions("write")
    public void writer() {
        log.info("I am write ! ");
    }


    @RequiresPermissions("read")
    public void read() {
        log.info("I am reading!");
    }
}
