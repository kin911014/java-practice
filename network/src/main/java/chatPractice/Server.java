package chatPractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	private static final int PORT = 9000;
	private static final String SERVER_IP= "127.0.0.1";
	static ConcurrentHashMap<String,PrintWriter> writerArray=new ConcurrentHashMap<>();
	static List<String> nameList= new ArrayList<>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(Socket Address(IP Address + Port) Binding
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			log("[SERVER] Starts...[" + SERVER_IP + ":" + PORT + "]");

			// 3. accept (sleep상태 io가 발생하면 깨어남)
			while(true) {
				Socket socket = serverSocket.accept(); // blocking (connect 전까지 서버가 더 밑으로 내려가지 않는다)
				new ServerThread(socket, writerArray, nameList).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.println("[server#]" + Thread.currentThread().getId()+ log);
	}
}
