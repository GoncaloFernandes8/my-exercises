package io.codeforall.fanstatics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");



        System.out.println(userService.getUserById(1));
        System.out.println("---------------------------------");
        System.out.println(userService.createUser("João"));
    }
}
