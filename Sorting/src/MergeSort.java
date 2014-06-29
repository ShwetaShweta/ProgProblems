/*One of the most popular sorting algorithm,divides the input set into 2 parts ,sorts them and
 * merge them thats why its complexity is O(nlogn).Most of the task is done in the
 * merge step of the algorithm.One disadvantage is that it need additional O(n) space for
 * sorting.It is not an in- place algorithm but is stable
 * Used in case of sorting large data that does not fits into memory
 */
public class MergeSort {
	public int[] mergeSortSimple(int[] data){
		if(data.length<2){
			return data;
		}
		/* Merge sort Hybrid
		 * if(data.length < 10 ) {
		 * insertionSort(data);
		 * return data;
		 * 
		 */
		int mid = (0+data.length)/2;
		int[] left = new int[mid];
		int[] right = new int[data.length - mid];
		System.arraycopy(data, 0, left, 0, left.length);
		System.arraycopy(data, mid, right, 0,right.length);
		mergeSortSimple(left);
		mergeSortSimple(right);
		return merge(data ,left,right);
	}
	public int[] merge(int[] data,int[] left,int[] right){
		int lind = 0;
		int rind =0;
		int aind =0;
		while(lind<left.length && rind < right.length){
			if(left[lind] <= right[rind]){
				data[aind++] = left[lind++];
			}
			else{
				data[aind++] = right[rind++];
			}
		}
		while(lind < left.length){
			data[aind++] = left[lind++];
		}
		while(rind < right.length){
			data[aind++] = right[rind++];
		}
		return data;
	}
	public static void main(String[] args) {
		int[] array = {2,4,6,8,9,1};
		System.out.println("Array before sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		MergeSort objSel=new MergeSort();
		array=objSel.mergeSortSimple(array);
		System.out.println("\nArray after sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}

}
