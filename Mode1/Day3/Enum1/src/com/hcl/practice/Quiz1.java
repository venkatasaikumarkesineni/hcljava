package com.hcl.practice;


import java.util.Scanner;
public class Quiz1
{
public static void main(String[] args)
{

String u[] =new String[]{"zero","|","||","|||","|V","V","V|","V||","v|||","|X"};
String t[] =new String[]{" ","ten","twenty","XXX","fourty","fifty","sixty","seventy","eighty","ninety"};
int i=33, a, b, c, d;
do{

if(i>9999)
System.out.println("too much for me\n");
else{
d = i%10;
c = (i%100)/10;
b = (i%1000)/100;

if(b>0) System.out.println(u[b]+" hundred and " );
if(c>1) System.out.println(t[c]);

if(d>0) System.out.println(u[d]);
System.out.println("\n");
}
}while(i>0);
}
}



