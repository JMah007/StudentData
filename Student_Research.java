/*This program contains the data for a research student only as well as methods to be used with that object
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: Handle objects of type research student. This extends the Student class
 Assumptions: 1. ID will contain 8 digits
 			  2. Names will only have alphabetical characters in them
 			  3. Marks passed in will be between 0 and 100
 */
import java.util.ArrayList;

public class Student_Research extends Student{

	private String enrolmentType;
	private double proposal;
	private double finalDissertation;
	private double overallMark;
	private String finalGrade;
	
	
	
	//Constructor which sets first name, last name, ID and enrollment type passed in as parameters
	/*Precondition: takes parameters newFirstName and newLastName as strings and newID as type long and newEnrolmentType as a string
	* Postcondition: returns a new object of type Student setting firstName, lastName and enrolmentType as strings and ID type long 
	*/
	public Student_Research(String newFirstName, String newLastName, long newID, String newEnrolmentType) {
		
		super(newFirstName, newLastName, newID);
		enrolmentType = newEnrolmentType;
		
	}

	
	//This constructor is used to create another object this time with the marks 
	/*Precondition: takes parameters newFirstName, newLastName and  newEnrolmentType as strings and newID as type long 
	*and proposal and final dissertation as double
	*Postcondition: returns a new object setting firstName, lastName and  enrolmentType as strings and ID as type long 
	*and proposal and finalDissertation as double
	*/
	public Student_Research(String newFirstName, String newLastName, long newID, String newEnrolmentType, double newProposal, double newFinalDissertation){
	
		super(newFirstName, newLastName, newID);
		enrolmentType = newEnrolmentType;
		proposal = newProposal;
		finalDissertation = newFinalDissertation;
	
	}


	//Assessor method which retrieves the final grade 
	/*Postcondition: returns finalGrade as a String. 
	*/
	public String getFinalGrade() {
		return finalGrade;
	}
	
	
	//Assessor method which retrieves the overall mark
	/*Postcondition: returns overallMark as a double. 
	*/
	public double getOverallMark() {
		return overallMark;
	}
	
	
	//Assessor method which retrieves the enrollment type of student
	/*Postcondition: returns enrollmentType as a string. 
	*/
	public String getEnrolmentType() {
		return enrolmentType;
	}
	
	
	//Assessor method which retrieves the proposal score
	/*Postcondition: returns proposal as a double. 
	*/
	public double getProposal() {
		return proposal;
	}
	
	
	//Assessor method which retrieves the final Dissertation score
	/*Postcondition: returns finalDissertation as a double. 
	*/
	public double getFinalDissertation() {
		return finalDissertation;
	}

	
	
	
	//This method displays the information currently held in the list of students
	/*Postcondition: some value will return as null or 0 if information hasn't been calculated or provided yet
	*/
	public void displayStudentList() {
		System.out.println("Enrolment type: " + enrolmentType);
		System.out.println("First Name: " + super.getFirstName());
		System.out.println("Last Name: " + super.getLastName());
		System.out.println("Student ID: " + super.getID());
		System.out.println("Proposal Score: " + proposal);
		System.out.println("Final Dissertation Score: " + finalDissertation);
		System.out.println(" ");
	}

	
	//This method displays a report of a student
	/*Postcondition: some value will return as null or 0 if information hasn't been calculated or provided yet
	 *The values displayed are enrollment type, final grade, first name and last name as a string. ID as a long. Overall mark as a double.
	*/
	public void reportGrade() {
		overallMark = Research.calcOverallMark(getProposal(), getFinalDissertation());
		finalGrade = Unit.calcFinalGrade(getOverallMark());
		System.out.println("Enrolment type: " + getEnrolmentType());
		System.out.println("First Name: " + super.getFirstName());
		System.out.println("Last Name: " + super.getLastName());
		System.out.println("Student ID: " + super.getID());
		System.out.println("Overall Mark: " + getOverallMark());
		System.out.println("Final Grade: " + getFinalGrade());
		
	
	}
}
