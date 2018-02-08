package cs6301.g45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
/**
* Driver program for SP5_Q3(select k largest elements of an array.)
* @author 	Lopamudra
* 				Bhakti Khatri
* 				Gautam Gunda
* 				Sangeeta Kadambala
*/

public class Driver_SP5_Q3 {
	public static void main(String[] args) {
		int k = 16; // change here for value of 'k'
		int length = 100000;  // change here for length for input random array
		Timer timer = new Timer(); //Timer used for running time
		int input[] = createRandArray(length);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the version number(1/2/3) to consider for selecting k largest elements :  " + "\n"+ "1. Using MaxHeap. "+ "\n" +
									"2. Using MinHeap." + "\n" + "3. Using Partition - O(n) algo .");
		System.out.println();
		String type = sc.next();
		switch(type) {
			case "1" : 
				System.out.println("First 20 elements of Input array : ");
				printFirstTen(input);
				timer.start();
				ArrayList<Integer> result = SelectKLargestElements.select(input, k);
				System.out.println(timer.end());
				System.out.println("Using MaxHeap :");
				printList(result);
				break;
			case "2" :
				System.out.println("First 20 elements of Input array : ");
				printFirstTen(input);
				timer.start();
				String result2 = SelectKLargestElements.select_minHeap(input, k);
				System.out.println(timer.end());
				System.out.println("Using MinHeap : (The output may not be in sorted order.)");
				System.out.println(result2);
				break;
			case "3" :
				System.out.println("First 20 elements of Input array : ");
				printFirstTen(input);
				timer.start();
				ArrayList<Integer> result3 = SelectKLargestElements.select_OofN(input, k);
				System.out.println(timer.end());
				System.out.println("Using O(n) algorithm : (The output may not be in sorted order.)");
				printList(result3);
				break;
			default:
				System.out.println("You have entered wrong number to select algorithm.");
				break;
		}
				
 	}
	/**
	 * Method to create random array of given length
	 * @param length : int : length of input randrom array
	 * @return : int[] array
	 */
	public static int[] createRandArray(int length){
		int[] arr = new int[length]; //input array to be sorted
		Random rand = new Random(); //Generate random numbers used for input array
		for(int i=0; i< length; i++) {
		   arr[i] = rand.nextInt(length); // use for random number
		   //arr[i] = length - 1 - i; // use for creating descending input array
		}
		return arr;
	}
	
	/**
	 * Method to print the list
	 * @param arr : input list to be printed
	 */
	public static void printList(ArrayList<Integer> arr) {
		Iterator<Integer> itr = arr.iterator();
		while(itr.hasNext())
			System.out.print(itr.next() + "  ");
		System.out.println();
	}
	
	/**
	 * Method to print the array
	 * @param arr input array
	 */
	static void printFirstTen(int[] arr) {
        int n = Math.min(arr.length, 20);
        for(int i = 0; i< n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }		
}
