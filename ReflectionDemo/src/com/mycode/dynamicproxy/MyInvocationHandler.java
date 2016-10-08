package com.mycode.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

	Object obj = null;// 实现了接口的真实角色的对象的声明
	
	/*1. 实例化真实角色；2. 返回代理角色的对象*/
	public Object binder(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	/*当通过代理角色的对象发起对被重写的方法的调用时，
	 * 都会转换为对如下的invoke方法的调用*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object returnValue = method.invoke(obj, args);
		return returnValue;
	}

}
