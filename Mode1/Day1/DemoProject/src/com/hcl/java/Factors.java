package com.hcl.java;

public class Factors
{
	public void calc(int n)
	{
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				System.out.println(i);
				
			}
		}
	}
	public static void main(String[] args) {
	int n=20;
	Factors obj=new Factors();
	obj.calc(n);
	}
	

}
