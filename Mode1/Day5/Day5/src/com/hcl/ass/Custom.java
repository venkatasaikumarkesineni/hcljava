package com.hcl.ass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Custom {
	public static void main(String[] args) {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter your name");
		try {
			String name=br.readLine();
			System.out.println("prinjted sucessfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
