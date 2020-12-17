import java.util.Scanner;

abstract class Sprite{
	protected int x,y;
	public abstract void move(String input);
}

class Main extends Sprite{
	public Main(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public void move(String input) {
		switch(input) {
		case "l": y++; break;
		case "h": y--; break;
		case "j": x--; break;
		case "k": x++; 
		}
	}
}

class Gold extends Sprite{
	public void move(String input) {
		x = 6;
		y = 3;
	}
}

class Monster extends Sprite{
	public Monster(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void move(String input) {
		switch(input) {
		case "a": x++; break;
		case "b": x--; break;
		case "c": y++; break;
		case "d": y--; break;
		}
	}
}

public class GoldGameTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		int x_main = 3;
		int y_main = 3;
		int x_monster = 7;
		int y_monster = 6;
		
		char board[][] = new char[10][19];
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<19;j++) {
				if(i==0 || i==9)
					board[i][j] = '#';
				else {
					board[i][0] = '#';
					board[i][18] = '#';
				}
			}
		}
		board[3][3] = '@';
		board[6][3] = 'G';
		board[7][6] = 'M';
		do {
			for(int i=0;i<10;i++) {
				for(int j=0;j<19;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println("\n");
			}
			System.out.print("왼쪽(h),위쪽(j),아래쪽(k),오른쪽(l): ");
			int r = (int)(Math.random()*4);
			String s = " ";
			input = sc.nextLine();
			switch(input) {
			case "l": board[x_main][y_main++] = ' '; break;
			case "h": board[x_main][y_main--] = ' '; break;
			case "j": board[x_main--][y_main] = ' '; break;
			case "k": board[x_main++][y_main] = ' '; 
			}
			switch(r) {
			case 0: s = "a"; board[x_monster++][y_monster] = ' '; break;
			case 1: s = "b"; board[x_monster--][y_monster] = ' '; break;
			case 2: s = "c"; board[x_monster][y_monster++] = ' '; break;
			case 3: s = "d"; board[x_monster][y_monster--] = ' '; 
			}
			Main m1 = new Main(x_main,y_main);
			Gold g1 = new Gold();
			Monster m2 = new Monster(x_monster,y_monster);
			m1.move(input);
			g1.move(input);
			m2.move(s);
			board[x_main][y_main] = '@';
			board[g1.x][g1.y] = 'G';
			board[x_monster][y_monster] = 'M';
			if(x_main == g1.x && y_main == g1.y) {
				System.out.println("승리");
				break;
			}
			if(x_main == x_monster && y_main == y_monster) {
				System.out.println("패배");
				break;
			}
		}while(x_main !=0&&x_main !=19&&y_main !=0&&y_main !=9&&x_monster !=0&&x_monster !=19&&y_monster !=0&&y_monster !=9);
	}
}

