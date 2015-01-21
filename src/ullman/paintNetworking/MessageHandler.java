package ullman.paintNetworking;

import ullman.paintNetworking.message.MessageFactory;
import ullman.paintNetworking.message.PaintMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageHandler extends Thread {
    private Socket socket;
    private MessageFactory factory;
    private Canvas canvas;

    public MessageHandler(Socket socket, MessageFactory factory, Canvas canvas) {
        this.socket = socket;
        this.factory = factory;
        this.canvas = canvas;
    }

    @Override
    public void run() {

        InputStream in;
        try {
            in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    PaintMessage message = factory.getMessage(line);
                    message.apply(canvas.getGraphics());
                    canvas.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
