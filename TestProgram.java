/*This program is used to test Student.java, Student_Course.java, Student_Research.java, Unit.java, Unit_Course.java and Research.java
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: TestProgram.java
 Date Last Edited: 27/10/2022
 Assignment 2
 Purpose: Get student info and student marks from a file and manipulate the data 
 Assumptions: 1. Marks passed in will be between 1-100 inclusive
 			  2. ID consists of 8 digits
 			  3. Only C and R type students
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class TestProgram {

	public static void main(String[] args) {
		
		int menuOption = 0;
		Scanner inputStream = null;
		Scanner kb = new Scanner(System.in);
		boolean option2Done = false;
		boolean option7Done = false;
		
		
		ArrayList<Student> student = new ArrayList<Student>();
		
		StudentInfo();
		
		//Get info from file containing students
		inputStream = openFileRead(kb);
		Student.readStudentInfo(inputStream, student);
		inputStream.close();
		
		
		
		while(menuOption != 1) {
			displayMenu();
			menuOption = getMenuOption(kb, option2Done, option7Done);
			
			//Lets program know if option 2 has been performed already
			if(menuOption == 2) {
				option2Done = true;
			}
			//Lets program know if option 7 has been performed already
			if(menuOption == 7) {
				option7Done = true;
			}
			
			displayResults(menuOption, kb, student);
			
			
		}

		
		System.exit(0);
		

	}
	
	
	
	
	//Method to output my details
	public static void StudentInfo() {
		System.out.println("Name: JaedenMah");
		System.out.println("ID: 34317578");
		System.out.println("Enrolment: Internal");
		System.out.println("Tutor: Maryam");
		System.out.println("Tutorial Day/Time: Wednesday/10:30 \n\n");
	}
	
	
	//Gets menu option choice from user
		/*Precondition: takes kb an object of Scanner class as parameter
		 * Postcondition: returns option which is an integer between 1 and 8 inclusive. Ensures option 8 cannot be chosen unless 7 has been chosen. 
		 * Ensures option 5 and 6 cannot be chosen unless 2 has been chosen
		 */
	public static int getMenuOption(Scanner kb, boolean option2Done, boolean option7Done) {
		int menuOption;
		String empty;
		
		System.out.println("Choose an option from 1-8: ");
		menuOption = kb.nextInt();
		empty = kb.nextLine(); //This stores the return character
		
		menuOption = validateMenuOption(kb, menuOption, option2Done, option7Done);
		
		return menuOption;
		
	}
	
	
	

	//This method ensures option 3, 5, 6 and 7 cannot be chosen unless option 2 has been chosen and that option 8 can't be 
	//chosen unless 7 has been chosen
	/*Precondition: takes as parameter kb which is an object of the Scanner class, a menu option selected type integer, boolean 
	 * variable to check if 2 has been chosen and boolean variable to check if 7 has been chosen
	 * Postcondition: returns an appropriate menu selection as an integer
	 */
	public static int validateMenuOption(Scanner kb, int menuOption, boolean option2Done, boolean option7Done) {
		String empty;
		
			
			while(menuOption > 8 || menuOption < 1) {//If menu option entered is not one of the options provided 
			System.out.println("Error, please enter an option from 1 to 8");
			menuOption = kb.nextInt();
			empty = kb.nextLine(); //This stores the return character
													}
			
			//Check if option 3, 5, 6 or 7 has been chosen but 2 hasnt been chosen
			while((menuOption == 3 && option2Done == false) || (menuOption == 5 && option2Done == false) || (menuOption == 6 && option2Done == false) || (menuOption == 7 && option2Done == false)){
				System.out.println("Error, option 2 must be done first");
				menuOption = kb.nextInt();
				empty = kb.nextLine(); //This stores the return character
				
				//in case a value outside of range is entered again
				while(menuOption > 8 || menuOption < 1) {
					System.out.println("Error, please enter an option from 1 to 8");
					menuOption = kb.nextInt();
					empty = kb.nextLine(); //This stores the return character
														}
																																																	}
			//Check if option 8 has been chosen but option 7 hasnt been chosen
			while(menuOption == 8 && option7Done == false) {
					System.out.println("Error, option 7 must be chosen first");
					menuOption = kb.nextInt();
					empty = kb.nextLine(); //This stores the return character
					
					//in case a value outside of range is entered again
					while(menuOption > 8 || menuOption < 1) {
						System.out.println("Error, please enter an option from 1 to 8");
						menuOption = kb.nextInt();
						empty = kb.nextLine(); //This stores the return character
															}
														   }
		return menuOption;
	}
	
	
	
	
	//Gets ID from user 
	/*Precondition: takes as parameter kb which is an object of the Scanner class
	 * Postcondition: returns long value an ID
	 */
	private static long getInputID(Scanner kb) {
		long ID;
		String emptySpace;
		
		System.out.println("Enter Student ID:");
		ID = kb.nextLong();
		emptySpace = kb.nextLine();
		return ID;
	}
	
	
	
	
	//Method that opens a file to read data from and asks the user for the name of that file. If file cannot be opened,
	//an appropriate message is displayed
	/*Precondition: takes as parameter kb which is an object of the Scanner class
	* Postcondition: returns inputStream which is of type Scanner to contain the file opened
	*/
	public static Scanner openFileRead(Scanner kb) {
		String fileName;
		Scanner inputStream = null;
		
		System.out.println("Enter name of file to open: ");
		fileName = kb.nextLine();
		
		try {
			inputStream = new Scanner(new File(fileName));
			System.out.println("File successfully opened!");
		}
		catch(FileNotFoundException e){
			System.out.println("File could not be opened. Goodbye!");
			System.exit(0);
		}
		
		return inputStream;
	}
	
	
	
	
	//Opens a file to write data into and asks user for the name of the given file. If file cannot be opened,
	//an appropriate message is displayed
	/*Precondition: takes as parameter kb which is an object of the Scanner class
	* Postcondition: asks user for name of csv file to open for writing and returns inputStream of type PrintWriter that contains 
	* the output file
	*/
	public static PrintWriter openFileWrite(Scanner kb) {
		String fileName;
		PrintWriter outputStream = null;
		
		System.out.println("Enter name of file to write to: ");
		fileName = kb.nextLine();
		
		try {
			outputStream = new PrintWriter(fileName);
			System.out.println("File successfully opened");
		}
		catch(FileNotFoundException e){
			System.out.println("File could not be opened. Goodbye!");
			System.exit(0);}
		
		return outputStream;
	}
	
	


	//Displays menu to user 
	/*Postcondition: displays a menu filled with options the user can choose  
	 */
	public static void displayMenu() {
		
		System.out.println("\n\n");
		System.out.println("1. Quit");
		System.out.println("2. Add on marks for students from specified file");
		System.out.println("3. Remove student from the list of students. (Option 2 must be chosen before choosing this");
		System.out.println("4. Display the list of students");
		System.out.println("5. Analyse Course Work students overall marks. (Option 2 must be chosen before choosing this)");
		System.out.println("6. Get grade report for student. (Option 2 must be chosen before choosing this)");
		System.out.println("7. Sort list of students by student ID. (Option 2 must be chosen before choosing this");
		System.out.println("8. Output sorted list of students to CSV file. (Option 7 must be chosen before choosing this)");
		System.out.println(" ");
	}
	
	
	
	//Method that writes whatever data is stored in the list of students to a file of chosen name
	/*Precondition: takes as parameter kb which is an object of the Scanner class, studentList which is an arrayList of type Student
	 *and outputStream type PrintWriter containing the file to write to
	*/
	public static void writeStudentInfo(ArrayList<Student> studentList, PrintWriter outputStream, Scanner kb) {
		int i;
		String enrolmentType;
		
		for(i=0; i<studentList.size(); i++) {
			
				outputStream.println(studentList.get(i).getEnrolmentType() + ", " + studentList.get(i).getFirstName() + ", " + studentList.get(i).getLastName() + 
						", " + studentList.get(i).getID() + ", " + studentList.get(i).getOverallMark() + ", " + studentList.get(i).getFinalGrade());			 
											}
		System.out.println("File successfully written to!");
		outputStream.close();
	}


	

	//Displays results of the option selected by user from the menu
	/*Precondition: takes as parameters choice a positive integer representing which option was chosen 
	 * from the menu and option must be a value between 1-8 inclusive,
	 * studentList which is an arrayList of students and kb an object of Scanner class as parameter
	 * Postcondition: displays the results of the menu option chosen by the user
	 */
	public static void displayResults(int choice, Scanner kb, ArrayList<Student> studentList) {
		Scanner inputStream;
		PrintWriter outputStream = null;
		long ID;
		int index;
		int i;
		
		switch(choice) {
		
		case 1: 
			System.out.println("You chose to exit the program. Goodbye!");
		break;
		
		case 2: 
			inputStream = openFileRead(kb);
			Student.readStudentMarks(inputStream, studentList);
			inputStream.close();
			break;
			
		case 3:
			ID = getInputID(kb);
			Student.removeStudent(studentList, ID, kb);
			break;
			
		case 4:
			for(i=0; i<studentList.size(); i++) {
			studentList.get(i).displayStudentList();
			}
			break;
			
		case 5:
			System.out.println("This option does not work");
			break;
			
		case 6:
			ID = getInputID(kb);
			index = Student.findStudentWithID(studentList, ID);
			if(index != -1) {
			studentList.get(index).reportGrade();
			}
			break;
			
		case 7:
			Student.sortStudentList(studentList);
			System.out.println("Student list was sorted successfully \n");
			for(i=0; i<studentList.size(); i++) {	//Displays the list once sorted
				studentList.get(i).displayStudentList();
				}
			break;
			
		case 8:
			outputStream = openFileWrite(kb);
			writeStudentInfo(studentList, outputStream, kb);
			break;
			
					}
		
	}

}
