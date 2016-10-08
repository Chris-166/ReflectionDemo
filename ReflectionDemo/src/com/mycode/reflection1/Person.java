package com.mycode.reflection1;

public class Person {
	
	private String id;
	protected String name;
	public int age;
	
	public Person() {
	}
	public Person(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void show() {
		System.out.println("���޾�����Ϣ");
	}
	public void showDetail(String sex) {
		System.out.println("�Ա�" + sex);
	}
	public void showDetail(String sex, String nation) {
		System.out.println("�Ա�" + sex + ", ������" + nation);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [id = " + id + ", name = " + name + ", age = " + age + "]";
	}
}
