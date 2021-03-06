package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
	
	try {
		// 4. IOStream 생성(받아오기)
		BufferedReader br
		= new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		// PrintWritter 개행을 자동으로 작성해준다. true는 Flush()를 자동으로 해준다.
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
		
		while (true) {
			// 5. data읽기
			String data = br.readLine(); 
			if (data == null) {
				EchoServer.log("closed by client");
				break;
			}

			EchoServer.log("received:" + data);

			// 6. 데이터쓰기
			pw.println(data);
		}
	} catch (SocketException e) {
		EchoServer.log("suddenly closed by client");
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
	}

}
