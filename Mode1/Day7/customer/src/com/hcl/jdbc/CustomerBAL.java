package com.hcl.jdbc;

import java.util.List;

public class CustomerBAL {
	static StringBuilder sb=new StringBuilder();
	public void writeCustomerFileBal() {
		new CustomerDAO().writeCustomerFileDao();
	} 
	public void readCustomerFileBal() {
		new CustomerDAO().readCustomerFileDao();
	}
	public boolean addCustomerBal(Customer objcustomer) throws CustomerException{
		boolean isAdded=true;
		if(objcustomer.getCustId()<0){
			sb.append("customer id should not be negative\r\n");
			isAdded=false;
		}
		if(objcustomer.getCustName().length()<5){
			sb.append("customer name should  be greater than 5 characters\r\n");
			isAdded=false;
		}
		if(objcustomer.getAnnualPremium()<20000){
			sb.append("customer annualpremium not less than 20000\r\n");
			isAdded=false;
		}
		if(objcustomer.getAnnualPremium()>100000){
			sb.append("customer annualpremium not greater than 100000\r\n");
			isAdded=false;
		}
		if(objcustomer.getModalPremium() < 1000) {
			sb.append("customer Modalpremium must be greater between 1000 \r\n");
			isAdded=false;
		}
		if(objcustomer.getModalPremium() > 50000) {
			sb.append("customer Modalpremium must less than 50000\r\n");
			isAdded=false;
		}
		if(objcustomer.getPaymentMode()<=1){
			sb.append("payment mode cannot be 0 or neagative\r\n");
			isAdded=false;
		}
		if(objcustomer.getPaymentMode()>3){
			sb.append("payment mode is wrong\r\n");
			isAdded=false;
		}
		if(isAdded==false){
			throw new CustomerException(sb.toString());
		}
		else{
			new CustomerDAO().addCustomerDao(objcustomer);
		}
		return isAdded;
	}
		public Customer searchCustomerBal(int custId){
			 return new CustomerDAO().searchCustomerDao(custId);
		 }
		 public List<Customer> showCustomerBal(){
			 return new CustomerDAO().showcustomer();
		 }
		 public String updateCustomerBal(Customer objcustomer){
			 return new CustomerDAO().updateCustomerDao(objcustomer);
		 }
		 public String deleteCustomerBal(int custId){
			 return new CustomerDAO().deleteCustomerDao(custId);
	}
}

