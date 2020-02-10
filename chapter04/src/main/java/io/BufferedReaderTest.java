package io;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {// 기반스트림
			FileReader fr = new FileReader("./secondWeekClass/io/BufferedReaderTest.java");

			br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				System.out.println(":");
				System.out.println(line);
				System.out.println("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일없음" + e);
		} catch (IOException e) {
			System.out.println("error - " + e);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}