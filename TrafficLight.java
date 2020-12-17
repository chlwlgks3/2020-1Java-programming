import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TrafficLight extends JFrame implements ActionListener{
	Color[] ary = { Color.red, Color.yellow, Color.green };
	JButton change;
	int index = 0;

	public void actionPerformed(ActionEvent e) {
		if(++index >= 3)
			index = 0;
		repaint();
	}
	
	class MyPanel extends JPanel {	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=0;i<3;i++) {
				if(i == index) {
					g.setColor(ary[index]);
					g.fillOval(100+100*i, 10, 100, 100);
				}
				else {
					g.setColor(Color.black);
					g.drawOval(100+100*i, 10,100, 100);
				}
			}
		}
	}
	
	public TrafficLight() {
		setSize(500,200);
		setTitle("Traffic Light");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		change = new JButton("신호변경");
		change.addActionListener(this);
		add(new MyPanel(),BorderLayout.CENTER);
		add(change,BorderLayout.SOUTH);	
	}
	
	public static void main(String[] args) {
		new TrafficLight();
	}

}
