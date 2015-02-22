package Client;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Connector {
	private static String host = "venus-6";
	private static int port = 9876;

	public static SSLSocket clientSocketFactory(){
		SSLSocketFactory factory = null;
		try {
		    char[] password = "password".toCharArray();
		    KeyStore ks = KeyStore.getInstance("JKS");
		    KeyStore ts = KeyStore.getInstance("JKS");
		    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
		    SSLContext ctx = SSLContext.getInstance("TLS");
		    ks.load(new FileInputStream("clientkeystore"), password);  // keystore password (storepass)
			ts.load(new FileInputStream("clienttruststore"), password); // truststore password (storepass);
			kmf.init(ks, password); // user password (keypass)
			tmf.init(ts); // keystore can be used as truststore here
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
		    factory = ctx.getSocketFactory();
		    return (SSLSocket)factory.createSocket(host, port);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return null;
	}
}