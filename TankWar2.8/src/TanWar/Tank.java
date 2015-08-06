package TanWar;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Random;
import java.awt.Image;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

/**
 * 坦克类，画坦克，以及处理坦克的事件
 * @author chen
 *
 */

public class Tank 
{
	/**
	 * 指明坦克的X，Y方向的速度
	 */
	public static final int XSPEED = 5, YSPEED = 5;
	/**
	 * 坦克的宽高
	 */
	
	//四个方向，上、下、左、右
	private boolean bL = false, bU = false, bR = false, bD = false;
	//指明坦克的好坏
	private boolean good = false;
	//调用随机产生类
	private static Random r = new Random();
	//调用血块类
	private BloodBar br = new BloodBar();
	
	//随机生成敌人坦克行走的步数
	private int step = r.nextInt(13) + 2;
	//坦克出现的位置
	private int x, y;
	//坦克原来的位置，为坦克撞墙时用，坦克回到原来位置
	private int oldX,oldY;
	//坦克的生命值
	private int life = 100;
	/**
	 * 获取坦克的生命值
	 * @return life
	 */
	public int getLife() {
		return life;
	}
	/**
	 * 设置坦克的我军生命值
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}

	TankClient tc = null;
	//枚举左、左上、上、右上、右、右下、下、左下、停止这几个方向，也即坦克的8个方向
	private Direction dir = Direction.STOP;
	private Direction ptdir = Direction.D;	
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	private static Image[] imag = null;
	
	private static HashMap<String, Image> imags = new HashMap<String, Image>();
	/*
	 * 这种代码有种好处，在加载这个类的时候，下面的static的内容就能运行，放到内存中
	 */
	static
	{
		imag = new Image[]{
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankL.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankLU.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankU.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankRU.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankR.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankRD.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankD.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/tankLD.gif")),
		};
		imags.put("L", imag[0]);
		imags.put("LU", imag[1]);
		imags.put("U", imag[2]);
		imags.put("RU", imag[3]);
		imags.put("R", imag[4]);
		imags.put("RD", imag[5]);
		imags.put("D", imag[6]);
		imags.put("LD", imag[7]);
		
	};
	
	public static final int WIDTH = 30, HEIGHT = 30;
	//指明坦克是否活着
	private boolean live = true;

	/**
	 * 返回坦克是否活着，活着返回true，否则false
	 * @return
	 */
	public boolean isLive() {
		return live;
	}
	
	/**
	 * 返回坦克是否是好的，好的true，否则false
	 * @return
	 */
	public boolean isGood()
	{
		return good;
	}
	
	/**
	 * 设置坦克的生命，活着设为true，否者设为false
	 * @param live
	 */
	public void setLive(boolean live) {
		this.live = live;
	}
	
	/**
	 * 构造函数对坦克的参数实例化，x代表横轴，y代表纵轴，good代表坦克的好还
	 * @param x
	 * @param y
	 * @param good
	 */
	public Tank(int x, int y,  boolean good) {
		this.x = x;
		this.y = y;
		this.oldX = oldX;
		this.oldY = oldY;
		this.good = good;
	}
	
	/**
	 * 另外的一个构造函数，初始化x横轴,y纵轴,good好坏,dir方向,tc是TankClient的一个引用
	 */
	public Tank(int x, int y, boolean good, Direction dir, TankClient tc)
	{
		this(x, y, good);
		this.tc = tc;
		this.dir = dir;
	}
	
	/**
	 * 画坦克，炮筒以及决定方向
	 * @param g
	 */
	public void draw(Graphics g)
	{//draw the Tank
		
		//判断坦克是否活着，活着往下进行，不活着，并且不是我军，直接remove
		if(!live)
		{
			if(!good)
			{
				tc.tanks.remove(this);
			}
			return;
			
		}
		if(good) 
		{
			br.draw(g);
		}
		/*
		 * 画出子弹、爆炸、坦克、坦克生命值的数量
		 */
		g.drawString("Missile Count:  " + tc.mis.size(), 10, 50);
		g.drawString("Explode Count:  "+ tc.exp.size(), 10, 70);
		g.drawString("Tanks   Count:  "+ tc.tanks.size(), 10, 90);
		g.drawString("Tanks    Life:  "+ tc.tank.getLife(), 10, 110);
		
		//给炮筒画方向
		switch(ptdir)
		{
		case L:
			g.drawImage(imags.get("L"), x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case LU:
			g.drawImage(imags.get("LU"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case U:
			g.drawImage(imags.get("U"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case RU:
			g.drawImage(imags.get("RU"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case R:
			g.drawImage(imags.get("R"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case RD:
			g.drawImage(imags.get("RD"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case D:
			g.drawImage(imags.get("D"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		case LD:
			g.drawImage(imags.get("LD"),  x - WIDTH/2, y - HEIGHT/2, null);
			break;
		}
		if(this.dir != Direction.STOP)
		{
			this.ptdir = this.dir;
		}
		
		move();
		
	}
	/*
	 * move方法让坦克动起来
	 */
	void move()
	{//move the Tank
		oldX = x;
		oldY = y;
		switch(dir)
		{
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U:
			y -= YSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		case STOP:
			break;
		}
		/*
		 * 判断坦克是否出界，如果出界然听他回到原来的位置
		 */
		if(x < 0) x = 0;
		if(y <30) y = 30;
		if(x > TankClient.GAME_WIDTH - Tank.WIDTH) x = TankClient.GAME_WIDTH - Tank.WIDTH;
		if(y > TankClient.GAME_HEIGHT - Tank.HEIGHT) y = TankClient.GAME_HEIGHT - Tank.HEIGHT;
		/*
		 * 如果坦克是敌军，让他随机走几步后打随机的炮弹
		 */
		if(!good)
		{
			Direction[] dirs = Direction.values();
			if(step == 0)
			{
				step = r.nextInt(12) + 2;
				int rn = r.nextInt(dirs.length);
				dir = dirs[rn];
			}
			if(r.nextInt(30) + 3 > 30)
			{
				this.fire();
			}
			
			step --;
		}
	}
	/*
	 * 按下方向键从而使坦克进行运动，8个方向
	 */
	void locaction()
	{//locate the Tank
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if(bL && bU && !bR && !bD) dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && bU && bR && !bD) dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && bR && bD) dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(bL && !bU && !bR && bD) dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
	}
	/**
	 * 按下按钮的处理方法，返回事件e
	 * @param e
	 */
	public void keyPress(KeyEvent e)
	{// keyPress to control the Tank
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_F2:
			if(good)
			{
				if(!this.live)
				{
					this.live = true;
					this.life = 100;
				}
			}
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		
		}
		locaction();
	}

	/**
	 * 释放按钮的事件处理
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key)
		{
		//释放ctrl键打出炮弹
		case KeyEvent.VK_CONTROL:
			fire();
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_A:
			superFire();
			break;
		}
		locaction();
	}
	
	/**
	 * 该方法处理当坦克穿过墙的时候让他们的坐标回到原来的位置
	 */
	public void stay()
	{
		x = oldX;
		y = oldY;
	}
	
	/**
	 * 处理打击坦克的方法，让子弹打击坦克，返回炮弹的类型
	 * @return
	 */
	public Missile fire()
	{
		if(!live)
		{
			return null;
		}
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, good, ptdir, tc);
		tc.mis.add(m);
		return m;
	}

	/**
	 * 超级炮弹的fire方法，传入方向，将向该方向发出炮弹
	 * @param dir
	 * @return
	 */
	public Missile fire(Direction dir)
	{
		if(!live)
		{
			return null;
		}
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, good, dir, tc);
		tc.mis.add(m);
		return m;
	}
	
	/**
	 * 返回坦克的rectangle 方法，返回x,y,WIDTH,HEIGHT
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	/**
	 * 该方法实现与墙相撞的问题，如果坦克还活着，并且与墙相交，让他回到
	 * 原来的位置，w为Wall类型的参数，相撞返回true，否则返回false
	 * @param w
	 * @return
	 */
	public boolean collidesWithWall(Wall w)
	{
		if(this.live && this.getRect().intersects(w.getRect()))
		{
			stay();
			return true;
		}
		return false;
	}
	/**
	 * 该方法解决坦克之间的互相穿越问题，针对敌军，如果他们的Rectangle相交，让他们回到原来位置,
	 * 如果相交返回true，否则返回false
	 * @param tanks
	 * @return
	 */
	public boolean collidesWithTanks(java.util.List<Tank> tanks)
	{
		for(int i = 0; i < tanks.size(); i ++)
		{
			Tank t = tanks.get(i);
			if(this != t)
			{
				if(this.live && t.isLive() && this.getRect().intersects(t.getRect()))
				{
					stay();
					return true;
				}
			}
			
		}
		return false;
	}
	
	/**
	 * 该方法解决坦克之间的互相穿越问题，针对我军和敌军之间，如果他们的Rectangle相交，让他们回到原来位置,
	 * 如果相交返回true，否则返回false
	 * @param tanks
	 * @return
	 */
	public boolean collidesWithTank(java.util.List<Tank> tanks)
	{
		for(int i = 0; i < tanks.size(); i ++)
		{
			Tank t = tanks.get(i);
			if(this != t)
			{
				if(this.live && t.isLive() && this.getRect().intersects(t.getRect()))
				{
					stay();
					return true;
				}
			}
			
		}
		return false;
	}
	
	/**
	 * 超级炮弹的处理方法，按下A后能发出八个方向的炮弹
	 */
	public void superFire()
	{
		Direction[] dirs = Direction.values();
		for(int i = 0; i< 8; i ++)
		{
			fire(dirs[i]);
		}
	}
	
	/**
	 * 该方法实现吃血块的功能，吃掉返回true，否则返回false
	 * @param b
	 * @return
	 */
	public boolean eatBlood(Blood b) {

		if(this.getRect().intersects(b.getRect()))
		{
			b.setLive(false);
			this.life = 100;
			return true;
		}
		return false;
	}
	
	/*
	 * 这个方法画出血条
	 */
	private class BloodBar
	{
		public void draw(Graphics g)
		{
			int w = (WIDTH + 50) * life/100;
			Color c = g.getColor();
			g.drawString("TankLive:  ", 650, 40);
			g.setColor(Color.YELLOW);
			g.drawRect(700, 30, WIDTH + 50, 10 );
			
			g.fillRect(700, 30, w, 10);
			g.setColor(c);
		}
	}
	
	
}
