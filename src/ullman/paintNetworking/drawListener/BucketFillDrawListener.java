package ullman.paintNetworking.drawListener;

import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.actionListener.ShapeDropDownListener;
import ullman.paintNetworking.message.BucketFillMessage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

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
        canvas.getModule().sendMessage(new BucketFillMessage(x, y, canvas.getStrokeSettings().getColor().getRGB(), canvas));

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
            if (x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight()) {
                if (oldColor.equals(new Color(image.getRGB(p.x, p.y))) ){
                    image.setRGB(p.x, p.y, newColor.getRGB());
                    if (p.x-1 >=0) {
                        queue.add(new Point(p.x - 1, p.y));
                    }
                    if (p.x+1 <canvas.getWidth()) {
                        queue.add(new Point(p.x + 1, p.y));
                    }
                    if (p.y - 1>=0) {
                        queue.add(new Point(p.x, p.y - 1));
                    }
                    if (p.y + 1<canvas.getHeight()) {
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
