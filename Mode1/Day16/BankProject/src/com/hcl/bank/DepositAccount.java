package com.hcl.bank;

public class DepositAccount {
	private int accno;
	private int amount;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String depositAccount(){
		return AccountBAL.depositaccountBal(accno,amount);
		
	}

}
