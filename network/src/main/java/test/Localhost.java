package test;

import java.net.InetAddress;

public class Localhost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
//			byte[] addresses = inetAddress.getAddress();
//			System.out.println(Arrays.toString(addresses));
			
//			for(byte address : addresses) {
//				System.out.println(address & 0x000000ff);
			System.out.println(hostname);
			System.out.println(hostAddress);
			
			
		} catch (java.net.UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
