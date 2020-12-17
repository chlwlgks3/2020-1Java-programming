package a2015117609;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook book = new AddressBook();
		boolean bool = true;
		
		while(bool) {
			System.out.println("=================================");
			System.out.println("1. 연락처입력");
			System.out.println("2. 연락처삭제");
			System.out.println("3. 연락처검색");
			System.out.println("4. 연락처 모두 출력");
			System.out.println("5. 종료");
			System.out.println("---------------------------------");
			System.out.print("1~5중 하나 입력: ");
			int input = sc.nextInt();
			sc.nextLine(); // 숫자입력후 버퍼에 남아있는 enter를 없애준다.
			System.out.println("=================================");
			
			switch(input) {
			case 1:
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("아이디: ");
				String id = sc.nextLine(); //id로 구분하여 밑에서 p를 스튜던트로 할지 패컬티로할지
				while(id.length() != 8 && id.length() !=10) {
					System.out.print("아이디를 잘못입력했습니다. 다시입력: ");
					id = sc.nextLine();
				}
				System.out.print("휴대폰번호: ");
				String mobileNum = sc.nextLine();
				while(mobileNum.length() != 11) {
					System.out.print("휴대폰번호를 잘못입력했습니다. 다시입력: ");
					mobileNum = sc.nextLine();
				}
				//구현
				switch(id.length()) {
				case 8: Faculty p = new Faculty(); 
						System.out.print("직장 연락처: ");
						String workNum = sc.nextLine();
						p.setName(name); p.setId(id); p.setMobileNum(mobileNum); p.setWorkNum(workNum); 
						if(book.insert(p) <0)
							System.out.println("이미동일한 id가있습니다. 입력실패");;
						break;
				case 10: Student s = new Student();
						 System.out.print("학점: ");
						 double gpa = sc.nextDouble();
						 while(gpa<0 || gpa>4.3){
							 System.out.print("학점을 잘못입력했습니다. 다시입력: ");
							 gpa = sc.nextDouble();
						 }
						 s.setName(name); s.setId(id); s.setMobileNum(mobileNum); s.setGpa(gpa);
						 if(book.insert(s) <0)
								System.out.println("이미동일한 id가있습니다. 입력실패");;
						 break;
				default:
				}
				break;
			case 2: System.out.print("1.이름으로삭제 2.아이디로삭제\n1번 또는 2번중 하나 입력: ");
					int choice = sc.nextInt();
					while(choice != 1 && choice != 2) {
						System.out.print("1 또는 2를 입력해야합니다. 다시입력: ");
						choice = sc.nextInt();
					}
					sc.nextLine(); // 버퍼에남아있는 엔터를 삭제해준다.
					if(choice == 1) {
						System.out.print("이름입력: ");
						String nameDelete = sc.nextLine();
						book.delete(nameDelete);
					}
					else {
						System.out.print("아이디입력: ");
						String idDelete = sc.nextLine();
						book.deleteById(idDelete);
					}
				break;
			case 3:System.out.print("1.이름으로검색 2.아이디로검색\n1번 또는 2번중 하나 입력: ");
					int choice2 = sc.nextInt();
					while(choice2 != 1 && choice2 != 2) {
						System.out.print("1 또는 2를 입력해야합니다. 다시입력: ");
						choice2 = sc.nextInt();
					}
					sc.nextLine(); // 버퍼에남아있는 엔터를 삭제해준다.
					if(choice2 == 1) {
						System.out.print("이름입력: ");
						String nameSearch = sc.nextLine();
						System.out.println(book.search(nameSearch));
					}
					else {
						System.out.print("아이디입력: ");
						String idSearch = sc.nextLine();
						System.out.println(book.searchById(idSearch).getMobileNum());
					}				
				break;
			case 4:
				System.out.println(book);
				break;
			case 5:
				bool = false;
				System.out.println("프로그램종료");
				break;
			default:
				System.out.println("잘못입력하였습니다.");
			}
		}
	}
}
