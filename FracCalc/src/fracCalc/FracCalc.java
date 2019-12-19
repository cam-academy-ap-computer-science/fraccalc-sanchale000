package fracCalc;

import java.util.*;

public class FracCalc {
		public static void main(String[] args){
	    	
	    	Scanner console = new Scanner(System.in);
	    	String i = "";
	    	boolean stop = false;
	    	while (stop == false) {
	    	System.out.print("Input?");
	    	String input = console.nextLine();
	    	if (input.contentEquals("quit")) {
	    		stop = true;
	    	} else {
	    	i = produceAnswer(input);
	    	}
	    	System.out.print(i);
	    	System.out.println();
	    	}
	    	
	    	

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
	    	String numOne = "";
	    	String numTwo = "";
	    	String numerOne = "";
	    	String denomOne = "";
	    	String wholeOne = "";
	    	String numerTwo = "";
	    	String denomTwo = "";
	    	String wholeTwo = "";
	    	String temporary = "";
	    	int wholenumOne = 0;
	    	int wholenumTwo = 0;
	    	int numernumOne = 0;
	    	int numernumTwo = 0;
	    	int denomnumOne = 0;
	    	int denomnumTwo = 0;
	    	int tempInt = 0;
	    	String tempString = "";
	    	
	    	
	    	if (input.indexOf(" ") != -1) {
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
	    	if (numOne.indexOf("/") != -1) { //numerator two
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
    	    if (numTwo.indexOf("/") != -1) { //numerator two
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
    	    
    	    wholenumOne = Integer.parseInt(wholeOne); //parsing numbers
    	    numernumOne = Integer.parseInt(numerOne);
    	    denomnumOne = Integer.parseInt(denomOne);
    	    wholenumTwo = Integer.parseInt(wholeTwo);
    	    numernumTwo = Integer.parseInt(numerTwo);
    	    denomnumTwo = Integer.parseInt(denomTwo);
    	    numernumOne = (((wholenumOne * denomnumOne) + numernumOne) * denomnumTwo);
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
    	    tempString = (numernumOne + "/" + denomnumOne);
    	    
	        return tempString;
	    }
	    

	  
	    
	}


