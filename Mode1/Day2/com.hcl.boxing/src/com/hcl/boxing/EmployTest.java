package com.hcl.boxing;

public class EmployTest 
{

  public static void main(String[] args) {
	Employ e1=new Employ();
	e1.basic=1212;
	e1.name="sai";
	e1.id=2324;
	Employ e2=new Employ();
	e2.basic=1212;
	e2.name="pove";
	e2.id=78;
	System.out.println(e1==e2);
	System.out.println(e1.equals(e2));
}
}
