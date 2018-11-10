package walking;

import javax.swing.ImageIcon;

/**
 * 游戏配置接口
 * 
 *
 */
public interface gameConfig {
	//游戏主窗体名字
	String title = "场景移动小游戏";
	//游戏主窗体的大小
	int frameX = 700;
	int frameY = 700;
	//游戏面板大小
	int panelX = 650;
	int panelY = 650;
	//游戏素材大小
	int elesize = 50;
	//人物大小
	int playersize = 50;
	//------------[游戏素材]----------
	//-----第一层
	ImageIcon icon0 = new ImageIcon(test.class.getResource("000空白.png"));
	ImageIcon icon1 = new ImageIcon(test.class.getResource("001草地.png"));
	ImageIcon icon2 = new ImageIcon(test.class.getResource("002地砖.png"));
	ImageIcon icon3 = new ImageIcon(test.class.getResource("003召泽地板副本.png"));
	ImageIcon icon4 = new ImageIcon(test.class.getResource("004sea.png"));
	ImageIcon icon5 = new ImageIcon(test.class.getResource("005mud.png"));
	ImageIcon icon101 = new ImageIcon(test.class.getResource("101绿树.png"));
	ImageIcon icon102 = new ImageIcon(test.class.getResource("102绿竹.png"));
	ImageIcon icon103 = new ImageIcon(test.class.getResource("103高绿树.png"));
	ImageIcon icon105 = new ImageIcon(test.class.getResource("105house.png"));
	ImageIcon icon106 = new ImageIcon(test.class.getResource("106volcano.png"));
	ImageIcon icon107 = new ImageIcon(test.class.getResource("107barn.png"));
	ImageIcon icon108 = new ImageIcon(test.class.getResource("108slime.png"));
	ImageIcon icon150 = new ImageIcon(test.class.getResource("150岩浆.png"));
	ImageIcon icon200 = new ImageIcon(test.class.getResource("200grass.png"));
	ImageIcon icon999 = new ImageIcon(test.class.getResource("000空白.png"));
	
	//角色行走图
	ImageIcon walk = new ImageIcon(test.class.getResource("角色行走图.png"));
	ImageIcon walk1 = new ImageIcon(test.class.getResource("角色停顿图.png"));
}
