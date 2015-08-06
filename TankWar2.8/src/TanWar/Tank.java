package TanWar;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Random;
import java.awt.Image;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

/**
 * ̹���࣬��̹�ˣ��Լ�����̹�˵��¼�
 * @author chen
 *
 */

public class Tank 
{
	/**
	 * ָ��̹�˵�X��Y������ٶ�
	 */
	public static final int XSPEED = 5, YSPEED = 5;
	/**
	 * ̹�˵Ŀ��
	 */
	
	//�ĸ������ϡ��¡�����
	private boolean bL = false, bU = false, bR = false, bD = false;
	//ָ��̹�˵ĺû�
	private boolean good = false;
	//�������������
	private static Random r = new Random();
	//����Ѫ����
	private BloodBar br = new BloodBar();
	
	//������ɵ���̹�����ߵĲ���
	private int step = r.nextInt(13) + 2;
	//̹�˳��ֵ�λ��
	private int x, y;
	//̹��ԭ����λ�ã�Ϊ̹��ײǽʱ�ã�̹�˻ص�ԭ��λ��
	private int oldX,oldY;
	//̹�˵�����ֵ
	private int life = 100;
	/**
	 * ��ȡ̹�˵�����ֵ
	 * @return life
	 */
	public int getLife() {
		return life;
	}
	/**
	 * ����̹�˵��Ҿ�����ֵ
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}

	TankClient tc = null;
	//ö�������ϡ��ϡ����ϡ��ҡ����¡��¡����¡�ֹͣ�⼸������Ҳ��̹�˵�8������
	private Direction dir = Direction.STOP;
	private Direction ptdir = Direction.D;	
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	private static Image[] imag = null;
	
	private static HashMap<String, Image> imags = new HashMap<String, Image>();
	/*
	 * ���ִ������ֺô����ڼ���������ʱ�������static�����ݾ������У��ŵ��ڴ���
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
	//ָ��̹���Ƿ����
	private boolean live = true;

	/**
	 * ����̹���Ƿ���ţ����ŷ���true������false
	 * @return
	 */
	public boolean isLive() {
		return live;
	}
	
	/**
	 * ����̹���Ƿ��Ǻõģ��õ�true������false
	 * @return
	 */
	public boolean isGood()
	{
		return good;
	}
	
	/**
	 * ����̹�˵�������������Ϊtrue��������Ϊfalse
	 * @param live
	 */
	public void setLive(boolean live) {
		this.live = live;
	}
	
	/**
	 * ���캯����̹�˵Ĳ���ʵ������x������ᣬy�������ᣬgood����̹�˵ĺû�
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
	 * �����һ�����캯������ʼ��x����,y����,good�û�,dir����,tc��TankClient��һ������
	 */
	public Tank(int x, int y, boolean good, Direction dir, TankClient tc)
	{
		this(x, y, good);
		this.tc = tc;
		this.dir = dir;
	}
	
	/**
	 * ��̹�ˣ���Ͳ�Լ���������
	 * @param g
	 */
	public void draw(Graphics g)
	{//draw the Tank
		
		//�ж�̹���Ƿ���ţ��������½��У������ţ����Ҳ����Ҿ���ֱ��remove
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
		 * �����ӵ�����ը��̹�ˡ�̹������ֵ������
		 */
		g.drawString("Missile Count:  " + tc.mis.size(), 10, 50);
		g.drawString("Explode Count:  "+ tc.exp.size(), 10, 70);
		g.drawString("Tanks   Count:  "+ tc.tanks.size(), 10, 90);
		g.drawString("Tanks    Life:  "+ tc.tank.getLife(), 10, 110);
		
		//����Ͳ������
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
	 * move������̹�˶�����
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
		 * �ж�̹���Ƿ���磬�������Ȼ�����ص�ԭ����λ��
		 */
		if(x < 0) x = 0;
		if(y <30) y = 30;
		if(x > TankClient.GAME_WIDTH - Tank.WIDTH) x = TankClient.GAME_WIDTH - Tank.WIDTH;
		if(y > TankClient.GAME_HEIGHT - Tank.HEIGHT) y = TankClient.GAME_HEIGHT - Tank.HEIGHT;
		/*
		 * ���̹���ǵо�����������߼������������ڵ�
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
	 * ���·�����Ӷ�ʹ̹�˽����˶���8������
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
	 * ���°�ť�Ĵ������������¼�e
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
	 * �ͷŰ�ť���¼�����
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key)
		{
		//�ͷ�ctrl������ڵ�
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
	 * �÷�������̹�˴���ǽ��ʱ�������ǵ�����ص�ԭ����λ��
	 */
	public void stay()
	{
		x = oldX;
		y = oldY;
	}
	
	/**
	 * ������̹�˵ķ��������ӵ����̹�ˣ������ڵ�������
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
	 * �����ڵ���fire���������뷽�򣬽���÷��򷢳��ڵ�
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
	 * ����̹�˵�rectangle ����������x,y,WIDTH,HEIGHT
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	/**
	 * �÷���ʵ����ǽ��ײ�����⣬���̹�˻����ţ�������ǽ�ཻ�������ص�
	 * ԭ����λ�ã�wΪWall���͵Ĳ�������ײ����true�����򷵻�false
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
	 * �÷������̹��֮��Ļ��ഩԽ���⣬��Եо���������ǵ�Rectangle�ཻ�������ǻص�ԭ��λ��,
	 * ����ཻ����true�����򷵻�false
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
	 * �÷������̹��֮��Ļ��ഩԽ���⣬����Ҿ��͵о�֮�䣬������ǵ�Rectangle�ཻ�������ǻص�ԭ��λ��,
	 * ����ཻ����true�����򷵻�false
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
	 * �����ڵ��Ĵ�����������A���ܷ����˸�������ڵ�
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
	 * �÷���ʵ�ֳ�Ѫ��Ĺ��ܣ��Ե�����true�����򷵻�false
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
	 * �����������Ѫ��
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
