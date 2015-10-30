/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * This class is a sub class of our Generic list. It has different search and sorting methods for courses as well 
 * as a check time and total credit hours methods.
 */

package SORWV_CSFinalProject;

public class SORWV_CourseArray extends SORWV_GenericList_SO<SORWV_Course> {

	public SORWV_CourseArray() {
		super();
	}

	public SORWV_CourseArray(int size) {
		super(size);
	}
//Iterates through the array to find the object from the parameter list
	public int sequentialSearch(SORWV_Course aCourse) {
		int found = -1;
		for (int i = 0; i < super.getIndex(); i++) {
			if (super.getObject(i).equals(aCourse))
				found = i;

		}
		return found;
	}
	//Iterates through the array to find the object that corresponds to the major and course number from the parameter list
	public int directCourseSearch(String major, int courseNum) {
		int found = -1;
		for (int i = 0; i < super.getIndex(); i++) {
			if ((super.getObject(i).getMajor()).equals(major)
					&& (super.getObject(i).getCourseNum() == courseNum)) {
				found = i;
			}

		}
		return found;
	}
//Returns a course array of courses with the corresponding major
	public SORWV_CourseArray majorSearch(String major) {
		SORWV_CourseArray ca = new SORWV_CourseArray(8);
		for (int i = 0; i < super.getIndex(); i++) {
			if ((super.getObject(i).getMajor()).equals(major)) {//checks to see if the majors are the same
				ca.add(super.getObject(i));
			}

		}
		return ca;
	}
//Searches the course array using the binary method for a particular course and returns the position
	public int binarySearch(SORWV_Course aCourse) {
		int first = 0;
		int last = super.getIndex() - 1;
		int middle = 0;

		while (first <= last) {
			middle = (first + last) / 2;
			if (super.getObject(middle).equals(aCourse)) {
				return middle;
			} else if (super.getObject(middle).compareTo(aCourse) < 0) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
		}
		return -1;
	}
//sorts the array in order based on major and course number
	public void selectSort() {
		for (int i = 0; i < super.getIndex() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < super.getIndex(); j++) {
				if (super.getObject(minIndex).compareTo(super.getObject(j)) > 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				super.swap(i, minIndex);
			}
		}

	}
//calculates the total credit hours of all the courses in the array
	public int totalCredits() {
		int credits = 0;
		for (int i = 0; i < super.getIndex(); i++) {
			credits += super.getObject(i).getCreditHrs();
		}
		return credits;
	}

	//Compares the days and time of courses to see if they overlap
	public boolean checkTime(SORWV_Course wantToAdd, SORWV_Student stud) {

		for (int i = 0; i < super.getIndex(); i++) {
			
			if (((super.getObject(i).getDays()).equals(wantToAdd.getDays()))&&(super.getObject(i).getTime() == wantToAdd.getTime())) {
				
				return false;
			}
		}
		return true;
	}
	
	public int isThere(SORWV_Course obj) {
		int pos = -1;
		for (int i = 0; i < index; i++) {
			if ((super.getObject(i)).equals(obj)) {
				pos = i;
			}
		}
		return pos;
	}
}
