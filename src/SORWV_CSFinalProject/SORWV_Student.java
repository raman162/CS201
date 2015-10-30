/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * blah blah
 */

package SORWV_CSFinalProject;

public abstract class SORWV_Student {
	protected SORWV_Name name;
	private String aNumber;
	private String major;
	protected SORWV_CourseArray schedule;

	// default constructor
	public SORWV_Student() {
		name = new SORWV_Name();
		aNumber = "aNum";
		major = "aMAj";
		schedule = new SORWV_CourseArray();

	}

	// /non-default constructor
	public SORWV_Student(String l, String f, String m, String anum, String maj) {
		if (SORWV_Student.validAnum(anum)) {
			aNumber = anum;
			name = new SORWV_Name(l, f, m);
			major = maj;
			schedule = new SORWV_CourseArray();

		} 
	}

	// accessor methods
	public String getFirst() {
		return name.getFirst();
	}

	public String getLast() {
		return name.getLast();
	}

	public String getMid() {
		return name.getMid();
	}

	public void setFirst(String a) {
		name.setFirst(a);
	}

	public void setLast(String a) {
		 name.setLast(a);
	}

	public void setMid(String a) {
		 name.setMid(a);
	}
	public String getAnum() {
		return aNumber;
	}

	public String getMajor() {
		return major;
	}

	public SORWV_CourseArray getSchedule() {
		return schedule;
	}

	// mutator methods
	public void setAnum(String anum) {
		if (validAnum(anum)) {
			aNumber = anum;
		} 
		else {
			System.err.println("Invalid Id number");
		}
	}
	
	

	public void setMajor(String maj) {
		major = maj;
	}

	public void setSched(SORWV_CourseArray sched) {
		schedule = sched;
	}

	// ToString Methods
	public String toString() {
		return "Name: " + name.getLast() + " " + name.getFirst() + " " + name.getMid() + " ANumber: " + aNumber + " Major: " + major;
	}

	public String tokenString() {
		return name.getLast() + "," + name.getFirst() + "," + name.getMid() + "," + aNumber + "," + major;
	}

	// equals method via A-number
	public boolean equals(SORWV_Student stud) {
		if (aNumber.equals(stud.getAnum())) {
			return true;
		} 
		else {
			return false;
		}
	}

	// equals method using string instead of object
	public boolean equalsAnum(String anum) {
		if (aNumber.equals(anum)) {
			return true;
		} 
		else {
			return false;
		}
	}

	// compare to via anumber
	public int compareTo(SORWV_Student stud) {
		int num1 = Integer.parseInt(aNumber.substring(1));
		int num2 = Integer.parseInt(stud.getAnum().substring(1));
		if (num1 > num2) {
			return 1;
		} 
		else if (num1 < num2) {
			return -1;
		} 
		else {
			return 0;
		}
	}
	
	public int compareTo(String anum) {
		int num1 = Integer.parseInt(aNumber.substring(1));
		int num2 = Integer.parseInt(anum.substring(1));
		if (num1 > num2) {
			return 1;
		} 
		else if (num1 < num2) {
			return -1;
		} 
		else {
			return 0;
		}
	}

	// method to check if anumber is valid
	public static boolean validAnum(String anum) {
		if (anum.length() != 9) {
			return false;
		} 
		else if (anum.startsWith("A")) {
			String num = anum.substring(1);
			try {
				Integer.parseInt(num);
			} 
			catch (NumberFormatException e) {
				return false;
			}
			return true;
		}
		return false;
	}

	// abstract methods
	public abstract int checkMin();

	public abstract int checkMax(SORWV_Course added);

}
