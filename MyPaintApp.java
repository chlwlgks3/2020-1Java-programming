import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class Point{
	int x,y;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class MyPaintApp extends JFrame implements ActionListener{
	int x,y;
	ArrayList<Point> list = new ArrayList<>();
	JButton erase;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == erase) {
			list.clear();
			repaint();
		}
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			this.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					list.add(new Point(x,y));
					repaint();
				}
			});		
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(Point p:list)
				g.fillOval(p.x, p.y, 4, 4);
		}
	}
	
	public MyPaintApp() {
		setSize(500,500);
		setTitle("MyPaintApp");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		erase = new JButton("Áö¿ì±â");
		erase.addActionListener(this);
		add(new MyPanel(),BorderLayout.CENTER);
		add(erase,BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyPaintApp();
	}
}
