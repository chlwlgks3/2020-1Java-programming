package Addressbook;

import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable{
	Vector<Person> vc = new Vector<Person>();
	boolean duplicate = false; // 똑같은 이름이 vector에 존재하는지 체크하는 변수
	
	public String insert(Person p) {
		String result;
		for(int i=0; i<vc.size(); i++) 
			if(vc.get(i).tel.equals(p.tel)) 
				duplicate = true;
		if(!duplicate) {
			vc.add(p);
			result = "등록성공\n";
			return result;
		}
		else {
			result = "이미 등록되어있습니다\n";
			return result;
		}
	}
	
	public String toString() {
		/* for (int i = 0; i < vc.size(); i++) 
		      return vc.get(i).toString();*/
		    return null;	 
	}
}
