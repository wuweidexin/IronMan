package TanWar;
import java.awt.*;
import java.util.Random;

/**
 * ��������ǽ�Ĺ��ܣ�ʵ����ǽ�����һ���ǽ��ͬʱ����ǽ��Rectangle
 * @author chen
 *
 */
public class Wall {
	

	int x, y, w ,d;
	
	private TankClient tc;
	/**
	 * ʵ����ǽ��x�����꣬y�����꣬w��ȣ�d�߶�
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
	 * ����һ��ǽ
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
	 * ����ǽ�����Rectangle
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, w, d);
	}
	

}
