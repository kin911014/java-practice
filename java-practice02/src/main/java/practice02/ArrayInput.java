package practice02;

import java.util.Scanner;

public class ArrayInput {

	public static void main(String[] args) {
		// 배열로 점수 10개 받아서 평균내기

		// 실수형 배열 선언

		double score[] = new double[10];

		// 평균 계산을 위한 총합 변수 선언

		double total = 0;

		// 스캐너로 점수 받아오기

		Scanner input = new Scanner(System.in);

		System.out.print("점수 10개를 입력하세요 : ");

		// 차례대로 점수를 받아서 총합을 계산하기

		for (int i = 0; i < score.length; i++) {

			score[i] = input.nextDouble();

			total += score[i];

		}

		// 평균 계산

		double average = total / score.length;



		System.out.println("평균은 " + average + "입니다.");


		input.close();
	}

}
