package ullman.paintNetworking;

import ullman.paintNetworking.message.MessageFactory;
import ullman.paintNetworking.message.PaintMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class OnlineNetworkModule implements NetworkModule {

	private Socket socket;
	private MessageFactory factory;
	private Canvas canvas;

	public OnlineNetworkModule(MessageFactory factory, Canvas canvas) {
		this.factory = factory;
		this.canvas = canvas;
		try {
			socket = new Socket("localhost", 3773);
		} catch (IOException e) {
			e.printStackTrace();
		}
		MessageReceiver receiver = new MessageReceiver(socket, factory, canvas);
		receiver.start();
	}

	public Socket getSocket() {
		return socket;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		try {
			OutputStream out = socket.getOutputStream();
			out.write((message.toString()).getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
