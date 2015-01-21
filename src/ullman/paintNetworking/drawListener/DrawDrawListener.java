package ullman.paintNetworking.drawListener;

import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.actionListener.ShapeDropDownListener;
import ullman.paintNetworking.message.LineMessage;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawDrawListener implements DrawListener {
    private int x1, y1, x2, y2;
    private Canvas canvas;

    public DrawDrawListener(Canvas canvas) {
        this.canvas = canvas;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        LineMessage msg = new LineMessage(x1, y1, x2, y2, canvas.getStrokeSettings().getColor().getRGB(), canvas.getStrokeSettings().getThickness());
        canvas.getModule().sendMessage(msg);

        x1 = x2;
        y1 = y2;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();

        LineMessage msg = new LineMessage(x1, y1, x2, y2, canvas.getStrokeSettings().getColor().getRGB(), canvas.getStrokeSettings().getThickness());
        canvas.getModule().sendMessage(msg);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void drawPreview(Graphics2D graphics) {

    }

}
