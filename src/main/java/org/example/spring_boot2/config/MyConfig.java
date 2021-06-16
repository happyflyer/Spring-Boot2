package org.example.spring_boot2.config;

import ch.qos.logback.core.db.DBHelper;
import org.example.spring_boot2.bean.Car;
import org.example.spring_boot2.bean.Pet;
import org.example.spring_boot2.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lifei
 */
@EnableConfigurationProperties(Car.class)
@ImportResource("classpath:beans.xml")
@ConditionalOnMissingBean(name = "tomcat")
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)
public class MyConfig {
    @Bean
    public User user02() {
        User user = new User("username02", 20);
        user.setPet(pet02());
        return user;
    }

    @Bean("tomcat")
    public Pet pet02() {
        return new Pet("tomcat02");
    }
}
