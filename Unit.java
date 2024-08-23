/*This program contains methods to return grades for a unit
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: provide method to determine final grade for a student in a unit
 Assumptions: 1. Marks passed in will be between 0 and 100
 */
public class Unit {
	
	
	//Method that reports the final grade 
	/*Postcondition: returns a message saying NA 
	*/
	public void reportFinalGrade() {
		
		System.out.println("NA");
	}
	
	
	
	//Determines the final grade for a student depending on the overall mark
	/*Precondition: takes as parameter an overall mark type double between 0 and 100
	*Postcondition: returns a string HD or D or C or P or N
	*/
	public static String calcFinalGrade(double overallMark) {
		String finalGrade;
		
		if(overallMark >= 80 && overallMark < 101) {
			finalGrade = "HD";
		}
		
		else if(overallMark >= 70 && overallMark < 80) {
			finalGrade = "D";
		}
		
		else if(overallMark >= 60 && overallMark < 70) {
			finalGrade = "C";
		}
		
		else if(overallMark >= 50 && overallMark < 60) {
			finalGrade = "P";
		}
		
		else{
			finalGrade = "N";
			
		}
		
		return finalGrade;
	}
	
	
}


