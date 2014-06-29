
public class compressString {
	public static String compression(String input){
		final int len = input.length();
		char last = input.charAt(0);
		int count=0 ;
		StringBuffer sb = new StringBuffer();
		int i = 0;
		int size = compressString.countCompression(input);
		if( size >= len){
			return input;
		}
		while( i < len){
			if(input.charAt(i) == last){
				count++;
			}
			else{
				sb.append(last);
				sb.append(count);
				last = input.charAt(i);
				count = 1;
			}
			i++;
		}
		sb.append(last);
		sb.append(count);
		return sb.toString();
	
	}
	public static int countCompression ( String input){
	  int i  = 0;
	  final int len=input.length();
	  int size = 0;
	  int count =  0;
	  char last = input.charAt(0);
	  if(input== "" || input.isEmpty() ){
		  return 0;
	  }
	  while(i < len){
		  if(input.charAt(i) == last){
			  count++;
		  }
		  else{
			  last = input.charAt(i);
			  System.out.println("Value of count:"+String.valueOf(count).length());
			  size+= 1 + String.valueOf(count).length();
			  count = 1;
		  }
	  i++;
	  }
	  size+= 1 + String.valueOf(count).length();
	  return size;
	  
	}
	public static void main(String[] args) {
		String input = "abbbcccdddeeefffggg";
		String output = compressString.compression(input);
		System.out.println("Input String is : "+input);
		System.out.println("Compressed String is :"+ output);
		
	}
}
