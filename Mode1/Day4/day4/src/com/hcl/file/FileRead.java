package com.hcl.file;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
	public static void main(String[] args) {
		File f1=
				new File("C:/hcljava/Day4/siri/src/com/hcl/ex/Custom.java");
		try {
			FileReader fr=new FileReader(f1);
			int ch;
			while((ch=fr.read())!=-1)
			{
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
