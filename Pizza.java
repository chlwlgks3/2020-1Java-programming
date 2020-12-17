import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pizza extends JFrame{
   private JPanel panelM,panel1, panel2, panel3, panel4, panel5;  
   private JLabel label; 
   private JButton order, cancel; 
   private JTextField price; 
   private double totalPrice = 1;
   boolean error = true; 
   JRadioButton r1 = new JRadioButton("Small");
   JRadioButton r2 = new JRadioButton("Medium");
   JRadioButton r3 = new JRadioButton("Large");
   JRadioButton r4 = new JRadioButton("콤보");
   JRadioButton r5 = new JRadioButton("포테이토");
   JRadioButton r6 = new JRadioButton("불고기");
   JRadioButton reset1 = new JRadioButton();
   JRadioButton reset2 = new JRadioButton(); 
   JCheckBox toppings1 = new JCheckBox("피망");
   JCheckBox toppings2 = new JCheckBox("치즈");
   JCheckBox toppings3 = new JCheckBox("페퍼로니");
   JCheckBox toppings4 = new JCheckBox("베이컨");
   
   class MyListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == order) { 
            if (r4.isSelected()) {            
               totalPrice = 10000;
               if (toppings1.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings2.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings3.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings4.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (r1.isSelected()) {
                  totalPrice = totalPrice*0.8;
               }
               if (r2.isSelected()) {
                  totalPrice = totalPrice*1;
               }
               if (r3.isSelected()) {
                  totalPrice = totalPrice*1.2;
               }
               if (!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected()){
                  price.setText("크기를 선택하세요");
                  error = false; 
               }
            }
            if (r5.isSelected()) {
               totalPrice = 12000;
               if (toppings1.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings2.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings3.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings4.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (r1.isSelected()) {
                  totalPrice = totalPrice*0.8;
               }
               if (e.getSource() == r2) {
                  totalPrice = totalPrice*1;
               }
               if (r3.isSelected()) {
                  totalPrice = totalPrice*1.2;
               }
               if (!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected()){
                  price.setText("크기를 선택하세요");
                  error = false; 
               }
            }
            if (r6.isSelected()) {
               totalPrice = 14000;
               if (toppings1.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings2.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings3.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (toppings4.isSelected()) {
                  totalPrice = totalPrice+500;
               }
               if (r1.isSelected()) {
                  totalPrice = totalPrice*0.8;
               }
               if (r2.isSelected()) {
                  totalPrice = totalPrice*1;
               }
               if (r3.isSelected()) {
                  totalPrice = totalPrice*1.2;
               }
               if (!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected()){
                  price.setText("크기를 선택하세요");
                  error = false; 
               }
            }
            if(!r4.isSelected()&&!r5.isSelected()&&!r6.isSelected()) {
               price.setText("피자 종류를 선택하세요");
            }
            if(r4.isSelected()||r5.isSelected()||r6.isSelected()) {
               if(error) {
                  price.setText((int)totalPrice+"원 입니다");
               }
               if(!error) {
                  price.setText("크기를 선택하세요");
                  error = true;
               }
            }
         }   
      if (e.getSource() == cancel) {
         reset1.setSelected(true);
         reset2.setSelected(true);
         toppings1.setSelected(false);
         toppings2.setSelected(false);
         toppings3.setSelected(false);
         toppings4.setSelected(false);
         price.setText("취소 되었습니다");
         }
      }
   }   
   public Pizza() {   
      setTitle("피자 주문");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      panelM = new JPanel();
      panel1 = new JPanel();
      panel2 = new JPanel();
      panel3 = new JPanel();
      panel4 = new JPanel();
      panel5 = new JPanel();
      label = new JLabel();
      order = new JButton("주문");
      cancel = new JButton("취소");
      price = new JTextField(20);
      panelM.setLayout(new BorderLayout());     
      label.setText("자바 피자에 오신것을 환영합니다");
      panel1.add(label);
      panelM.add(panel1, BorderLayout.NORTH);
      panel3.add(order);
      panel3.add(cancel);
      panel3.add(price);
      order.addActionListener(new MyListener());
      cancel.addActionListener(new MyListener());
      price.setEditable(false);
      panelM.add(panel3, BorderLayout.SOUTH); 
      panel2.setBorder(BorderFactory.createTitledBorder("크기"));
      
      ButtonGroup size = new ButtonGroup();
      size.add(r1);
      size.add(r2);
      size.add(r3);
      size.add(reset1);
      r1.addActionListener(new MyListener());
      r2.addActionListener(new MyListener());
      r3.addActionListener(new MyListener());
      panel2.add(r1);
      panel2.add(r2);
      panel2.add(r3);
      panelM.add(panel2, BorderLayout.EAST);
      panel4.setBorder(BorderFactory.createTitledBorder("종류"));     
      ButtonGroup type = new ButtonGroup();
      type.add(r4);
      type.add(r5);
      type.add(r6);
      type.add(reset2);
      r4.addActionListener(new MyListener());
      r5.addActionListener(new MyListener());
      r6.addActionListener(new MyListener());
      panel4.add(r4);
      panel4.add(r5);
      panel4.add(r6);
      panelM.add(panel4, BorderLayout.WEST);
      panel5.setBorder(BorderFactory.createTitledBorder("추가토핑"));
      toppings1.addActionListener(new MyListener());
      toppings2.addActionListener(new MyListener());
      toppings3.addActionListener(new MyListener());
      toppings4.addActionListener(new MyListener());      
      panel5.add(toppings1);
      panel5.add(toppings2);
      panel5.add(toppings3);
      panel5.add(toppings4);
      panelM.add(panel5, BorderLayout.CENTER);   
      add(panelM);
      pack();
      setVisible(true);
   }
   public static void main(String[] args) {
      Pizza obj = new Pizza();
   }
}
