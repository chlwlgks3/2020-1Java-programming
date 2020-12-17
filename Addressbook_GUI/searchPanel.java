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
	JRadioButton name, tel, init; //�̸� �Ǵ� ��ȭ��ȣ�� �˻�. init�� ��ư������ ������ư
	ButtonGroup group = new ButtonGroup();
	JTextField input; //�̸� �Ǵ� ��ȭ��ȣ �Է��ؽ�Ʈ�ʵ�
	JTextField imformation; //��� ����� �ؽ�Ʈ�ʵ�
	JButton search, back;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			m.change("startPanel");
			//�ڷΰ��� ��ư�� �������� ���ÿ� �ʱ�ȭ�۾�
			init.setSelected(true);
			imformation.setText("������ ���⿡");
			input.setText("�̸� �Ǵ� ��ȭ��ȣ�� �Է��Ͻð� '�˻��ϱ�'�� �����ּ���");
		}
		
		if(e.getSource() == search){
			if(name.isSelected() == false && tel.isSelected() == false)
				imformation.setText("�̸� �Ǵ� ��ȭ��ȣ�� �˻��� �ϳ��� ����ּ���");
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
						imformation.setText("�׷��̸��� ���������ʽ��ϴ�");
				}
				if(tel.isSelected()) {
					for(int i = 0;i<m.bookobj.vc.size();i++) {
						if(m.bookobj.vc.get(i).tel.equals(input.getText())) {
							imformation.setText(m.bookobj.vc.get(i).toString());
							exist_tel = true;
						}
					}
					if(!exist_tel)
						imformation.setText("�׷���ȣ�� ���������ʽ��ϴ�");
				}
				
				
			}
		}
		
	}
	
	public searchPanel(Main m) {
		this.m = m;
		this.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(); JPanel p2 = new JPanel(); JPanel p3 = new JPanel();
		name = new JRadioButton("�̸����� �˻�");
		tel = new JRadioButton("��ȭ��ȣ�� �˻�");
		init = new JRadioButton();
		group.add(name); group.add(tel); group.add(init);
		p1.add(name); p1.add(tel);
		
		input = new JTextField("�̸� �Ǵ� ��ȭ��ȣ�� �Է��Ͻð� '�˻��ϱ�'�� �����ּ���");
		imformation = new JTextField("������ ���⿡");
		imformation.setEditable(false);
		p2.setLayout(new GridLayout(2,0));
		p2.add(input); p2.add(imformation);
		
		search = new JButton("�˻��ϱ�");
		back = new JButton("�ڷΰ���");
		search.addActionListener(this); back.addActionListener(this);
		p3.add(back); p3.add(search);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
	}
	
	
}
