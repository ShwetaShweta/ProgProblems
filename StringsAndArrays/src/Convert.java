
/*
 * This class contains method to convert integer to string and string to integer
 */
public class Convert {
	public static void main(String[] args) {
		String input = "-0";
		System.out.println("Input String : " + input);
		int output = Convert.toInteger(input);
		System.out.println("Integer equivalent : " + output);
		System.out.println("Output multiplied with 2 :" + output*2);
		String op = Convert.toString(output);
		System.out.println("String equivalent of output : " + op);
	}
	public static int toInteger(String str){
		int num=0 , i = 0 , len = str.length();
		boolean negFlag = false;
		//Checking for negative number ,if number is negative then skipping the minus sign
		if(str.charAt(0) == '-'){
			negFlag = true;
			i = 1;
		}
		//Applying Horner's rule

		do{
			num*= 10;
			num+= (str.charAt(i++) - '0');
		}while ( i < len);
		//If number is negative changing its sign
		if(negFlag){
			num = -num;
		}
		return num;	 
	}

	public static String toString ( int number){
		final int MAX_DIGITS =10  ;
		int i =0;
		//Buffer can hold max digits + 1 for negative sign
		char []temp = new char[MAX_DIGITS +1 ];
		boolean isNegative = false;
		if(number < 0){
			isNegative = true;
			number = -number;
		}
		if(number == 0){
			return "0";
		}
		while(number != 0){
			temp[i++] = (char)((number % 10) + '0');
			number /=10;
		}
		StringBuilder b = new StringBuilder();
		if(isNegative){
			b.append('-');

		}
		while(i>0){
			b.append(temp[--i]);
		}
		return b.toString();
	}
	
}
