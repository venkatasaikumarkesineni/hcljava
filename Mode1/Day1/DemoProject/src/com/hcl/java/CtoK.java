package com.hcl.java;

public class CtoK {
	public void calc(double c)
	{
		double k;
		k=273+c;
		System.out.println(k);
		
	}
public static void main(String[] args) {
  double c=33;
  CtoK obj=new CtoK();
  obj.calc(c);
}
}
