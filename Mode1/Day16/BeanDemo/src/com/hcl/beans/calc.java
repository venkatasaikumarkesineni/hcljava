package com.hcl.beans;

public class calc {
	private int firstNo;
	private int secondNo;
	public int getFirstNo() {
		return firstNo;
	}
	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}
	public int getSecondNo() {
		return secondNo;
	}
	public void setSecondNo(int secondNo) {
		this.secondNo = secondNo;
	}
	public int sum()
	{
		return getFirstNo() + getSecondNo();
	}

}
