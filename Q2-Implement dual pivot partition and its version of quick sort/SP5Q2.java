package cs6301.g45;
/**
 * Java Program to run the sorting algorithms
 * @author Bhakti Khatri
 * @author Lopamudra Muduli
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */
import java.util.Random;
import java.util.Scanner;

public class SP5Q2 {
	Timer timer = new Timer(); 	
	//For the call of quick sort using generic array 
	public void quickSort(int length, Integer[] arr){
		System.out.print("First 10 elements in the Input unsorted array : ");
		QuickSort qSort = new QuickSort();
		qSort.printFirstTen(arr);
		timer.start();
		qSort.quickSort(arr);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		qSort.printFirstTen(arr);
	}
	//For the call of dual pivot quick sort using generic array
	public void dualPivotQuickSort(int length,Integer[] arr){
		System.out.print("First 10 elements in the Input unsorted array : ");
		QuickSortDualPivotPartition qSort = new QuickSortDualPivotPartition();
		qSort.printFirstTen(arr);
		timer.start();
		qSort.dPQuickSort(arr,0,length - 1);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		qSort.printFirstTen(arr);
	}
	public static void main(String args[]){
		SP5Q2 d = new SP5Q2();
		Random rand = new Random(); //Generate random numbers used for input array
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int length = sc.nextInt();
		System.out.println("Enter -> 1 for distinct inputs \n      -> 2 for duplicate inputs");
		int inputType = sc.nextInt();
		Integer[] arr = new Integer[length],arr1;
		if(inputType == 2) 
			for(int i=0; i<length; i++) {
			    arr[i] = rand.nextInt(500);
			}
		else 
			for(int i=0; i<length; i++) {
			    arr[i] = rand.nextInt(length);
			}
		
		arr1=arr.clone();	//for passing same unsorted array elements to both the functions for comparison purposes.
		System.out.println("----------------------------------");
		System.out.println("QuickSort:");
		
		d.quickSort(length,arr);
		System.out.println("----------------------------------");
		System.out.println("Dual-pivot QuickSort:");
		d.dualPivotQuickSort(length,arr1);
		
		sc.close();	
	}
}
