package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp에서 \는 tap의 역할로 여백을 준
		// c:\\temp   결과: c:\temp로 결과출력
		System.out.println("c:\\temp");
		//"hello"
		System.out.println("\"hello\"");
		
		// 제어문자
		// \t -> tab
		// \n -> New Line(개행)
		// \r -> Carrage Return
		System.out.print("HELLO\tWorld\r\n");
		System.out.print("HELLO\tWorld\n");
		
		char c = '\'';
		System.out.println(c);
	}

}
