package com.example.sortingVisualizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sortingVisualizer.model.SortingStep;
import com.example.sortingVisualizer.service.SortingService;

@RestController
@RequestMapping("/sorting")
public class SortingController {
	
	@Autowired
	SortingService sortingService;
	
	@GetMapping("/generateArray")
	public int[] getArray() {
		return sortingService.getArray();
	}
	
	@PostMapping("/bubbleSort")
	public List<SortingStep> bubbleSort(@RequestBody int[] array) {
		return sortingService.bubbleSort(array);
	}
	
	@PostMapping("/mergeSort")
	public List<SortingStep> mergeSort(@RequestBody int[] array){
		return sortingService.mergeSort(array);
	}
	
	@PostMapping("/selectionSort")
	public List<SortingStep> selectionSort(@RequestBody int[] array){
		return sortingService.selectionSort(array);
	}
	
	@PostMapping("/insertionSort")
    public List<SortingStep> insertionSortSteps(@RequestBody int[] array) {
        return sortingService.insertionSort(array);
    }
	
	@PostMapping("/countingSort")
    public List<SortingStep> countingSortSteps(@RequestBody int[] array) {
        return sortingService.countingSort(array);
    }
	
	@PostMapping("/quickSort")
    public List<SortingStep> quickSortSteps(@RequestBody int[] array) {
        return sortingService.quickSort(array);
    }
}
