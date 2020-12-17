package a2015117609;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	ArrayList<Person> buffer = new ArrayList<Person>();
	
	// Person�� buffer�� �����ϴ� �޼ҵ�
	// id�� ������ �����Ͱ� �̹� ������� -1�� ��ȯ�Ͽ� ����ó���Ѵ�.
	int insert(Person p) {	
		for(int i=0;i<buffer.size();i++) 
			if(buffer.get(i).id.equals(p.id))
				return -1;
		buffer.add(p);
		return 0;
	}
	
	// �̸����� �����ϴ� �޼ҵ�
	// �̸��� �������� ��� ����ó���Ѵ�.
	int delete(String name) {
		int count = 0;
		int index = 0;
		for(int i=0;i<buffer.size();i++) 
			if(buffer.get(i).name.equals(name)) {
				index = i;
				count++; 
			}
		switch(count) {
		case 0: System.out.println("�Է��� �̸��� �����ϴ�."); break; 
		case 1: System.out.println("�����Ϸ�"); buffer.remove(index); break;
		default: System.out.println("���������� �ֽ��ϴ�. �����Ұ�"); return -1;
		}
		return 0;
	}
	
	int deleteById(String id) {
		int index = 0;
		int count = 0;
		for(int i=0;i<buffer.size();i++)
			if(buffer.get(i).id.equals(id)) {
				index = i;
				count++;
			}
		if(count == 0) {
			System.out.println("�Է��� id�� ���������ʽ��ϴ�.");
			return -1;
		}
		buffer.remove(index);
		System.out.println("�����Ϸ�");
		return 0;
	}
	
	// �������� �˻��� �� �ִ�. -> ���������� ���� ��� id�� �Է¹޾Ƽ� �� id�� ��������� ����ó ��ȯ
	String search(String name) {
		int[] index = new int[buffer.size()];
		int count =0;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<buffer.size();i++)
			if(buffer.get(i).name.equals(name)) 
				index[count++] = i;
		if(count == 0) 
			return "�Է��� �̸��� ���������ʽ��ϴ�.";
		else if(count == 1) 
			return buffer.get(index[count]).mobileNum;
		else {
			System.out.print("���������� �ֽ��ϴ�. id�Է�: ");
			String id = sc.nextLine();
			for(int i=0;i<buffer.size();i++) {
				if(buffer.get(i).id.equals(id))
					return buffer.get(i).mobileNum;
			}
		}
		return null;
	}
	
	Person searchById(String id) {
		int index = 0;
		int count = 0; 
		for(int i=0;i<buffer.size();i++)
			if(buffer.get(i).id.equals(id)) {
				index = i;
				count++;
			}
		if(count == 0) {
			System.out.println("�Է��� id�� ���������ʽ��ϴ�.");
			return null;
		}
		return buffer.get(index);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(" ");
		for(int i=0;i<buffer.size();i++) {
			sb.append(buffer.get(i).name+"�� id["+buffer.get(i).id+"] ��ȭ��ȣ["+buffer.get(i).mobileNum+"]");
			sb.append("\n");
		}
		return sb.toString(); // ��� ����ó ����ϵ��� return �� ����
	}
}
