package io;

import java.io.Serializable;

public class PersonDTO implements Serializable{

	private String name;
	private int age;
	private double height;
	
	public PersonDTO(String name, int age, double height) 
	{
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	
}