package a2015117609;

public class Student extends Person {
	double gpa; //��� ����

	public String getId() {
		return id;
	}

	public double getGpa() {
		return gpa;
	}

	// �������� üũ�Ͽ� ���� 0 <= x <= 4.3
	public int setGpa(double gpa) {
		if(gpa<0 || gpa>4.3)
			return -1;
		this.gpa = gpa;
		return 0;
	}

	// id�� ������ ��Ȯ���� üũ�ϰ� ����
	public int setId(String id) {
		if(id.length() != 10)
			return -1;
		super.id=  id;
		return 0;
	}
	
}
