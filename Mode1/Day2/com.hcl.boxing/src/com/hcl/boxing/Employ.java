package com.hcl.boxing;

public class Employ 
{
	int basic;
	String name;
	double id;
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + empno;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		Employ e=(Employ)obj;
		if (e.basic==basic)
				{
			return true;
				}
		else
		{
			return false;
		}
			
	}
	
	@Override
	public String toString() {
		return "Employ [empno=" + id+ ", name=" + name + ", basic=" + basic + "]";
	}

}
