package javaapplication1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket client= new Socket("127.0.0.1",2002);
		BufferedReader cin= new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintStream cout = new PrintStream(client.getOutputStream());
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true) {
			System.out.println("Client : ");
			s=stdin.readLine();
			cout.println(s);
			if( s.equalsIgnoreCase("bye")) {
				System.out.println("Conncetion ended by client");
				break;
			}
			s=cin.readLine();
			System.out.println("Server : "+s+"\n");
		}
		
		client.close();
		cin.close();
		cout.close();
		stdin.close();
		
	}

}
