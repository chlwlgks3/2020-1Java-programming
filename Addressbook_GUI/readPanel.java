package Addressbook;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class readPanel extends JPanel implements ActionListener{
	Main m;
	ioFile file = new ioFile();
	JTextArea imformation;
	JScrollPane scrollPane;
	JButton back;
	JLabel top;
	
	public void actionPerformed(ActionEvent e) {
		m.change("startPanel");
	}
	
	public readPanel(Main m) {
		this.m = m;
		setLayout(new BorderLayout());
		top = new JLabel("�ּҷ��� ��������Դϴ�");
		imformation = new JTextArea();
		scrollPane = new JScrollPane(imformation);
		back = new JButton("�ڷΰ���");
		back.addActionListener(this);
		if(m.bookobj.vc.size() == 0)
			imformation.append("��� ������ ����Ǿ������ʽ��ϴ�");
		for(int i = 0; i<m.bookobj.vc.size();i++) 
			imformation.append("\n"+m.bookobj.vc.get(i));
		add(top,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		add(back,BorderLayout.SOUTH);
	}
}
