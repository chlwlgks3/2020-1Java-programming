package Addressbook;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class writePanel extends JPanel implements ActionListener {
	Main m;
	ioFile file = new ioFile();
	JLabel name_label = new JLabel("이름");
	JLabel tel_label = new JLabel("전화번호");
	JLabel age_label = new JLabel("나이");
	JTextField name = new JTextField("이름을 입력하세요");
	JTextField tel = new JTextField("(-)생략하고 전화번호를 입력하세요");
	JTextField age = new JTextField("나이를 입력하세요");
	JButton save = new JButton("저장");
	JButton back = new JButton("뒤로가기");
	JTextField imformation = new JTextField(" ");
	Boolean isName = false, isTel = false , isAge = false; //name,tel,age가 입력되었는지 확인하기위한 변수
	
	public writePanel(Main m) {
		this.m = m;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(4, 2));
		p2.setLayout(new FlowLayout());
		imformation.setEditable(false);
		setLayout(new BorderLayout());
		back.addActionListener(this);
		save.addActionListener(this);
		p1.add(name_label);
		p1.add(name);
		p1.add(tel_label);
		p1.add(tel);
		p1.add(age_label);
		p1.add(age);
		p2.add(back);
		p2.add(save);
		add(p1,BorderLayout.NORTH); add(p2,BorderLayout.SOUTH);
		add(imformation,BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		Person p;
		if (e.getSource() == save) {
			if(name.getText().length() != 0 && !name.getText().equals("이름을 입력하세요"))
				isName = true;
			if(tel.getText().length() == 11)
				isTel = true;
			if(age.getText().length() !=0 && !age.getText().equals("나이를 입력하세요"))
				isAge = true;
			if(!isName || !isTel || !isAge) {
				imformation.setText("모든항목을 채워주세요");
				if(tel.getText().length() != 11 && !tel.getText().equals("(-)생략하고 전화번호를 입력하세요")) 
					imformation.setText("전화번호 형식에 맞춰서 입력해주세요(-)를 생략해야합니다");	
			}
			if(isName == true && isTel == true && isAge == true) {
				p = new Person("","",0);
				p.setName(name.getText());
				p.setTel(tel.getText());
				p.setAge(Integer.parseInt(age.getText()));
				file.writeFile(m.bookobj);
				m.bookobj.insert(p);
				name.setText("이름을 입력하세요");
				tel.setText("(-)생략하고 전화번호를 입력하세요");
				age.setText("나이를 입력하세요");
				imformation.setText("성공적으로 저장되었습니다");
			}
		}
		
		if (e.getSource() == back) {
			m.change("startPanel");
			//뒤로가기 누름과 동시에 초기화작업
			name.setText("이름을 입력하세요");
			tel.setText("(-)생략하고 전화번호를 입력하세요");
			age.setText("나이를 입력하세요");
			imformation.setText(" ");
		}
	}
	
	
}
