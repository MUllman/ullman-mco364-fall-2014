package ullman.paintNetworking;

import ullman.paintNetworking.drawListener.DrawListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JComponent {
    private BufferedImage image;
    private DrawListener listener;
    private StrokeSettings strokeSetting;
    private NetworkModule module;
    private Graphics2D graphics;

    public Canvas(StrokeSettings strokeSetting) {
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB_PRE);
        graphics = (Graphics2D) image.getGraphics();
        clear();
        this.strokeSetting = strokeSetting;
        this.module = null;
    }

    public void setModule(NetworkModule module) {
        this.module = module;
    }

    public NetworkModule getModule() {
        return module;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

        strokeSetting.changeStrokeSettings((Graphics2D) g);
        listener.drawPreview((Graphics2D) g);
    }

    public void setDrawListener(DrawListener drawListener) {
        if (listener != null) {
            this.removeMouseListener(listener);
            this.removeMouseMotionListener(listener);
        }
        listener = drawListener;
        this.addMouseListener(drawListener);
        this.addMouseMotionListener(drawListener);
    }

    public BufferedImage getImage() {
        return image;
    }

    public StrokeSettings getStrokeSettings() {
        return strokeSetting;
    }

    public void clear() {
        graphics.setPaint(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        repaint();
    }

    public Graphics2D getGraphics (){
        return graphics;
    }

}
