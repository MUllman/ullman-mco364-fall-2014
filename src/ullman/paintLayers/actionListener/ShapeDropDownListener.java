package ullman.paintLayers.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ullman.paintLayers.Canvas;
import ullman.paintLayers.drawListener.CircleDrawListener;
import ullman.paintLayers.drawListener.FilledCircleDrawListener;
import ullman.paintLayers.drawListener.LineDrawListener;
import ullman.paintLayers.drawListener.DrawDrawListener;
import ullman.paintLayers.drawListener.FilledRectangleDrawListener;
import ullman.paintLayers.drawListener.RectDrawListener;
import ullman.paintLayers.drawListener.BucketFillDrawListener;

public class ShapeDropDownListener implements ActionListener {
    private Canvas canvas;

    public ShapeDropDownListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox dropDown = (JComboBox) e.getSource();
        String tool = (String) dropDown.getSelectedItem();

        if (tool.equals("Draw")) {
            canvas.setDrawListener(new DrawDrawListener(canvas));

        } else if (tool.equals("Line")) {
            canvas.setDrawListener(new LineDrawListener(canvas));


        } else if (tool.equals("Rectangle")) {
            canvas.setDrawListener(new RectDrawListener(canvas));

        } else if (tool.equals("Filled Rectangle")) {
            canvas.setDrawListener(new FilledRectangleDrawListener(canvas));

        } else if (tool.equals("Circle")) {
            canvas.setDrawListener(new CircleDrawListener(canvas));

        } else if (tool.equals("Filled Circle")) {
            canvas.setDrawListener(new FilledCircleDrawListener(canvas));

        } else if (tool.equals("Bucket Fill")) {
            canvas.setDrawListener(new BucketFillDrawListener(canvas));
        }
    }
}
