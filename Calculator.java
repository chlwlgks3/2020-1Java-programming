import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
	String arr[][] = {{"Backspace"," "," ","CE","C"},
					  {"7","8","9","/","sqrt"},
					  {"4","5","6","x","%"},
					  {"1","2","3","-","1/x"},
					  {"0","+/-",".","+","="} };
	
	public Calculator() {
		JPanel panel = new JPanel();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		
		JTextField t1 = new JTextField(45);
		panelA.add(t1);
		panelA.setLayout(new GridLayout(0,1));
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				JButton button = new JButton(arr[i][j]);
				button.setBackground(Color.yellow);
				panelB.add(button);
			}
		}
		panelB.setLayout(new GridLayout(5,5,3,3));
		panel.add(panelA);
		panel.add(panelB);
		this.add(panel);
		setSize(530,250);
		panel.setBackground(Color.orange);
		setTitle("Calculator");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
	}
}
