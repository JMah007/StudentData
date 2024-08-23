/*This program is for manipulating data for a university unit
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: provide method to determine an overall mark for a unit course
 Assumptions: 1. Marks passed in will be between 0 and 100
 */
public class Unit_Course {

	private static String unitID = "ICT167";
	private static int year = 1;
	
	

	//Assessor method which retrieves the unit ID 
	/*Postcondition: returns unitID as a String. 
	*/
	public static String getUnitID() {
		return unitID;
	}
	

	//Assessor method which retrieves the year the unit is held in
	/*Postcondition: returns year as an integer. 
	*/
	public static int getUnitYear() {
		return year;
	}
	
	
	//Method that takes in 2 assignment marks and final exam mark to find the average mark of the three
	/*Precondition: takes parameters assignment 1, assignment 2 and final exam type double
	* Postcondition: returns overallMark a double which has been calculated according to weightings of the scores
	*/
	public static double calcOverallMark(double assignment1, double assignment2, double finalExam) {
		double overallMark;
		
		overallMark = ((assignment1 * 30) + (assignment2 * 30) + (finalExam * 40)) / (30 + 30 + 40);
	
		return overallMark;
	}
	
}
