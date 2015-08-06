package TanWar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * 该类提供爆炸，当坦克被炮弹撞击到的时候就会发生爆炸
 * @author chen
 *
 */
public class Explode {
	//x,y分别是横纵轴
	private int x,y;
	//step反应爆炸到第几部
	private int step = 0;
	
	private static boolean init = false;
	//live反应爆炸是否活着
	private boolean live = true;
	//一维数组存储爆炸的半径
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	private static Image[] img = {
		tk.getImage(Explode.class.getClassLoader().getResource("Images/0.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/2.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/3.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/4.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/5.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/6.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/7.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/8.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/9.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("Images/10.gif")),
	};
	//TankClient的索引
	TankClient tc;
	/**
	 * 构造方法，实例化横轴，纵轴以及TankClient的索引
	 * 参数 ：x 横轴
	 *       y 纵轴
	 *       tc TankClient的索引
	 * @param x
	 * @param y
	 * @param tc
	 */
	public Explode(int x, int y, TankClient tc)
	{
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	/**
	 * 提供画爆炸过程的方法
	 * @param g
	 */
	public void draw(Graphics g)
	{
		if(!init)
		{
			for (int j = 0; j < img.length; j++) {
				g.drawImage(img[j], -100, -100, null);
			}
			init = true;
		}
		//如果爆炸结束了把他清除
		if(!live)
		{
			tc.exp.remove(this);
			return;
		}
		//如果爆炸的步数等于一维数组的长度，把他从新置零，生命去掉
		if(step == img.length)
		{
			live = false;
			step = 0;
			return;
		}
		g.drawImage(img[step], x, y, null);
		step ++;
	}
}
