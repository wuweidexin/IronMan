package TanWar;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.*;
import java.io.IOException;

/**
 * 这个类是整个游戏的主窗口
 * @author chen
 *
 */

public class TankClient extends Frame{

	/**
	 * 指明游戏的宽度
	 */
	public static final int GAME_WIDTH = 800;
	/**
	 * 指明游戏的高度
	 */
	public static final int GAME_HEIGHT = 600;
	
	//指明坦克的大小
	int x = 50, y = 50;
	//为图形版坦克做好准备
	Image offScreenImage = null;
	
	Tank tank = new Tank(800,600, true, Direction.STOP,  this);
	Wall w1 = new Wall(100, 300, 10, 120, this);
	Wall w2 = new Wall(300, 200, 200, 15, this);
	Blood b = new Blood();
	/*
	 * 分别用线性表来存储不断变化添加的子弹，爆炸，坦克
	 */
	List <Missile> mis = new ArrayList<Missile>();
	List <Explode> exp = new ArrayList<Explode>();
	List <Tank> tanks = new ArrayList<Tank>();
	
	/**
	 * 调用其他类画出坦克，子弹，爆炸，血块等
	 */
	public void paint(Graphics g)
	{
		if(tanks.size() <= 0)
		{
			/*
			 * 下面的TankWarProp.getProperty("reduesTankCount"))是调用另外的一个累，里面运用了
			 * 配置文件，能够进行再不在需要从新编译代码的前提下，能够改变相关的量
			 */
			for(int i = 0; i < Integer.parseInt(TankWarProp.getProperty("reduesTankCount"));  i ++)
			{
				//向主窗口中添加敌人的坦克
				tanks.add(new Tank(50 + 40*(i+1), 50, false, Direction.D, this));
			}
		}
		
		for(int i = 0; i < mis.size(); i ++)
		{
			/*
			 * 添加子弹，并且调用子弹类里面打击好坦克，以及坏坦克的方法，还有撞击墙的方法
			 */
			Missile m = mis.get(i);
			m.hitTank(tank);
			m.hitTanks(tanks);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}
		//画出爆炸
		for(int i = 0; i < exp.size(); i ++)
		{
			Explode e = exp.get(i);
			e.draw(g);
		}
		//不断生成敌人坦克，同时调用撞击墙的方法
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
	 * 更新界面，同时为图形版做好准备
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
	 * 画出主窗口，默认生成6量坦克
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
	 * 线程类控制刷新的时间
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
	 * 按键容器，处理按下按钮以及释放按钮的功能
	 * @author chen
	 *
	 */
	public class keyMonitor extends KeyAdapter
	{
		public void keyReleased(KeyEvent e) {
			//调用坦克类中释放按钮的功能
			tank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			//调用坦克类中按下按钮的功能
			tank.keyPress(e);
		}

	}

}








