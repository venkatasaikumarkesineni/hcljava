package com.hcl.java;

public class PerfectNum 
{
  public void calc(int n)
  {
	 int sum=0;
	  for(int i=1;i<n;i++)
	  {
		  if(n%i==0)
		  {
			  System.out.println(i);
			  sum=sum+i;
		  }
	  }
  
  if(sum==n)
  {
	  System.out.println("perfect");
  }
  else
  {
	  System.out.println(" not perfect");
  }
  }
  public static void main(String[] args) {
	int n=6;
	PerfectNum obj=new PerfectNum();
	obj.calc(n);
}
}
