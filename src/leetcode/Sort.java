package leetcode;

import java.util.Arrays;

public class Sort {
	public int[] selectionSort(int [] arr ) {
		for(int i = 0; i<= arr.length -1; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					arr[i] = arr[j] + arr[i];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
		}
		return arr;
		
	}
	public int[] bubbleSort(int[] arr) {
		for(int i = 0 ; i< arr.length -1;i++) {
			for(int j = 0; j< arr.length -i-1;j++) {
				if(arr[j] > arr[j +1]) {
					arr[j] = arr[j] + arr[j + 1];
					arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
				}
			}
		}
		return arr;
		
	}
	public int InsertionSort(int[] arr) {
		return 0;
		
	}
	public int[] mergeSort(int[] arr) {
		return arr;
		
	}
	public int[] quickSort(int[] arr) {
		return arr;
		
	}
public static void main(String[] args) {
	Sort s = new Sort();
	int[] arr = {2,4,5,1,0};
	int[] arr1 = arr.clone();
	System.out.println(Arrays.toString(s.selectionSort(arr)));
	System.out.println(Arrays.toString(s.bubbleSort(arr)));
	System.out.println(arr.equals(arr1));

	
}
}
