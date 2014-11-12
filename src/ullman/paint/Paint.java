package ullman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class Paint extends JFrame implements ActionListener {

	private Canvas canvas;

	public Paint() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);

		canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);

		DrawListner listner = new DrawListner(canvas);

		JButton button = new JButton("color");
		button.addActionListener(this);
		canvas.addMouseMotionListener(listner);
		canvas.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				int newStroke = (canvas.getStroke() + (e.getUnitsToScroll() * (-1)));
				if(newStroke<1){
					newStroke = 1;
				}
				canvas.setStroke(newStroke);
			}
		});
		add(button, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Color initialcolor = Color.RED;
		Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
		canvas.setColor(color);
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
