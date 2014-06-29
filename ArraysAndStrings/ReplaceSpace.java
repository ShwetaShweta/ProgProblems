
public class ReplaceSpace {


	public static boolean permutaion(String str1,String str2){
		//Base condition
		if(str1.length()!= str2.length()){
			return false;
		}
		char[] charArr1 = new char[256];
		char[] charArr2 = new char[256];
		for(int i = 0 ; i < str1.length();i++){
			int index = str1.charAt(i);
			charArr1[index]++;
		}
		for(int i = 0 ; i < str2.length();i++){
			int index = str2.charAt(i);
			charArr2[index]++;
		}
		for(int i = 0 ; i < str1.length();i++){
			int index = str1.charAt(i);
			if(charArr1[index]!= charArr2[index]){
				return false;
			}
		}
		return true;
	}
	public static char[] replaceSpace(char[] input,int length){
		int spaceCount=0 , newLength ;
		for(int i = 0 ; i < length ; i ++){
			if(input[i] == ' '){
				spaceCount++;
			}
		}
		newLength = length + (spaceCount * 2);
		input[newLength] = '\0';
		for(int i = length-1 ; i > 0 ; i--){
	              if(input[i] == ' '){
	            	  input[newLength - 1] = '0';
	            	  input[newLength - 2] = '2';
	            	  input[newLength - 3] = '%';
	            	  newLength = newLength - 3;
	              }
	              else{
	            	  input[newLength-1] = input[i];
	            	  newLength = newLength - 1 ;
	              }
		}
		return input;

	}
	public static void main(String[] args) {
		String str1 = "abbba";
		String str2 = "babaB";
		String str3 = "hello I am Shweta\0\0\0\0\0\0\0";
		char[] input = new char[24];
		input=str3.toCharArray();
		boolean ret = ReplaceSpace.permutaion(str1, str2);
		if(ret == true){
			System.out.println(str1 + " and " + str2 +  " are permutations of each other");
		}
		else{
			System.out.println(str1 + " and " + str2 + " are not permutaions of each other");
		}
		
		input=ReplaceSpace.replaceSpace(input, 17);
	    ReverseCStyleString.display(input);  
	}
}
