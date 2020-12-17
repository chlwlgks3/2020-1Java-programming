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
	
	// ��ȭ��ȣ ���� üũ 010-xxxx-xxxx ���·� ����
	// 01012345678 �Է��ߴٸ� 010-1234-5678�� ��ȯ�Ͽ� ����
	// ������ �ٸ��� ������ȯ
	public int setMobileNum(String mobileNum) {
		String s1,s2,s3;
		s1 = mobileNum.substring(0,3);
		s2 = mobileNum.substring(3,7);
		s3 = mobileNum.substring(7, mobileNum.length());
		if(mobileNum.length() != 11 || !s1.equals("010"))
			return -1; // ���˰� �ٸ���� -1��ȯ�ϰ� �Լ�����
		String s4 = s1+"-"+s2+"-"+s3;
		this.mobileNum = s4;
		return 0;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", mobileNum=" + mobileNum + "]";
	}
	
	
	
}
