package com.mycode.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

	Object obj = null;// ʵ���˽ӿڵ���ʵ��ɫ�Ķ��������
	
	/*1. ʵ������ʵ��ɫ��2. ���ش����ɫ�Ķ���*/
	public Object binder(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	/*��ͨ�������ɫ�Ķ�����Ա���д�ķ����ĵ���ʱ��
	 * ����ת��Ϊ�����µ�invoke�����ĵ���*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object returnValue = method.invoke(obj, args);
		return returnValue;
	}

}
