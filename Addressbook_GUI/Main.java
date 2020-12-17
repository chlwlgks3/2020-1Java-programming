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
	
	public void change(String panelName) { // ȭ����ȯ �޼ҵ�
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
		setTitle("�ּҷ� ���α׷�");
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
		//10�� ���Ϳ� ����
		m.bookobj.vc.add(new Person("�Ӳ���","01011112222",25));
		m.bookobj.vc.add(new Person("������","01023457896",52));
		m.bookobj.vc.add(new Person("�踻��","01033334444",75));
		m.bookobj.vc.add(new Person("����ȯ","01044445555",30));
		m.bookobj.vc.add(new Person("������","01055556666",42));
		m.bookobj.vc.add(new Person("���¿�","01066667777",18));
		m.bookobj.vc.add(new Person("�ڱ���","01077778888",20));
		m.bookobj.vc.add(new Person("������","01088889999",21));
		m.bookobj.vc.add(new Person("������","01099997777",22));
		m.bookobj.vc.add(new Person("ȫ�浿","01012345678",23));
		
		
	}
	
}
