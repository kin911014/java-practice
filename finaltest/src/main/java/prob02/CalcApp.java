package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.print( "두 정수와 연산자를 입력하시오 >> " );
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operation = scanner.next();
		/* operation에 따라 4칙 연산 객체를 생성하고 caculate 메서드를 호출합니다. */
		
		Arithmetic a1 = null;
		if("+".equals(operation)) {
			a1 = new Add();
		}
		if("-".equals(operation)) {
			a1 = new Sub();
		}
		if("*".equals(operation)) {
			a1 = new Mul();
		}
		if("/".equals(operation)) {
			a1 = new Div();
		}
		
		System.out.println(a1.calculate(a, b));
	}
}
