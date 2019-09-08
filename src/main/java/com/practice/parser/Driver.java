package com.practice.parser;

public class Driver {
	
	public static int getValue(String code) {
		
	     String codeVal = code.replaceAll("'", "");
		 if(codeVal.equals("driv_1")) {
			 return 10;
		 }
		 if(codeVal.equals("driv_2")) {
			 return 20;
		 }
		 else
			 return 0;
	     
	}

}
