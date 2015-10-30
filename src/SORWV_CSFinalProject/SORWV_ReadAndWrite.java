/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * blah blah
 */

package SORWV_CSFinalProject;

import java.io.*;
import java.util.*;

public class SORWV_ReadAndWrite {

	//the method reads the file that has all the course information stored and uses it to create new course objects and add them to one array of all courses
	public static SORWV_CourseArray allCourseRead() {
		SORWV_CourseArray allCourses = new SORWV_CourseArray();
		
		try { //attempt to write a file with all the information
			FileReader theFile = new FileReader("SORWV_courses.txt");
			Scanner inFile = new Scanner(theFile);
			String line = " ";
			
			while (inFile.hasNext()) {
				line = inFile.nextLine();
				String[] tokens = line.split(",");
				SORWV_Course aCourse = new SORWV_Course(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[4]);
				allCourses.add(aCourse);
			}
			inFile.close();
		}
		catch (FileNotFoundException fnfe) { //notify of error occuring
			System.err.println("File not found- all course read");
		}
		return allCourses;
	}

	//method that reads the file that contains the information for all students and creates an array with all the student objects
	public static SORWV_StudentsArray allStudentsRead() {
		SORWV_StudentsArray allStudents = new SORWV_StudentsArray();

		try {
			FileReader theFile2 = new FileReader("SORWV_students.txt");
			Scanner inFile2 = new Scanner(theFile2);
			String line = " ";

			while (inFile2.hasNext()) {
				line = inFile2.nextLine();
				String[] tokens = line.split(",");

				//the if statement checks if the student is undergrad or grad to instantiate the appropriate student
				if (tokens[5].equals("UG")) {
					SORWV_Undergraduate aStudent = new SORWV_Undergraduate(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
					allStudents.add(aStudent);
				} 
				else {
					SORWV_Graduate aStudent = new SORWV_Graduate(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
					allStudents.add(aStudent);
				}
			}
			inFile2.close();
		} 
		catch (FileNotFoundException fnfe) {
			System.err.println("File not found- all student read");
		}
		return allStudents;
	}

	//method that reads the schedule corresponding to the stunden't ANUmber and creates an array of those courses 
	public static SORWV_CourseArray personalScheduleRead(String aNumber) {

		String savedSched = aNumber + ".txt";
		SORWV_CourseArray savedSchedule = new SORWV_CourseArray();

		try {
			FileReader theFile = new FileReader(savedSched);
			Scanner inFile = new Scanner(theFile);
			String line = " ";

			while (inFile.hasNext()) {
				line = inFile.nextLine();
				String[] tokens = line.split(",");

				SORWV_Course aCourse = new SORWV_Course(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[4]), tokens[3]);
				savedSchedule.add(aCourse);
			}
			inFile.close();
		}

		catch (FileNotFoundException fnfe) {
			System.err.println("File not found- personal schedfule read");
		}

		return savedSchedule;
	}

	//method that creates the file that contains the schedule of a corresponding student
	public static void scheduleWrite(String aNumber, SORWV_CourseArray aSched) {
		String savedSched = aNumber + ".txt";
		
		if (aSched.getIndex() > 0) {
			
			try {
				FileWriter fileOut = new FileWriter(savedSched);
				BufferedWriter outFile = new BufferedWriter(fileOut);
				aSched.selectSort();

				for (int j = 0; j < aSched.getIndex(); j++) {
					outFile.write(aSched.getObject(j).tokenString());
					outFile.newLine();
				}
				outFile.close();

			} 
			catch (IOException e) {
				System.out.println("some error in part 1 of schedule write");
			}
		} 
		else {
			
			try {
				FileWriter fileOut = new FileWriter(savedSched);
				BufferedWriter outFile = new BufferedWriter(fileOut);
				outFile.close();
			} 
			catch (IOException e) {
				System.out.println("some error in schedule write");
			}
		}
	}

	//method that overwrites the file containing all student so that newly created student will also be there
	public static void studentWrite(SORWV_StudentsArray allStudents) {
		
		try {
			FileWriter fileOut = new FileWriter("SORWV_students.txt");
			BufferedWriter outFile = new BufferedWriter(fileOut);
			allStudents.selectSort();
			for (int j = 0; j < allStudents.getIndex(); j++) {
				outFile.write(allStudents.getObject(j).tokenString());
				outFile.newLine();
			}
			outFile.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
