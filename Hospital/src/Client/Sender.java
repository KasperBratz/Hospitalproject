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
		System.out.println("sendeing:" +out);
		this.out.println(out);
		//this.out.close();
	}
	public String msg() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return "error";
		}
	}
}
