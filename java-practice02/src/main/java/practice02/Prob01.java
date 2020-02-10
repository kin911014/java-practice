package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int money = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액:");
		int input = scanner.nextInt();
		
		for (int i = 0; i < MONEYS.length; i++) {
			if(MONEYS[i] <= input) {
				money = input/MONEYS[i]; 
				input %= MONEYS[i];
			}
			System.out.println(MONEYS[i] + "원 : " +money + "개" );
		}
		
		scanner.close();
	}

}
