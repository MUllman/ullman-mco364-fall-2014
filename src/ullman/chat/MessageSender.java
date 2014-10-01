package ullman.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
public class MessageSender extends Thread {

	private List<Socket> sockets;
	private BlockingQueue<String> messages;

	public MessageSender(List<Socket> sockets, BlockingQueue<String> messages2) {
		this.sockets = sockets;
		this.messages = messages2;
	}

	public void run() {
		
		while (true) {
			String message;
			try {
				message = messages.take();
				for (Socket socket : sockets) {
					try {
						OutputStream out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.println(message);
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
