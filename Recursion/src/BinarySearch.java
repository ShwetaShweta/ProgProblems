public class BinarySearch {
	//Note - Replace illegal argument with BSException everywhere
	public static int binarySearch(int[] array ,int target){
		return binarySearch(array,target,0,array.length-1);
	}
	public static int binarySearch(int[] array,int target, int lower , int upper ){
		int center;
		int range = upper - lower ;
		if(array[lower] > array [upper]){
			throw new IllegalArgumentException ("Array not sorted");
		}
		if(range == 0 && array[lower]!=target){
			throw new IllegalArgumentException ("Target value not in array");
		}
		if(range<0){
			throw new IllegalArgumentException ("Limits reversed");
		}
		center = (range/2) + lower;
		if(array[center] == target){
			return center;
		}
		else if (array[center] < target){
			return binarySearch(array,target,center+1,upper);
		}
		else{
			return binarySearch(array,target,lower,center-1);
		}

	}
	public static int iterBinarySearch(int []array,int target){
		int center;
		int lower = 0 , upper = array.length-1;
		if(lower > upper ){
			throw new IllegalArgumentException ("Limit reversed");
		}

		while(true){
			center = ((upper - lower)/2) + lower;
			if( array[lower] > array[upper]){
				throw new IllegalArgumentException ("Array Not sorted");
			}
			if((upper - lower) ==0 && array[lower]!=target ){
				throw new IllegalArgumentException ("Target not found");
			}
			if(array[center] == target){
				return center;
			}
			else if ( array[center] < target){
				lower = center +1;
			}
			else{
				upper = center -1;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		int target = 20;
		int result = BinarySearch.binarySearch(array, target);
		int r = BinarySearch.iterBinarySearch(array, target);
		System.out.println("Element found at : "+result);
		System.out.println("Iterative binary search element found at:"+r);
	}

}
