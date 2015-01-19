package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import ullman.paintLayers.Canvas;

public abstract class ShapeDrawListener implements DrawListener {
    protected Canvas canvas;
    protected boolean preview;
    protected Point startPoint, currentPoint;
    protected int x, y, width, height;

    public ShapeDrawListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        preview = true;
        startPoint = e.getPoint();
        currentPoint = e.getPoint();
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
    public void mouseDragged(MouseEvent e) {
        currentPoint = e.getPoint();
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void draw(Graphics2D g) {
        x = Math.min(startPoint.x, currentPoint.x);
        y = Math.min(startPoint.y, currentPoint.y);
        width = Math.abs(startPoint.x - currentPoint.x);
        height = Math.abs(startPoint.y - currentPoint.y);
    }

    @Override
    public void drawPreview(Graphics2D g) {
        if (preview) {
            draw(g);
        }
    }
}
