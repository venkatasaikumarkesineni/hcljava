package com.hcl.practice;
class First
{
	public void show()
	{
		System.out.println("show method fromfirst");
	}
}
class Second extends  First
{
	public void show()
	{
		System.out.println("ow derived methods");
	}
}
public class InhDemo {
	public static void main(String[] args) {
		Second obj=new Second();
		obj.show();
		
	}

}
