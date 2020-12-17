package Addressbook;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class deletePanel extends JPanel implements ActionListener {
	Main m;
	ioFile file = new ioFile();
	JRadioButton name, tel, init; // 이름 또는 전화번호로 삭제
	ButtonGroup group = new ButtonGroup();
	JTextField input;
	JTextField imformation;
	JButton deleteOne, deleteAll, back;

	public void actionPerformed(ActionEvent e) {
		Person p;
		if (e.getSource() == back) {
			m.change("startPanel");
			init.setSelected(true);
			input.setText("이름또는 전화번호를 입력하시고 삭제버튼을 눌러주세요");
			imformation.setText(" ");
		}

		if (e.getSource() == deleteOne) {
			if(!name.isSelected() && !tel.isSelected())
				imformation.setText("이름또는 전화번호로 삭제중 하나를 선택해주세요");
			if (name.isSelected()) {
				String nameInput = input.getText();
				imformation.setText(nameInput);
				delete(nameInput);
				file.writeFile(m.bookobj);			
				input.setText("이름또는 전화번호를 입력하시고 삭제버튼을 눌러주세요");
			}
			if (tel.isSelected()) {
				String telInput = input.getText();
				imformation.setText(telInput);
				deleteTel(telInput);
				file.writeFile(m.bookobj);
				input.setText("이름또는 전화번호를 입력하시고 삭제버튼을 눌러주세요");
			}
		}

		if (e.getSource() == deleteAll) {
			m.bookobj.vc.removeAllElements();
			imformation.setText("주소록의 정보가 모두 삭제되었습니다");
			file.writeFile(m.bookobj);
		}
	}
	
	public void delete(String name) {
		int count = 0;
		for (int i = 0; i < m.bookobj.vc.size(); i++) 
			if (m.bookobj.vc.get(i).name.equals(name))
				count++;	
		if (count > 1) {
			imformation.setText("동명이인이 존재하므로 전화번호로 삭제해주세요.\n");
		} else if (count == 0)
			imformation.setText(name + "의 이름이 존재하지않습니다\n");
		else {
			for (int i = 0; i < m.bookobj.vc.size(); i++) {
				if (m.bookobj.vc.get(i).name.equals(name)) {
					m.bookobj.vc.remove(i);
					imformation.setText(name + "의 정보가 삭제되었습니다\n");
				}
			}
		}
	}

	void deleteTel(String tel) {
		boolean existTel = false;
		for (int i = 0; i < m.bookobj.vc.size(); i++) {
			if (m.bookobj.vc.get(i).tel.equals(tel)) {
				m.bookobj.vc.remove(i);
				imformation.setText(tel + "의 번호를 가진 사람의 정보가 삭제되었습니다\n");
				existTel = true;
			}
		}
		if (!existTel)
			imformation.setText("입력하신 전화번호는 존재하지않습니다\n");
	}

	public deletePanel(Main m) {
		this.m = m;
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		name = new JRadioButton("이름으로 삭제");
		tel = new JRadioButton("전화번호로 삭제");
		init = new JRadioButton();
		group.add(name);
		group.add(tel);
		group.add(init);
		p1.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(tel);
		input = new JTextField("이름또는 전화번호를 입력하시고 삭제버튼을 눌러주세요");
		imformation = new JTextField(" ");
		imformation.setEditable(false);
		p2.setLayout(new GridLayout(2, 0));
		p2.add(input);
		p2.add(imformation);
		deleteOne = new JButton("삭제");
		deleteAll = new JButton("모두삭제");
		back = new JButton("뒤로가기");
		deleteOne.addActionListener(this);
		deleteAll.addActionListener(this);
		back.addActionListener(this);
		p3.setLayout(new FlowLayout());
		p3.add(back);
		p3.add(deleteOne);
		p3.add(deleteAll);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
	}
}
