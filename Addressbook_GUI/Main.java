package Addressbook;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame{
	public startPanel stp = null;
	public writePanel wp = null;
	public readPanel rp = null;
	public searchPanel sp = null;
	public deletePanel dp = null;
	public AddressBook bookobj = null;
	public ioFile file = new ioFile();
	
	public void change(String panelName) { // 화면전환 메소드
		if(panelName.equals("writePanel")) {
			getContentPane().removeAll();
			getContentPane().add(wp);
			revalidate();
			repaint();
		}	
		else if(panelName.equals("readPanel")) {
			getContentPane().removeAll();
			getContentPane().add(new readPanel(this));
			revalidate();
			repaint();
		}
		else if(panelName.equals("searchPanel")) {
			getContentPane().removeAll();
			getContentPane().add(sp);
			revalidate();
			repaint();
		}
		else if(panelName.equals("deletePanel")) {
			getContentPane().removeAll();
			getContentPane().add(dp);
			revalidate();
			repaint();
		}
		else if(panelName.equals("startPanel")) {
			getContentPane().removeAll();
			getContentPane().add(stp);
			revalidate();
			repaint();
		}
	}
	
	public Main() throws IOException {
		setTitle("주소록 프로그램");
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bookobj = file.readFile();
		stp = new startPanel(this);
		sp = new searchPanel(this);
		wp = new writePanel(this);
		rp = new readPanel(this);
		dp = new deletePanel(this);
		add(stp);	
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();	
		//10명 벡터에 저장
		m.bookobj.vc.add(new Person("임꺽정","01011112222",25));
		m.bookobj.vc.add(new Person("변수한","01023457896",52));
		m.bookobj.vc.add(new Person("김말자","01033334444",75));
		m.bookobj.vc.add(new Person("전두환","01044445555",30));
		m.bookobj.vc.add(new Person("박정희","01055556666",42));
		m.bookobj.vc.add(new Person("노태우","01066667777",18));
		m.bookobj.vc.add(new Person("박근혜","01077778888",20));
		m.bookobj.vc.add(new Person("최지한","01088889999",21));
		m.bookobj.vc.add(new Person("유관순","01099997777",22));
		m.bookobj.vc.add(new Person("홍길동","01012345678",23));
		
		
	}
	
}
