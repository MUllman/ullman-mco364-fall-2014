package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import ullman.paintLayers.Canvas;

public class DrawDrawListener implements DrawListener {
    private int x1, y1, x2, y2;
    private Canvas canvas;

    public DrawDrawListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void draw(Graphics2D g) {
        canvas.getStrokeSettings().changeStrokeSettings(g);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        draw((Graphics2D) canvas.getImage().getGraphics());
        canvas.repaint();
        x1 = x2;
        y1 = y2;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        draw((Graphics2D) canvas.getImage().getGraphics()); // lets u draw dots by clicking
        canvas.repaint();
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
