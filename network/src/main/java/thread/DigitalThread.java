package thread;

public class DigitalThread extends Thread {
// 1. 클래스 생성시 thread를 상속 설정해주어야한다

	// override해서 run 검색 후 실행하면 아래 메소드 생성
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
