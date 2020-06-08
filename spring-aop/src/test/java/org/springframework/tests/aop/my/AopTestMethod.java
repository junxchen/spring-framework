package org.springframework.tests.aop.my;

/**
 * @author junxchen
 * @date 2020-06-05
 */
public class AopTestMethod implements TestProxyInterface {
    @Override
    public void service() {

        System.out.println("Service method");
    }
}
