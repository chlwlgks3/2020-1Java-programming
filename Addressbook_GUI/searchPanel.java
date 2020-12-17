package Addressbook;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class searchPanel extends JPanel implements ActionListener{
	Main m;
	AddressBook book = new AddressBook();
	ArrayList<Person> buffer = new ArrayList<Person>();
	JRadioButton name, tel, init; //이름 또는 전화번호로 검색. init은 버튼해제용 라디오버튼
	ButtonGroup group = new ButtonGroup();
	JTextField input; //이름 또는 전화번호 입력텍스트필드
	JTextField imformation; //결과 출력할 텍스트필드
	JButton search, back;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			m.change("startPanel");
			//뒤로가기 버튼이 눌러짐과 동시에 초기화작업
			init.setSelected(true);
			imformation.setText("정보는 여기에");
			input.setText("이름 또는 전화번호를 입력하시고 '검색하기'를 눌러주세요");
		}
		
		if(e.getSource() == search){
			if(name.isSelected() == false && tel.isSelected() == false)
				imformation.setText("이름 또는 전화번호로 검색중 하나를 골라주세요");
			else {
				boolean exist_name = false, exist_tel = false;
				if(name.isSelected()) {
					for(int i = 0;i<m.bookobj.vc.size();i++) {
						if(m.bookobj.vc.get(i).name.equals(input.getText())) {
							imformation.setText(m.bookobj.vc.get(i).toString());
							exist_name = true;
						}
					}
					if(!exist_name)
						imformation.setText("그런이름이 존재하지않습니다");
				}
				if(tel.isSelected()) {
					for(int i = 0;i<m.bookobj.vc.size();i++) {
						if(m.bookobj.vc.get(i).tel.equals(input.getText())) {
							imformation.setText(m.bookobj.vc.get(i).toString());
							exist_tel = true;
						}
					}
					if(!exist_tel)
						imformation.setText("그런번호가 존재하지않습니다");
				}
				
				
			}
		}
		
	}
	
	public searchPanel(Main m) {
		this.m = m;
		this.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(); JPanel p2 = new JPanel(); JPanel p3 = new JPanel();
		name = new JRadioButton("이름으로 검색");
		tel = new JRadioButton("전화번호로 검색");
		init = new JRadioButton();
		group.add(name); group.add(tel); group.add(init);
		p1.add(name); p1.add(tel);
		
		input = new JTextField("이름 또는 전화번호를 입력하시고 '검색하기'를 눌러주세요");
		imformation = new JTextField("정보는 여기에");
		imformation.setEditable(false);
		p2.setLayout(new GridLayout(2,0));
		p2.add(input); p2.add(imformation);
		
		search = new JButton("검색하기");
		back = new JButton("뒤로가기");
		search.addActionListener(this); back.addActionListener(this);
		p3.add(back); p3.add(search);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
	}
	
	
}
