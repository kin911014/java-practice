package prob01;

public class Self {

	public static void main(String[] args) {
		int l = randomize(1,9);
		int r = randomize(1,9);
		System.out.println(l + ":" + r);
	}
	private static int randomize( int lNum, int rNum ) {
        int random = (int) ( Math.random() * rNum ) + lNum;
        return random;
        
	}
}
