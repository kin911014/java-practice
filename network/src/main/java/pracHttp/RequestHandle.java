//package pracHttp;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//
//public class RequestHandle extends Thread {
//	private static final String DOCUMENT_ROOT = "./webapp";
//	private Socket socket;
//
//	public RequestHandle(Socket socket) {
//		this.socket = socket;
//	}
//
//	@Override
//	public void run() {
//		try {
//			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
//			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress());	
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//			OutputStream outputStream = socket.getOutputStream();
//			
//			String request = null;
//			
//			while(true) {
//				String line = br.readLine();
//				
//				// 브라우저가 연결 끊음
//				if(line == null) {
//					break;
//				}
//				if("".equals(line)) {
//					break;
//				}
//				//header의 첫번째 라인만 읽음
//				if(request == null) {
//					request = line;
//					break;
//				}
//				}
//				consoleLog(request);
//				String[] tokens = request.split(" ");
//			
//				if("GET".equals(tokens[0])) {
//				responseStaticResource(outputStream, tokens[1], tokens[2])
//				
//				}else {
//					error 400(outputStream , tokens[2]);
//				
//			
//			
//			
//			
//				}catch(Exception ex) {
//					consoleLog("error" : +ex);
//				}finally {
//					try {
//						if(socket != null && socket.isClosed() == false) {
//							socket.close()
//						}
//						
//					} catch (Exception e) {
//						consoleLog("error" + ex)
//					}
//				}
//	
//	}
//
//	public void consoleLog(String message) {
//		System.out.println("[RequestHandle#" + getId() + "]" + message);
//	}
//
//}
