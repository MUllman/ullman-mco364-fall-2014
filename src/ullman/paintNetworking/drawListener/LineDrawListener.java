package ullman.paintNetworking.drawListener;

import ullman.paintNetworking.actionListener.ShapeDropDownListener;
import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.message.LineMessage;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineDrawListener implements DrawListener {

    private Canvas canvas;
    private int x1, y1, x2, y2;
    private boolean preview;

    public LineDrawListener(Canvas canvas) {
        this.canvas =canvas;
    }

    @Override
    public void drawPreview(Graphics2D graphics) {
        if(preview){
            graphics.drawLine(x1, y1, x2, y2);;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        preview = true;
        x1 = e.getX();
        y1 = e.getY();
        x2 = e.getX();
        y2 = e.getY();
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        preview = false;

        x2 = e.getX();
        y2 = e.getY();
        LineMessage msg = new LineMessage(x1, y1, x2, y2, canvas.getStrokeSettings().getColor().getRGB(), canvas.getStrokeSettings().getThickness());
        canvas.getModule().sendMessage(msg);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        canvas.repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}