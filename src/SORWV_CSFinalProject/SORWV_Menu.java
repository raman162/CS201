/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * blah blah
 */


package SORWV_CSFinalProject;

import java.util.*;

public class SORWV_Menu {

	//method that checks if a valid major is entered
	public static boolean checkMajor(String major) {
		
		switch (major) {
			case "BIOL":
				return true;
			case "BME":
				return true;
			case "CHE":
				return true;
			case "CAE":
				return true;
			case "ECE":
				return true;
			case "MATH":
				return true;
			case "MMAE":
				return true;
			case "PHYS":
				return true;
			default:
				return false;
		}
	}

	//method that checks if the course number entered is valid
	public static boolean checkNum(String coursenum) {
		
		//checks if the length is valid
		if (coursenum.length() == 3) {
			
			//checks if all are digits
			try {
				@SuppressWarnings("unused")
				int d = Integer.parseInt(coursenum);
			} 
			catch (NumberFormatException nfe) {
				return false;
			}
			return true;
		}
		else
			return false;
	}

	//method that numbers the classes in the schedule and displays them to user so that user can delete the class he wants by selecting the corresponding number
	public static void deleteCourse(SORWV_CourseArray sched) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	
		//prints out all the courses in the schedule
		for (int i = 0; i < sched.getIndex(); i++) {
			System.out.println(i + "-" + sched.getObject(i).toString());
		}
		//asks user to select which course to delete and checks if the options valid before removing the course from the array
		System.out.println("Please select the course that you want to delete or (-1) to cancel");
		int ans = input.nextInt();
		
		if (ans >= sched.getIndex()) {
			System.err.println("Invalid option");
		} 
		else if (ans >= 0) {
			sched.delete(ans);
			System.out.println("Course successfully removed.\n");
		}
		
	}

	//method that displays the courses in the schedule, total credit hours and if the student needs to ass classes
	public static void theirSchedule(SORWV_CourseArray sched, SORWV_Student stud) {
		
		//checks if any courses are in the schedule array
		if(sched.totalCredits() ==0){
			System.out.println("You have no courses added to your schedule.");
		}
		//if courses are present they are printed out along with credit hour information
		else {
			System.out.println("Your current schedule is: ");
			
			for (int i = 0; i < sched.getIndex(); i++) {
				System.out.println(sched.getObject(i).toString());
			}
			System.out.println("\nYou currently have " + sched.totalCredits() + " credit hours.");
		}
		
		//if the student is under minimum hours it displays how many more hours are needed
		if (stud.checkMin() < 0) {
			System.out.println("You need to add " + stud.checkMin() * -1 + " credits to meet minimum");
		}	
	}

	//the menu choices are printed out and appropriate responses are generated for each choice
	public static void menuOptions(SORWV_CourseArray allCourses, SORWV_Student stud) {
		System.out.println("\nPlease choose one of the following options:\n1 - Search for a direct courses\n2 - Search by major\n3 - View all available courses\n4 - View schedule\n5 - Drop a course\n(-1 to exit)");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	
		try{
			int ans = input.nextInt();
			String searchMaj;
			@SuppressWarnings("unused")
			String garbage; //used to clear input line
			
			switch (ans) {
				case 1: //Student searches for a direct course by first entering the major and then the course number. 
						//An appropriate error message is displayed if there is an issue and then the menu options are displayed again
					garbage = input.nextLine();
					
					boolean theCheck = false;
					while(!theCheck){
					System.out.println("Please enter the major (for eg. - BIOL, BME, CHE, CAE, ECE, MATH, MMAE, PHYS)\nEnter (-1) at any time to cancel and return to the main menu. ");
					searchMaj = input.nextLine().toUpperCase();
				
					if(searchMaj.equals("-1")){
						theCheck = true;
						continue;
					}
					
					//check if the major entered is correct before prompting user for further info
					if (!SORWV_Menu.checkMajor(searchMaj)) {
							System.err.println("Invalid Course Major, please try again");
							continue;
						}
						
					System.out.println("Please enter a three digit course number");
					String coursenum = input.nextLine();
						
					if(coursenum.equals("-1")){
						theCheck = true;
						continue;
					}
					
					//checks if the user entered valid course number before looking for the corresponding course
					if (!SORWV_Menu.checkNum(coursenum)) {
							System.err.println("Invalid Course Number, please try again");
							continue;
						}
						
					int cnum = Integer.parseInt(coursenum);
					int pos = allCourses.directCourseSearch(searchMaj, cnum);
							
					//prints out the course searched for and asks for confirmation before adding it to schedule
					if (pos == -1) {
							System.err.println("Invalid course option!");
							continue;
						}
						
					System.out.println(allCourses.getObject(pos).toString());
					System.out.println("Press 1 to add this course\nPress 2 to return to main menu"); 
					String in = input.nextLine();
						
					
					//if they confirm to add it
					if (in.equals("1")) {
								
						//checks if the class day and time doesn't conflict with the classes already in the schedule and then checks if the class will make the student go over max credit hours
						if (!stud.getSchedule().checkTime(allCourses.getObject(pos), stud)) {
								System.err.println("Course can not be added due to interference with schedule");
								continue;
							}			
							
						int chours = stud.checkMax(allCourses.getObject(pos));
									
						//if the student doesn't go over max hours the course gets added and the student is returned to main menu
						if (chours < 0) {
								System.out.println("You will be " + chours * -1 + " credit hours over the limit! Course can not be added.");
								continue;
							}
							
						stud.getSchedule().add(allCourses.getObject(pos));
						System.out.println("The course has been added to your schedule.");
						theCheck = true;
						continue;
					} 
									
					else if (in.equals("2") || in.equals("-1")) {
						theCheck = true;
						continue;
					} 
					else {
						System.err.println("Invalid option");
						continue;
								}
							}	
					SORWV_Menu.menuOptions(allCourses, stud);
					break;
				case 2: //Student searches for all courses of a certain major and all those courses are displayed, then the student enters the course number of the class to be added. 
						//If there's an error an appropriate message is displayed and then the menu options are displayed again
					garbage = input.nextLine();
					
					boolean check = false;
					//displays all the courses in that major
					while (!check) {
					System.out.println("Please enter the major you will like to search for (for eg. - BIOL, BME, CHE, CAE, ECE, MATH, MMAE, PHYS) or (-1) to return to main menu.");
					searchMaj = input.nextLine().toUpperCase();
					
					if (searchMaj.equals("-1")) {
						check = true;
						continue;
					} 
					
					//checks if major is valid before continuing
						if (!SORWV_Menu.checkMajor(searchMaj)) {
							System.err.println("Invalid Course Major, please try again");
							continue;
						}
							
						SORWV_CourseArray allmajor = allCourses.majorSearch(searchMaj);
						for (int i = 0; i < allmajor.getIndex(); i++) {
							System.out.println(allmajor.getObject(i).toString());
						}
						System.out.println("Enter course number you would like to add or (-1) to return to main menu: ");
						String in = input.nextLine();
							
						if (in.equals("-1")) {
								check = true;
								continue;
						} 
						
						//checks if the course number is valid before trying to add the class
						else {
							if (!SORWV_Menu.checkNum(in)) {
									System.err.println("Invalid Course Number, please try again");
									continue;
							}
						
							int cnum = Integer.parseInt(in);
							int pos = allCourses.directCourseSearch(searchMaj,cnum);
							if (pos == -1) {
								System.err.println("Invalid option, this course is not available.");
								continue;
							} 
							
							//checks if the class doesn't overlap with the others in the schedule and if the studen't won't go over the max credit hours before addingthecourse to the schedule
							else {
								if (!(stud.getSchedule()).checkTime(allCourses.getObject(pos), stud)) {
										System.err.println("Course can not be added due to interference with schedule");
										continue;
									}	
									
								int chours = stud.checkMax(allCourses.getObject(pos));
								if (chours < 0) {
										System.err.println("You will be " + chours * -1 + " credit hours over the limit! Course can not be added.");
										continue;
									}
									
								stud.getSchedule().add(allCourses.getObject(pos));
								System.out.println("The course has been added to your schedule.");
								check = true;
								continue;
							} 
											
						} 
										
					}
					SORWV_Menu.menuOptions(allCourses, stud);
					break;
				case 3: //All courses are displayed with their dates and times and credit hours, then student enters the major and later the course number to add the class. 
						//If there is an incorrect input an appropriate message is displayed, then the menu options are displayed again
					System.out.println(allCourses.getIndex());
					garbage = input.nextLine();
					
					
					//prints out all the available courses
					for (int i = 0; i < allCourses.getIndex(); i++) {
						System.out.println(allCourses.getObject(i).toString());
					}
					
					boolean aCheck = false;
					while(!aCheck){
					//asks student for the major of the course they wish to add
					System.out.println("Please enter the major (for eg. - BIOL, BME, CHE, CAE, ECE, MATH, MMAE, PHYS) or (-1) to return to the main menu.");
					searchMaj = input.nextLine().toUpperCase();
					
					if (searchMaj.equals("-1")) {
						aCheck = true;
						continue;
					} 
					
					//checks if the entered major is valid
					if (!SORWV_Menu.checkMajor(searchMaj)) {
							System.err.println("Incorrect major!");
							continue;
					}
					
					System.out.println("Please enter a three digit course number");
					String coursenum = input.nextLine();
						
					//checks if the entered course number is valid
					if (!SORWV_Menu.checkNum(coursenum)) {
						System.err.println("Incorrect course number!");
						continue;
					}
							
					int cnum = Integer.parseInt(coursenum);
					int pos = allCourses.directCourseSearch(searchMaj, cnum);
							
					//if the corresponding course exist the student is asked for confirmation before adding it
					if (pos == -1) {
							System.err.println("Invalid course option!");
							continue;
					}
								
					System.out.println(allCourses.getObject(pos).toString());
					System.out.println("Press 1 to add this course\nPress 2 to return to main menu");
					String in = input.nextLine();
								
					//before adding the course the schedule is checked for overlapping days and times and if the student won't go over max hours
					if (in.equals("1")) {
						if (!stud.getSchedule().checkTime(allCourses.getObject(pos), stud)) {
								System.err.println("Course can not be added due to interference with schedule");
								continue;
							}
							
					int chours = stud.checkMax(allCourses.getObject(pos));
					if (chours < 0) {
							System.err.println("You will be " + chours * -1 + " credit hours over the limit! Course can not be added.");
							continue;
						}
						
					stud.getSchedule().add(allCourses.getObject(pos));
					System.out.println("The course has been added to your schedule.");
					aCheck =true;
					continue;
					} 
					
					else if (in.equals("2") || in.equals("-1")) {
						aCheck =true;
						continue;
					} 
					else {
						System.err.println("Invalid option");
						aCheck =true;
					}
					} 
					SORWV_Menu.menuOptions(allCourses, stud);
					break;
				case 4: //Students schedule and credit hour information is displayed, then the menu options are displayed again
					SORWV_Menu.theirSchedule(stud.getSchedule(), stud);
					SORWV_Menu.menuOptions(allCourses, stud);
					break;
				case 5: //Student is shown options to remove courses from their schedule, then the menu options are displayed again
					SORWV_Menu.deleteCourse(stud.getSchedule());
					SORWV_Menu.theirSchedule(stud.getSchedule(), stud);
					SORWV_Menu.menuOptions(allCourses, stud);
					break;
				case -1: //Student chooses to exit the program
					SORWV_ReadAndWrite.scheduleWrite(stud.getAnum(), stud.getSchedule());
					System.out.println("Goodbye!");
					break;
				default: //Invalid input from user, menu is displayed again
					System.err.println("Invalid Option!");
					SORWV_Menu.menuOptions(allCourses, stud);
					break;
			}
		}
		catch(InputMismatchException ime){
			System.err.println("Invalid entery, please enter an integer");
			SORWV_Menu.menuOptions(allCourses, stud);
		}
	}

	//main method in this class that gets student info through the Login class and obtains all the relevant info from the ReadandWrite class before sending the user to the menuOption to make their selections
	public static void mainMenu() {
		int theStudent = SORWV_Login.studentLogin();
		
		if (theStudent > -1) {
			SORWV_StudentsArray allStudents = SORWV_ReadAndWrite.allStudentsRead();		//The file with all students is read and an array of all students is created
			SORWV_CourseArray allCourses = SORWV_ReadAndWrite.allCourseRead();			//The file with all courses is read and an array of all courses is created
			SORWV_Student thisStudent = allStudents.getObject(theStudent);		//The student object corresponding to the information entered in the Login is retrieved
			String anum = thisStudent.getAnum();							//The student's ANumber is retrieved
			thisStudent.setSched(SORWV_ReadAndWrite.personalScheduleRead(anum));	//The ANumber is used to access the student's current schedule
			SORWV_Menu.menuOptions(allCourses, thisStudent);						//User is displayed menu options and is able to add and remove courses from their schedule
		}
		else
			System.out.println();
	}

}
