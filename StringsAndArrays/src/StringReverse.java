
public class StringReverse {

	public static void main(String[] args) {
		String input = "Hello how are you doing today? I hope  you are fine.";
		System.out.println("Before reversing : "+ input);
		String output = StringReverse.strReverse(input);
		System.out.println("After reversing : "+ output);
	}
	public static String strReverse(String input){
		String []splString = input.split(" ");
		final int len = splString.length;
		int i = len;
		StringBuffer sb = new StringBuffer();
		for( i = splString.length-1 ; i >= 0 ; i--){
			sb.append(splString[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
}
