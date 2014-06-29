
public class BitManipulation {

	/*
	 * M = 111
	 * N = 1001   Mask = 11 0000 11
	 * i = 1
	 * j = 3
	 * left = 11 1111 11  << 5 +1  = 11 0000 00
	 * right =00 0000 01  << 2 = 00 0001 00 - 1 =  11 
	 *  
	 * 
	 */
	public static int insert(int n , int m , int i , int j){
		int allOnes = ~0;
		int left = ( allOnes << j+1);
		int right = ( 1 << i) - 1 ;
		int mask = left | right;
		int n_cleared = n & mask ;
		int m_shifted = m << i;
		return n_cleared | m_shifted;
	}
	public static int nextLargest(int num ){
		int c0 = 0;
		int c1 = 1;
		int c = num;
		while( ( c & 1)== 0 && (c != 0)){
			c0++;
			c >>= 1;
		}
		while( ( c & 1 ) == 1){
			c1++;
			c >>= 1;
		}
		//p = position of rightmost non trailing 0 
		int p = c0+ c1 - 1;
		if( p > 31 || p == 0){
			return -1;
		}
		//flip 0 at position p 
		num |= ( 1 << p);  
		//Clear all bits to the right of p
		num &= ~ (( 1 << p)-1);
		// Insert c1 -1 to the right
		num |= ( 1 << c1 -1) - 1;
		return num;		
	}
	public static int nextSmallest(int num ){
		int c0 = 0;
		int c1 = 0;
		int c = num;
		while( (c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		if(c == 0){
			return -1;
		}
		while( ( c & 1 ) == 0 && c!=  0){
			c0++;
			c >>= 1;
		}
		int p = c0 + c1 ; // position of rightmost 1
		System.out.println(p);
		int mask = ( ~0 << p);
		num&= mask;   //Clears from p bit onwards
		int mask1 = ( 1 << c1 + 1) - 1; // Sequence of (c1+1) ones 
		num|= mask1 << ( c0 -1);
		return num;
	}
	public static String check(double num){
		StringBuffer sb = new StringBuffer();
		sb.append('.');
		while(num > 0){
			if(sb.length() > 32){
				return "ERROR";
			}
			else{
				double r = num * 2;
				if(r > 1){
					sb.append(1);
					num = 1 - num ;
				}
				else{
					sb.append(0);
					num = r;
				}
			}
		}
		return sb.toString();
	}
	public static int bitSwappedRequired( int num1 ,int num2){
		int count = 0;
		/*
		 * 	for(int c = num1 ^ num2 ; c != 0 ; c = c >>1){
			count+= c & 1;
		}
		return count;
		 */
		for( int c = num1 ^ num2 ; c!= 0 ; c = c & (c-1)){
			count ++;
		}
		return count;
	}
	public static void isEven( int num){
		if (( num & (num -1)) == 0 ){
			System.out.println(num + " is a power of 2");
		}
		else{
			System.out.println(num + " is not a power of 2");
		}
	}
	public static void main(String[] args) {
		BitManipulation.isEven(-8);
		int count = BitManipulation.bitSwappedRequired(10, 7);
		System.out.println(count);

	}
}
