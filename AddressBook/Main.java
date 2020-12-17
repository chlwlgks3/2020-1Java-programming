package a2015117609;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook book = new AddressBook();
		boolean bool = true;
		
		while(bool) {
			System.out.println("=================================");
			System.out.println("1. ����ó�Է�");
			System.out.println("2. ����ó����");
			System.out.println("3. ����ó�˻�");
			System.out.println("4. ����ó ��� ���");
			System.out.println("5. ����");
			System.out.println("---------------------------------");
			System.out.print("1~5�� �ϳ� �Է�: ");
			int input = sc.nextInt();
			sc.nextLine(); // �����Է��� ���ۿ� �����ִ� enter�� �����ش�.
			System.out.println("=================================");
			
			switch(input) {
			case 1:
				System.out.print("�̸�: ");
				String name = sc.nextLine();
				System.out.print("���̵�: ");
				String id = sc.nextLine(); //id�� �����Ͽ� �ؿ��� p�� ��Ʃ��Ʈ�� ���� ����Ƽ������
				while(id.length() != 8 && id.length() !=10) {
					System.out.print("���̵� �߸��Է��߽��ϴ�. �ٽ��Է�: ");
					id = sc.nextLine();
				}
				System.out.print("�޴�����ȣ: ");
				String mobileNum = sc.nextLine();
				while(mobileNum.length() != 11) {
					System.out.print("�޴�����ȣ�� �߸��Է��߽��ϴ�. �ٽ��Է�: ");
					mobileNum = sc.nextLine();
				}
				//����
				switch(id.length()) {
				case 8: Faculty p = new Faculty(); 
						System.out.print("���� ����ó: ");
						String workNum = sc.nextLine();
						p.setName(name); p.setId(id); p.setMobileNum(mobileNum); p.setWorkNum(workNum); 
						if(book.insert(p) <0)
							System.out.println("�̵̹����� id���ֽ��ϴ�. �Է½���");;
						break;
				case 10: Student s = new Student();
						 System.out.print("����: ");
						 double gpa = sc.nextDouble();
						 while(gpa<0 || gpa>4.3){
							 System.out.print("������ �߸��Է��߽��ϴ�. �ٽ��Է�: ");
							 gpa = sc.nextDouble();
						 }
						 s.setName(name); s.setId(id); s.setMobileNum(mobileNum); s.setGpa(gpa);
						 if(book.insert(s) <0)
								System.out.println("�̵̹����� id���ֽ��ϴ�. �Է½���");;
						 break;
				default:
				}
				break;
			case 2: System.out.print("1.�̸����λ��� 2.���̵�λ���\n1�� �Ǵ� 2���� �ϳ� �Է�: ");
					int choice = sc.nextInt();
					while(choice != 1 && choice != 2) {
						System.out.print("1 �Ǵ� 2�� �Է��ؾ��մϴ�. �ٽ��Է�: ");
						choice = sc.nextInt();
					}
					sc.nextLine(); // ���ۿ������ִ� ���͸� �������ش�.
					if(choice == 1) {
						System.out.print("�̸��Է�: ");
						String nameDelete = sc.nextLine();
						book.delete(nameDelete);
					}
					else {
						System.out.print("���̵��Է�: ");
						String idDelete = sc.nextLine();
						book.deleteById(idDelete);
					}
				break;
			case 3:System.out.print("1.�̸����ΰ˻� 2.���̵�ΰ˻�\n1�� �Ǵ� 2���� �ϳ� �Է�: ");
					int choice2 = sc.nextInt();
					while(choice2 != 1 && choice2 != 2) {
						System.out.print("1 �Ǵ� 2�� �Է��ؾ��մϴ�. �ٽ��Է�: ");
						choice2 = sc.nextInt();
					}
					sc.nextLine(); // ���ۿ������ִ� ���͸� �������ش�.
					if(choice2 == 1) {
						System.out.print("�̸��Է�: ");
						String nameSearch = sc.nextLine();
						System.out.println(book.search(nameSearch));
					}
					else {
						System.out.print("���̵��Է�: ");
						String idSearch = sc.nextLine();
						System.out.println(book.searchById(idSearch).getMobileNum());
					}				
				break;
			case 4:
				System.out.println(book);
				break;
			case 5:
				bool = false;
				System.out.println("���α׷�����");
				break;
			default:
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
		}
	}
}
