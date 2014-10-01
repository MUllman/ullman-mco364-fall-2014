package ullman.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SocketHandler extends Thread {

	private Socket s;
	private BlockingQueue<String> messages;

	public SocketHandler(Socket s, BlockingQueue<String> messages) {
		this.s = s;
		this.messages = messages;
	}

	public void run() {

		try {
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while((line = reader.readLine()) !=null){
				messages.add(line);
				//write to all the clients
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
