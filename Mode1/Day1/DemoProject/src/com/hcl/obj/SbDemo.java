package com.hcl.obj;
import com.hcl.java.StringBuilder1;

public class SbDemo {
	public StringBuilder show(String name,int status,String code)
	{
		StringBuilder  sbError=new StringBuilder();
		boolean isvalid=true;
		if(name.charAt(0)!='A')
		{
			sbError.append("should start with A"+"\r\n");
		isvalid=false;
		}
		if(name.indexOf(' ')== -1)
		{
			sbError.append("name  contains both first name and last name"+ "\r\n");
		      isvalid=false;
		}
		if(name.length()>20)
		{
			sbError.append("it should not contain more than 20letters" + "\r\n");
		      isvalid=false;
		}
		if((status!=0) && (status!=1))
		{
			sbError.append("it should be either one or 0" + "\r\n");
			isvalid=false;
		}
		if(code.length()>=6)
		{
			sbError.append(" it should have 6 charecters");
		}
		if(isvalid==true)
		{
			
			sbError.append("name is " + name);
		
			sbError.append("status" + status);
			sbError.append("code " +code);
		}
		return sbError;
	}
	public static void main(String[] args) {
		
		String name;
		
	
		int status;
		String code;

		
	
		name="Aira vath";
		status=1;
		code="sai";
		
		
		
		SbDemo obj1=new SbDemo();
		StringBuilder sb=obj1.show(name,status,code);
		System.out.println(sb);
		
		//StringBuilder obj=new SbExample().show(age,name,course,city);

		//System.out.println(obj);
	}

}

