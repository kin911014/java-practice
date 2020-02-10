package prob5;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		top = -1;
		buffer = new String[capacity];
	}
	
	public void push(String s) {
		if(top == buffer.length-1) { //stack full 
			resize();
		}
		
		// top = top+1
		buffer[++top] = s;
	}
	
	public String pop() throws{
		if(isEmpty()) {
			throw new MyStackException();
		}
		String result = buffer[top];
		buffer[top] = null;
		top--;
		return result;
	}
	
	public boolean isEmpty() {
		return top == -1
	}
	
	public void resize() {
		String[] temp = new String[buffer.length*2];
		for (int i = 0; i < buffer.length; i++) {
			temp[i] = buffer[i];
		}
		
		buffer = temp;
	}
}