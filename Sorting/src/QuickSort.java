
public class QuickSort {
	//Hoare's algorithm - this is in place 
	public void optimizedQuickSort(int[] data){
		optimizedQuickSort(data, 0 , data.length-1);
	}
	public void optimizedQuickSort(int[] data , int left , int right){
		int pivotIndex = (left+right)/2;
		int pivotValue = data[pivotIndex];
		int i = left;
		int j = right;
		while(i<=j){
			//Find the leftmost value greater than the pivot
			while(data[i]<pivotValue)i++;
			//Find the smallest value less than the pivot
			while(data[j]>pivotValue)j--;
			//If the values are in wrong order,swap them
			if(i<=j){
				swap(data,i,j);
				i++;
				j--;
			}
			//Apply the algorithm to the partitions we made
			if(left<j){
				optimizedQuickSort(data,left,j);
			}
			if(i<right){
				optimizedQuickSort(data,i,right);
			}

		}
	}
	public int[] quickSortSimple(int[] data){
		if(data.length<2){
			return data;
		}
		int pivotIndex = (data.length)/2;
		int pivotValue = data[pivotIndex];
		int leftCount = 0;
		//Count how many are less than pivot
		for(int i = 0 ; i < data.length ; i++){
			if (data[i] < pivotValue){
				++leftCount;
			}
		}
		//Allocate left array and right array
		int[] left = new int[leftCount];
		int[] right = new int[data.length - leftCount-1];
		int lind = 0;
		int rind = 0;
		for(int i = 0; i <data.length ; i++){
			if(i== pivotIndex) continue;
			int val = data[i];
			if(val < pivotValue){
				left[lind++] = val;
			}
			else{
				right[rind++] = val;
			}
		}
		//Sort the subsets
		left = quickSortSimple(left);
		right = quickSortSimple(right);
		//Combine the sorted arrays and put the pivot back in
		System.arraycopy(left,0,data,0,left.length);
		data[left.length]=pivotValue;
		System.arraycopy(right, 0,data,left.length+1 ,right.length);
		return data;

	}
	public void swap (int[] data ,int index1,int index2){
		if(index1!=index2){
			int element1 = data[index1];
			data[index1] = data[index2];
			data[index2] = element1;
		}
	}
	public static void main(String[] args) {
		int[] array = {13,19,9,5,12,8,7,4,11,2,6,21};
		System.out.println("Array before sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		QuickSort objSel=new QuickSort();
		objSel.optimizedQuickSort(array);
		//array=objSel.quickSortSimple(array);
		System.out.println("\nArray after sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
}
