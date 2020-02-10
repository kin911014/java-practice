package prob01;

public class Printer{
	
//	public void println(int a) {
//		System.out.println(a);
//	}
//	
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//	
//	public void println(double c) {
//		System.out.println(c);
//	}
//	
//	public void println(String d) {
//		System.out.println(d);
//	}
//	
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	// 가변변수: 여러 변수를 한꺼번에 넣기
	public int sum(int... nums) {
		int sum = 0;
		for(int n :nums) {
			sum += n;
		}
		return sum;
	}
	
	public <T> void println(T... ts) {
		for(T t:ts) {
			System.out.println(t);
		}
	}
}
