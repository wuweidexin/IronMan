package TanWar;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * ����ʵ���ڵ�����ط���
 * @author chen
 *
 */
public class Missile {
	
	/**
	 * �����ڵ��Ŀ��
	 */
	public static final int WIDTH = 10, HEIGHT = 10;
	/**
	 * �����ڵ��ĸ߶�
	 */
	public static final int XSPEED = 10, YSPEED = 10;
	private boolean bL = false, bU = false, bR = false, bD = false;
	
	
	private int x,y;
	Direction ptdir ;
	private TankClient tc;
	private Tank ta;
	private boolean live = true;
	
	private boolean good;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	private static Image[] missileImage = null;
	
	private static HashMap<String, Image> imags = new HashMap<String, Image>();
	static
	{
		missileImage = new Image[]{
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileL.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileLU.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileU.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileRU.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileR.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileRD.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileD.gif")),
			tk.getImage(Explode.class.getClassLoader().getResource("Images/missileLD.gif")),
		};
		imags.put("L", missileImage[0]);
		imags.put("LU", missileImage[1]);
		imags.put("U", missileImage[2]);
		imags.put("RU", missileImage[3]);
		imags.put("R", missileImage[4]);
		imags.put("RD", missileImage[5]);
		imags.put("D", missileImage[6]);
		imags.put("LD", missileImage[7]);
		
	};
	
	
	/**
	 * ���� �ڵ���Rectangle
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	/**
	 * �����ڵ��Ƿ���ţ����ŷ���true�����򷵻�false
	 * @return
	 */
	public boolean isLive() {
		return live;
	}
	/**
	 * ���캯����ʵ����x��y�Լ�Tank.Direction
	 * @param x
	 * @param y
	 * @param dir
	 */
	public Missile(int x, int y, Direction ptdir) {
		this.x = x;
		this.y = y;
		this.ptdir = ptdir;
	}
	/**
	 * �����һ�����캯����ʵ��������x��y�����������ᣬgood����
	 * �û���dir����̹�˵ķ���tc����TankClient��һ������
	 * @param x
	 * @param y
	 * @param good
	 * @param dir
	 * @param tc
	 */
	public Missile(int x, int y, boolean good, Direction dir, TankClient tc)
	{
		
		this(x, y, dir);
		this.good = good;
		this.tc =tc;
	}
	
	/**
	 * �÷����ǣ������ڵ������̹�����Ҿ��ģ��ڵ�����ɫ�ǻ�ɫ
	 * ����ǵо��ڵ��Ǻ�ɫ
	 * @param g
	 */
	public void draw(Graphics g)
	{
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
		move();
	}
	
	/*
	 * �÷�����ʵ���ڵ��ƶ�������
	 * xspeed��yspeed�ֱ������������ٶ�
	 */
	private void move() {
		// TODO Auto-generated method stub
		if(!live)
		{
			tc.mis.remove(this);
		}
		switch(ptdir)
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
		}
		
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT)
		{
			live = false;
		}
	}
	/**
	 * �÷���ʵ�֣����̹�˵ķ��������̹�˱����У����̹����ʧ�����ҷ���true
	 * ���򷵻�false
	 * @param t
	 * @return
	 */
	public boolean hitTank(Tank t)
	{
		if(this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood())
		{
			if(t.isGood())
			{
				t.setLife(t.getLife() - 20);
				if(t.getLife() <= 0)
				{
					t.setLive(false);
				    
				}
			}
			else
			{
				t.setLive(false);
			}
			this.live  = false;
		    if(!live)
		    {
		    	Explode exp = new Explode(x, y, tc);
		    	tc.exp.add(exp);
		    }
			return true;
		}
		return false;
	}
	
	/**
	 * �÷���ʵ�ֵз�̹�˱��ڵ�������⣬����з�̹�˱����з���true�����򷵻�false,
	 * ������List���͵�̹��
	 * @param t
	 * @return
	 */
	public boolean hitTanks(List <Tank> t)
	{
		for(int i = 0; i < t.size(); i ++)
		{
			if(hitTank(t.get(i)))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ײ��ǽ��ʵ��̹���޷���Խǽ�����̹��ײ����ǽ����true�����򷵻�false
	 * ������Wall ��Ҫײ����ǽ
	 * @param w
	 * @return
	 */
	public boolean hitWall(Wall w)
	{
		if(this.getRect().intersects(w.getRect()))
		{
			live = false;
			return true;
		}
		return false;
	}
}
