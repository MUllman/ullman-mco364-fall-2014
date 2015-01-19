package ullman.paintLayers.drawListener;

import ullman.paintLayers.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Created by mullman14 on 12/23/14.
 */
public class BucketFillDrawListener implements DrawListener {
    private Canvas canvas;
    private Color oldColor;
    private int x;
    private int y;

    public BucketFillDrawListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        oldColor = new Color(canvas.getCurrentLayerImage().getRGB(x, y));
        Graphics2D g = (Graphics2D) canvas.getCurrentLayerImage().getGraphics();
        draw(g);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void draw(Graphics2D g) {
        floodFill(x, y, oldColor, canvas.getStrokeSettings().getColor(), canvas.getCurrentLayerImage());
    }

    @Override
    public void drawPreview(Graphics2D graphics) {

    }

    private void floodFill(int x, int y, Color oldColor, Color newColor, BufferedImage image) {
        if (oldColor.equals(newColor)) {
            return;
        }

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (x >= 0 && x < 800 && y >= 0 && y < 600) {
                if (oldColor.equals(new Color(image.getRGB(p.x, p.y))) ){
                    image.setRGB(p.x, p.y, newColor.getRGB());
                    if (p.x-1 >=0) {
                        queue.add(new Point(p.x - 1, p.y));
                    }
                    if (p.x+1 <800) {
                        queue.add(new Point(p.x + 1, p.y));
                    }
                    if (p.y - 1>=0) {
                        queue.add(new Point(p.x, p.y - 1));
                    }
                    if (p.y + 1<600) {
                        queue.add(new Point(p.x, p.y + 1));
                    }
                }
            }
        }
        canvas.repaint();
    }

    public boolean validCoordinate(int x, int y) {
        return (x >= 0 && x < 800 && y >= 0 && y < 600);
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
