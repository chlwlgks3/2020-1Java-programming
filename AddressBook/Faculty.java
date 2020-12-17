package a2015117609;

public class Faculty extends Person {
	String workNum;
	
	public String getId() {
		return id;
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	// id 포맷체크 2019xxxx
	public int setId(String id) {
		if( id.length() != 8)
			return -1;
		super.id = id;
		return 0;
	}
}
