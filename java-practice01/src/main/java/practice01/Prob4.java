package practice01;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String input = scanner.nextLine();
		
		for (int i = 0; i <= input.length(); i++) {
			System.out.println(input.substring(0, i));
		}
		
		scanner.close();
	}

}
