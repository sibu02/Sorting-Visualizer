package com.example.sortingVisualizer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sortingVisualizer.model.SortingStep;

@Service
public class SortingService {
	public int[] getArray() {
		int length = 15;
		int array[] = new int[length];
		for(int i=0;i<length;i++) {
			array[i] = (int)Math.floor(Math.random()*20)+1;
		}
		return array;
	}
	
	//bubble sort
	public List<SortingStep> bubbleSort(int[] array){
		List<SortingStep> sortingSteps = new ArrayList<>();
		int n = array.length-1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				sortingSteps.add(new SortingStep(array.clone(),j,j+1));
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				sortingSteps.add(new SortingStep(array.clone(),j,j+1));
			}
		}
		
		return sortingSteps;
	}
	
	//Merge sort
	public List<SortingStep> mergeSort(int[] array){
		List<SortingStep> steps = new ArrayList<>();
		mergeSortHelp(array,0,array.length-1,steps);
		return steps;
	}
	
	public void mergeSortHelp(int[] array,int start,int end,List<SortingStep> steps) {
		if(start >= end) {
			return;
		}
		int mid = start + (end - start)/2;
		mergeSortHelp(array,start,mid,steps);
		mergeSortHelp(array,mid+1,end,steps);
		merge(array,start,mid,end,steps);
	}
	
	public void merge(int[] array,int start,int mid,int end,List<SortingStep> steps) {
		int i = start;
		int j = mid+1;
		int k = 0;
		int temp[] = new int[end - start +1];
		while(i <= mid && j <= end) {
			steps.add(new SortingStep(array.clone(),i,j));
			if(array[i] <= array[j]) {
				temp[k] = array[i];
				i++;
			}
			else {
				temp[k] = array[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			steps.add(new SortingStep(array.clone(),i,-1));
			temp[k++] = array[i++];
		}
		while(j <= end) {
			steps.add(new SortingStep(array.clone(),j,-1));
			temp[k++] = array[j++];
		}
		
		for(k=0,i=start;k<temp.length;i++,k++) {
			array[i] = temp[k];
			steps.add(new SortingStep(array.clone(), i, -1));
		}
	}
	
	//selection Sort
	public List<SortingStep> selectionSort(int[] array){
		List<SortingStep> steps = new ArrayList<>();
		int n = array.length;
		for(int i=0;i<n-1;i++) {
			int smallest = i;
			for(int j=i+1;j<n;j++) {
				steps.add(new SortingStep(array.clone(),smallest,j));
				if(array[smallest] > array[j]) {
					smallest = j;
				}
			}
			int temp = array[smallest];
			array[smallest] = array[i];
			array[i] = temp;
			steps.add(new SortingStep(array.clone(),smallest,i));
		}
		
		return steps;
	}
	
	//Insertion Sort
	public List<SortingStep> insertionSort(int[] array) {
        List<SortingStep> steps = new ArrayList<>();

        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int prev = i - 1;

            while (prev >= 0 && array[prev] > curr) {
                steps.add(new SortingStep(array.clone(), prev, prev + 1));
                array[prev + 1] = array[prev];
                prev--;
            }
            array[prev + 1] = curr;
            steps.add(new SortingStep(array.clone(), prev + 1, i));
        }
        steps.add(new SortingStep(array.clone(), -1, -1));
        return steps;
    }
	
	//Counting sort
	public List<SortingStep> countingSort(int[] array) {
        List<SortingStep> steps = new ArrayList<>();

        // Find the maximum element in the array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Initialize the count array
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
            steps.add(new SortingStep(array.clone(), i, array[i])); // Add step for counting
        }

        // Store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            steps.add(new SortingStep(output.clone(), i, count[array[i]])); // Add step for placing elements
        }

        // Copy the sorted elements back to the original array
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
            steps.add(new SortingStep(array.clone(), i, -1)); // Add step for final sorted array
        }

        return steps;
    }
	
	//Quick Sort
	public List<SortingStep> quickSort(int[] array) {
        List<SortingStep> steps = new ArrayList<>();
        quickSortHelper(array, 0, array.length - 1, steps);
        return steps;
    }

    private void quickSortHelper(int[] array, int low, int high, List<SortingStep> steps) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, steps);
            quickSortHelper(array, low, pivotIndex - 1, steps);
            quickSortHelper(array, pivotIndex + 1, high, steps);
        }
    }

    private int partition(int[] array, int low, int high, List<SortingStep> steps) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            steps.add(new SortingStep(array.clone(), j, high));
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                steps.add(new SortingStep(array.clone(), i, j));
            }
        }
        swap(array, i + 1, high);
        steps.add(new SortingStep(array.clone(), i + 1, high));
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
