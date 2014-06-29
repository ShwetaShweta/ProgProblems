
/*Sorts like a person would sort a deck of card,best case running time is O(n),when
 *the list is already sorted,so it is good for inserting new elements in a pre-sorted list
 *It is an in place stable algorithm,often used for sorting small data sets and increase
 *efficiency of large data sets
 */
public class InsertionSort { 
	public void insertionSort(int[] array){
		int i , j;
		int key;
		for (j = 1; j <array.length;j++){
			i = j;
			key = array[j];
			while(i>0 && array[i-1]>key){
				array[i] = array[i-1];
				i--;
			}
			array[i] = key;
		}
	}
	 
	public static void main(String[] args) {
		int[] array = {2,4,6,8,9,1,2};
		System.out.println("Array before sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		InsertionSort objSel=new InsertionSort();
		//objSel.selectionSortRecursive(array);
		objSel.insertionSort(array);
		System.out.println("\nArray after sorting:");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
}
