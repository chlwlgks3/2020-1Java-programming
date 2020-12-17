package a2015117609;

public class Student extends Person {
	double gpa; //평균 학점

	public String getId() {
		return id;
	}

	public double getGpa() {
		return gpa;
	}

	// 학점범위 체크하여 저장 0 <= x <= 4.3
	public int setGpa(double gpa) {
		if(gpa<0 || gpa>4.3)
			return -1;
		this.gpa = gpa;
		return 0;
	}

	// id의 포맷이 정확한지 체크하고 대입
	public int setId(String id) {
		if(id.length() != 10)
			return -1;
		super.id=  id;
		return 0;
	}
	
}
