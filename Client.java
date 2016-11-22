package APP;

import java.io.*;
import java.net.*;

public class Client {
	private Socket server;
	Client() throws IOException {
		server = new Socket(InetAddress.getLocalHost(), 8888);
		System.out.println("您的好友客户端已上线");
		BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		DataOutputStream out = new DataOutputStream(server.getOutputStream());
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		String message;
		while (true) {
			message = in.readLine();
			out.write(intToBytes(1));
			out.flush();
			System.out.println(in.readLine());
			if (message.trim().equals("quit"))
				break;
		}
		in.close();
		out.close();
		sin.close();
		server.close();
		System.out.println("链接已断开");
	}
	
	public static byte[] intToBytes(int v) {
			byte[] b = new byte[4]; 
			b[0] = (byte) ((v >>> 24));  
			b[1] = (byte) ((v >>> 16)); 
			b[2] = (byte) ((v >>> 8)); 
			b[3] = (byte) ((v >>> 0)); 
			for(int i=0;i<b.length;i++) 
				System.out.println(b[i]); 
			System.out.println(Integer.toBinaryString(v)); 
			return b; 
		}
	public static void main(String[] args) throws IOException {
		Client client = new Client();
	}
	
}
