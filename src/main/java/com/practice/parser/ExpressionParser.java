package com.practice.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class ExpressionParser {
	
	private static char EMPTY = 0;
	

	
	
	
	public static void main(String[] args) {	
		
		
		boolean isEvalComplete = true;		
		String expression = "((scalar[scal_1] * driver[driv_1]) + scalar[scal_1]) - driver[drive_1] )";
	    
		while(isEvalComplete) {
			 String subExpr = StringUtils.substringBetween(expression, "(", ")");
			 if(subExpr==null) {
				 isEvalComplete=false;
				 break;
			 }
			int result = evaluate(subExpr);
			expression = expression.replace(subExpr, String.valueOf(result));		
			expression = expression.replace(expression.charAt(expression.lastIndexOf("(")), EMPTY);		
			expression = expression.replaceFirst(")","");
			System.out.println("after evaluating ->"+expression);
		}
	}
	
	
	private static int evaluate(String subExpr) {
		
	  //  ValidatorUtils.checkIfExpressionContainsValidOperator(subExpr);
	    
	   // String leftExpression = 
		
		
		return 0;
		
	}


	public void parse() {
		Stack<String> operator = new Stack<String> ();		
		Stack<String> operand = new Stack<String> ();
		
		String expression = " ((scalar[scal_1] * driver[driv_1]) + scalar[scal_1]) - driver[drive_1] ";
	
		String string = StringUtils.substringBetween(expression, "(", ")");
		
		System.out.println(string);

		/*
		validateParenthesis(expression);
		vaidateSquareBrackets(expression);
		
		char[] chars = expression.toCharArray();
		
		for(int i=0;i<chars.length;i++) {
			
			if(chars[i]=='(') {
				
			}
			
		}*/
			
		
	}

	
	private static void vaidateSquareBrackets(String expression) {
		// TODO Auto-generated method stub
		
	}

	private static void validateParenthesis(String expression) {
		// TODO Auto-generated method stub
		
	}
	
}
