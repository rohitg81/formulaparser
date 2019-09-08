package com.practice.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
	
	private static Map<String,Operator> operatorMap = new HashMap<>();
	
	static {
		
		operatorMap.put("+", Operator.ADD);
		operatorMap.put("-", Operator.SUBTRACT);
		
	}
	
	
	public static void main(String[] args) {
		
		
		String expression = "result323/driver['scal_1'] /driver['driv_1']+ driver['driv_1']  -  scalar['driv_1'] + driver['driv_1']";
			
		boolean b2=Pattern.compile("result[0-9]*\\s*[-+*/]\\s*((driver|scalar)\\['[a-zA-Z0-9_]*'\\]\\s*(\\s*[-+*/]\\s*(driver|scalar)\\['[a-zA-Z0-9_]*'\\])*)").matcher(expression).matches();  
		
		
		boolean b3=Pattern.compile("(driver|scalar)\\['[a-zA-Z0-9_]*'\\]\\s*(\\s*[-+*/]\\s*(driver|scalar)\\['[a-zA-Z0-9_]*'\\])*").matcher(expression).matches();  
		
		
		System.out.println(b2);
		
	}
	

	
	public static boolean validateExpression(String expression) {
		
		
		boolean match1= Pattern.compile("result[0-9]*\\s*[-+*/]\\s*((driver|scalar)\\['[a-zA-Z0-9_]*'\\]\\s*(\\s*[-+*/]\\s*(driver|scalar)\\['[a-zA-Z0-9_]*'\\])*)").matcher(expression).matches();  
		
		boolean match2= Pattern.compile("(driver|scalar)\\['[a-zA-Z0-9_]*'\\]\\s*(\\s*[-+*/]\\s*(driver|scalar)\\['[a-zA-Z0-9_]*'\\])*").matcher(expression).matches(); 
		
		return match1 || match2;
	}
	


}
