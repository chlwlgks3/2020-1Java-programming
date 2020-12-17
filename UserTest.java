import java.util.ArrayList;
import java.util.Scanner;
//Login ��� �����߽��ϴ�.
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
			System.out.print("��ȣ�� �Է��Ͻÿ�: ");
			num = sc.nextInt();
			sc.nextLine(); //���ڸ� �Է¹ް��� ���ۿ� �����ִ� enter�� ����.
			switch(num) {
			case 1: 
					System.out.print("id: "); String id = sc.nextLine();
					System.out.print("Password: "); String password = sc.nextLine();
					list.add(new User(id,password)); break;
			case 2: System.out.print("id�� �Է��ϼ���: ");
					String id_log = sc.nextLine();
					int index = -1;
					for(int i=0;i<list.size();i++) {
						if(list.get(i).userId.equals(id_log)) {
							index = i;
							break;
						}	
					}
					if(index == -1) //index�� ó�� �������� -1�� ��� list�迭�� id�������� �ǹ��Ѵ�
						System.out.println("��ġ�ϴ� ID�� �����ϴ�.");
					else {
						System.out.print("��й�ȣ�� �Է��ϼ���: "); String password_log = sc.nextLine();
						if(list.get(index).password.equals(password_log))
							System.out.println("�α��� ����");
						else
							System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
					}
					break;
			case 3: System.out.println("�� ȸ����: "+User.count);
					for(User obj : list) 
					System.out.println("{"+obj.userId+","+obj.password+"}"); break;
			case 4: System.out.println("���α׷� ����"); break;
			default: System.out.println("1~4���� ������ �ϳ��� �Է��ϼ���"); 
			}
		}while(num != 4);
	}
}
