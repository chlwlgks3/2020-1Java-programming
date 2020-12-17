package ee2015117609;

import java.util.Random;
import java.util.Scanner;

class Hangman{
	StringBuffer ans = new StringBuffer();
	String result = "01234";
	
	public Hangman() { // Hangman 클래스의 생성자 : 랜덤한 문자열 ans 생성한다.
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int[] arr = new int['z'-'a'+1]; // 중복방지를 위한 배열 arr선언
		for(int i=0;i<5;i++) {
			int num = r.nextInt('z'-'a'+1);
			if(arr[num] == 1) {
				i--;
				continue; // 만약 똑같은 수가 랜덤으로 나왔다면 i를 하나 줄이고 다시 for문의 증감식으로 이동함
			}
			arr[num] = 1;
			char tmp = (char)('a'+num);
			sb.append(tmp);
		}
		ans = sb;
	}
	
	public String toString() { // 결과적으로 문자열 ans 반환 (toString()메소드는 StringBuffer를 return 타입으로 가질수 없으므로 String 클래스 참조변수 s로 변환해준후 s반환)
		 String s = "01234";
		 for(int i=0;i<5;i++) 
			s = s.replace(s.charAt(i),ans.charAt(i));
		 return s;
	}
	
	public String equals(StringBuffer sb,String x) { //문자열 sb에 내가 입력한 문자가 있는지 알아보는 함수. 입력한 있다면 문자열result의 문자를 변경
		int num =0;
		char input = x.charAt(0);
		for(int i=0;i<5;i++) {
			if(sb.charAt(i) == input) {
				result = result.replace(result.charAt(i), input);
			}
		}
		while(num<5) {
			switch(result.charAt(num)) {
			case '0': case '1': case '2': case '3': case '4': System.out.print("_"); break; // 문자열 result의 num번째 문자가 숫자인경우 "_"출력
			default: System.out.print(result.charAt(num)); // 문자열 result의 num번째 문자가 숫자가 아닌 모든경우 그 알파벳 출력
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
		System.out.print("현재의상태:_____");
		while(true) {
			System.out.print("\n글자를 추측하시오: ");
			String x = sc.nextLine();
			System.out.print("현재의상태:");
			if(obj.equals(obj.ans, x).equals(obj.toString())) { //toString()함수는 Hangman class의 ans 문자열 반환함. 결과적으로 result.equals(ans)가 조건이됨
				System.out.print("\n정답입니다!\n프로그램종료");
				break;		
				
			}
		}
	}
}
