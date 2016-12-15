package gastaldo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(9999);
		int n=0;
		while(true){
			Socket s=ss.accept();
			n++;
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(n);
			System.out.println("Ho dato all'IP "+ s.getRemoteSocketAddress().toString() +"  il numero "+ n);
			s.close();
		}
	}

}
