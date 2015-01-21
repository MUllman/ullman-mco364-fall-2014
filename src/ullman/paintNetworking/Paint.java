package ullman.paintNetworking;

import ullman.paintNetworking.actionListener.*;
import ullman.paintNetworking.message.MessageFactory;

import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {

    private String[] Shapes = {"Draw", "Line", "Rectangle", "Filled Rectangle", "Circle", "Filled Circle", "Bucket Fill"};
    private StrokeSettings settings;
    private JLabel thicknessLabel;
    private JButton colorButton;
    private NetworkModule module;

    public Paint() {
        settings = new StrokeSettings();

        setSize(800, 600);
        setTitle("Paint");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Canvas canvas = new Canvas(settings);
        add(canvas, BorderLayout.CENTER);

        MessageFactory factory = new MessageFactory(canvas);

        this.module = new OnlineNetworkModule(factory,canvas);
        //this.module = new LoopbackNetworkModule(canvas);
        canvas.setModule(this.module);

        JPanel topNav = new JPanel();

        ShapeDropDownListener listener = new ShapeDropDownListener(canvas);
        ClearListener clearListener = new ClearListener(canvas);


        colorButton = new JButton("CHANGE COLOR");
        colorButton.setOpaque(true);
        colorButton.setBackground(settings.getColor());
        colorButton.addActionListener(new ChooseColorListener(this, canvas));
        topNav.add(colorButton);

        JComboBox shapeDropDown = new JComboBox(Shapes);
        shapeDropDown.addActionListener(listener);
        shapeDropDown.setSelectedIndex(0);
        topNav.add(shapeDropDown);

        JButton clearButton = new JButton("CLEAR");
        clearButton.addActionListener(clearListener);
        topNav.add(clearButton);

        topNav.add(new JLabel("Thickness:"));
        thicknessLabel = new JLabel(String.valueOf(settings.getThickness()));
        topNav.add(thicknessLabel);
        canvas.addMouseWheelListener(new ScrollListener(settings, thicknessLabel));

        add(topNav, BorderLayout.NORTH);
    }

    public void changeColor(Color color) {
        settings.setLColor(color);
        colorButton.setBackground(color);
    }

    public Color getColor(){
        return settings.getColor();
    }


    public static void main(String[] args) {
        Paint p = new Paint();
        p.setVisible(true);
    }
}
