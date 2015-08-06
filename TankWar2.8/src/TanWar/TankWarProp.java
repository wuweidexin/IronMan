package TanWar;
import java.util.Properties;
import java.io.IOException;
public class TankWarProp {
	static Properties pro = new Properties();
	static
	{
		/*
		 * 下面的语句实现运用配置文件，首先或得该类的class的目录，最后会得url从而拿到在config中的相关
		 * 信息，这里要学会怎么运用配置文件，还有就是怎样把代码高效运行，需要对相关内存等的有所理解
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
