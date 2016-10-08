package com.mycode.dynamicproxy;

/**
 * 反射的应用：动态代理
 * @author herdyouth
 *
 */
public class TestReflection3 {
	public static void main(String[] args) {
		// 1. 真实角色的对象
		RealityRole realRole = new RealityRole();
		// 2. 创建实现了InvocationHandler接口的类的对象
		MyInvocationHandler invocationHandler = new MyInvocationHandler();
		// 3. 调用关联的方法，动态地返回一个代理类的对象
		Object obj = invocationHandler.binder(realRole);
		CommonInterface com = (CommonInterface)obj;//此时com就是代理类的对象
		// 4. 调用相应的方法，进而调用的invoke()
		com.action();
	}
}
