
import java.util.HashMap;
public class UniqueChar {
	public static boolean uniqueChar(String input){
		final int len = input.length();
		HashMap<Integer,String> unique= new HashMap<Integer,String>();
		int j =0;
		while(j  <len){
			int cp = input.codePointAt(j);
			j+= Character.charCount(cp);
			if(unique.containsKey(cp)){
				unique.put(cp, "seenMoreThanOnce");
				return false;
			}
			else{
				unique.put(cp, "seenOnce");
			}
			j++;
		}
		return true;
	}
	public static void main(String[] args) {
		String input ="hjhjk";
		boolean ret = UniqueChar.uniqueChar(input);
		if(ret){
			System.out.println("String "+input+" contains unique characters");
		}
		else{
			System.out.println("String "+ input + " does not contains unique characters");
		}
	}
}
