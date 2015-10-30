/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 *  This is a child class of Student. For polymorphism, we use chickMin(), checkMax(), toString() and tokenString()
 */

package SORWV_CSFinalProject;

public class SORWV_Undergraduate extends SORWV_Student {
	//maximum and minimum credit hours for undergrad student
	final int MIN = 12;
	final int MAX = 18;

	// default constructor
	public SORWV_Undergraduate() {
		super();
	}

	// non-default constructor
	public SORWV_Undergraduate(String l, String f, String m, String anum, String maj) {
		super(l, f, m, anum, maj);
	}

	public SORWV_Undergraduate(SORWV_Student stud) {
		super(stud.getLast(), stud.getFirst(), stud.getMid(), stud.getAnum(), stud.getMajor());
	}

	//method returns a negative value if student is under minimum hours
	public int checkMin() {
		return schedule.totalCredits() - MIN;
	}

	//method returns negative if student is over maximum hours
	public int checkMax(SORWV_Course added) {
		return MAX - (schedule.totalCredits() + added.getCreditHrs());
	}

	public String toString() {
		return "Undergraduate Student: " + super.toString();
	}
	//prints out tokenized version for file writing
	public String tokenString() {
		return super.tokenString() + ",UG";
	}

}
