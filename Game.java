import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = (int)(Math.random()*100)+1;
		int count = 0;
		int guess = 0;
		do {
			count++;
			System.out.print("정답을 추측하여 보시오: ");
			guess = sc.nextInt();
			if(guess < ans) 
				System.out.println("Low");
			else if(guess > ans)
				System.out.println("High");
		}while(guess != ans);
		System.out.println("축하합니다. 시도횟수="+count);
	}
}
