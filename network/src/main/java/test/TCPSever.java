package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPSever {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 1. 클라이언트가 먼저 닫고 time-Wait 시간에 소켓에 포트번호 할당을 가능하게 하기위해서. 서버에서는 필수!
			
			serverSocket.setReuseAddress(true);
			

			// 2. 바인딩(Socket Address(IP Address + Port) Binding
			serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000));

			// 3. accept (sleep상태 io가 발생하면 깨어남)
			Socket socket = serverSocket.accept(); // blocking (서버가 더 밑으로 내려가지 않는다)
			InetSocketAddress remoteInetSocketAddress 
			= (InetSocketAddress) socket.getRemoteSocketAddress();

			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();

			System.out.println("[server]connected by client[" + remoteHostAddress + ":" + remotePort + " ] ");
			try {
				// 4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				while (true) {
					// 5. data읽기
					byte[] buffer = new byte[256];

					int readByteCount = is.read(buffer); // blocking 발생
					System.out.println("readByteCount값 :" + readByteCount);
					if (readByteCount == -1) {
						// client에서 정상종료
						System.out.println("[server]close by client");
						break;
					}

					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server]received:" + data);

//					try {
//						Thread.
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
					
					// 6. 데이터쓰기
					os.write(data.getBytes("UTF-8"));
				}
			} catch (SocketException e) {
				System.out.println("[server] sudden closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
