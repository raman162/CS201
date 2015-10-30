/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * This class creates a new Student object and accesses the array of all students.
 */

package SORWV_CSFinalProject;
import java.util.*;

public class SORWV_Login {

	//checks to see if that A number is already used
	public static boolean aNumRepeat(String anum, SORWV_StudentsArray allstudents) {
		if (allstudents.isEmpty()) {
			return false;
		}
		boolean check = false;
		
		for (int i = 0; i < allstudents.getIndex(); i++) {
			
			if (allstudents.getObject(i).equalsAnum(anum)) {
				check = true;
			}
		}
		return check;
	}

	//method creates a new student object with the information provided by user while checking if user wants to exit by entering -1
	public static void newStudent() {
	
		SORWV_StudentsArray allStudents = SORWV_ReadAndWrite.allStudentsRead();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String validAnum = "";
		
		//while loop checks if the ANumber is valid and makes sure it's not already used so schedules don't get overwritten
		boolean check = false; //check used to run the first while loop
		boolean check2 = false; //check set in the first while loop to run the second loop
		while (!check) {
			
			System.out.println("Please enter your last name: ");
			String ln = input.nextLine();	//last name entered
				if(ln.equals("-1")){
					check = true;
					continue;
				}
			System.out.println("Please enter your first name: ");
			String fn = input.nextLine();	//first name entered
				if(fn.equals("-1")){
					check = true;
					continue;
				}
			System.out.println("Please etner your middle name (NA if you do not have):");
			String mn = input.nextLine();	//middle name entered
				if(mn.equals("-1")){
					check = true;
					continue;
				}
			System.out.println("Please enter your major (MMAE, CAE, CS): ");
			String maj = input.nextLine().toUpperCase();	//major entered
				if(maj.equals("-1")){
					check = true;
					continue;
				
				}
			System.out.println("Please enter your Anumber (A20253565): ");
			String anum = input.nextLine().toUpperCase();	//anumber entered
			if(anum.equals("-1")){		
				check = true;
				continue;
			}
			else if (SORWV_Student.validAnum(anum) ) {
				
				if(!SORWV_Login.aNumRepeat(anum, allStudents)){
				validAnum = anum;
				check = true;
				check2 = true; //set to true to run the second while loop
				}
				else{
					System.err.println("This A-Number is already used");
				}
			}
			else System.err.println("Incorrect A-Number");
		
		
		//it creates undergrad or grad student depending on user choice. Then the student object is saved and written in the all student file and a schedule file is created for that student
		while (check2) {
			int ans;
			System.out.println("If you are an Undergraduate press (1). If you are a Graduate press (2)");
			ans = input.nextInt();
			switch (ans) {
				case 1:
					SORWV_Undergraduate ugstud = new SORWV_Undergraduate(ln, fn, mn, validAnum,maj);
					allStudents.add(ugstud);
					SORWV_ReadAndWrite.studentWrite(allStudents);
					SORWV_ReadAndWrite.scheduleWrite(ugstud.getAnum(), ugstud.getSchedule());
					check2 = false;
					System.out.println("Now that you have entered your credentials, click returning student (2) if you want to modify your schedule");
					break;
				case 2:
					SORWV_Graduate gradstud = new SORWV_Graduate(ln, fn, mn, validAnum, maj);
					allStudents.add(gradstud);
					SORWV_ReadAndWrite.studentWrite(allStudents);
					SORWV_ReadAndWrite.scheduleWrite(gradstud.getAnum(), gradstud.getSchedule());
					check2 = false;
					System.out.println("Now that you have entered your credentials, click returning student (2) if you want to modify your schedule");
					break;
				default:
					System.err.println("Invalid answer, Please try again");
					break;
			}
		}}
		
	}

	// a returning user provided their ANumber which is checked for validity and the studen't file/schedule is retrieved
	public static int returnStudent() {
		SORWV_StudentsArray allStudents = SORWV_ReadAndWrite.allStudentsRead();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean check = false;
		int search=-1;
		String validAnum = "";
		
		while (!check) {
			System.out.println("Please enter your Anumber (A20253565):");
			String aNum = input.nextLine().toUpperCase();	//a number entered to log in
			
			if(aNum.equals("-1")){
				check = true;
			}
			else if (SORWV_Student.validAnum(aNum)) {
				validAnum = aNum;
				check = true;
				search = allStudents.binarySearch(validAnum);
				//search = allStudents.aNumSeqSearch(validAnum);
			}
			else{
				System.err.println("Invalid A-Number");
				check = false;}
		}
	
		return search;
	}
//main method in this class which allows user to select if they want to create a new student or access saved information
	public static int studentLogin() {
		int exit = -1; //initialization of the value that will be returned
		boolean theCheck = false;
		while(!theCheck){
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Are you a new student (1), or returning student(2), \nTo cancel enter (-1) anytime.");
		String ans1 = input.nextLine();
		
		switch (ans1) {
			case "1": //The user is a new student and they are sent to the new student method to enter their personal information
				SORWV_Login.newStudent();	
				
				break;
			case "2": //The user is returning student and their information is retrieved
				SORWV_StudentsArray allStudents = SORWV_ReadAndWrite.allStudentsRead();
				int posStud = SORWV_Login.returnStudent();
				if (posStud > -1) {
					System.out.println("Welcome back " + allStudents.getObject(posStud).getFirst());
					exit = posStud;
					theCheck=true;
				} 
				
				break;
			case "-1": //User chooses to exit the program
				System.out.println("Goodbye!");	
				theCheck =true;
				break;
			default: //Incorrect input, user is prompted for input again
				System.err.println("Invalid Option!");
				break;
		}}
		
		return exit;
	}
}