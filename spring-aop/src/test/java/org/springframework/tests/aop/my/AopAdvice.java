package org.springframework.tests.aop.my;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author junxchen
 * @date 2020-06-05
 */
public class AopAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before......");
    }
}
