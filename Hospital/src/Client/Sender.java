package Client;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Sender {
	private BufferedReader in;
	private PrintWriter out;
	
	public Sender(BufferedReader in, PrintWriter out){
		this.in = in;
		this.out = out;
	}
}
