package TanWar;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.*;
import java.io.IOException;

/**
 * �������������Ϸ��������
 * @author chen
 *
 */

public class TankClient extends Frame{

	/**
	 * ָ����Ϸ�Ŀ��
	 */
	public static final int GAME_WIDTH = 800;
	/**
	 * ָ����Ϸ�ĸ߶�
	 */
	public static final int GAME_HEIGHT = 600;
	
	//ָ��̹�˵Ĵ�С
	int x = 50, y = 50;
	//Ϊͼ�ΰ�̹������׼��
	Image offScreenImage = null;
	
	Tank tank = new Tank(800,600, true, Direction.STOP,  this);
	Wall w1 = new Wall(100, 300, 10, 120, this);
	Wall w2 = new Wall(300, 200, 200, 15, this);
	Blood b = new Blood();
	/*
	 * �ֱ������Ա����洢���ϱ仯��ӵ��ӵ�����ը��̹��
	 */
	List <Missile> mis = new ArrayList<Missile>();
	List <Explode> exp = new ArrayList<Explode>();
	List <Tank> tanks = new ArrayList<Tank>();
	
	/**
	 * ���������໭��̹�ˣ��ӵ�����ը��Ѫ���
	 */
	public void paint(Graphics g)
	{
		if(tanks.size() <= 0)
		{
			/*
			 * �����TankWarProp.getProperty("reduesTankCount"))�ǵ��������һ���ۣ�����������
			 * �����ļ����ܹ������ٲ�����Ҫ���±�������ǰ���£��ܹ��ı���ص���
			 */
			for(int i = 0; i < Integer.parseInt(TankWarProp.getProperty("reduesTankCount"));  i ++)
			{
				//������������ӵ��˵�̹��
				tanks.add(new Tank(50 + 40*(i+1), 50, false, Direction.D, this));
			}
		}
		
		for(int i = 0; i < mis.size(); i ++)
		{
			/*
			 * ����ӵ������ҵ����ӵ�����������̹�ˣ��Լ���̹�˵ķ���������ײ��ǽ�ķ���
			 */
			Missile m = mis.get(i);
			m.hitTank(tank);
			m.hitTanks(tanks);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}
		//������ը
		for(int i = 0; i < exp.size(); i ++)
		{
			Explode e = exp.get(i);
			e.draw(g);
		}
		//�������ɵ���̹�ˣ�ͬʱ����ײ��ǽ�ķ���
		for(int i=0; i<tanks.size(); i++) {
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
		tank.draw(g);
		tank.collidesWithWall(w1);
		tank.collidesWithWall(w2);
		tank.collidesWithTank(tanks);
		tank.eatBlood(b);
		b.draw(g);
		w1.draw(g);
		w2.draw(g);
	}
	/**
	 * ���½��棬ͬʱΪͼ�ΰ�����׼��
	 */
	public void update(Graphics g)
	{
		if(offScreenImage == null)
		{
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/**
	 * ���������ڣ�Ĭ������6��̹��
	 */
	public void launchFrame()
	{

		int initTankCount = Integer.parseInt(TankWarProp.getProperty("initTankCount"));
		
		for(int i = 0; i < initTankCount;  i ++)
		{
			tanks.add(new Tank(50 + 40*(i+1), 50, false, Direction.D, this));
		}
		
		this.setLocation(400,400);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setVisible(true);
		this.setTitle("TankWar");
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.addWindowListener(new WindowAdapter()
		{

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		}
		);
		
		
		new Thread(new PraintThread()).start();
		this.addKeyListener(new keyMonitor());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	
	/*
	 * �߳������ˢ�µ�ʱ��
	 */
	private class PraintThread implements Runnable
	{

		public void run() {
			while(true)
			{
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	/**
	 * ���������������°�ť�Լ��ͷŰ�ť�Ĺ���
	 * @author chen
	 *
	 */
	public class keyMonitor extends KeyAdapter
	{
		public void keyReleased(KeyEvent e) {
			//����̹�������ͷŰ�ť�Ĺ���
			tank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			//����̹�����а��°�ť�Ĺ���
			tank.keyPress(e);
		}

	}

}








