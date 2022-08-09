package com.example.shirotest2;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class ShiroTest2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ShiroTest2Application.class, args);

        context.getBean(QuickStart.class).run();
    }


    @Bean
    public Realm realm() {

        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("Frank=12345,admin\n" + "vivi=12345,user");
        realm.setRoleDefinitions("admin=read,write\n" + "user=read");
        realm.setCachingEnabled(true);
        return realm;
    }
//    @Bean
//    public Realm realm() {
//        TextConfigurationRealm realm = new TextConfigurationRealm();
//        realm.setUserDefinitions("joe=password,user\n" +
//                "jill.coder=password,admin");
//
//        realm.setRoleDefinitions("admin=read,write\n" +
//                "user=read");
//        realm.setCachingEnabled(true);
//        return realm;
//    }

}
