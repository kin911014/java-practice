package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// logging Remote Host IP Address & Port
						InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
						consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
		
			// get IOStream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			OutputStream outputStream = socket.getOutputStream();
			
			String request = null;
			
			while(true) {
				String line = br.readLine();
				
				// 브라우저가 연결을 끊음
				if(line == null ) {
					break;
				}
				if("".equals(line)) {
				break;
			    }
				// header의 첫번째 라인만 읽음
				if(request == null) {
					request = line;
					break;
				}
			}
			consoleLog(request);
			String[] tokens = request.split(" ");
			
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1],tokens[2]);
//			consoleLog(request);
			}else {// [POST, DELETE, PUT], HEAD, CONNECT
				// 응답예시  ex) 
				// HTTP/1.1 400 Bad Request/r/n
//				Content-Type:text/html; charset=utf-8\r\n"
//				\r\n
//				HTML 에러문서(./webapp/error/404.html
//				response400Error(outputStream, protocol);
				error400(outputStream, tokens[2] );
			}
			
		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(
			OutputStream outputStream, String uri, String protocol) throws IOException{
		
		if("/".equals(uri)) {
			uri = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + uri);
		if(!file.exists()) {
			// 응답예시  ex) 
			// HTTP/1.1 404 Not Found/r/n
//			Content-Type:text/html; charset=utf-8\r\n"
//			\r\n
//			HTML 에러문서(./webapp/error/404.html
			
//			response404Error(outputStream, protocol);
			error404(outputStream);
			
		}
		
		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
				
		// 응답
		outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		outputStream.write(body);
	}
	
	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
	
	public void error400(OutputStream outputStream, String protocol) throws IOException{
		File file = new File("./webapp/error/400.html");
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		outputStream.write( "HTTP/1.1 400 Bad Request/r/n".getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		outputStream.write(body);
	}
	public void error404(OutputStream outputStream) throws IOException{
		File file = new File("./webapp/error/404.html");
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		// HTTP/1.1 404 Not Found/r/n
//		Content-Type:text/html; charset=utf-8\r\n"
//		\r\n
//		HTML 에러문서(./webapp/error/404.html
		
//		response404Error(outputStream, protocol);
		outputStream.write( "HTTP/1.1 404 Not Found/r/n".getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
		outputStream.write(body);
	}
	
}
