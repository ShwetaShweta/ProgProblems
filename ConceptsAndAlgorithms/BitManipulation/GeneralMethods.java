
public class GeneralMethods {
	/*Bitwise operations are , & , | , ^ ,~ , << , >>
	 * 
	 */
	//Get ith bit of given number
	public int getBit(int num , int bit){
		if((num & (1 << bit))!=0){
			return 1;
		}
		else{
			return 0;
		}
	}
	// 1000 | 1001 = 1001 (9)
	public int setBit(int num , int bit){
		System.out.println( 1 << bit);
		return ( num | ( 1 << bit));
	}
	/*
	 * num = 1001
	 * bit = 2;
	 * ( 0001 << 3 ) = 1000
	 * ~1000 = 0111
	 *  1001 & 0111 = 0001   ( Set all other bit in mask to be 1 except the bit to be set) 
	 */
	public int clearBit ( int num , int bit){
		int mask = ~( 1 << bit);
		return ( num & mask);
	}
	/*
	 * clear all bits from MSB to i(inclusive)
	 * we need a sequence of 0s followed by i 1's
	 * (20,3) = (10100,3) = 00011
	 * (00001 << 3) = (01000 ) 
	 * 01000                 01000                  
	 *-00001   = 11110 + 1 = 11111
	 *                      -------
	 *                      100111
	 *  10100 & 00111 = 00100                    
	 */ 
	public int clearMSBThroughI ( int num , int bit){
		int mask = (1 << bit) - 1;
		return ( num & mask);
	}
	/*(20 ,2) =  ( 10100 , 2 ) = (10000)
	 * 1's followed by i 0's
	 *  -1 = 11111 >>> 31-2 =  11111 >> 29 = ~(00111) = 11000
	 *  (10100 & 11000) = 10000
	 *      
	 */
	public int clearBitsIThrough0 ( int num , int bit){
		int mask = ~(-1 >>> ( 32 - bit));
		System.out.println(mask);
		return num & mask;
	}
	/* (10100 , 2 , 0 ) = ( 10000) = 16
	 * (00001 << 2) = ~00100 = 11011
	 * (00000 << 2 ) = 00000   // (00001 << 2) = 00100
	 * (NUM & MASK) = (10100 & 11011) = 10000
	 * (10000) |  00000) = 10000
	 *  10000 | 00100 = 10100 
	 *   
	 */

	public int updateBit(int num , int i , int v){
		int mask = ~( 1 << i);
		return (num & mask) | ( v << i);
	}

	public static void main(String[] args) {
		GeneralMethods obj = new GeneralMethods();
		int ret = obj.updateBit(20,2 ,0);
		System.out.println(ret);
	}
}

