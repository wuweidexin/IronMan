package TanWar;
import java.awt.*;
/**
 * 该类实现血块，当坦克吃了血块后就能得到血量的补充
 * @author chen
 *
 */
public class Blood {
	//x,y代表血块的位置
	int x, y;
	//w，d代表血块的大小
	int w = 15,d =15;
	//血块是否活着（被吃掉）
	private boolean live = true;
	//血块出现的位置的控制量
	private int step = 0;
	//TankClient索引
	TankClient tc;
	//二位数组存储血块出现的位置
	private int[][] pos = {
			{200,310}, {250,350}, {300,200}, {350,300}, {400,400}, {200, 310}
	};
	/**
	 * 提供画出血块
	 * @param g
	 */
	public void draw(Graphics g)
	{
		if(!live)return;
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, w, d);
		g.setColor(c);
		
		move();
	}
	/**
	 * 返回血块是否活着这个量
	 * @return
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * 该方法提供设置血块是否活着
	 * @param live
	 */
	public void setLive(boolean live) {
		this.live = live;
	}
	/*
	 * 提供血块的轨迹，即血块出现的位置
	 */
	private void move() {
		step ++;
		if(step >= pos.length)
		{
			step = 0;
		}
		else
		{
			x = pos[step][0];
			y = pos[step][1];
		}
		
		
	}
	/*
	 * 返回血块的Rectangle
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, w, d);
	}
}
