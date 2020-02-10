package practice02;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		String rev = sb.reverse().toString();
		System.out.println(rev);
		String result = rev;
//		String revString = reverseString(str);
		
		
//		String result ="";
//		String rev = reverseString(str)z
//		for (int i = 0; i < array.length; i++) {
//			
//		}
		
		return result;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		
	}
}
