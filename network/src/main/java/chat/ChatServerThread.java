
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;



public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName;
	ConcurrentHashMap<String,PrintWriter> writerArray;
	List<String> nameList;
	
	public ChatServerThread(Socket socket,ConcurrentHashMap<String,PrintWriter>writerArray,List<String> nameList) {
		this.socket=socket;
		this.writerArray=writerArray;
		this.nameList=nameList;
		
	}
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		ChatServer.log(" connected by client " + remoteHostAddress + ":" + remotePort);
		
		try {
			//4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			String name=br.readLine();
			while(nameList.contains(name)){
				pw.println("no");
				name=br.readLine();
			}
			pw.println("ok");
			
			synchronized(nameList) {
			nameList.add(name.trim());
			}
			
			while(true) {
				//5. 데이터 읽기
				String request = br.readLine();
				if(request == null) {
					ChatServer.log(" closed by client");
					break;
				}
				String[] tokens = request.split(":");
				if(tokens.length==0) {
					domessage(request);
				}   // 방 입장
				else if("join".equals(tokens[0])) {
					dojoin(tokens[1],pw);
					// 퇴장
				}else if("quit".equals(tokens[0])) {
					doQuit(pw);
				}else if("message".equals(tokens[0])) {
					if(tokens.length<1) {
						domessage("");
					}else {
						String data =tokens[1];
						for(int i=2;i<tokens.length;i++) {
							data +=":"+tokens[i];
						}
						
						domessage(data);
					}
				}else {
					ChatServer.log("에러: 알수 없는 요청"+tokens[0]+")");
				}
				
			}
		} catch(SocketException e) {
			ChatServer.log("suddenly closed by client");
			synchronized(nameList) {
				nameList.remove(nickName);
				}
			String data = nickName +"님이 퇴장하셨습니다";
			broadcast(data);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	} 
	
	private void dojoin(String nickName, PrintWriter printWriter) {
		this.nickName= nickName;
		printWriter.println("join:ok");
		String data =nickName+ "님이 참여하였습니다"; 
		addWriter(printWriter);
		broadcast(data);
		printWriter.flush();
	}
	
	private void addWriter(PrintWriter writer) {
			synchronized(writerArray) {
				writerArray.put(nickName,writer);
			}
	}
			
	private void broadcast(String data) {
		synchronized(writerArray) {
			Set<String> keys= writerArray.keySet();
			Iterator<String> it = keys.iterator();
			PrintWriter printwriter;
			String temp;
			while(it.hasNext()) {
				temp=it.next();
				printwriter=writerArray.get(temp);
				printwriter.println(data);
				printwriter.flush();
			}
		}
	}
	private void domessage(String message) {
		String reMessage=message;
		broadcast(nickName+":"+reMessage+"\r");
	}

	private void doQuit(PrintWriter p) {
		removeWriter(p);
		String data = nickName +"님이 퇴장하셨습니다";
		broadcast(data);
		synchronized(nameList) {
		nameList.remove(nickName);
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void removeWriter(PrintWriter writer) {
		writerArray.remove(writer);
	}
}
