/* Compares an element in an array to all the elements after its index,if a key with smaller
 * value is found , the keys are replaced
 * Running time is O(n^2) , It's an in place algorithm but not stable
 * Preferred - When moving data is more expensive then comparing them
 */
public class SelectionSort {
    public void stableSelectionSort(int[] data){
    	for(int start = 0; start < data.length;start++){
    		insert(data,start,findMinimumIndex(data,start));
    	}
    }
    public void insert(int[] data,int start,int minIndex){
    	if(minIndex>start){
    		int temp = data[minIndex];
    		System.arraycopy(data,start,data,start+1,minIndex-start);
    		data[start]=temp;
    	}
    }
	public void  selectionSortRecursive(int[] data){
		selectionSortRecursive(data , 0);
	}
	public void selectionSortRecursive(int[] data , int start){
		while(start < data.length-1){
			swap(data,start,findMinimumIndex(data,start));
			++start;
			selectionSortRecursive(data,start);
		}
	}
	public int findMinimumIndex(int[] data,int from){
		int minpos=from;
		for(int i = from+1; i < data.length ;++i){
			if(data[i] < data[minpos]){
				minpos = i;
			}
		}
		return minpos;
	}
	public void swap (int[] data ,int index1,int index2){
		if(index1!=index2){
			int element1 = data[index1];
			data[index1] = data[index2];
			data[index2] = element1;
		}
	}
	public void selectionSortIterative(int[] data){
		int current = 0;
		final int len = data.length;
		while(current < len -1){
			int minpos = current;
			for(int i = current+1 ; i < len ; ++i){
				if ( data[i] < data[minpos]){
					minpos = i;
				}	 
			}
			if(minpos != current){
				int temp = data[current];
				data[current] = data[minpos];
				data[minpos]=temp;
			}
			++current;
		}
	}
	public static void main(String[] args) {
		int[] array = {2,4,6,8,9,1,2,9,8,7};
		System.out.println("Array before sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		SelectionSort objSel=new SelectionSort();
		//objSel.selectionSortRecursive(array);
		//objSel.selectionSortIterative(array);
		objSel.stableSelectionSort(array);
		System.out.println("\nArray after sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
}
