package com.mycode.dynamicproxy;

/**
 * �����Ӧ�ã���̬����
 * @author herdyouth
 *
 */
public class TestReflection3 {
	public static void main(String[] args) {
		// 1. ��ʵ��ɫ�Ķ���
		RealityRole realRole = new RealityRole();
		// 2. ����ʵ����InvocationHandler�ӿڵ���Ķ���
		MyInvocationHandler invocationHandler = new MyInvocationHandler();
		// 3. ���ù����ķ�������̬�ط���һ��������Ķ���
		Object obj = invocationHandler.binder(realRole);
		CommonInterface com = (CommonInterface)obj;//��ʱcom���Ǵ�����Ķ���
		// 4. ������Ӧ�ķ������������õ�invoke()
		com.action();
	}
}
