/*
 * Raman Walwyn-Venugopal 
 * Sylwia Odrzywolska
 * CS 201-01 Fall 2013
 * Final Project
 * 
 * This is a Generic List of objects
 */

package SORWV_CSFinalProject;
//instance variables
public class SORWV_GenericList_SO<T> {
	final int MAX_SIZE = 100;
	protected T[] anArray;
	protected int index;
	protected int pointer;

	//default constructor
	@SuppressWarnings("unchecked")
	public SORWV_GenericList_SO() {
		anArray = (T[]) new Object[MAX_SIZE];
		index = 0;
	}

	//nondefault constructor
	@SuppressWarnings("unchecked")
	public SORWV_GenericList_SO(int size) {
		anArray = (T[]) new Object[size];
		index = 0;
	}

	public int getLength() {
		return anArray.length;
	}

	//return a copy of the array
	@SuppressWarnings("unchecked")
	public T[] getArray() {
		T[] copy = (T[]) new Object[anArray.length];
		for (int i = 0; i < index; i++) {
			copy[i] = anArray[i];
			index += 1;
		}
		return copy;
	}

	//set the array to equal another array
	public void setArray(T[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			anArray[i] = anArray[i];
			index += 1;
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int anIndex) {
		index = anIndex;
	}

	//get the object at a given position
	public T getObject(int pos) {
		return (T) anArray[pos];
	}

	//delete the object in a given position
	public void delete(int pos) {
		for (int i = pos; i < index - 1; i++) {
			anArray[i] = anArray[i + 1];
		}
		index--;
	}

	//insert an object into the array
	public void insert(int pos, T obj) {
		if (index != anArray.length) {
			for (int i = index; i > pos; i--) {
				anArray[i] = anArray[i - 1];
			}
			anArray[pos] = obj;
			index += 1;
		}
	}

	//check if the object is present
	public int isThere(T obj) {
		int pos = -1;
		for (int i = 0; i < index; i++) {
			if (anArray[i].equals(obj)) {
				pos = i;
			}
		}
		return pos;
	}

	//delete the given object and move the rest of the object in the array to prevent empty spaces
	public void delete(T obj) {
		for (int i = 0; i < index; i++) {
			if (anArray[i].equals(obj)) {
				for (int j = i; j < anArray.length - 1; j++) {
					anArray[j] = anArray[j + 1];
				}
			}
		}
		index -= 1;
	}

	//check if the array is full
	public boolean isFull() {
		if (anArray.length == index) {
			return true;
		} else
			return false;
	}

	//check if the array is empty
	public boolean isEmpty() {
		if (anArray == null) {
			return true;
		} else
			return false;
	}

	//empty the array
	public void clear() {
		anArray = null;
		index = 0;
	}

	//change capacity of array to match the size
	@SuppressWarnings("unchecked")
	public void trim() {
		T[] temp = (T[]) new Object[anArray.length];
		for (int i = 0; i < index; i++) {
			temp[i] = anArray[i];
		}
		anArray = (T[]) new Object[index + 1];
		for (int i = 0; i < index; i++) {
			anArray[i] = temp[i];
		}
	}

	//increase the capacity of the arrray
	@SuppressWarnings("unchecked")
	public void moreCapacity() {
		if (anArray.length == (index + 1)) {
			T[] temp = (T[]) new Object[anArray.length + 1];
			for (int i = 0; i < index; i++) {
				temp[i] = anArray[i];
			}
			anArray = (T[]) new Object[temp.length];
			for (int i = 0; i < index + 1; i++) {
				anArray[i] = (T) temp[i];
			}
		}
	}

	public void reset() {
		pointer = 0;
	}

	//check if there's an object in the next space
	public boolean hasNext() {
		if (!anArray[pointer].equals(null)) {
			return true;
		} else
			return false;
	}

	//retrieve the object in the next space
	public T getNext() {
		pointer++;
		return anArray[pointer - 1];
	}

	public String toString(int k) {
		return anArray[k].toString();
	}

	//add an object to the next emty space
	public void add(T obj) {
		anArray[index] = obj;
		index++;
	}

	//switch the objects in two positions
	public void swap(int switchThis, int forThis) {
		T temp = getObject(switchThis);
		anArray[switchThis] = anArray[forThis];
		anArray[forThis] = temp;
	}

}