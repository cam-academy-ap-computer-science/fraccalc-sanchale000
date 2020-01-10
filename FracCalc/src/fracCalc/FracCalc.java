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
 *		Print (computed numerator + \ + computed denominator)
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
	    	if (input.contentEquals("quit")) {  //stop thing
	    		stop = true;
	    	} else {
	    	i = produceAnswer(input);
	    	}
	    	System.out.print(i);
	    	System.out.println();
	    	}
	    	System.out.println("Done");
	    	

	    }
	    
	    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	    // This function takes a String 'input' and produces the result
	    //
	    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	    //      e.g. input ==> "1/2 + 3/4" 1 + 
	    //        
	    // The function should return the result of the fraction after it has been calculated
	    //      e.g. return ==> "1_1/4"
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
	    	int store3 = 0;
	    	int gcd = 0;
	    	
	    	
	    	if (input.indexOf(" ") != -1) { //breaking string into numbers
	    		spaceLoc = input.indexOf(" ");
	    		operator = input.charAt(spaceLoc + 1);
	    		numOne = input.substring(0, spaceLoc);
	    		numTwo = input.substring(spaceLoc + 3, input.length());
	    	} else {
	    		return "Error: invalid input";
	    	}
	    	System.out.println(numOne);
	    	System.out.println(numTwo);
	    	System.out.println(operator);
	    	if (numOne.indexOf("_") != -1) { //whole number one
	    		wholeOne = numOne.substring(0, numOne.indexOf("_"));	    		
	    	} else if (numOne.indexOf("/") == -1) { 
	    		wholeOne = numOne.substring(0, numOne.length());
	    	} else { 
	    		wholeOne = "0";
	    	}
	    	System.out.println("wholeOne " + wholeOne);
	    	if (numTwo.indexOf("_") != -1) { //whole number two
	    		wholeTwo = numTwo.substring(0, numTwo.indexOf("_"));	    		
	    	} else if (numTwo.indexOf("/") == -1) { 
	    		wholeTwo = numTwo.substring(0, numTwo.length());
	    	} else { 
	    		wholeTwo = "0";
	    	}
	    	System.out.println("wholeTwo " + wholeTwo);
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
	    	System.out.println("numerOne " + numerOne);
	    	System.out.println("denomOne " + denomOne);
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
    	    System.out.println("numerTwo " + numerTwo);
    	    System.out.println("denomTwo " + denomTwo);
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
    	    System.out.println("numernumOne " + numernumOne);
    	    numernumTwo = (((wholenumTwo * denomnumTwo) + numernumTwo) * denomnumOne );
    	    System.out.println("numernumTwo " + numernumTwo);
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
    	    System.out.println("numernumOne post operator " + numernumOne);
    	    System.out.println("denomnumOne post operator " + denomnumOne);
    	    System.out.println(numernumOne + "/" + denomnumOne);
    	    
    	    store1 = numernumOne; //start simplifying
	    	store2 = denomnumOne;
	    	while (denomnumOne != Math.abs(numernumOne)) {
	        	if(denomnumOne > Math.abs(numernumOne)) {
	                denomnumOne = denomnumOne - Math.abs(numernumOne);
	        	}else {
	        		numernumOne = Math.abs(numernumOne) - denomnumOne;
	        	}
	        }
	    	gcd = numernumOne;
	    	System.out.println("gcd " + gcd);
	    	numernumOne = store1;
	    	denomnumOne = store2;
	    	numernumOne = numernumOne / gcd;
	    	denomnumOne = denomnumOne / gcd;
	    	
	    	if (numernumOne == 0) {
	    		tempString = "0";
	    	} else if (Math.abs(numernumOne) > denomnumOne ) {
	    		store1 = numernumOne / denomnumOne;
	    		store2 = numernumOne % denomnumOne;
	    		if (store2 != 0) {
	    			tempString = store1 + "_" + Math.abs(store2) + "/" + denomnumOne;
	    		} else {
	    			tempString = "" + store1;
	    		}
	    	} else if (denomnumOne > Math.abs(numernumOne)) {
	    		tempString = numernumOne + "/" + denomnumOne;
	    	} else {
	    		tempString = "" + numernumOne/denomnumOne;
	    	}
    	    
	        return tempString;
	    }
	    

	  
	    
	}


