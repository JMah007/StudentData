/*This program contains the data for a course student only as well as methods to be used with that object
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: Handle objects of type course student. This extends the Student class
 Assumptions: 1. ID will contain 8 digits
 			  2. Names will only have alphabetical characters in them
 			  3. Marks passed in will be between 0 and 100
 */
import java.util.ArrayList;

public class Student_Course extends Student{
	
	private String enrolmentType;
	private double assignment1;
	private double assignment2;
	private double finalExam;
	private double overallMark;
	private String finalGrade;


	
	//Constructor which sets first name, last name, ID and enrollment type passed in as parameters
	/*Precondition: takes parameters newFirstName and newLastName as strings and newID as type long and newEnrolmentType as a string
	* Postcondition: returns a new object of type Student setting firstName, lastName and enrolmentType as strings and ID type long 
	*/
	public Student_Course(String newFirstName, String newLastName, long newID, String newEnrolmentType) {
		
		super(newFirstName, newLastName, newID);
		enrolmentType = newEnrolmentType;
	}
	
	
	//This constructor is used to create another object this time with the marks 
	/*Precondition: takes parameters newFirstName, newLastName and  newEnrolmentType as strings and newID as type long 
	 *and newAssignment1, newAssignment2 and newFinalExam as type double
	 *Postcondition: returns a new object setting firstName, lastName and  enrolmentType as strings and ID as type long 
	 *and assignment1, assignment2 and finalExam as type double
	*/
	public Student_Course(String newFirstName, String newLastName, long newID, String newEnrolmentType, double newAssignment1, double newAssignment2, double newFinalExam) {
		
		super(newFirstName, newLastName, newID);
		enrolmentType = newEnrolmentType;
		assignment1 = newAssignment1;
		assignment2 = newAssignment2;
		finalExam = newFinalExam;
		
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
	
	//Assessor method which retrieves the enrollment type
	/*Postcondition: returns enrollment type as a String. 
	*/
	public String getEnrolmentType() {
		return enrolmentType;
	}
	
	//Assessor method which retrieves the score for assignment 1
	/*Postcondition: returns assignment1 as a double
	*/
	public double getAssignment1() {
		return assignment1;
	}
	
	//Assessor method which retrieves the score for assignment 2
	/*Postcondition: returns assignment2 as a double
	 */
	public double getAssignment2() {
		return assignment2;
	}
	
	//Assessor method which retrieves the score for the final exam
	/*Postcondition: returns finalExam as a double
	*/
	public double getFinalExam() {
		return finalExam;
	}
	
	
	
	//This method displays the information currently held in the list of students
	/*Postcondition: some values will return as null or 0 if information hasn't been calculated or provided yet.
	 * The values displayed are enrollment type, first name and last name as a string.ID as a long. Assignment 1, assignment 2 
	 * and final exam scores as a double
	*/
	public void displayStudentList() {
		System.out.println("Enrolment type: " + enrolmentType);
		System.out.println("First Name: " + super.getFirstName());
		System.out.println("Last Name: " + super.getLastName());
		System.out.println("Student ID: " + super.getID());
		System.out.println("Assignment 1: " + assignment1);
		System.out.println("Assignment 2: " + assignment2);
		System.out.println("Final Exam: " + finalExam);
		System.out.println(" ");
	}
	
	
	//This method displays a report of a student
	/*Postcondition: some value will return as null or 0 if information hasn't been calculated or provided yet
	 *The values displayed are enrollment type, unit ID, final grade, first name and last name as a string. ID as a long. Overall mark as a double.
	*/
	public void reportGrade() {
		String unitID;
		
		unitID = Unit_Course.getUnitID();
		overallMark = Unit_Course.calcOverallMark(getAssignment1(), getAssignment2(), getFinalExam());
		finalGrade = Unit.calcFinalGrade(getOverallMark());
		System.out.println("Enrolment type: " + getEnrolmentType());
		System.out.println("First Name: " + super.getFirstName());
		System.out.println("Last Name: " + super.getLastName());
		System.out.println("Student ID: " + super.getID());
		System.out.println("Unit ID: " + unitID);
		System.out.println("The overall mark is: " + getOverallMark());
		System.out.println("Final Grade: " + getFinalGrade());
		
	
		
		
	}
	
	

}
