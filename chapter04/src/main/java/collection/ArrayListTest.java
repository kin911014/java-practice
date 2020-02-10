package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {


	public static void main(String[] args) {
		// 아래 코드가 잘 쓰이는 개념
		
		List<String> list = new ArrayList<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		// 순회
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String s = list.get(i);
			System.out.println(list.get(i));
		}
		
		list.remove(1);
		list.remove(new String("둘리"));
		
		// 순회2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		list.add(0, "또치");
		
		// 순회 3(for each)
		for (String s : list ) {
			System.out.println(s);
		}

	}

}
