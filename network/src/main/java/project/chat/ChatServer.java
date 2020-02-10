package project.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class ChatServer {
	private static final int PORT=5005;
	private static final String SERVER_IP = "127.0.0.1";
	static ConcurrentHashMap<String,PrintWriter> writerArray=new ConcurrentHashMap<>();
	static List<String> nameList= new ArrayList<>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		
		try {
		 // 1. 서버 소켓 생성	
		 serverSocket= new ServerSocket();
		 // 2. 바인딩(Socket Address(IP Address+ port) Binding)
		 serverSocket.bind(new InetSocketAddress(SERVER_IP,PORT));
		 log(" Start..." + SERVER_IP + PORT );
		 
				//3. accept
				while(true) {
					Socket socket = serverSocket.accept();
					new ChatServerThread(socket,writerArray,nameList).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
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
		System.out.println("[Server #+"+Thread.currentThread().getId()+"]"+log);
	}

}
