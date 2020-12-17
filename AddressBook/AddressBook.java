package a2015117609;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	ArrayList<Person> buffer = new ArrayList<Person>();
	
	// Person을 buffer에 삽입하는 메소드
	// id가 동일한 데이터가 이미 있을경우 -1을 반환하여 오류처리한다.
	int insert(Person p) {	
		for(int i=0;i<buffer.size();i++) 
			if(buffer.get(i).id.equals(p.id))
				return -1;
		buffer.add(p);
		return 0;
	}
	
	// 이름으로 삭제하는 메소드
	// 이름이 여러명일 경우 오류처리한다.
	int delete(String name) {
		int count = 0;
		int index = 0;
		for(int i=0;i<buffer.size();i++) 
			if(buffer.get(i).name.equals(name)) {
				index = i;
				count++; 
			}
		switch(count) {
		case 0: System.out.println("입력한 이름이 없습니다."); break; 
		case 1: System.out.println("삭제완료"); buffer.remove(index); break;
		default: System.out.println("동명이인이 있습니다. 삭제불가"); return -1;
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
			System.out.println("입력한 id가 존재하지않습니다.");
			return -1;
		}
		buffer.remove(index);
		System.out.println("삭제완료");
		return 0;
	}
	
	// 여러명이 검색될 수 있다. -> 동명이인이 있을 경우 id를 입력받아서 그 id를 가진사람의 연락처 반환
	String search(String name) {
		int[] index = new int[buffer.size()];
		int count =0;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<buffer.size();i++)
			if(buffer.get(i).name.equals(name)) 
				index[count++] = i;
		if(count == 0) 
			return "입력한 이름이 존재하지않습니다.";
		else if(count == 1) 
			return buffer.get(index[count]).mobileNum;
		else {
			System.out.print("동명이인이 있습니다. id입력: ");
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
			System.out.println("입력한 id가 존재하지않습니다.");
			return null;
		}
		return buffer.get(index);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(" ");
		for(int i=0;i<buffer.size();i++) {
			sb.append(buffer.get(i).name+"의 id["+buffer.get(i).id+"] 전화번호["+buffer.get(i).mobileNum+"]");
			sb.append("\n");
		}
		return sb.toString(); // 모든 연락처 출력하도록 return 값 변경
	}
}
