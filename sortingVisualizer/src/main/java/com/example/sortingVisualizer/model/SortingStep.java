package com.example.sortingVisualizer.model;

public class SortingStep {
	int[] array;
	int currIndex;
	int comparingIndex;
	
	public SortingStep(int[] array, int currIndex, int comparingIndex) {
		this.array = array;
		this.currIndex = currIndex;
		this.comparingIndex = comparingIndex;
	}
	
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public int getCurrIndex() {
		return currIndex;
	}
	public void setCurrIndex(int currIndex) {
		this.currIndex = currIndex;
	}
	public int getComparingIndex() {
		return comparingIndex;
	}
	public void setComparingIndex(int comparingIndex) {
		this.comparingIndex = comparingIndex;
	}
}
