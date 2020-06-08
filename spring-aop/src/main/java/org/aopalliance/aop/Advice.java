/*
 * Copyright 2002-2016 the original author or authors.
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

package org.aopalliance.aop;

/**
 * Tag interface for Advice. Implementations can be any type
 * of advice, such as Interceptors.
 *
 * @author Rod Johnson
 * @version $Id: Advice.java,v 1.1 2004/03/19 17:02:16 johnsonr Exp $
 *
 * 定义在连接点做什么,目标方法的切面增强设计
 *
 * 切面由切点（pointcut）和增强（advice）组成，而advice中包含了增强的横切代码，pointcut包含了连接点的描述信息
 *
 * 其实Spring中提供的增强MethodBeforeAdvice、AfterReturningAdvice等，也包含了连接点信息，就是一个切面，最终都会被AdvisorRegister转换成Advisor
 * 所以说，Spring 中的Advisor就是横切面的抽象，包含切点和增强
 */
public interface Advice {

}
