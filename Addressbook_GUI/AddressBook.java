package Addressbook;

import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable{
	Vector<Person> vc = new Vector<Person>();
	boolean duplicate = false; // �Ȱ��� �̸��� vector�� �����ϴ��� üũ�ϴ� ����
	
	public String insert(Person p) {
		String result;
		for(int i=0; i<vc.size(); i++) 
			if(vc.get(i).tel.equals(p.tel)) 
				duplicate = true;
		if(!duplicate) {
			vc.add(p);
			result = "��ϼ���\n";
			return result;
		}
		else {
			result = "�̹� ��ϵǾ��ֽ��ϴ�\n";
			return result;
		}
	}
	
	public String toString() {
		/* for (int i = 0; i < vc.size(); i++) 
		      return vc.get(i).toString();*/
		    return null;	 
	}
}
