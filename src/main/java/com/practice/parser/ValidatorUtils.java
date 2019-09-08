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
		
	
		
		
	//	boolean b2=Pattern.compile("driver\\['[a-zA-Z0-9_]*'\\]").matcher("driver['driv_1_2']").matches();    
		
		
	//	boolean b2=Pattern.compile("driver\\['[a-zA-Z0-9_]*'\\] [+]? driver\\['[a-zA-Z0-9_]*'\\]").matcher("driver['driv_1_2'] + driver['driv_1_2']").matches();   
		
	//	boolean b2=Pattern.compile("driver\\['[a-zA-Z0-9_]*'\\] [+]? scalar\\['[a-zA-Z0-9_]*'\\]").matcher("driver['driv_1_2'] + scalar['driv_1_2']").matches();   
		
      
	//	boolean b2=Pattern.compile("driver\\['[a-zA-Z0-9_]*'\\]\\s+[+]?\\s+scalar\\['[a-zA-Z0-9_]*'\\]").matcher("driver['driv_1_2'] +    scalar['driv_1_2']").matches();   
	
		
	//	boolean b2=Pattern.compile("driver\\['[a-zA-Z0-9_]*'\\]([+]driver\\['[a-zA-Z0-9_]*'\\])*").matcher("driver['driv_1_2']+driver['driv_1_2']+driver['driv_1_2']").matches();   
		
	//	boolean b2=Pattern.compile("driver\\['[a-zA-Z0-9_]*'\\]([+]driver\\['[a-zA-Z0-9_]*'\\])*").matcher("driver['driv_1_2']+driver['driv_1_2']+driver['driv_1_2']+driver['driv_1_2']+driver['driv_1_2']").matches();   
	
	//	boolean b2=Pattern.compile("(driver|scalar)\\['[a-zA-Z0-9_]*'\\]([+](driver|scalar)\\['[a-zA-Z0-9_]*'\\])*").matcher("driver['driv_1_2']+scalar['driv_1_2']").matches();   
		
	//	boolean b2=Pattern.compile("(driver|scalar)\\['[a-zA-Z0-9_]*'\\]([+](driver|scalar)\\['[a-zA-Z0-9_]*'\\])*").matcher("scalar['driv_1_2']+scalar['driv_1_2']").matches();   
		
	//	boolean b2=Pattern.compile("(driver|scalar)\\['[a-zA-Z0-9_]*'\\]([-+*/](driver|scalar)\\['[a-zA-Z0-9_]*'\\])*").matcher("scalar['driv_1_2']-scalar['driv_1_2']").matches();   
		
		boolean b2=Pattern.compile("(driver|scalar)\\['[a-zA-Z0-9_]*'\\]\\s*([-+*/]\\s*(driver|scalar)\\['[a-zA-Z0-9_]*'\\])*").matcher("scalar['driv_1_2']  -scalar['driv_1_2']").matches();   
		
		
		System.out.println(b2);
	}
	
	public static void checkIfContainsValidOperator(String expression) {
		
		AtomicBoolean isContains=new AtomicBoolean(false);
		Set<String> keySet = operatorMap.keySet();
		keySet.forEach(k-> {
			if(expression.contains(k))
				isContains.set(true);	
		});
		
		if(isContains.get()==false) {
			
			throw new RuntimeException("The expression does not contain any valid operator");
		}
				
	}


}
