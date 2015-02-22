package Server;

import java.io.*;
import java.net.*;
import java.security.KeyStore;

import javax.net.*;
import javax.net.ssl.*;
import javax.security.cert.X509Certificate;

public class Server implements Runnable {
	private ServerSocket serverSocket = null;
	private static int numConnectedClients = 0;
	private Login log;

	public Server(Login log) throws IOException {
		int port = 9876;

		String type = "TLS";
		ServerSocketFactory ssf = Server.getServerSocketFactory(type);
		serverSocket = ssf.createServerSocket(port);
		((SSLServerSocket) serverSocket).setNeedClientAuth(true); // enables
																	// client
																	// authentication;
		newListener();
		this.log = log;

	}

	public void run() {
		try {
			SSLSocket socket = (SSLSocket) serverSocket.accept();
			newListener();
			SSLSession session = socket.getSession();
			X509Certificate cert = (X509Certificate) session
					.getPeerCertificateChain()[0];
			String subject = cert.getSubjectDN().getName();
			numConnectedClients++;
			System.out.println("client connected");
			System.out.println("client name (cert subject DN field): "
					+ subject);
			System.out.println(numConnectedClients
					+ " concurrent connection(s)\n");

			PrintWriter out = null;
			BufferedReader in = null;
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String clientMsg = null;
			while ((clientMsg = in.readLine()) != null) {
				String rev = new StringBuilder(clientMsg).toString();
				System.out.println(rev);
				if(rev.charAt(0)=='0'){
					String[] s=rev.split("\t",3);
					System.out.println(s[1]+s[2]);
					boolean b=log.checkAccess(s[1],s[2]);
					out.println(b);
					//hämta alla filer
				}else if(rev.charAt(0)=='1'){
					String[] s=rev.split("\t",2);
					//hämta fil
				}else if(rev.charAt(0)=='2'){
					String[] s=rev.split("\t",3);
					//lyckades eller inte
				}
				System.out.println("received '" + clientMsg + "' from client");
				System.out.print("sending '" + rev + "' to client...");
				out.println(rev);
				out.flush();
				System.out.println("done\n");
			}
			in.close();
			out.close();
			socket.close();
			numConnectedClients--;
			System.out.println("client disconnected");
			System.out.println(numConnectedClients
					+ " concurrent connection(s)\n");
		} catch (IOException e) {
			System.out.println("Client died: " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}

	private void newListener() {
		(new Thread(this)).start();
	} // calls run()

	public static ServerSocketFactory getServerSocketFactory(String type) {
		if (type.equals("TLS")) {
			SSLServerSocketFactory ssf = null;
			try { // set up key manager to perform server authentication
				SSLContext ctx = SSLContext.getInstance("TLS");
				KeyManagerFactory kmf = KeyManagerFactory
						.getInstance("SunX509");
				TrustManagerFactory tmf = TrustManagerFactory
						.getInstance("SunX509");
				KeyStore ks = KeyStore.getInstance("JKS");
				KeyStore ts = KeyStore.getInstance("JKS");
				char[] password = "password".toCharArray();

				ks.load(new FileInputStream("serverkeystore"), password); // keystore
																			// password
																			// (storepass)
				ts.load(new FileInputStream("servertruststore"), password); // truststore
																			// password
																			// (storepass)
				kmf.init(ks, password); // certificate password (keypass)
				tmf.init(ts); // possible to use keystore as truststore here
				ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
				ssf = ctx.getServerSocketFactory();
				return ssf;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return ServerSocketFactory.getDefault();
		}
		return null;
	}
}
