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
	    	
	    	if (input.indexOf(" ") != -1) {
	    		spaceLoc = input.indexOf(" ");
	    		operator = input.charAt(spaceLoc + 1);
	    		numOne = input.substring(0, spaceLoc);
	    		numTwo = input.substring(spaceLoc + 3, input.length());
	    	} else {
	    		System.out.println("Invalid Input");
	    		
	    	}
	    	if (numOne.indexOf("_") != -1) { //whole number one
	    		wholeOne = numOne.substring(0, input.indexOf("_"));	    		
	    	} else if (numOne.indexOf("/") == -1) { 
	    		wholeOne = numOne.substring(0, spaceLoc);
	    	} else { 
	    		wholeOne = "0";
	    	}
	    	if (numTwo.indexOf("_") != -1) { //whole number two
	    		wholeTwo = numTwo.substring(0, input.indexOf("_"));	    		
	    	} else if (numTwo.indexOf("/") == -1) { 
	    		wholeTwo = numTwo.substring(0, spaceLoc);
	    	} else { 
	    		wholeTwo = "0";
	    	}
	    		
	    	
	    	
	    	
	        
	        return wholeOne;
	    }

	  
	    
	}


