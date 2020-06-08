package org.springframework.tests.aop.my;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

import static org.springframework.tests.TestResourceUtils.qualifiedResource;

/**
 * @author junxchen
 * @date 2020-06-05
 */
public class ProxyFactoryBeanTests {

    private static final Class<?> CLASS = ProxyFactoryBeanTests.class;
    private static final Resource DEPENDENT_BEANS_CONTEXT = qualifiedResource(CLASS, "myAop.xml");
    private DefaultListableBeanFactory dependentBeansFactory;


    @Before
    public void setUp() {
        // Interesting hierarchical factory to test counts.
        // Slow to read so we cache it.

        this.dependentBeansFactory = new DefaultListableBeanFactory();
        new XmlBeanDefinitionReader(this.dependentBeansFactory).loadBeanDefinitions(DEPENDENT_BEANS_CONTEXT);
    }

    @Test
    public void test1() {
        TestProxyInterface bean = (TestProxyInterface)dependentBeansFactory.getBean("proxyAop");
        System.out.println(bean.getClass());
        bean.service();
        System.out.println(1111);
    }


}
