package org.example.spring_boot2;

import ch.qos.logback.core.db.DBHelper;
import org.example.spring_boot2.bean.Pet;
import org.example.spring_boot2.bean.User;
import org.example.spring_boot2.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lifei
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // SpringApplication.run(MainApplication.class, args);

        // 获取IoC容器
        ConfigurableApplicationContext run = SpringApplication.run(
                MainApplication.class, args);
        // 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("==========");

        // 从容器中获取组件
        User user1 = run.getBean("user02", User.class);
        System.out.println(user1);
        Pet pet1 = run.getBean("tomcat", Pet.class);
        Pet pet2 = run.getBean("tomcat", Pet.class);
        System.out.println(pet1 == pet2);
        MyConfig myConfig = run.getBean(MyConfig.class);
        System.out.println(myConfig);
        System.out.println("==========");

        // Full模式与Lite模式
        User user2 = myConfig.user02();
        User user3 = myConfig.user02();
        System.out.println(user2 == user3);
        System.out.println("==========");

        // 组件依赖
        User user4 = myConfig.user02();
        Pet pet3 = myConfig.pet02();
        System.out.println(user4.getPet() == pet3);
        System.out.println("==========");

        // 全类名导入
        String[] beanNames = run.getBeanNamesForType(User.class);
        for (String name : beanNames) {
            System.out.println(name);
        }
        DBHelper dbHelper = run.getBean(DBHelper.class);
        System.out.println(dbHelper);
        System.out.println("==========");

        // 原生配置文件导入
        User user01 = run.getBean("user01", User.class);
        System.out.println(user01);
        Pet pet01 = run.getBean("pet01", Pet.class);
        System.out.println(pet01);
        System.out.println("==========");
    }
}
