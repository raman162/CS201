/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * This class creates an object named Course. THe attributes are the major, course number, credit hours, 
 * time and days. 
 */

package SORWV_CSFinalProject;

public class SORWV_Course {

	private String major;
	private int courseNum;
	private int creditHrs;
	private int time;
	private String days;

	//default constructor
	public SORWV_Course() {
		major = "ENG";
		courseNum = 101;
		creditHrs = 3;
		time = 800;
		days = "MW";
	}
//non-default constructor
	public SORWV_Course(String newMajor, int newCourseNum, int newCreditHrs,
			int newTime, String newDays) {
		major = newMajor;
		courseNum = newCourseNum;
		creditHrs = newCreditHrs;
		time = newTime;
		days = newDays;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String aMajor) {
		major = aMajor;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int aCourseNum) {
		courseNum = aCourseNum;
	}

	public int getCreditHrs() {
		return creditHrs;
	}

	public void setCreditHrs(int aCreditHrs) {
		creditHrs = aCreditHrs;
	}

	public int getTime() {
		return time;
	}
//converts 24 hour format to 12 hour format
	public String getTimeString() {
		String theTime = " ";
		switch (time) {
		case 835:
			theTime = "8:35 am";
			break;
		case 1000:
			theTime = "10:00 am";
			break;
		case 1125:
			theTime = "11:25 am";
			break;
		case 1350:
			theTime = "1:50 pm";
			break;
		case 1515:
			theTime = "3:15 pm";
			break;
		case 1700:
			theTime = "5:00 pm";
			break;
		case 1825:
			theTime = "7:25 pm";
			break;
		default:
			theTime = "Invalid Time Entered";
		}

		return theTime;
	}

	public void setTime(int aTime) {
		time = aTime;
	}

	public String getDays() {
		return days;
	}
	//Returns the corresponding days in a readable format
	public String getDaysString() {
		String theDays;
		
		switch (days) {
		case "MW":
			theDays = "Monday and Wednesday";
			break;
		case "TR":
			theDays = "Tuesday and Thursday";
			break;
		case "MWF":
			theDays = "Monday, Wednesday, and Friday";
			break;
		case "F":
			theDays = "Friday";
			break;
		case "T":
			theDays = "Tuesday";
			break;
		default:
			theDays = "Invalid Day Entered";
		}

		return theDays;
	}

	public void setDays(String aDays) {
		days = aDays;
	}
//compares the courses first based on alphabetical major and course number
	public int compareTo(SORWV_Course aCourse) {
		if (major.compareTo(aCourse.getMajor()) < 0) {
			return -1;
		} else if (major.compareTo(aCourse.getMajor()) > 0) {
			return 1;
		} else {
			if (courseNum > aCourse.getCourseNum()) {
				return 1;
			} else if (courseNum < aCourse.getCourseNum()) {
				return -1;
			} else
				return 0;
		}

	}

	public boolean equals(SORWV_Course aCourse){
		if(major.equals(aCourse.getMajor()) && (courseNum == aCourse.getCourseNum())){
			return true;
		}
		else return false;
	}
	public String toString() {
		return "Course " + major + courseNum + " is " + creditHrs
				+ " credit hours and will be offered on " + getDaysString()
				+ " at " + getTimeString() + ".";
	}
//prints out tokenized version for file writing
	public String tokenString() {
		return major + "," + courseNum + "," + creditHrs + "," + days + ","
				+ time;
	}
}
