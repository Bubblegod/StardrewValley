package walking;
/**
 * 开始游戏
 * 
 *
 */
public class test {
	public static void main(String[] args) {
		//首先从地图文件中读入地图数组
		ReadMapFile.readfile();
		//用读到的地图数组创建游戏窗体，开始游戏
		new mainFrame();
	}
}
