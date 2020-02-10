package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		for (int i = 0; i < COUNT_GOODS; i++) {
			goods[i] = new Goods();

			String sc = scanner.nextLine();
			String[] token = sc.split(" ");
			goods[i].setDrink(token[0]);
			goods[i].setPrice(Integer.parseInt(token[1]));
			goods[i].setAmount(Integer.parseInt(token[2]));

		}
		for (int j = 0; j < COUNT_GOODS; j++) {

			System.out.println(
					goods[j].getDrink() + "(가격:" + goods[j].getPrice() + ")이 " + goods[j].getAmount() + "개 입고 되었습니다.");
		}

		scanner.close();
	}
}
