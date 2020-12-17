package Addressbook;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* PersonŬ���� 10���� vector�� �̿��Ͽ� ���� ����
PersonŬ������ String name,String tel, int age �� ����

1.�ڷ��Է�
2.�ڷ��б�
3.�ڷ�ã��
4.�ڷ����
5.����
�� ��ɵ��� GUI�� �����
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
			System.exit(0); //exit ������ �ٷ� ����
		}
	}
	
	public startPanel(Main m) {	
		this.m = m;
		setLayout(new GridLayout(6, 0));
		write = new JButton("1.�Է�");
		write.addActionListener(this);
		read = new JButton("2.�б�");
		read.addActionListener(this);
		search = new JButton("3.�˻�");
		search.addActionListener(this);
		delete = new JButton("4.����");
		delete.addActionListener(this);
		exit = new JButton("5.����");
		exit.addActionListener(this);
		add(new JLabel("�Ʒ��׸��� ���ϴµ����� �����ϼ���")); add(write); add(read); add(search); add(delete); add(exit);
		setVisible(true);
	}
}
