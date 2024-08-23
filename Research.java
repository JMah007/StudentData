/*This program is for manipulating data for a university research unit
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: provide method to determine an overall mark for a research unit
 Assumptions: 1. Marks passed in will be between 0 and 100
 */
public class Research {

	
	//Method that takes in a proposal score and final dissertation score to find the average score of the two
	/*Precondition: takes parameters proposal type double and finalDissertation type double
	* Postcondition: returns overallMark a double which has been calculated according to weightings of the scores
	*/
	public static double calcOverallMark(double proposal, double finalDissertation) {
		double overallMark;
		
		overallMark = (((proposal * 40) + (finalDissertation * 60)) / (40 + 60));
	
		return overallMark;
	}
	
	
}