
public class ReverseCStyleString {
	public static char[] reverseStr(char[] str){
		final int len = str.length;
		int end = str.length-1;
		int start = 0;
		while(end > 0 && start < len-1 && start !=end){
			char temp = str[start];
			str[start]=str[end];
			str[end]=temp;
			//input.replace(input.charAt(end), temp);
			start++;
			end--;
		}
		return str;
	}
	public static void display(char[] input){
		for(int i =0;i<input.length;i++){
			System.out.print(input[i]);
		}
	}
	public static void main(String[] args) {
		String input = "hello how are you";
		System.out.println("Initial input:"+ input);
		char[] output = new char[input.length()];
		output=ReverseCStyleString.reverseStr(input.toCharArray());
		System.out.print("Input after reversing:");
		ReverseCStyleString.display(output);
	}
}
