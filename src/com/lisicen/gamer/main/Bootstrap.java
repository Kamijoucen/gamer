package com.lisicen.gamer.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by X6TI on 2017/5/28.
 */
public enum  Bootstrap {
    INSTANCE;
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    public ApplicationContext getContext() {
        return context;
    }
}
