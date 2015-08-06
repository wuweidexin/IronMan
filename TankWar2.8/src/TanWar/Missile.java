package TanWar;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * 该类实现炮弹的相关方法
 * @author chen
 *
 */
public class Missile {
	
	/**
	 * 定义炮弹的宽度
	 */
	public static final int WIDTH = 10, HEIGHT = 10;
	/**
	 * 定义炮弹的高度
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
	 * 返回 炮弹的Rectangle
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	/**
	 * 返回炮弹是否活着，活着返回true，否则返回false
	 * @return
	 */
	public boolean isLive() {
		return live;
	}
	/**
	 * 构造函数，实例化x，y以及Tank.Direction
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
	 * 另外的一个构造函数，实例化对象，x，y代表横轴和纵轴，good代表
	 * 好坏，dir代表坦克的方向，tc代表TankClient的一个引用
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
	 * 该方法是，画出炮弹，如果坦克是我军的，炮弹的颜色是黄色
	 * 如果是敌军炮弹是黑色
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
	 * 该方法是实现炮弹移动的问题
	 * xspeed和yspeed分别代表两个轴的速度
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
	 * 该方法实现，打击坦克的方法，如果坦克被打中，这个坦克消失，并且返回true
	 * 否则返回false
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
	 * 该方法实现敌方坦克被炮弹打的问题，如果敌方坦克被打中返回true，否则返回false,
	 * 参数是List类型的坦克
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
	 * 撞击墙，实现坦克无法穿越墙，如果坦克撞击到墙返回true，否则返回false
	 * 参数：Wall 是要撞击的墙
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
