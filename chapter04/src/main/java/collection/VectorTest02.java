package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		// 아래 코드가 잘 쓰이는 개념
		List<String> list = new Vector<>();
		
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
		
		// 순회2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		// 순회 3
		for (String s : list ) {
			System.out.println(s);
		}
	}

}
