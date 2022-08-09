package com.example.shirotest;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ShiroTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShiroTestApplication.class, args);

        context.getBean(QuickStart.class).run();

    }

    @Bean
    public Realm realm() {

        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("Frank=12345,user\n" +
                "Vivi=12345,admin\n");

        realm.setRoleDefinitions("admin=read,write\n" +
                                "user=read");

        realm.setCachingEnabled(true);
        return realm;
    }

}
