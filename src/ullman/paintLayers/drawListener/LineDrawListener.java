package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import ullman.paintLayers.Canvas;

public class LineDrawListener implements DrawListener {

    private Canvas canvas;
    private boolean preview;
    private int x1, x2, y1, y2;

    public LineDrawListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void drawPreview(Graphics2D graphics) {
        if (preview) {
            draw(graphics);
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
        y2 = e.getY();
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        preview = false;
        Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
        canvas.getStrokeSettings().changeStrokeSettings(g);
        draw(g);
        canvas.repaint();
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