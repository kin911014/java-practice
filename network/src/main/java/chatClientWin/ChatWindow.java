package chatClientWin;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;


public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	private String name;
	private static  PrintWriter pw;

	public ChatWindow(String name, Socket socket) {
		this.name=name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket= socket;
	}

	public void show() {
		
		// 1. UI 초기화 작업 
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() { // 일회용 클래스
			
			@Override
			public void keyReleased(KeyEvent e) {
				char KeyCode=e.getKeyChar();
				if(KeyCode== KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		
		   // 3. Thread 선언
	    try {
	    	
	    	pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);// true 를 안하면 버퍼가 완전히 차지 않으면 바로 가지 않는다. 
			new ChatClientThread(name,socket).start();
		
	    } catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void sendMessage() {
		
		String message =textField.getText();
		
		// 소켓을 통해 메세지가 온경우 

		if("quit".equals(message)){
			pw.println(message);
			textField.setText("");
			textField.requestFocus();
			System.exit(0);
		}
		else if(message ==null) {
			ChatClientApp.log("[Client] Error occured");
			
			return;
		}else {
			textField.setText("");
			textField.requestFocus();
			pw.println("message:"+message);
		}
	
	}
	
	public class ChatClientThread extends Thread{
		private Socket socket;
		String nickName;
		public ChatClientThread(String name, Socket socket) {
			this.socket=socket;
			this.nickName = name;
		}
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); 
			  while(true) {
					String data = br.readLine();
					
					if(data ==null) {
						ChatClientApp.log("[Client] 오류로 종료합니다.");
						break;
					}
			
					ChatClientApp.log(data);
					textArea.append(data); 
					textArea.append("\n");
					
				}
			  	Thread.sleep(1000);
				System.exit(0);
			}catch(Exception e){
		      }
		}
	}
}
