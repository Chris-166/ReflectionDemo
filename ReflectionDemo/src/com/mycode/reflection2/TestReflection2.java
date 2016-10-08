package com.mycode.reflection2;

import com.mycode.reflection1.Person;

/**
 * 通过反射获取Class类实例的4种方法
 * @author herdyouth
 *
 */
public class TestReflection2 {
	public static void main(String[] args) {
		getClassInstance1();
		getClassInstance2();
		getClassInstance3();
		new TestReflection2().getClassInstance1();
	}
	
	/*1. 通过类.class属性获取*/
	public static void getClassInstance1() {
		Class clazz0 = String.class;
		System.out.println(clazz0);
		Class clazz = Person.class;
		try {
			Person person = (Person) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(clazz);
	}
	
	/*2. 通过运行时类的对象获取*/
	public static void getClassInstance2() {
		Person person = new Person();
		Class clazz = person.getClass();
		System.out.println(clazz);
	}
	
	/*3. 通过Class.forname()方法获取*/
	public static void getClassInstance3() {
		String className = "com.mycode.reflection1.Person";
		try {
			Class clazz = Class.forName(className);
			System.out.println(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*4. 通过类的加载器获取*/
	public void getClassInstance4() {
		String className = "com.mycode.reflection1.Person";
		ClassLoader classLoader = this.getClass().getClassLoader();
		try {
			Class clazz = classLoader.loadClass(className);
			System.out.println(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
