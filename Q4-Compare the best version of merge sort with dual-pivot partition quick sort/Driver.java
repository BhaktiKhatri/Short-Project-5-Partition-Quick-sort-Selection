package cs6301.g45;

import java.util.Random;
import java.util.Scanner;
import cs6301.g45.QuickSortDualPivotPartition;

/**
 * Java Program to run the sorting algorithms
 * @author Bhakti Khatri
 * @author Lopamudra Muduli
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */

public class Driver {
	
	Timer timer = new Timer(); 					//Timer used to check running time of dual-pivot quick sort and merge sort
	public static boolean duplicateFlag = false;
	
	/*For quick sort using generic array*/
	public void quickSort(int length){
		Integer[] arr = new Integer[length]; //input array to be sorted
		Random rand = new Random(); //Generate random numbers used for input array
		
		if(duplicateFlag == false) {
			for(int i=0; i<length; i++) {
			    arr[i] = rand.nextInt(length);
			}
		} else {
			for(int i=0; i<length; i++) {
			    arr[i] = rand.nextInt(100);
			}
		}
		System.out.print("First 10 elements in the Input unsorted array : ");
		QuickSortDualPivotPartition qSort = new QuickSortDualPivotPartition();
		qSort.printFirstTen(arr);
		timer.start();
		qSort.dPQuickSort(arr,0,length - 1);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		qSort.printFirstTen(arr);
	}
		
	/*For merge sort using int array*/
	public void mSort(int length){
		int[] temp = new int[length]; //temporary array to be used during the merge operation.
		int[] arr = new int[length];
		Random rand = new Random(); //Generate random numbers used for input array
		if(duplicateFlag == false) {
			for(int i=0; i<length; i++) {
			    arr[i] = rand.nextInt(length);
			}
		} else {
			for(int i=0; i<length; i++) {
			    arr[i] = rand.nextInt(100);
			}
		}
		System.out.print("First 10 elements in the Input unsorted array : ");
		MergeSUsingIntArray.printFirstTen(arr);
	    timer.start();
	    MergeSUsingIntArray.mergeSort(arr,temp,0,length - 1);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		MergeSUsingIntArray.printFirstTen(arr);
	}
	
	public static void main(String[] args) {
		Driver d = new Driver();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int length = sc.nextInt();
		System.out.println("Enter -> 1 for distinct inputs \n      -> 2 for duplicate inputs");
		int inputType = sc.nextInt();
		
		if(inputType == 2) 
			duplicateFlag = true;
		else 
			duplicateFlag = false;
		
		System.out.println("Enter -> 1 for Dual-Pivot Quick Sort \n      -> 2 for Merge Sort");
		int ans = sc.nextInt();
		if (ans == 1) {
			System.out.println("----------------------------------");
			System.out.println("Dual-pivot QuickSort:");
			d.quickSort(length);
		} else if (ans == 2) {
			System.out.println("----------------------------------");
			System.out.println("Merge Sort int array:");
			d.mSort(length);
		} else {
			System.out.println("Enter proper input!");
		}
		sc.close();	
	}

}
