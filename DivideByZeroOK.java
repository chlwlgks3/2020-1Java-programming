import java.util.Scanner;

public class DivideByZeroOK {
	public static void main(String[] args) {
		int x,y,result=0,count=0;
		Scanner sc = new Scanner(System.in);
		
		while(count<3) {
			System.out.print("피젯수: ");
			x = sc.nextInt();
			System.out.print("젯수: ");
			y = sc.nextInt();
			try {
				result = x/y;
			}catch(ArithmeticException e) {
				count++;
				if(count == 3) { //3번연속 잿수로 0을 입력했을경우)
					System.out.println("이 바보야");
				}
				else 
					System.out.println("0으로 나눌수없습니다. 다시입력하시오");
			}
			finally {
				if(y != 0) {
					count = 0;// 젯수로 0을 입력하지않을경우 count는 다시 0으로 초기화해준다 (3번연속 잿수로 0을 입력했을때만 종료되어야함)
					System.out.println("result= "+result);
				}
			}
		}	
		System.out.println("프로그램종료");
	}
}
