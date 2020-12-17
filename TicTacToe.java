import java.util.Scanner;

public class TicTacToe{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[3][3];
		int x,y;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++)
				board[i][j] = ' ';
		}
		
		do {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print("  "+board[i][j]);
				if(j != 2)
					System.out.print("|");
			}
			if(i !=2)
				System.out.print("\n---|---|---\n");
		}
		System.out.print("\n�������� ��ǥ�� �Է��Ͻÿ�: ");
		x = sc.nextInt();
		y = sc.nextInt();
		if(board[x][y] !=' ') {
			System.out.println("�߸��� ��ǥ�Դϴ�.");
			continue;
		}else 
			board[x][y] ='X';
		
		int i=0,j=0;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(board[i][j] == ' ') 
					break;
			}
			if(j<3)	
				break;
		}
		if(i<3 && j<3)
			board[i][j] = 'O';
		
		int count=0;
		for(int k=0;k<3;k++) {
			for(int m=0;m<3;m++) 
				if(board[k][m] ==' ')
					count++;
		}
		if(count == 0) {
			for(int k=0;k<3;k++) {
				for(int m=0;m<3;m++) {
					System.out.print("  "+board[k][m]);
					if(m != 2)
						System.out.print("|");
				}
				if(k !=2)
					System.out.print("\n---|---|---\n");
			}
			System.out.println("\n���α׷��� ����Ǿ����ϴ�");
			break;
		}
		}while(true);
	}
}