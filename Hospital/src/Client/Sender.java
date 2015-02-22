package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Sender {
	private BufferedReader in;
	private PrintWriter out;
	
	public Sender(BufferedReader in, PrintWriter out){
		this.in = in;
		this.out = out;
	}
	public void push(String out){
		System.out.println("sending:" +out);
		this.out.println(out);
	}
	public String msg() {
		// TODO Auto-generated method stub
		try {
			return in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
}
