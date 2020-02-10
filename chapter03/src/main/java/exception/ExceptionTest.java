package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 11 -a;
		System.out.println("some code0");
		try {
			System.out.println("some code1");
			int result = (1 + 2 + 3) / b;
		 	System.out.println("some code2");
		}catch(ArithmeticException x) {
			// 1. 사과
			System.out.println("죄송합니다. 비정상적인 종료로 인하여 오류가 발생하였습니다.");
			// 2. 로그 남기기(파일 or DB)
			System.out.println(x);
			// 3. 정상종료
			return;
		}finally {
			System.out.println("some code 4");
		}
		System.out.println("some code5");
	}

}
