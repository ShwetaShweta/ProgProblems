import java.util.HashMap;

/*
 * This class finds the first non repeating char in the input String
 */
public class NonRepeatedChar{
	
	/* Description - Finds the first non repeated char in the input string,considers
	 * Unicode encoding of characters(16-bit space),counts the occurrence of each character
	 * and return the first with count as 1 
	 * Input        -  String named input
	 * Output       -  First non - repeatable string ,if not present then returns null
	 */
	public static String nRC(String input){
		HashMap<Integer,Object> charHash =new HashMap<Integer,Object>();
		Object seenOnce = new Object() , seenMany = new Object();
		Object seen;
		int i;
		final int length =input.length();
		for( i = 0; i< length;){
			final int cp = input.codePointAt(i);
			//System.out.println("Code Point value of "+ input.charAt(i) + " is " + cp +
			//		",and number of char needed to store it is:" + Character.charCount(cp));
			i+= Character.charCount(cp);
			seen = charHash.get(cp);
			if(seen == null){
				charHash.put(cp, seenOnce);
			}
			else {
				if (seen ==  seenOnce){
					charHash.put(cp, seenMany);
				}
			}
		}
		//Search hash table in order of String
		for(i =0; i< length;){
			final int cp =input.codePointAt(i);
			i+= Character.charCount(cp);
			if(charHash.get(cp) == seenOnce){
				return new String (Character.toChars(cp));
			}
		}
		return null;
	}
	public static void main(String[] args) {
		String input = "hello";
		String output =NonRepeatedChar.nRC(input);
		if(output == null){
			System.out.println("No distinct character present in the string "+ input);
		}
		else
			System.out.println("First Non Repeated Character is:"+ output);
	}
}
