package com.hcl.boxing;

class First
{
	public First()
	{
		System.out.println("baseclass constructor");
	}
}
class Second extends First
{
			public Second()
		{
			System.out.println("derived class constructor");
		}
}

public class Inhc {
	public static void main(String[] args) {
	new Second();
	
	
	}

}
