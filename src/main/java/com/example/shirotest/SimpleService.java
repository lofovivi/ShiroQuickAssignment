package com.example.shirotest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleService {

    private static Logger log = LoggerFactory.getLogger(SimpleService.class);

    @RequiresPermissions("write")
    public void writeRestrictedCall() {
        log.info("write permission!");
    }

    @RequiresPermissions("read")
    public void readRestrictedCall() {
        log.info("read permission!");
    }

}
