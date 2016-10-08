package com.mycode.reflection1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射获取对象的属性、方法等
 * @author herdyouth
 *
 */
public class TestReflection1 {
	public static void main(String[] args) {
		noReflection();
		System.out.println("=======反射之后========");
		testReflection1();
		testReflection2();
	}
	
	/*不使用反射*/
	public static void noReflection() {
		// 1 获取对象
		Person person = new Person();
		// 2 获取对象的属性
		person.setId("12150203");
		person.setName("FanFF");
		person.setAge(18);
		System.out.println(person);
		// 3 调用对象的方法
		person.showDetail("男");
	}
	
	/*java.lang.Class为反射的源头,可以返回其运行时类
	 * 有了其运行时类就可以知道该类的父类、构造方法、异常的声明、注解、方法、接口等全部结构
	 * */
	public static void testReflection1() {
		Person person = new Person();
		Class clazz = person.getClass();// 通过运行时类的对象，返回其运行时类
		System.out.println(clazz);// class com.mycode.reflection.Person
	}
	
	/*使用反射来获取对象，进而再获取其方法、属性*/
	public static void testReflection2() {
		// 1. 创建clazz对应的运行时Person类的对象
		// Class<Person> clazz = Person.class;
		Class clazz = Person.class;
		try {
			Person person = (Person)clazz.newInstance();
			System.out.println(person);
			// 2 获取对象的public属性
			Field ageField = clazz.getField("age");
			ageField.set(person, 18);
			// 2.1 获取对象的非public属性(private\protected)
			Field idField = clazz.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(person, "12150203");
			// 2.2 获取对象的属性
			Field nameField = clazz.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(person, "FanFF");
			System.out.println(person);
			// 3. 调用运行是类的指定方法
			// 3.1 调用无参方法
			Method show = clazz.getMethod("show");
			show.invoke(person);
			// 3.2 调用有参方法，可变参数列表确定了方法重载时的指定方法
			Method showDetail1 = clazz.getMethod("showDetail", String.class);
			showDetail1.invoke(person, "男");
			Method showDetail2 = clazz.getMethod("showDetail", String.class, String.class);
			showDetail2.invoke(person, "男", "China");
			System.out.println(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
