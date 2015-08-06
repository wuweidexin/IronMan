package TanWar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * �����ṩ��ը����̹�˱��ڵ�ײ������ʱ��ͻᷢ����ը
 * @author chen
 *
 */
public class Explode {
	//x,y�ֱ��Ǻ�����
	private int x,y;
	//step��Ӧ��ը���ڼ���
	private int step = 0;
	
	private static boolean init = false;
	//live��Ӧ��ը�Ƿ����
	private boolean live = true;
	//һά����洢��ը�İ뾶
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
	//TankClient������
	TankClient tc;
	/**
	 * ���췽����ʵ�������ᣬ�����Լ�TankClient������
	 * ���� ��x ����
	 *       y ����
	 *       tc TankClient������
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
	 * �ṩ����ը���̵ķ���
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
		//�����ը�����˰������
		if(!live)
		{
			tc.exp.remove(this);
			return;
		}
		//�����ը�Ĳ�������һά����ĳ��ȣ������������㣬����ȥ��
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
