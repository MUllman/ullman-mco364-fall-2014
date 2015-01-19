package ullman.paintLayers;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import ullman.paintLayers.drawListener.DrawListener;

public class Canvas extends JComponent {
    private BufferedImage[] images;
    private DrawListener listener;
    private StrokeSettings strokeSetting;
    private int currentLayer;

    public Canvas(StrokeSettings strokeSetting) {
        images = new BufferedImage[4];
        for (int i = 0; i < images.length; i++) {
            images[i] = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB_PRE);
            clear(i);
        }

        this.strokeSetting = strokeSetting;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < images.length; i++) {
            g.drawImage(images[i], 0, 0, null);
        }
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
        return images[currentLayer];
    }

    public StrokeSettings getStrokeSettings() {
        return strokeSetting;
    }

    public BufferedImage getCurrentLayerImage() {
        return images[currentLayer];
    }

    public int getCurrentLayer() {
        return currentLayer;
    }

    public void setCurrentLayer(int currentLayer) {
        this.currentLayer = currentLayer;
    }

    public void clear(int layer) {
        Graphics2D graphics = images[layer].createGraphics();
        if (layer == 0) {
            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, images[layer].getWidth(), images[layer].getHeight());
        } else {
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
            graphics.fillRect(0, 0, images[layer].getWidth(), images[layer].getHeight());
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

        }
        repaint();
    }

}
