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
		top = new JLabel("주소록의 모든정보입니다");
		imformation = new JTextArea();
		scrollPane = new JScrollPane(imformation);
		back = new JButton("뒤로가기");
		back.addActionListener(this);
		if(m.bookobj.vc.size() == 0)
			imformation.append("어떠한 정보도 저장되어있지않습니다");
		for(int i = 0; i<m.bookobj.vc.size();i++) 
			imformation.append("\n"+m.bookobj.vc.get(i));
		add(top,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		add(back,BorderLayout.SOUTH);
	}
}
