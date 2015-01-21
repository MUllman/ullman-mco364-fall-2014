package ullman.paintNetworking.actionListener;

import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.NetworkModule;
import ullman.paintNetworking.message.ClearMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener
{
    private Canvas canvas;

    public ClearListener(Canvas canvas) {

        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.getModule().sendMessage(new ClearMessage(canvas));
    }

}
