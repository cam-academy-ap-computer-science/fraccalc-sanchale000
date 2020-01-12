package fracCalc;

import java.util.*;
/*Frac Calc Should:
 *	Parse String into two substrings
 *		substrings contain two numbers
 *		store operator as char for future use
 *
 *	Parse substrings 
 *		store a substring as whole 
 *		store a substring as numerator
 *		store a substring as denominator
 *		do this for first and second numbers
 *
 *	Use parseInt to turn strings into numbers
 *		make sure to watch negative numbers
 *		
 *	Compute numbers
 *		simplify numbers into improper fractions
 *		multiply denominators to make a common denominator
 *		compute numbers with a series of if statements based on operator
 *
 *	Returning
 *		calculate gcd of two numbers
 *		divide numbers by gcd
 *		use a series of if statements to produce correctly displaying output
 *
 *	Include sentinel loop for "quit"
 *		
 * 	
 */
public class FracCalc {
		public static void main(String[] args){
	    	
	    	Scanner console = new Scanner(System.in);
	    	String i = "";
	    	boolean stop = false;
	    	while (stop == false) {
	    		System.out.print("Input?");
	    		String input = console.nextLine();
	    		if (input.contentEquals("quit")) {  //stop 
	    			stop = true;
	    		} else {
	    			i = produceAnswer(input);
	    			System.out.print(i);
	    			System.out.println();
	    		}
	    	
	    	}
	    	System.out.println("Done");
	    	

	    }
	    
	   
	    public static String produceAnswer(String input) { 
	       
	    	int spaceLoc = 0;
	    	char operator = ' ';  //would definitely have to rework whole program for extra credit 
	    	String numOne = "";  // declaring all my variables all at once 
	    	String numTwo = "";
	    	String numerOne = "";
	    	String denomOne = "";
	    	String wholeOne = "";
	    	String numerTwo = "";
	    	String denomTwo = "";
	    	String wholeTwo = "";
	    	int wholenumOne = 0;
	    	int wholenumTwo = 0;
	    	int numernumOne = 0;
	    	int numernumTwo = 0;
	    	int denomnumOne = 0;
	    	int denomnumTwo = 0;
	    	String tempString = "";
	    	int store1 = 0;
	    	int store2 = 0;
	    	int gcd = 0;
	    	
	    	
	    	if (input.indexOf(" ") != -1) { //breaking string into numbers
	    		spaceLoc = input.indexOf(" ");
	    		operator = input.charAt(spaceLoc + 1);
	    		numOne = input.substring(0, spaceLoc);
	    		numTwo = input.substring(spaceLoc + 3, input.length());
	    	} else {
	    		return "Error: invalid input";
	    	}
	    	
	    	if (numOne.indexOf("_") != -1) { //whole number one
	    		wholeOne = numOne.substring(0, numOne.indexOf("_"));	    		
	    	} else if (numOne.indexOf("/") == -1) { 
	    		wholeOne = numOne.substring(0, numOne.length());
	    	} else { 
	    		wholeOne = "0";
	    	}
	    	
	    	if (numTwo.indexOf("_") != -1) { //whole number two
	    		wholeTwo = numTwo.substring(0, numTwo.indexOf("_"));	    		
	    	} else if (numTwo.indexOf("/") == -1) { 
	    		wholeTwo = numTwo.substring(0, numTwo.length());
	    	} else { 
	    		wholeTwo = "0";
	    	}
	    	
	    	if (numOne.indexOf("/") != -1) { //numerator and denominator one
	    		if (numOne.indexOf("_") != -1) {
	    			numerOne = numOne.substring(numOne.indexOf("_")+1, numOne.indexOf("/"));
	    			denomOne = numOne.substring(numOne.indexOf("/")+1,numOne.length());
	    		} else {
	    			numerOne = numOne.substring(0, numOne.indexOf("/"));
	    			denomOne = numOne.substring(numOne.indexOf("/")+1,numOne.length());
	    		}
	    	} else {
	    		numerOne = "0";
	    		denomOne = "1";
	    	}
	    	
    	    if (numTwo.indexOf("/") != -1) { //numerator and denominator two
    		    if (numTwo.indexOf("_") != -1) {
    			    numerTwo = numTwo.substring(numTwo.indexOf("_")+1, numTwo.indexOf("/"));
    			    denomTwo = numTwo.substring(numTwo.indexOf("/")+1, numTwo.length());
    		    } else {
    			    numerTwo = numTwo.substring(0, numTwo.indexOf("/"));
    			    denomTwo = numTwo.substring(numTwo.indexOf("/")+1,numTwo.length());
    		    }
    	    } else {
    		    numerTwo = "0";
    		    denomTwo = "1";
    	    }
    	   
    	    // parsing numbers
    	    wholenumOne = Integer.parseInt(wholeOne); //number one 
    	    if (wholeOne.indexOf("-") != -1) {
    	    	numernumOne = -1 * (Integer.parseInt(numerOne));
    	    } else {
    	    	numernumOne = Integer.parseInt(numerOne);
    	    }
    	    denomnumOne = Integer.parseInt(denomOne);
    	    wholenumTwo = Integer.parseInt(wholeTwo); //number two
    	    if (wholeTwo.indexOf("-") != -1) {
    	    	numernumTwo = -1 * (Integer.parseInt(numerTwo));
    	    } else {
    	    	numernumTwo = Integer.parseInt(numerTwo);
    	    }
    	    denomnumTwo = Integer.parseInt(denomTwo);
    	    numernumOne = (((wholenumOne * denomnumOne) + numernumOne) * denomnumTwo); //modifying numbers to be in a "useable state"
    	   
    	    numernumTwo = (((wholenumTwo * denomnumTwo) + numernumTwo) * denomnumOne );
    	 
    	    denomnumOne = (denomnumOne * denomnumTwo);
    	    
    	    if ((denomnumOne == 0) || (denomnumTwo == 0)) { //calculating values based on operator
    	    	return "Error: divide by 0";
    	    } else if (operator == '+') {
    	    	numernumOne = numernumOne + numernumTwo;
    	    } else if (operator == '-') {
    	    	numernumOne = numernumOne + (-1 * numernumTwo);
    	    } else if (operator == '*') {
    	    	numernumOne = numernumOne * numernumTwo;
    	    	denomnumOne = denomnumOne * denomnumOne;
    	    } else if (operator == '/') {
    	    	numernumOne = numernumOne * denomnumOne;
    	    	denomnumOne = denomnumOne * numernumTwo;
    	    } else {
    	    	return "Error: invalid operator";
    	    }
    	    
    	   
    	    
    	    if (numernumOne == 0) {  // print 0 if numerator is equal to 0
    	    	return "0";
    	    }
    	    
    	    store1 = numernumOne; //start simplifying
	    	store2 = denomnumOne;
	    	denomnumOne = Math.abs(denomnumOne);
	    	numernumOne = Math.abs(numernumOne);
	    	while (denomnumOne != numernumOne) {  // gcd calculator, its not very efficient, so it takes a while with big numvers
	        	if(denomnumOne > numernumOne) {
	                denomnumOne = denomnumOne - numernumOne;
	                System.out.print("a");
	        	}else {
	        		numernumOne = numernumOne - denomnumOne;
	        		System.out.print("b");
	        		
	        	}
	        }
	    	
	    	gcd = numernumOne; //divide both numbers by gcd
	    	numernumOne = store1;
	    	denomnumOne = store2;
	    	System.out.println("");
	    	System.out.println(numernumOne + "/" + denomnumOne);
	    	numernumOne = numernumOne / gcd;
	    	denomnumOne = denomnumOne / gcd;
	    
	    	if (Math.abs(numernumOne) > Math.abs(denomnumOne)) {  //decide how to correctly print numbers
	    		store1 = numernumOne / denomnumOne;
	    		store2 = numernumOne % denomnumOne;
	    		System.out.println("store1 " + store1);
	    		System.out.println("store2 " + store2);
	    		if (store2 != 0) {
	    			tempString = store1 + "_" + Math.abs(store2) + "/" + Math.abs(denomnumOne);
	    		} else {
	    			tempString = "" + store1;
	    		}
	    	} else if (Math.abs(numernumOne) < Math.abs(denomnumOne)) {
	    		if (denomnumOne < 0) {
	    			tempString = (-1 * numernumOne) + "/" + (-1 *denomnumOne);
	    		} else {
	    			tempString = numernumOne + "/" + denomnumOne;
	    		}
	    	} else {
	    		tempString = "" + numernumOne/denomnumOne;
	    	}
    	    
	        return tempString;
	    }
	    

	  
	    
	}


