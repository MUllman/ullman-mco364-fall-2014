package ullman.paintNetworking.drawListener;

import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.actionListener.ShapeDropDownListener;
import ullman.paintNetworking.message.ShapeMessage;
import ullman.paintNetworking.message.ShapeType;

import java.awt.*;
import java.awt.event.MouseEvent;

public class FilledRectangleDrawListener implements DrawListener {

    private Canvas canvas;
    private int x1, y1, x2, y2, width, height;
    boolean preview;

    public FilledRectangleDrawListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void drawPreview(Graphics2D graphics) {
        if(preview){
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            width = Math.abs(x1 - x2);
            height = Math.abs(y1 - y2);
            graphics.fillRect(x, y, width, height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        preview = true;
        x1= e.getX();
        x2= e.getX();
        y1= e.getY();
        y2= e.getY();
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        x2 = e.getX();
        y2 = e.getY();
        preview = false;

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        ShapeMessage msg = new ShapeMessage(ShapeType.RECT, x, y, width, height, canvas.getStrokeSettings().getColor().getRGB(),
                canvas.getStrokeSettings().getThickness(), true);
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
        x2= e.getX();
        y2 = e.getY();
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
