package ullman.paintNetworking.message;


import ullman.paintNetworking.Canvas;

import java.awt.*;

public class ClearMessage implements PaintMessage {

    private Canvas canvas;

    public ClearMessage (Canvas canvas){
        this.canvas = canvas;
    }

    public String toString() {
        return "CLEAR\n";
    }

    @Override
    public void apply(Graphics2D g) {

        g.setPaint(Color.white);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
