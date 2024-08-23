/*This program contains the data for a student as well as methods to manipulate that data
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: Handle objects of type student and manipulate the data
 Assumptions: 1. ID will contain 8 digits
 			  2. Names will only have alphabetical characters in them
 */
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private long ID;;
	
	
	
	//Default constructor which sets first name last name and student ID to default values
	/*Postcondition: returns an object of type Student with firstName and lastName as strings 
	 * saying names not given and value of 0 for ID as long type
	 */
	public Student() {
		setStudent("No first name given", "No last name given", 0);
	}
	
	//Constructor which sets first name, last name and ID to values passed in as parameters
	/*Precondition: takes parameters newFirstName and newLastName as strings and newID as type long
	* Postcondition: returns a new object of type Student with firstName and lastName as strings and ID type long
	*/
	public Student(String newFirstName, String newLastName, long newID) {
		setStudent(newFirstName, newLastName, newID);
		
	}
	
	
	
	//Private method for constructors to call to initialize all instance variables
	/*Precondition: takes parameters newFirstName and newLastName which are strings and ID which is type long
	 * Postcondition: returns string values for first and last name and returns long value for ID 
	*/
	private void setStudent(String newFirstName, String newLastName, long newID){
		firstName = newFirstName;
		lastName = newLastName;
		ID = newID;
	}

	
	//Mutator method that sets value for first name
	/*Precondition: takes parameters newFirstName as a string
	* Postcondition: sets firstName as a string
	*/
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	//Mutator method that sets value for last name
	/*Precondition: takes parameters newLastName as a string
	* Postcondition: sets lastName as a string
	 */
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	//Mutator method that sets value for student ID
	/*Precondition: takes parameters newID as type long
	 * Postcondition: sets ID as type long
	 */
	public void setID(long newID) {
		ID = newID;
	}
	
	
	
	
	
	//Assessor method which retrieves the first name
	/*Postcondition: returns firstName as a String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	//Assessor method which retrieves the last name
	/*Postcondition: returns lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}
	
	//Assessor method which retrieves the student ID
	/*Postcondition: returns ID as a long value
	*/
	public long getID() {
		return ID;
	}
	
	//Assessor method which retrieves the final grade 
	/*Postcondition: returns finalGrade as a String. This method can be overridden
	*/
	public String getFinalGrade() {
		return null;
	}
	
	//Assessor method which retrieves the enrollment type
	/*Postcondition: returns enrollment type as a String. This method can be overridden
	 */
	public String getEnrolmentType() {
		return null;
	}
	
	//Assessor method which retrieves the overall mark
	/*Postcondition: returns overallMark as a double. This method can be overridden
	*/
	public double getOverallMark() {
		return 0;
	}

	
	
	//This method reports the data for the student
	/*Postcondition: returns message saying there is no grade. This method can be overridden
	*/
	public void reportGrade() {
		System.out.println("There is no grade here");
	}
	
	
	//This method displays whatever is in the list of Students
	/*Postcondition: returns a message saying NA for not available. This method can be overridden
	*/
	public void displayStudentList() {
		System.out.println("NA");
	}
	
	
	//Compares 2 student objects to see if they are the same
	/*Precondition: takes as parameters 2 objects of type Student
	 * Postcondition: returns true if objects have the same student ID otherwise it returns false
	*/
	public static boolean equals(Student student1, Student student2) {
		boolean sameStudent = false;
		
		if(student1.getID() == student2.getID()) {
			sameStudent = true;
											     }
		
		return sameStudent;
	}
	
	
	
	
	
	//Method which reads the data from the input file for each student and creates an object for each student
	/*Precondition: takes as parameters the inputFile as type Scanner. Also takes an uninitialized arrayList. The input
	 * file should contain the enrollment type, first name, last name and student ID for each student.
	* Postcondition: returns list of student objects as an arrayList thats now initialized with their enrollment type, first name, last name as strings
	* and ID as a type long
	*/
	public static void readStudentInfo(Scanner inputStream, ArrayList<Student> studentList) {
		
		long ID;
		String firstName;
		String lastName;
		String enrolmentType;
		
		while(inputStream.hasNextLine()) {
			
			enrolmentType = inputStream.next();	
			firstName = inputStream.next();
			lastName = inputStream.next();
			ID = inputStream.nextLong();
			
			
			if(enrolmentType.equalsIgnoreCase("C") == true) {
				Student_Course student = new Student_Course(firstName, lastName, ID, enrolmentType);
				studentList.add(student);
															}
			
			else if(enrolmentType.equalsIgnoreCase("R") == true) {
				Student_Research student = new Student_Research(firstName, lastName, ID, enrolmentType);
				studentList.add(student);
																 }
			
										}
	}
	

	//Method which reads the data from the input file for each student and creates an object for each student
	/*Precondition: takes as parameters the inputFile as type Scanner. Also takes an arrayList already initialized. The input
	 * file should contain the marks of each student
	 * Postcondition: returns list of student objects with each object containing their enrollment type, first name, last name and ID and marks. 
	 * Course students have a mark for assignment 1, 2 and final exam whereas Research students have a mark for proposal and final dissertation 
	 * as type double
	*/
	public static void readStudentMarks(Scanner inputStream, ArrayList<Student> studentList) {
		
		int counter = 0;
		double assignment1, assignment2, finalExam;
		double proposal, finalDissertation;
		String enrolmentType;
		
		
		while(inputStream.hasNextLine()) {
			
			//Check what the enrollment type of student is to determine whether to create Student_Course or Student_esearch object
			enrolmentType = inputStream.next();
			
			//Create _Student_Course object
			if(enrolmentType.equalsIgnoreCase("C") == true) {
			
				assignment1 = inputStream.nextDouble();			
				assignment2 = inputStream.nextDouble();
				finalExam = inputStream.nextDouble();
				
				Student_Course newStudent = new Student_Course(studentList.get(counter).getFirstName(), studentList.get(counter).getLastName(), studentList.get(counter).getID(), enrolmentType, assignment1, assignment2, finalExam);
				
				studentList.set(counter, newStudent);
				counter++;
			}
			
			//Create Student_Research object
			else if(enrolmentType.equalsIgnoreCase("R") == true) {
				
				proposal = inputStream.nextDouble();
				finalDissertation = inputStream.nextDouble();
				
				Student_Research newStudent = new Student_Research(studentList.get(counter).getFirstName(), studentList.get(counter).getLastName(), studentList.get(counter).getID(), enrolmentType, proposal, finalDissertation);
				
				studentList.set(counter, newStudent);
				counter++;
			}
			
										}
		
	}
	
	

	//Method which removes a student from the list of students by matching student ID's
	/*Precondition: takes as parameters a list of students, the student ID and kb an object of type Scanner
	* Postcondition: returns the list of students with one student been removed. The method removes the student with the ID
	* corresponding to the ID passed into the method
	*/
	public static ArrayList<Student> removeStudent(ArrayList<Student> studentList, long ID, Scanner kb){
		
		int remove;
		
		remove = verifyID(ID, studentList, kb);
		
		//if remove is equal to -1 it means student was not found
		if(remove != -1) {
			System.out.println(ID + " " + studentList.get(remove).getFirstName() + " " + studentList.get(remove).getLastName() 
					+ " was removed from the list");
			studentList.remove(remove);
			
			System.out.println(ID + " was removed successfully");
		}
		
		return studentList;
	}
	
	
	
	
	//This method is used verify the ID the user entered to remove a student with the ID from the list of students. 
	//The verification is done with a yes no question.
	/*Precondition: takes as parameters a list of students, the student ID to remove and kb an object of type Scanner
	* Postcondition: returns an integer of -1 if user says no and returns position in array list with student whose ID 
	* given ID from user if yes is selected
	*/
	private static int verifyID(long ID, ArrayList<Student> studentList, Scanner kb) {
		int index;
		
		String choice;
		boolean yes;
		boolean no;
		
		
		index = findStudentWithID(studentList, ID);
		
		//If list contains student with the ID
		if(index != -1) {
		
		studentList.get(index).getID();
		
		System.out.println("Are you sure you want to remove " + ID + " " + 
		studentList.get(index).getFirstName() + " " + studentList.get(index).getLastName() + "?");
		choice = kb.nextLine();
		
		yes = choice.equalsIgnoreCase("Y");
		no = choice.equalsIgnoreCase("N");
			
			//If input is not equal to yes or no
			while((yes == false) && (no == false)) {
				System.out.println("Error, enter either Y or N");
				choice = kb.nextLine();
				yes = choice.equalsIgnoreCase("Y");
				no = choice.equalsIgnoreCase("N");
												   }
			
		if(no == true) {
			index = -1;
			
					   }
		
					    }	
		return index;
	}
		
		

	//Finds the index of student object in the array list containing the same ID passed in
	/*Precondition: takes as parameters a list of students and the student ID of student to remove as type long
	* Postcondition: returns the index of the student in the array list containing the same ID passed in or returns an
	* integer of -1 if no student could be found with the matching ID
	*/
	public static int findStudentWithID(ArrayList<Student> studentList, long ID){
	
		int i;
		boolean foundMatch = false;
		
		//Goes through entire list of students
		for(i=0; i<studentList.size(); i++){
	
			if(ID == studentList.get(i).getID()) {
				foundMatch = true;
				System.out.println("Found student in list with ID: " + ID);
				break;
												 }
		
									   	   }
	
		if(foundMatch == false) {
			System.out.println("Could not find student in list with ID: " + ID);
			i = -1;
							    }
										
		return i;
	}
	
	
	
	//This method sorts the list of students in ascending order according to their student ID
	/*Precondition: takes as parameters a list of students with initialized ID's
	* Postcondition: returns the student list in sorted order
	*/
	public static ArrayList<Student> sortStudentList(ArrayList<Student> studentList) {
		
		int i, j;
		
		//number of passes
		for(i=1; i<studentList.size(); i++) {
			
			//performs a single pass
			for(j=0; j<studentList.size()-1; j++) {
				
			//compares 2 adjacent elements	
			if(studentList.get(j).getID() > studentList.get(j+1).getID()){
				swapStudents(studentList, j, j+1);
			}
			}
		}
		return studentList;
	}
	
	
	//This method swaps 2 student objects in the array list 
	/*Precondition: takes as parameters a list of students as well as the index of the 2 student objects to be swapped
	* Postcondition: returns the student list in sorted order
	*/
	private static void swapStudents(ArrayList<Student> studentList, int student1, int student2) {
		Student temp;
		
		temp = studentList.get(student1);
		
		studentList.set(student1, studentList.get(student2));
		studentList.set(student2, temp);
	}
	

	
}
