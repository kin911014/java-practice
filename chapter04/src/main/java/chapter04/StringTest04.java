package chapter04;

public class StringTest04 {

	public static void main(String[] args) {
		String s = "aBcABCabcAbc";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc"));
		System.out.println(s.indexOf("abc", 3));
		System.out.println(s.indexOf("abc",7));
		System.out.println(s.substring(3));
		System.out.println(s.substring(3,5));

		String s2 = "   ab cd   ";
		String s3 = "dfg,hijk,lmno,pq";
				
		String s4 = s2.concat(s3);
		
		System.out.println(s4);
		System.out.println(s3);
		// trim은 가운데를 제외한 양쪽의 스페이스 여백을 없애는것
		System.out.println("-----" + s2.trim() + "-----");
		System.out.println("-----" + s2.replaceAll(" ", "") + "-----");
		
		String[] tokens = s3.split(":");
		for (String str : tokens) {
			System.out.println(str);
		}
		
		// append는 StringBuffer는 append로 배열을 늘려 단어를 추가
//		String str = "Hello" + "World" + "Java" + 1000;
		String str = new StringBuffer("Hello").append("world").append(1000).toString();
		
		System.out.println(str);
		
		// 주의: + 문자열연산
		String str2 = "";
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < 10000; i++) {
//			str2 = str2 + i;
			sb.append('c');
		}
		System.out.println(sb.length());
		//format
		String name = "둘리";
		int score = 100;
		
		System.out.println(name + "님의 점수는 "+ score + "점 입니다.");
		String str3 = String.format("%s님의 점수는 %d점 입니다.", name, score);
		System.out.println(str3);
	}
	

}
