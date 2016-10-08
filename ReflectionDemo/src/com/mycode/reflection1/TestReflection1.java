package com.mycode.reflection1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���÷����ȡ��������ԡ�������
 * @author herdyouth
 *
 */
public class TestReflection1 {
	public static void main(String[] args) {
		noReflection();
		System.out.println("=======����֮��========");
		testReflection1();
		testReflection2();
	}
	
	/*��ʹ�÷���*/
	public static void noReflection() {
		// 1 ��ȡ����
		Person person = new Person();
		// 2 ��ȡ���������
		person.setId("12150203");
		person.setName("FanFF");
		person.setAge(18);
		System.out.println(person);
		// 3 ���ö���ķ���
		person.showDetail("��");
	}
	
	/*java.lang.ClassΪ�����Դͷ,���Է���������ʱ��
	 * ����������ʱ��Ϳ���֪������ĸ��ࡢ���췽�����쳣��������ע�⡢�������ӿڵ�ȫ���ṹ
	 * */
	public static void testReflection1() {
		Person person = new Person();
		Class clazz = person.getClass();// ͨ������ʱ��Ķ��󣬷���������ʱ��
		System.out.println(clazz);// class com.mycode.reflection.Person
	}
	
	/*ʹ�÷�������ȡ���󣬽����ٻ�ȡ�䷽��������*/
	public static void testReflection2() {
		// 1. ����clazz��Ӧ������ʱPerson��Ķ���
		// Class<Person> clazz = Person.class;
		Class clazz = Person.class;
		try {
			Person person = (Person)clazz.newInstance();
			System.out.println(person);
			// 2 ��ȡ�����public����
			Field ageField = clazz.getField("age");
			ageField.set(person, 18);
			// 2.1 ��ȡ����ķ�public����(private\protected)
			Field idField = clazz.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(person, "12150203");
			// 2.2 ��ȡ���������
			Field nameField = clazz.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(person, "FanFF");
			System.out.println(person);
			// 3. �������������ָ������
			// 3.1 �����޲η���
			Method show = clazz.getMethod("show");
			show.invoke(person);
			// 3.2 �����вη������ɱ�����б�ȷ���˷�������ʱ��ָ������
			Method showDetail1 = clazz.getMethod("showDetail", String.class);
			showDetail1.invoke(person, "��");
			Method showDetail2 = clazz.getMethod("showDetail", String.class, String.class);
			showDetail2.invoke(person, "��", "China");
			System.out.println(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
