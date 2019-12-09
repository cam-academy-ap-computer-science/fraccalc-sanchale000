package fracCalc;

import java.util.*;

public class FracCalc {
		public static void main(String[] args){
	    	// TODO: Read the input from the user and call produceAnswer with an equation
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
	    //      e.g. input ==> "1/2 + 3/4"
	    //        
	    // The function should return the result of the fraction after it has been calculated
	    //      e.g. return ==> "1_1/4"
	    public static String produceAnswer(String input) { 
	        // TODO: Implement this function to produce the solution to the input
	    	int spaceLoc = 0;
	    	char operator = ' ';
	    	String numOne = "";
	    	String numTwo = "";
	    	spaceLoc = input.indexOf(" ");
	    	operator = input.charAt(spaceLoc + 1);
	    	numOne = input.substring(0, spaceLoc);
	    	numTwo = input.substring(spaceLoc + 3, input.length() );
	    	
	        
	        return numTwo;
	    }

	    // TODO: Fill in the space below with any helper methods that you think you will need
	    
	}


