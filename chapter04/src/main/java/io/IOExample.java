package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IOExample {
	// throws IOException를 통해 오류를 없앨 수 있다.
	public static void main(String[] args) throws IOException{
		byte[] src = {1, 2, 3, 4};
		byte[] dest = null;
		
		// 주스트림 
		InputStream is = new ByteArrayInputStream(src);
		OutputStream os = new ByteArrayOutputStream();
		
		// 리턴은 integer로 리턴 할 것
		int data = -1;
		while((data = is.read()) != -1) {
			os.write(data);
		}
		
		dest = ((ByteArrayOutputStream)os).toByteArray();
		
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
		
	}

}

