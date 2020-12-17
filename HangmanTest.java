package ee2015117609;

import java.util.Random;
import java.util.Scanner;

class Hangman{
	StringBuffer ans = new StringBuffer();
	String result = "01234";
	
	public Hangman() { // Hangman Ŭ������ ������ : ������ ���ڿ� ans �����Ѵ�.
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int[] arr = new int['z'-'a'+1]; // �ߺ������� ���� �迭 arr����
		for(int i=0;i<5;i++) {
			int num = r.nextInt('z'-'a'+1);
			if(arr[num] == 1) {
				i--;
				continue; // ���� �Ȱ��� ���� �������� ���Դٸ� i�� �ϳ� ���̰� �ٽ� for���� ���������� �̵���
			}
			arr[num] = 1;
			char tmp = (char)('a'+num);
			sb.append(tmp);
		}
		ans = sb;
	}
	
	public String toString() { // ��������� ���ڿ� ans ��ȯ (toString()�޼ҵ�� StringBuffer�� return Ÿ������ ������ �����Ƿ� String Ŭ���� �������� s�� ��ȯ������ s��ȯ)
		 String s = "01234";
		 for(int i=0;i<5;i++) 
			s = s.replace(s.charAt(i),ans.charAt(i));
		 return s;
	}
	
	public String equals(StringBuffer sb,String x) { //���ڿ� sb�� ���� �Է��� ���ڰ� �ִ��� �˾ƺ��� �Լ�. �Է��� �ִٸ� ���ڿ�result�� ���ڸ� ����
		int num =0;
		char input = x.charAt(0);
		for(int i=0;i<5;i++) {
			if(sb.charAt(i) == input) {
				result = result.replace(result.charAt(i), input);
			}
		}
		while(num<5) {
			switch(result.charAt(num)) {
			case '0': case '1': case '2': case '3': case '4': System.out.print("_"); break; // ���ڿ� result�� num��° ���ڰ� �����ΰ�� "_"���
			default: System.out.print(result.charAt(num)); // ���ڿ� result�� num��° ���ڰ� ���ڰ� �ƴ� ����� �� ���ĺ� ���
			}
			num++;
		}
		return result;
	}
}

public class HangmanTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hangman obj = new Hangman();
		System.out.println("answer= "+obj.ans);
		System.out.print("�����ǻ���:_____");
		while(true) {
			System.out.print("\n���ڸ� �����Ͻÿ�: ");
			String x = sc.nextLine();
			System.out.print("�����ǻ���:");
			if(obj.equals(obj.ans, x).equals(obj.toString())) { //toString()�Լ��� Hangman class�� ans ���ڿ� ��ȯ��. ��������� result.equals(ans)�� �����̵�
				System.out.print("\n�����Դϴ�!\n���α׷�����");
				break;		
				
			}
		}
	}
}
