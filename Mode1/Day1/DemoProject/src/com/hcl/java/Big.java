package com.hcl.java;

public class Big {
	
		public void calc(int a,int b,int c)
		{
			int cal;
			
			cal=(a>b)&&(a>c)?a:((b>c)?b:c);
			System.out.println(cal);
		}
	
	public static void main(String[] args) {

		int a=10,b=12,c=13;
		Big obj=new Big();
		obj.calc(a,b,c);
	}

}
