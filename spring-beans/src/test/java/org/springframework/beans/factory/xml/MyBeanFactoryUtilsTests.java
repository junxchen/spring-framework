/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.xml;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtilsTests;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.Resource;

import static org.springframework.tests.TestResourceUtils.qualifiedResource;

/**
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 04.07.2003
 */
public final class MyBeanFactoryUtilsTests {

    private static final Class<?> CLASS = BeanFactoryUtilsTests.class;
    private static final Resource DEPENDENT_BEANS_CONTEXT = qualifiedResource(CLASS, "dependentBeans.xml");

    private DefaultListableBeanFactory dependentBeansFactory;


    @Before
    public void setUp() {
        // Interesting hierarchical factory to test counts.
        // Slow to read so we cache it.

        this.dependentBeansFactory = new DefaultListableBeanFactory();
        new XmlBeanDefinitionReader(this.dependentBeansFactory).loadBeanDefinitions(DEPENDENT_BEANS_CONTEXT);
        dependentBeansFactory.preInstantiateSingletons();
    }


    @Test
    public void test1() {
        Object bean = dependentBeansFactory.getBean("myTestBean");
        System.out.println(bean.getClass());
    }

}
