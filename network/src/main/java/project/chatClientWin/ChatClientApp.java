package project.chatClientWin;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChatClientApp {
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=5005;
	static List<String> clientList = new ArrayList<>();
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket=null;
		
		try {
			// 1. socket 
			socket= new Socket();
			// 2. connect to server 
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			// 3. ioStream 생성 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			PrintWriter	pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			
			while(true ) {
				log(" Insert your Nickname");
				name = scanner.nextLine().trim();
				
				if(!name.isEmpty()) {
					break;
				}
			}
			pw.println(name);
			String ck=br.readLine();
			while(!"ok".equals(ck)) {
				log(" 중복입니다 다시 입력해주세요 : ");
				name=scanner.nextLine();
				if(name.isEmpty()) {
					continue;
				}
				pw.println(name);
				ck=br.readLine();
			}
			scanner.close();
		
		// 4. join 프로토콜 요청 및 처리 
		pw.println("join:"+name);
		
		// 5. join이 성공 응답을 받으면 실행 
		String joinCheck = br.readLine();
		log(" connecting....");
		if("join:ok".equals(joinCheck))
			new ChatWindow(name,socket).show();
			
		}catch(Exception e){
			e.printStackTrace();
	      }
	}
	public static void log(String log) {
		System.out.println("[Client #+"+Thread.currentThread().getId()+"]"+log);
	}
}
