import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame{
	JButton[][] buttons = new JButton[3][3];
	JLabel result = new JLabel();
	char turn = 'X';
	int end = 0;
	int count = 0;
	
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); 
			char pressed = b.getText().charAt(0); 
			if(end == 0) { //밑에서 누르면 end를 1로바꾼다
			for (int i = 0; i < 3; i++) {  // 클릭시 X와 O 한번씩 마킹됨
				for (int j = 0; j < 3; j++) {  	
					if (b==buttons[i][j]) {
						if(pressed == ' ') {
							if( turn == 'X') {
								buttons[i][j].setText("X");
								result.setText("O의 차례");
								turn = 'O';
								count++;
							}
							else {
								buttons[i][j].setText("O");
								result.setText("X의 차례");
								turn = 'X';
								count++;
						}
					}
						
				}
			}
		}
	}		
			for (int i = 0; i < 3; i++) {  
				for (int j = 0; j < 3; j++) {  
					if(buttons[i][0].getText().equals("X")&&buttons[i][1].getText().equals("X")&&buttons[i][2].getText().equals("X")){
						result.setText("승리:X");
						end = 1;} 
					else if(buttons[i][0].getText().equals("O")&&buttons[i][1].getText().equals("O")&&buttons[i][2].getText().equals("O")){
						result.setText("승리:O");
						end = 1;}
					else if(buttons[0][j].getText().equals("O")&&buttons[1][j].getText().equals("O")&&buttons[2][j].getText().equals("O")){
						result.setText("승리:O");
						end = 1;}
					else if(buttons[0][j].getText().equals("X")&&buttons[1][j].getText().equals("X")&&buttons[2][j].getText().equals("X")){
						result.setText("승리:X");
						end = 1;} 
					else if(buttons[0][0].getText().equals("X")&&buttons[1][1].getText().equals("X")&&buttons[2][2].getText().equals("X")){
						result.setText("승리:X");
						end = 1;} 
					else if(buttons[0][2].getText().equals("O")&&buttons[1][1].getText().equals("O")&&buttons[2][0].getText().equals("O")){
						result.setText("승리:O");
						end = 1;}
					else if(buttons[0][0].getText().equals("O")&&buttons[1][1].getText().equals("O")&&buttons[2][2].getText().equals("O")){
						result.setText("승리:O");
						end = 1;}
					else if(buttons[0][2].getText().equals("X")&&buttons[1][1].getText().equals("X")&&buttons[2][0].getText().equals("X")){
						result.setText("승리:X");
						end = 1;} 
					else {
						if(count == 9) { // 총 9칸이 다눌렀는데 승자가 안나온다면 무승부처리
							result.setText("무승부");
							end = 1;} 
						}
					}
				}
			}
		}		
	public TicTacToe() {
		setSize(700,700);
		setTitle("TicTacToe");
		JPanel panel = new JPanel();
		JPanel board = new JPanel();
		JPanel resultPan = new JPanel();	
		panel.setLayout(new BorderLayout());
		board.setLayout(new GridLayout(3,3,0,0));
		for (int i = 0; i < 3; i++) {			
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton(" ");	
				buttons[i][j].addActionListener(new MyListener());
				board.add(buttons[i][j]);	
			}
		}
		result.setText(new String("Game Start!"));
		resultPan.add(result);
		panel.add(board, BorderLayout.CENTER);
		panel.add(resultPan, BorderLayout.SOUTH);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		TicTacToe obj = new TicTacToe();
	}
}
