package com.hcl.jdbc;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CustomerMain {
	public  static void deleteCustomer(){
		int custId;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter customer id");
		custId=sc.nextInt();
		CustomerBAL obj=new CustomerBAL();
		String res=obj.deleteCustomerBal(custId);
		System.out.println(res);	
	}
	public static void showCustomer(){
		CustomerBAL obj=new CustomerBAL();
		List<Customer> lstcustomer=obj.showCustomerBal();
		for (Customer customer : lstcustomer) {
			System.out.println(customer);
	}
	}
	public static void updateCustomer(){
		Customer objcustomer=new Customer();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter customer id");
		objcustomer.setCustId(Integer.parseInt(sc.nextLine()));
		System.out.println("enter customer name");
		objcustomer.setCustName(sc.nextLine());
		System.out.println("enter customer annual premium");
		objcustomer.setAnnualPremium(Integer.parseInt(sc.nextLine()));
		System.out.println("enter modal premium");
		objcustomer.setModalPremium(Integer.parseInt(sc.nextLine()));
		System.out.println("enter payemntmode");
		objcustomer.setPaymentMode(Integer.parseInt(sc.nextLine()));
		CustomerBAL obj1=new CustomerBAL();
		String res=obj1.updateCustomerBal(objcustomer);
		System.out.println(res);	
	}
	public static void searchCustomer(){
		int custId;
		Scanner sc=new Scanner(System.in);
		custId=sc.nextInt();
		CustomerBAL obj=new CustomerBAL(); 
		Customer objcustomer=obj.searchCustomerBal(custId);
		if(objcustomer!=null) {
			System.out.println(objcustomer);
		} else {
			System.out.println("notfound");
		}
	}
	public static void writeCustomerFile() {
		new CustomerBAL().writeCustomerFileBal();
	}
	
	public static void readCustomerFile() {
		new CustomerBAL().readCustomerFileBal();
	}
	public static void addCustomer() {
		
		Customer objcustomer=new Customer();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter customer id");
		objcustomer.setCustId(Integer.parseInt(sc.nextLine()));
		System.out.println("enter customer name");
		objcustomer.setCustName(sc.nextLine());
		System.out.println("enter annual premium");
		objcustomer.setAnnualPremium(Integer.parseInt(sc.nextLine()));
		System.out.println("enter modal premium");
		objcustomer.setModalPremium(Integer.parseInt(sc.nextLine()));
		System.out.println("enter payment mode");
		objcustomer.setPaymentMode(Integer.parseInt(sc.nextLine()));
		CustomerBAL obj=new CustomerBAL();
		try {
			boolean res=obj.addCustomerBal(objcustomer);
			if(res==true) {
				System.out.println(" customer isadded");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int yn;
		do {
			System.out.println("Options");
			System.out.println("---------");
			System.out.println("1. Add customer");
			System.out.println("2. Show customer");
			System.out.println("3. Search customer");
			System.out.println("4. Update customer");
			System.out.println("5. Delete customer");
			System.out.println("6. writecustomerfile()");
			System.out.println("7. readcustomerfile()");
			System.out.println("8. Exit");
			System.out.println("enter yourchoice");
			yn=sc.nextInt();
			switch(yn) {
			case 1 : 
				addCustomer();
				break;
			case 2 :
				showCustomer();
				break;
			case 3 :
				searchCustomer();
				break;
			case 4 : 
				updateCustomer();
				break;
			case 5 : 
				deleteCustomer();
				break;
			case 6 : 
				writeCustomerFile();
				break;
			case 7 :
				readCustomerFile();
				break;
			case 8 :
				return;	
			default : 
				System.out.println("invalid enter");
			}
		} while(yn!=8);
	}

	}





