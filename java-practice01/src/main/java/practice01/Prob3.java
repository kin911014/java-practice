package practice01;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요:");
		int sum = 0;
		int input = scanner.nextInt();
		for (int i = 0; i <= input; i++) {
			if (input % 2 == 0 && i % 2 == 0) {
				sum += i;
			} else if(input % 2 == 1 && i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과값: " + sum);
	}
}
