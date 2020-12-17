package Addressbook;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

class writePanel extends JPanel implements ActionListener {
	Main m;
	ioFile file = new ioFile();
	JLabel name_label = new JLabel("�̸�");
	JLabel tel_label = new JLabel("��ȭ��ȣ");
	JLabel age_label = new JLabel("����");
	JTextField name = new JTextField("�̸��� �Է��ϼ���");
	JTextField tel = new JTextField("(-)�����ϰ� ��ȭ��ȣ�� �Է��ϼ���");
	JTextField age = new JTextField("���̸� �Է��ϼ���");
	JButton save = new JButton("����");
	JButton back = new JButton("�ڷΰ���");
	JTextField imformation = new JTextField(" ");
	Boolean isName = false, isTel = false , isAge = false; //name,tel,age�� �ԷµǾ����� Ȯ���ϱ����� ����
	
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
			if(name.getText().length() != 0 && !name.getText().equals("�̸��� �Է��ϼ���"))
				isName = true;
			if(tel.getText().length() == 11)
				isTel = true;
			if(age.getText().length() !=0 && !age.getText().equals("���̸� �Է��ϼ���"))
				isAge = true;
			if(!isName || !isTel || !isAge) {
				imformation.setText("����׸��� ä���ּ���");
				if(tel.getText().length() != 11 && !tel.getText().equals("(-)�����ϰ� ��ȭ��ȣ�� �Է��ϼ���")) 
					imformation.setText("��ȭ��ȣ ���Ŀ� ���缭 �Է����ּ���(-)�� �����ؾ��մϴ�");	
			}
			if(isName == true && isTel == true && isAge == true) {
				p = new Person("","",0);
				p.setName(name.getText());
				p.setTel(tel.getText());
				p.setAge(Integer.parseInt(age.getText()));
				file.writeFile(m.bookobj);
				m.bookobj.insert(p);
				name.setText("�̸��� �Է��ϼ���");
				tel.setText("(-)�����ϰ� ��ȭ��ȣ�� �Է��ϼ���");
				age.setText("���̸� �Է��ϼ���");
				imformation.setText("���������� ����Ǿ����ϴ�");
			}
		}
		
		if (e.getSource() == back) {
			m.change("startPanel");
			//�ڷΰ��� ������ ���ÿ� �ʱ�ȭ�۾�
			name.setText("�̸��� �Է��ϼ���");
			tel.setText("(-)�����ϰ� ��ȭ��ȣ�� �Է��ϼ���");
			age.setText("���̸� �Է��ϼ���");
			imformation.setText(" ");
		}
	}
	
	
}
