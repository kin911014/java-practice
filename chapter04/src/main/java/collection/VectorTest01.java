package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		// 옛날방식
		Vector<String> v = new Vector<>();
		v.addElement("둘리");
		v.addElement("마이클");
		v.addElement("도우넛");

		// 순회1
		int count = v.size();
		for (int i = 0; i < count; i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		v.removeElementAt(1);
		
		// 순회 2, 가능하면 사용x
		Enumeration<String> e = v.elements();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
			
		}
			
	}

}
