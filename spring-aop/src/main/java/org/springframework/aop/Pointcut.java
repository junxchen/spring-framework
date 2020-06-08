/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.aop;

/**
 * Core Spring pointcut abstraction.
 *
 * <p>A pointcut is composed of a {@link ClassFilter} and a {@link MethodMatcher}.
 * Both these basic terms and a Pointcut itself can be combined to build up combinations
 * (e.g. through {@link org.springframework.aop.support.ComposablePointcut}).
 *
 * @author Rod Johnson
 * @see ClassFilter
 * @see MethodMatcher
 * @see org.springframework.aop.support.Pointcuts
 * @see org.springframework.aop.support.ClassFilters
 * @see org.springframework.aop.support.MethodMatchers
 *
 * 切点，决定Advice通知应该作用于哪个连接点,也就是说通过Pointcut来定义需要增强的方法的集合,即关注点
 *
 * 切面由切点（pointcut）和增强（advice）组成，而advice中包含了增强的横切代码，pointcut包含了连接点的描述信息
 *
 * 其实Spring中提供的增强MethodBeforeAdvice、AfterReturningAdvice等，也包含了连接点信息，就是一个切面，最终都会被AdvisorRegister转换成Advisor
 * 所以说，Spring 中的Advisor就是横切面的抽象，包含切点和增强
 */
public interface Pointcut {

	/**
	 * Return the ClassFilter for this pointcut.
	 * @return the ClassFilter (never {@code null})
	 * 类过滤器，定位到特定的类上
	 */
	ClassFilter getClassFilter();

	/**
	 * Return the MethodMatcher for this pointcut.
	 * @return the MethodMatcher (never {@code null})
	 *
	 * 由这个MethodMatcher来判断是否需要对当前方法调用进行增强，或者是否需要对当前调用方法应用配置好的Advice通知
	 * 方法匹配器，定位到特定的方法上
	 */
	MethodMatcher getMethodMatcher();


	/**
	 * Canonical Pointcut instance that always matches.
	 * 使用静态类常量持有单例对象，私有化构造函数
	 */
	Pointcut TRUE = TruePointcut.INSTANCE;

}
