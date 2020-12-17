package Addressbook;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class deletePanel extends JPanel implements ActionListener {
	Main m;
	ioFile file = new ioFile();
	JRadioButton name, tel, init; // �̸� �Ǵ� ��ȭ��ȣ�� ����
	ButtonGroup group = new ButtonGroup();
	JTextField input;
	JTextField imformation;
	JButton deleteOne, deleteAll, back;

	public void actionPerformed(ActionEvent e) {
		Person p;
		if (e.getSource() == back) {
			m.change("startPanel");
			init.setSelected(true);
			input.setText("�̸��Ǵ� ��ȭ��ȣ�� �Է��Ͻð� ������ư�� �����ּ���");
			imformation.setText(" ");
		}

		if (e.getSource() == deleteOne) {
			if(!name.isSelected() && !tel.isSelected())
				imformation.setText("�̸��Ǵ� ��ȭ��ȣ�� ������ �ϳ��� �������ּ���");
			if (name.isSelected()) {
				String nameInput = input.getText();
				imformation.setText(nameInput);
				delete(nameInput);
				file.writeFile(m.bookobj);			
				input.setText("�̸��Ǵ� ��ȭ��ȣ�� �Է��Ͻð� ������ư�� �����ּ���");
			}
			if (tel.isSelected()) {
				String telInput = input.getText();
				imformation.setText(telInput);
				deleteTel(telInput);
				file.writeFile(m.bookobj);
				input.setText("�̸��Ǵ� ��ȭ��ȣ�� �Է��Ͻð� ������ư�� �����ּ���");
			}
		}

		if (e.getSource() == deleteAll) {
			m.bookobj.vc.removeAllElements();
			imformation.setText("�ּҷ��� ������ ��� �����Ǿ����ϴ�");
			file.writeFile(m.bookobj);
		}
	}
	
	public void delete(String name) {
		int count = 0;
		for (int i = 0; i < m.bookobj.vc.size(); i++) 
			if (m.bookobj.vc.get(i).name.equals(name))
				count++;	
		if (count > 1) {
			imformation.setText("���������� �����ϹǷ� ��ȭ��ȣ�� �������ּ���.\n");
		} else if (count == 0)
			imformation.setText(name + "�� �̸��� ���������ʽ��ϴ�\n");
		else {
			for (int i = 0; i < m.bookobj.vc.size(); i++) {
				if (m.bookobj.vc.get(i).name.equals(name)) {
					m.bookobj.vc.remove(i);
					imformation.setText(name + "�� ������ �����Ǿ����ϴ�\n");
				}
			}
		}
	}

	void deleteTel(String tel) {
		boolean existTel = false;
		for (int i = 0; i < m.bookobj.vc.size(); i++) {
			if (m.bookobj.vc.get(i).tel.equals(tel)) {
				m.bookobj.vc.remove(i);
				imformation.setText(tel + "�� ��ȣ�� ���� ����� ������ �����Ǿ����ϴ�\n");
				existTel = true;
			}
		}
		if (!existTel)
			imformation.setText("�Է��Ͻ� ��ȭ��ȣ�� ���������ʽ��ϴ�\n");
	}

	public deletePanel(Main m) {
		this.m = m;
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		name = new JRadioButton("�̸����� ����");
		tel = new JRadioButton("��ȭ��ȣ�� ����");
		init = new JRadioButton();
		group.add(name);
		group.add(tel);
		group.add(init);
		p1.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(tel);
		input = new JTextField("�̸��Ǵ� ��ȭ��ȣ�� �Է��Ͻð� ������ư�� �����ּ���");
		imformation = new JTextField(" ");
		imformation.setEditable(false);
		p2.setLayout(new GridLayout(2, 0));
		p2.add(input);
		p2.add(imformation);
		deleteOne = new JButton("����");
		deleteAll = new JButton("��λ���");
		back = new JButton("�ڷΰ���");
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
