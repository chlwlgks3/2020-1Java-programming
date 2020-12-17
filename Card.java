public class Card {
	public static void main(String[] args) {
	String[] card1 = {"Clubs","Diamonds","Hearts","Spades"};
	String[] card2 = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	int matrix[][] = new int[4][13];
	for(int i=0;i<5;i++) {
		int k = (int)(Math.random()*4);
		int m = (int)(Math.random()*13);
		if(matrix[k][m] ==1) {
			i--;
			continue;
		}
		matrix[k][m] = 1;
		System.out.println(card1[k]+"ÀÇ "+card2[m]);
	}
	}
}
