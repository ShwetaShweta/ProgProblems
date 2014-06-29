
public class RemoveChar {
	public static void main(String[] args) {
		String str = "Hello how are you doing today ?";
		System.out.println("Input String is : "+ str);
		String remove = "aeiou";
		String output = RemoveChar.removeChar(str, remove);
		System.out.println("After removing characters : " + remove);
        System.out.println("Ouput String is : "+ output);				
	}
	/*
	 * Remove all the characters of the string "remove" from the input string "str"
	 */
   public static String removeChar(String str,String remove){
       char []r = remove.toCharArray();
       char []s = str.toCharArray();
       int src = 0 , dest = 0 ;
       boolean []flags = new boolean[128];
       //For all the characters in "remove" assign its corresponding ASCII index as true
       for(src = 0 ; src < r.length ; src++){
    	   flags[r[src]] = true;
       }
       /*Copy only of corresponding ASCII value of "str" characters are false in the "flags" array
        * else skip that index
        */
       for(src = 0; src < s.length; src++){
    	   if(!flags[s[src]]){
    		   s[dest++] = s[src];
    	   }
       }
       return new String (s , 0 , dest);
   }
}
