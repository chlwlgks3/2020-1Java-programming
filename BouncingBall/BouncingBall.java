import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BouncingBall extends JFrame implements ActionListener {
   private int x = 60, y = 60; // ���� ó����ġ
   private int x2 = 100, y2 = 100;
   private int xSpeed = 2, ySpeed = 2;
   private int xSpeed2 = 2, ySpeed2 = 2;
   private static final int WIDTH = 600;
   private static final int HEIGHT = 800;
   private static final int PERIOD = 10;
   private int bar_x = 170;
   private int bar_y = HEIGHT - 130; // bar�� �׷��� x��ǥ,y��ǥ
   private int bar_width = 300, bar_height = 30;
   private int speedTime = 1, barTime = 1, ballTime = 0, level = 1;
   private boolean proceed = true;
   private ArrayList<Integer> record = new ArrayList<Integer>(); //������ ����� �����迭
   Font f = new Font("Serif", Font.BOLD | Font.ITALIC, 17);
   Sound s = new Sound();
   
   class Sound extends JFrame{
		public void Play(String fileName) {
			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
				Clip clip = AudioSystem.getClip();
				clip.stop();
				clip.open(ais);
				clip.start();
			} catch (Exception ex) {
			}
		}
   }
   
   class MyPanel extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         if (proceed) {       	
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, 50, 700);
            g.fillRect(0, 0, 600, 50);
            g.fillRect(540, 0, 50, 700);
            g.setColor(Color.green);
            g.fillRect(bar_x, bar_y, bar_width, bar_height);
            g.setColor(Color.orange);
            g.fillOval(x, y, 40, 40);
            g.setFont(f);
            if(level == 20) //�ִ뷹���� 20�� �����ϸ� ������� MAX���� ���
            	g.drawString("Level:MAX!!!", 300, 15);
            else //�ִ뷹���� �ƴѰ�� ���緹�����
            	g.drawString("Level:"+level, 300, 15);
            
            g.drawString("Score:" + (ballTime / 10), 500, 15); //����ȭ���� ���������� ������ ��Ÿ������
            if (ballTime >= 500) { //ballTime500�̻���� �ι�° ���� ��Ÿ��
               g.setColor(Color.magenta);
               g.fillOval(x2, y2, 40, 40);
            }
         } else {
        	boolean duplicate = false; //�ߺ��� ������ ������� ������� �ʵ��� �� ����
            g.setColor(Color.black);
            g.drawString("GAME OVER", 200, 300);
            g.drawString("Score:" +ballTime / 10, 200, 320);
            g.drawString("������Ϸ��� 'R'��ư�� �����ּ���", 200, 340);
            for(int i=0;i<record.size();i++)
            	if(record.get(i) == ballTime/10) //�����ߺ� üũ
            		duplicate = true;
            if(!duplicate)
            	record.add(ballTime/10);            
            Collections.sort(record,Collections.reverseOrder());
            g.drawString("====RANKING====", 200,360);
            System.out.println(record.size());
            for(int i = 0;i<record.size();i++) {
            	if(i == 3) //3������� ȭ�鿡 ���
            		break;
            	g.drawString(""+(i+1)+"��:"+record.get(i), 200,380+20*i);
            }        
            if(ballTime/10 == record.get(0) )
            	g.drawString("1��޼��� ���ϵ帳�ϴ�!", 200, 440);
         }
      }
   }
   
   public void update() {
      x += xSpeed;
      y += ySpeed;
      if (ballTime >= 500) { //�ι�°���� �̵�
         x2 += xSpeed2;
         y2 += ySpeed2;
      }
      if (y > HEIGHT - 120 || y2 > HEIGHT - 120) {
    	 s.Play("gameover.wav");
         proceed = false;
      }
      if (x > WIDTH - 95 || x < 50) {
         xSpeed = -xSpeed;
         s.Play("bounce.wav");
      }
      if (y < 50) {
         ySpeed = -ySpeed;
         s.Play("bounce.wav");
      }
      if (x2 > WIDTH - 95 || x2 < 50) {
         xSpeed2 = -xSpeed2;
         s.Play("bounce.wav");
      }
      if (y2 < 50) {
         ySpeed2 = -ySpeed2;
         s.Play("bounce.wav");
      }
      if (y > bar_y - 40 && x > bar_x && x < bar_x + bar_width) {
         ySpeed = -ySpeed;
         s.Play("bounce.wav");
      }
      if (y2 > bar_y - 40 && x2 > bar_x && x2 < bar_x + bar_width) {
         ySpeed2 = -ySpeed2;
         s.Play("bounce.wav");
      }
   }

   public BouncingBall() {
      setSize(WIDTH, HEIGHT);
      setTitle("Bouncing Ball");  
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      addKeyListener(new key());
      add(new MyPanel());
      setVisible(true);
      Timer timer = new Timer(PERIOD, this);
      timer.start();
   }
   
   public void actionPerformed(ActionEvent e) {
      if (barTime % 70 == 0 && bar_width >= 220) {  // 0.7�ʸ��� ���� ���� �پ��,���� ���̴� �ּ� 220
            bar_width = bar_width - 5;  
            level++; //bar���̰� �پ�鶧���� level���
      }
      if (speedTime % 700 == 0 && Math.abs(xSpeed) <= 5) { // 7�ʸ��� ���ӵ� ����, ���ִ�ӵ��� 5
         if (xSpeed < 0) 
            xSpeed--;
         else
            xSpeed++;        
         if (ySpeed < 0) 
            ySpeed--;
         else 
            ySpeed++;
         level++; //���ӵ� ������������ level ���
         if(ballTime == 500)
        	 level++; //�ι�° �� �����Ǹ� level���
      }
      barTime++;
      speedTime++;
      if (proceed) // ���������߿��� �ð��� �帣����
         ballTime++;
      if(proceed) { //�����������϶��� update() �� repaint()����
	      update();
	      repaint();
      }
   }

   class key extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         int keyCode = e.getKeyCode();
         if (keyCode == KeyEvent.VK_R) {
        	//�ʱ�ȭ
            x = 60; y = 60;
            x2 = 10; y2 = 100;
            xSpeed = 2; ySpeed = 2;
            bar_x = 170;
            bar_y = HEIGHT - 130;
            bar_width = 300;
            bar_height = 30;
            speedTime = 1;
            barTime = 1;
            ballTime = 0;
            //�����
            proceed = true;
         }
         if (keyCode == KeyEvent.VK_LEFT) {
            if (bar_x > 50) //���ʺ��� �����ʵ���
               bar_x = bar_x - 10;
         }
         if (keyCode == KeyEvent.VK_RIGHT) {
            if (bar_x + 10 + bar_width < WIDTH - 55) //�����ʺ��� �����ʵ���
               bar_x = bar_x + 10;
         }
      }
   }

   public static void main(String[] args) {
      BouncingBall f = new BouncingBall();
   }
}