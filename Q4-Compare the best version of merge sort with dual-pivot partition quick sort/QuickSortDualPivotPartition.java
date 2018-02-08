package cs6301.g45;

/**
 * Java Program to perform dual-pivot quick sort using Yaroslavskiy's method
 * @author Bhakti Khatri
 * @author Lopamudra Muduli
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */

public class QuickSortDualPivotPartition {
	
	/**
     * Method to perform dual-pivot quick sort
     * @param arr: T[] - generic array to be sorted
     * @param p: int - start index of arr
     * @param r: int - end index of arr
     */
    public <T extends Comparable<? super T>> void dPQuickSort(T[] arr, int p, int r) {
        int[] index = dualPivotPartition(arr, p, r);
        if(index != null) {
	        dPQuickSort(arr, p, index[0] - 1);				//S1=arr[p+1...k-1]
	        if (index[2] != 1) { 							//if x1 = x2 then there are no unprocessed elements to sort; so dPQuickSort S2 only if x1 != x2
	        	dPQuickSort(arr, index[0] + 1, index[1]);	//S2=arr[k...i-1]
	        }
	        dPQuickSort(arr, index[1], r);					//S3=arr[j+1...r-1]
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
     * Method to perform dual-pivot partition by Yaroslavskiy's method
     * @param arr: T[] - generic array
     * @param p: int - start index of array arr
     * @param r: int - end index of array arr
     * @return partition index of array that are used in dPQuickSort S1, S2 & S3
     */
    public <T extends Comparable<? super T>> int[] dualPivotPartition(T[] arr, int p, int r) {
        
    	if (p >= r) return null;				//x1 <= x2; x1 = arr[p], x2 = arr[r]
        
        if (arr[p].compareTo(arr[r]) == 1) {	//if pivot1 > pivot2 then exchange them
        	exchange(arr, p, r);
        }
        
        T x1 = arr[p];		//Pivot1		
        T x2 = arr[r];		//Pivot2
        
        int pivotFlag = 0;
        if (x1.compareTo(x2) == 0) pivotFlag = 1;	//To check if both the pivots are equal	
        
        //Loop invariant
        int i = p + 1;
        int k = i;
        int j = r - 1;
        
        //unprocessed elements
        while (i <= j) {
             
        	if((x1.compareTo(arr[i]) == 0 || x1.compareTo(arr[i]) == -1) && (x2.compareTo(arr[i]) == 0 || x2.compareTo(arr[i]) == 1)) {	//Case 1: x1<=arr[i]<=x2
                i++;						//S2 grows by 1
            }
        	else if(arr[i].compareTo(x1) == -1)  {	//Case 2: arr[i] < x1
        		exchange(arr, k, i);		//S1 grows by 1
                k++;
                i++;
            }
        	else if(arr[j].compareTo(x2) == 1)  {	//Case 3: arr[j] > x2
                j--;						//S3 grows by 1
            }
        	else if(arr[i].compareTo(x2) == 1 && arr[j].compareTo(x1) == -1)  {		//Case 4: arr[i] > x2 & arr[j] < x1
        		exchange(arr, i, j);		//Circular swap arr[k] ->arr[i] -> arr[j] ->arr[k]
                j--;
                exchange(arr, i, k);
                k++;
                i++;
            }	
        	//Case 5: arr[i] > x2 & x1 <= arr[j] <= x2
        	else if(arr[i].compareTo(x2) == 1 && ((x1.compareTo(arr[j]) == 0 || x1.compareTo(arr[j]) == -1) && (x2.compareTo(arr[j])==0 || x2.compareTo(arr[j]) == 1))) {
        		exchange(arr, i, j);		//S2 & S3 grows by 1 each
                i++;
                j--;
            }
        }
        
        exchange(arr, p, k - 1);							//Exchange arr[p] <-> arr[k-1]
        exchange(arr, j + 1, r);							//Exchange arr[j+1] <-> arr[r]
        
        int[] partitionIndex = {k - 1, i, pivotFlag};		//indexes used in dPQuickSort
        return partitionIndex;
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