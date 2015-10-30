/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * This the Name class that comines the first, middle, and last names so that they cannot be easily altered.
 */

package SORWV_CSFinalProject;
//instance variables
public class SORWV_Name {

	private String first;
	private String middle;
	private String last;
	//default constructor	
	public SORWV_Name(){
		first = " ";
		middle = " ";
		last = " ";
	}
	//non-default constructor
	public SORWV_Name(String l, String f, String m){
		last = l;
		first = f;
		middle = m;
	}
	//accessor methods
	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getMid() {
		return middle;
	}
	//mutator methods
	public void setFirst(String f) {
		first = f;
	}

	public void setLast(String l) {
		last = l;
	}

	public void setMid(String m) {
		middle = m;
	}
	//toString method
	public String toString(){
		return first + " " + middle + " " + last ;
	}
	
	public String tokenString(){
		return last+","+first+","+middle;
	}
}
