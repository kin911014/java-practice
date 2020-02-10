package thread;

public class UppercaseAlpahbetRunnableImpl extends UppercaseAlpahbet implements Runnable {
 //UppercaseAlpahbetRunnableImpl 는 UppercaseAlpahbet을 상속, Runnable을 interface로 Implement했다는의미
	@Override
	public void run() {
		print();

	}

}
