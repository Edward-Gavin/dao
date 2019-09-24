package com.xiaokea.util;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-24 10:52
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SSMUtil {
    public static ApplicationContext getAC() {
        return new ClassPathXmlApplicationContext("bean.xml");
    }
}
