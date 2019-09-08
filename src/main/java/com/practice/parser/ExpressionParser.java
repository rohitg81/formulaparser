package com.practice.parser;

import java.util.HashMap;
import java.util.Map;

public class ExpressionParser {
	
	
	static Map<String,Integer> interim = new HashMap<>();
	public static void main(String[] args) {			
	boolean isEvalComplete = true;		
	String expression = "((scalar['scal_1'] + driver['driv_1']) + scalar['scal_1']) + driver['driv_2'])";
	int index=1;    
		while(isEvalComplete) {
			if(!expression.contains("(")) {
				isEvalComplete=false;
				break;
			}
			
			String subExpr = expression.substring(expression.lastIndexOf("(")+1, expression.indexOf(")"));
			int result = evaluate(subExpr);
			String key = "result"+index;
			interim.put(key, result);
			String enclosedSubExpr = expression.substring(expression.lastIndexOf("("), expression.indexOf(")") + 1);		
			expression = expression.replace(enclosedSubExpr, key);		
			System.out.println("after evaluating ->"+expression);
			++index;
		}
		
		System.out.println("final expression"+expression);
	}
	
	
	private static int evaluate(String subExpr) {
		
	   String trimmedWhiteSpaceExpression = subExpr.replaceAll(" ", "");
		
	   boolean isValidExpression =  ValidatorUtils.validateExpression(trimmedWhiteSpaceExpression);
	   
	   String left = trimmedWhiteSpaceExpression.substring(0, trimmedWhiteSpaceExpression.indexOf("+"));

	   
	   String right = trimmedWhiteSpaceExpression.substring(trimmedWhiteSpaceExpression.indexOf("+")+1, trimmedWhiteSpaceExpression.length());
	    
	   int total = getResult(left) + getResult(right);
	   
	   
	   return total;
		
	}
	
	private static int getResult(String function) {
		
      if(function.contains("result")) {
			
			return interim.get(function);
		}
		
		String code = function.substring(function.lastIndexOf("[")+1, function.indexOf("]"));
		
		if(function.contains("driver")) {
			
			return Driver.getValue(code);
		}
		
		
		if(function.contains("scalar")) {
			
			return Scalar.getValue(code);
		}
		
		return 0;	
	}
	
}
