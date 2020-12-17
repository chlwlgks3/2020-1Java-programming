package Addressbook;

import java.io.Serializable;

public class Person implements Serializable{
	String name;
	String tel;
	int age;
	
	public Person(String name,String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "name:"+name+" tel:"+tel+" age: "+age;
	}
	
}
