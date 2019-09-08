package com.practice.parser;

public class Scalar {
	
	
	public static int getValue(String code) {
	     return code.replaceAll("'", "").equals("scal_1") ? 20 : 0;	
	}

}
