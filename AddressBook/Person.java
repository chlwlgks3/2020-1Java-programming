package a2015117609;

public abstract class Person {
	protected String name;
	protected String id;	//Student: 2019xxxxxx, Faculty:2019xxxx
	protected String mobileNum;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String getId();
	public abstract int setId(String id);
	
	public String getMobileNum() {
		return mobileNum;
	}
	
	// 전화번호 포맷 체크 010-xxxx-xxxx 형태로 삽입
	// 01012345678 입력했다면 010-1234-5678로 변환하여 저장
	// 포맷이 다르면 오류반환
	public int setMobileNum(String mobileNum) {
		String s1,s2,s3;
		s1 = mobileNum.substring(0,3);
		s2 = mobileNum.substring(3,7);
		s3 = mobileNum.substring(7, mobileNum.length());
		if(mobileNum.length() != 11 || !s1.equals("010"))
			return -1; // 포맷과 다를경우 -1반환하고 함수종료
		String s4 = s1+"-"+s2+"-"+s3;
		this.mobileNum = s4;
		return 0;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", mobileNum=" + mobileNum + "]";
	}
	
	
	
}
