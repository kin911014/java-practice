package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		// 비어있는 경우, StackException 이 발생
		//s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		System.out.println(s.pop());
		//peek()는 빼내지않고 맨위에 무엇이 있는지 확인만 하는것
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

}
