import java.util.Scanner;

public class DivideByZeroOK {
	public static void main(String[] args) {
		int x,y,result=0,count=0;
		Scanner sc = new Scanner(System.in);
		
		while(count<3) {
			System.out.print("������: ");
			x = sc.nextInt();
			System.out.print("����: ");
			y = sc.nextInt();
			try {
				result = x/y;
			}catch(ArithmeticException e) {
				count++;
				if(count == 3) { //3������ ����� 0�� �Է��������)
					System.out.println("�� �ٺ���");
				}
				else 
					System.out.println("0���� �����������ϴ�. �ٽ��Է��Ͻÿ�");
			}
			finally {
				if(y != 0) {
					count = 0;// ������ 0�� �Է������������ count�� �ٽ� 0���� �ʱ�ȭ���ش� (3������ ����� 0�� �Է��������� ����Ǿ����)
					System.out.println("result= "+result);
				}
			}
		}	
		System.out.println("���α׷�����");
	}
}
