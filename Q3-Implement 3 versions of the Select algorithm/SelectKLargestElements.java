package cs6301.g45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
/**
* Implementation of select of k largest elements of an array.
* @author 	Lopamudra
* 				Bhakti Khatri
* 				Gautam Gunda
* 				Sangeeta Kadambala
*/

public class SelectKLargestElements {
	
	/** Using MaxHeap to select k largest elements
	 * @param arr : int Input array 
	 * @param k : int k largest elements
	 * @return ArrayList<Integer> : having list of k largest elements
	 */
	public static ArrayList<Integer> select(int[] arr, int k) {
		 PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
		        @Override
		        public int compare(Integer o1, Integer o2) {
		            return o2-o1;
		        }
		    });
		for(int i = 0; i < arr.length; i++ )
			maxheap.add(arr[i]);
		ArrayList<Integer> resultList = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			resultList.add(maxheap.remove());
		}
		return resultList;
	}
	
	/** Using MinHeap to select k largest elements
	 * @param arr : int Input array 
	 * @param k : int k largest elements
	 * @return ArrayList<Integer> : having list of k largest elements
	 */
	public static String select_minHeap(int[] arr, int k){
		Iterator<Integer> itr = Arrays.stream(arr).iterator();
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		int i = 0;
		while(i < k) {
			if(itr.hasNext()) {
				minHeap.add(itr.next());
				i++;
			}else 
				return Arrays.toString(minHeap.toArray());
		}
		while(itr.hasNext()) {
			int x = itr.next();
			if(minHeap.peek() < x) {
				minHeap.remove();
				minHeap.add(x);
			}
		}
		return Arrays.toString(minHeap.toArray());
	}
	
	/** Using Partition to select k largest elements : O(n)
	 * @param arr : int Input array 
	 * @param k : int k largest elements
	 * @return String : of k largest elements
	 */
	public static ArrayList<Integer> select_OofN(int[] arr, int k) {
		int n = arr.length;
		ArrayList<Integer> result = new ArrayList<>();
		if(k <= 0)
			return result ;
		if(k >= n) {
 			return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		}
		select(arr, 0, n, k);
		for(int i = n - k; i < n; i++)
			result.add(arr[i]);
		return result ;
	}
	/**
	 * Helper recursion function for select_OofN
	 * @param arr:  int  array :  Input array 
	 * @param p : int : start index of input array
	 * @param n : int : total number of elements in the array
	 * @param k : int : k largest elements
	 * @return
	 */
	public static int select(int[] arr, int p, int n, int k) {
		int rIndex = p + n - 1;
		if(n < 17) {
			InsertionSort.insertionsort(arr, p, rIndex);
			return arr[p + n - k];
		}else {
			int q = partition(arr, p, rIndex);
			int left = q - p;
			int right = rIndex - q;
			if(right >= k)
				return select(arr, q + 1, right, k);
			else if( right + 1 == k)
				return arr[q];
			else
				return select(arr, p, left, k);
		}
	}
	
	/**
	 * Partition function
	 * @param arr : int  array :  Input array 
	 * @param p : int : start index of input array
	 * @param r : int : end index of input array
	 * @return int : index of partition i.e pivot element index
	 */
	public static int partition(int[] arr, int p, int r) {
		int pivot = arr[r];
		int i = p - 1, j;
		for(j = p; j <= r - 1; j++) {
			if(arr[j] <= pivot) {
				i ++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, r);
		return i + 1;
	}
	
	/**
	 * Exchange function 
	 * @param arr : int  array :  Input array 
	 * @param i : index to be swapped
	 * @param j : index to be swapped
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
