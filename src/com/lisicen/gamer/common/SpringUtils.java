package com.lisicen.gamer.common;

import com.lisicen.gamer.main.Bootstrap;
import org.springframework.context.ApplicationContext;

/**
 * Created by X6TI on 2017/5/28.
 */
public class SpringUtils {
    private static ApplicationContext context = Bootstrap.INSTANCE.getContext();

    public static  <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }
}
