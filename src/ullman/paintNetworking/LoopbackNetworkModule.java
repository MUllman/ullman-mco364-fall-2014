package ullman.paintNetworking;

import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.NetworkModule;
import ullman.paintNetworking.message.MessageFactory;
import ullman.paintNetworking.message.PaintMessage;

import java.awt.Graphics2D;


public class LoopbackNetworkModule implements NetworkModule {

    private Canvas canvas;

    public LoopbackNetworkModule(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void sendMessage(PaintMessage message) {
        message.apply((Graphics2D) canvas.getImage().getGraphics());
        canvas.repaint();

    }

}
