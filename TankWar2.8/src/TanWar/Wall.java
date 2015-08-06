package TanWar;
import java.awt.*;
import java.util.Random;

/**
 * 该类是想墙的功能，实例化墙，并且画出墙，同时返回墙的Rectangle
 * @author chen
 *
 */
public class Wall {
	

	int x, y, w ,d;
	
	private TankClient tc;
	/**
	 * 实例化墙的x横坐标，y纵坐标，w宽度，d高度
	 * @param x
	 * @param y
	 * @param w
	 * @param d
	 * @param tc
	 */
	public Wall(int x, int y, int w, int d, TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.d = d;
		this.tc = tc;
	}
	
	/**
	 * 画出一堵墙
	 * @param g
	 */
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.CYAN);
		g.fillOval(x, y, w, d);
		g.setColor(c);
	}
	
	/**
	 * 返回墙这个的Rectangle
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, w, d);
	}
	

}
