
public class Dice {
	private int num1;
	private int num2;
	private int count;
	
	public Dice() {
		num1 =0; 
		num2 =0; 
		count=0;
	}
	
	private void setNum() {
		num1 = (int)(Math.random()*6)+1;
		num2 = (int)(Math.random()*6)+1;
	}
	
	private void print() {
		System.out.println("주사위1= "+num1+" 주사위2= "+num2);
		if(num1+num2 ==2)
			System.out.println("(1,1)이 나오는데 걸린 횟수 ="+count);
	}
	
	private void func() {
		while(num1+num2 !=2) {
			count++;
			setNum();
			print();
		}
	}
	
	public static void main(String[] args) {
		Dice obj = new Dice();
		obj.func();
	}
}
