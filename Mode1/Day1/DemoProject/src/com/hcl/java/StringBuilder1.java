package com.hcl.java;

public class StringBuilder1 {
	public void show(int age,String name,String course,String city)
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
			System.out.println("age is "+ age);
		System.out.println("name is " + name);
		System.out.println("course " + course);
		System.out.println("city" + city);
		}
		else
		{
			System.out.println(sbError);
		}
	}
	public static void main(String[] args) {
		int age;
		String name;
		String course;
		String city;
		age=21;
		name="sai kumar";
		course="java`"
				+ ""
				+ "";
		city="chennai";
		
StringBuilder1 obj=new StringBuilder1();
		obj.show(age,name,course,city);
		
	}

}
