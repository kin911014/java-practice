package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 9000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(Socket Address(IP Address + Port) Binding
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			log("Server Starts...[port:" + PORT + "]");

			// 3. accept (sleep상태 io가 발생하면 깨어남)
			while (true) {
				Socket socket = serverSocket.accept(); // blocking (서버가 더 밑으로 내려가지 않는다)
				new EchoServerReceiveThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.println("[server#]" + Thread.currentThread().getId() + log);
	}
}
