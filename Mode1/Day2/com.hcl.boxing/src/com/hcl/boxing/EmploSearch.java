package com.hcl.boxing;

public class EmploSearch {
	public Employ showEmploy(int empno)
	{
		Employ employ=null;
		
			if(empno==1)
		{
			employ=new Employ();
			employ.id=100;
			employ.name="sai";
			employ.basic=8821;
		}
			if(empno==3)
			{
				employ = new Employ();
				employ.id=21;
				employ.name="siri";
				employ.basic=5678;
			}
			return employ;
			
	}
	public static void main(String[] args) {
	EmploSearch objSearch=new EmploSearch();
	Employ res=objSearch.showEmploy(1);
	if(res!=null)
	{
		System.out.println(res);
	}
	else
	{
		System.out.println("emp no not found");
	}
		
	}

}
