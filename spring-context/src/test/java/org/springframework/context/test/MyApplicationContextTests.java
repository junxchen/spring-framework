package org.springframework.context.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author junxchen
 * @date 2020-06-10
 */
public class MyApplicationContextTests {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/org/springframework/context/test/config-bean.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);
        System.out.println(bean);
    }
}
