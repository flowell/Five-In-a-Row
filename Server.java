package APP;
import java.io.*;
import java.net.*;

public class Server implements Runnable {
	private Socket client;
	
	Server(Socket client) {
		this.client = client;
	}
	
	public void run() {
		try {
			DataInputStream in = new DataInputStream(client.getInputStream());
			PrintWriter out = new PrintWriter(client.getOutputStream());
			
			while (true) {
				int message = in.read();
				System.out.println(message);
				out.println("服务器已收到您的信息");
				out.flush();
				if (message == -1)
					break;
			}
			out.println("服务器已断开链接");
			in.close();
			out.close();
			client.close();
			System.out.println("链接已断开");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
