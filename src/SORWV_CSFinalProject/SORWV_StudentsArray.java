/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * blah blah
 */

package SORWV_CSFinalProject;

public class SORWV_StudentsArray extends SORWV_GenericList_SO<SORWV_Student> {

	public SORWV_StudentsArray() {
		super();
	}

	public SORWV_StudentsArray(int size) {
		super(size);
	}

	public int sequentialSearch(SORWV_Student aStudent) {
		int found = -1;
		for (int i = 0; i < super.getIndex(); i++) {
			if (super.getObject(i).equals(aStudent))
				found = i;

		}
		return found;
	}

	public int aNumSeqSearch(String anum) {
		int found = -1;
		for (int i = 0; i < super.getIndex(); i++) {
			if ((super.getObject(i)).equalsAnum(anum)) {
				found = i;
			}
		}
		if (found==-1){
			System.err
			.println("Student does not exits, please create new student or try re-entering Id");
		}
		return found;

	}
	public int binarySearch(String anum) {
		int first = 0;
		int last = super.getIndex() - 1;
		int middle = 0;

		while (first <= last) {
			middle = (first + last) / 2;
			if (super.getObject(middle).equalsAnum(anum)) {
				return middle;
			} else if (super.getObject(middle).compareTo(anum) < 0) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
		}
		return -1;
	}
	
	public int binarySearch(SORWV_Student aStudent) {
		int first = 0;
		int last = super.getIndex() - 1;
		int middle = 0;

		while (first <= last) {
			middle = (first + last) / 2;
			if (super.getObject(middle).equals(aStudent)) {
				return middle;
			} else if (super.getObject(middle).compareTo(aStudent) < 0) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
		}
		return -1;
	}

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
	
	public String tokenString(int k) {
		return anArray[k].tokenString();
	}

}
