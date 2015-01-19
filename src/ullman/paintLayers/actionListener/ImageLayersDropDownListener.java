package ullman.paintLayers.actionListener;

import ullman.paintLayers.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageLayersDropDownListener implements ActionListener {
    private Canvas canvas;

    public ImageLayersDropDownListener(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox dropDown = (JComboBox) e.getSource();
        String tool = (String) dropDown.getSelectedItem();

        if (tool.equals("Layer 1")) {
            canvas.setCurrentLayer(0);

        } else if (tool.equals("Layer 2")) {
            canvas.setCurrentLayer(1);


        } else if (tool.equals("Layer 3")) {
            canvas.setCurrentLayer(2);

        } else if (tool.equals("Layer 4")) {
            canvas.setCurrentLayer(3);

        }
    }
}

