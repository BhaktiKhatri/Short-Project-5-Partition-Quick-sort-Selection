package cs6301.g45;
/**
 * Java Program to perform dual-pivot quick sort using Yaroslavskiy's method
 * @author Bhakti Khatri
 * @author Lopamudra Muduli
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */
import java.util.Random;

public class QuickSort {
	/**
     * Method to perform quick sort
     * @param arr: T[] - generic array to be sorted
     */
	public <T extends Comparable<? super T>> void quickSort(T[] arr) {
		quickSort(arr,0,arr.length-1);
	}
	/**
     * Method to perform quick sort
     * @param arr: T[] - generic array to be sorted
     * @param p: int - start index of arr
     * @param r: int - end index of arr
     */
	public <T extends Comparable<? super T>> void quickSort(T[] arr, int p, int r) {
        if(p<r){
        	int q=partition(arr,p,r);
        	quickSort(arr,p,q-1);
        	quickSort(arr,q+1,r);
        }
    }
	/**
     * Method to exchange two elements of array arr
     * @param arr: T[] - generic array whose elements are to be exchanged
     * @param x: int - exchange element with y
     * @param y: int - exchange element with x
     */
	public static <T> void exchange(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
	/**
     * Method to perform partition for quick sort
     * @param arr: T[] - generic array to be sorted
     * @param p: int - start index of arr
     * @param r: int - end index of arr
     * @return partition index that is used in quicksort
     */
	public <T extends Comparable<? super T>> int partition(T[] arr, int p, int r) {
		Random rand=new Random();
		int i =p+rand.nextInt(r-p+1);
		exchange(arr,i,r);
		T x = arr[r];
		i=p-1;
		for(int j=p;j<r;j++){
			if(arr[j].compareTo(x)==-1){
				i++;
				exchange(arr,i,j);
			}
		}
		exchange(arr,i+1,r);
		return i+1;
	}
	/**
     * Method to print the first 10 elements of the array
     * @param arr: T[] - array elements to be printed
     */
	public <T> void printFirstTen(T[] arr) {
        int n = Math.min(arr.length, 10);
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }	
}
