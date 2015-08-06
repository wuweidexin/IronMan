package TanWar;
import java.awt.*;
/**
 * ����ʵ��Ѫ�飬��̹�˳���Ѫ�����ܵõ�Ѫ���Ĳ���
 * @author chen
 *
 */
public class Blood {
	//x,y����Ѫ���λ��
	int x, y;
	//w��d����Ѫ��Ĵ�С
	int w = 15,d =15;
	//Ѫ���Ƿ���ţ����Ե���
	private boolean live = true;
	//Ѫ����ֵ�λ�õĿ�����
	private int step = 0;
	//TankClient����
	TankClient tc;
	//��λ����洢Ѫ����ֵ�λ��
	private int[][] pos = {
			{200,310}, {250,350}, {300,200}, {350,300}, {400,400}, {200, 310}
	};
	/**
	 * �ṩ����Ѫ��
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
	 * ����Ѫ���Ƿ���������
	 * @return
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * �÷����ṩ����Ѫ���Ƿ����
	 * @param live
	 */
	public void setLive(boolean live) {
		this.live = live;
	}
	/*
	 * �ṩѪ��Ĺ켣����Ѫ����ֵ�λ��
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
	 * ����Ѫ���Rectangle
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x, y, w, d);
	}
}
