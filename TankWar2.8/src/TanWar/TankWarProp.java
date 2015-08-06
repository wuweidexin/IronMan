package TanWar;
import java.util.Properties;
import java.io.IOException;
public class TankWarProp {
	static Properties pro = new Properties();
	static
	{
		/*
		 * ��������ʵ�����������ļ������Ȼ�ø����class��Ŀ¼�������url�Ӷ��õ���config�е����
		 * ��Ϣ������Ҫѧ����ô���������ļ������о��������Ѵ����Ч���У���Ҫ������ڴ�ȵ��������
		 * 
		 */
		try {
			pro.load(TankWarProp.class.getClassLoader().getResourceAsStream("config/tank.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	private TankWarProp(){
		
	}
	public static String getProperty(String key)
	{
		return pro.getProperty(key);
	}
}
