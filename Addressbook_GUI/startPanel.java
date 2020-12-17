package Addressbook;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Person클래스 10개를 vector를 이용하여 임의 생성
Person클래스는 String name,String tel, int age 로 구성

1.자료입력
2.자료읽기
3.자료찾기
4.자료삭제
5.종료
위 기능들을 GUI로 만들기
*/

public class startPanel extends JPanel implements ActionListener{
	JButton write,read,search,delete,exit;
	JLabel name_label, tel_label, age_label;
	JTextField name, tel, age;
	Main m;
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == write) {
			m.change("writePanel");
		}
		else if(e.getSource() == read) {
			m.change("readPanel");
		}
		else if(e.getSource() == search) {
			m.change("searchPanel");
		}
		else if(e.getSource() == delete) {
			m.change("deletePanel");
		}
		else if(e.getSource() == exit) {
			System.exit(0); //exit 누르면 바로 종료
		}
	}
	
	public startPanel(Main m) {	
		this.m = m;
		setLayout(new GridLayout(6, 0));
		write = new JButton("1.입력");
		write.addActionListener(this);
		read = new JButton("2.읽기");
		read.addActionListener(this);
		search = new JButton("3.검색");
		search.addActionListener(this);
		delete = new JButton("4.삭제");
		delete.addActionListener(this);
		exit = new JButton("5.종료");
		exit.addActionListener(this);
		add(new JLabel("아래항목중 원하는동작을 선택하세요")); add(write); add(read); add(search); add(delete); add(exit);
		setVisible(true);
	}
}
