package com.hcl.obj;

import com.hcl.java.StringBuilder1;

public class SbExample {
	public StringBuilder show(int age,String name,String course,String city)
	{
		StringBuilder  sbError=new StringBuilder();
		boolean isvalid=true;
		if(age<=20)
		{
			sbError.append("age be greater than 20"+"\r\n");
		isvalid=false;
		}
		if(name.indexOf(' ')== -1)
		{
			sbError.append("name doesnot contains both first name and last name"+ "\r\n");
		      isvalid=false;
		}
		if(!course.equalsIgnoreCase("java"))
		{
			sbError.append("only java courseallowed" + "\r\n");
		      isvalid=false;
		}
		if(isvalid==true)
		{
			sbError.append("age is "+ age);
			sbError.append("name is " + name);
			sbError.append("course " + course);
			sbError.append("city" + city);
		}
		return sbError;
	}
	public static void main(String[] args) {
		int age;
		String name;
		String course;
		String city;
		age=21;
		name="sai kumar";
		course="java"
		city="chennai";
		
		SbExample obj1=new SbExample();
		StringBuilder sb=obj1.show(age, name, course, city);
		System.out.println(sb);
		
		//StringBuilder obj=new SbExample().show(age,name,course,city);

		//System.out.println(obj);
	}
	public StringBuilder show(String name, int status, String code) {
		// TODO Auto-generated method stub
		return null;
	}

}

