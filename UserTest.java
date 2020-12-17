import java.util.ArrayList;
import java.util.Scanner;
//Login 기능 구현했습니다.
class User{
	String userId, password;
	static int count;
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
		count++;
	}
}
public class UserTest {
	public static void main(String[] args) {
		int num =0;
		ArrayList<User> list = new ArrayList<User>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=================================");
			System.out.println("1.Sign Up\n2.Login\n3.Print All Users\n4.Exit");
			System.out.println("=================================");
			System.out.print("번호를 입력하시오: ");
			num = sc.nextInt();
			sc.nextLine(); //숫자를 입력받고나서 버퍼에 남아있는 enter를 비운다.
			switch(num) {
			case 1: 
					System.out.print("id: "); String id = sc.nextLine();
					System.out.print("Password: "); String password = sc.nextLine();
					list.add(new User(id,password)); break;
			case 2: System.out.print("id를 입력하세요: ");
					String id_log = sc.nextLine();
					int index = -1;
					for(int i=0;i<list.size();i++) {
						if(list.get(i).userId.equals(id_log)) {
							index = i;
							break;
						}	
					}
					if(index == -1) //index가 처음 지정해준 -1일 경우 list배열에 id가없음을 의미한다
						System.out.println("일치하는 ID가 없습니다.");
					else {
						System.out.print("비밀번호를 입력하세요: "); String password_log = sc.nextLine();
						if(list.get(index).password.equals(password_log))
							System.out.println("로그인 성공");
						else
							System.out.println("비밀번호가 틀렸습니다");
					}
					break;
			case 3: System.out.println("총 회원수: "+User.count);
					for(User obj : list) 
					System.out.println("{"+obj.userId+","+obj.password+"}"); break;
			case 4: System.out.println("프로그램 종료"); break;
			default: System.out.println("1~4중의 숫자중 하나를 입력하세요"); 
			}
		}while(num != 4);
	}
}
