package walking;

import javax.swing.ImageIcon;

/**
 * ��Ϸ���ýӿ�
 * 
 *
 */
public interface gameConfig {
	//��Ϸ����������
	String title = "�����ƶ�С��Ϸ";
	//��Ϸ������Ĵ�С
	int frameX = 700;
	int frameY = 700;
	//��Ϸ����С
	int panelX = 650;
	int panelY = 650;
	//��Ϸ�زĴ�С
	int elesize = 50;
	//�����С
	int playersize = 50;
	//------------[��Ϸ�ز�]----------
	//-----��һ��
	ImageIcon icon0 = new ImageIcon(test.class.getResource("000�հ�.png"));
	ImageIcon icon1 = new ImageIcon(test.class.getResource("001�ݵ�.png"));
	ImageIcon icon2 = new ImageIcon(test.class.getResource("002��ש.png"));
	ImageIcon icon3 = new ImageIcon(test.class.getResource("003����ذ帱��.png"));
	ImageIcon icon4 = new ImageIcon(test.class.getResource("004sea.png"));
	ImageIcon icon5 = new ImageIcon(test.class.getResource("005mud.png"));
	ImageIcon icon101 = new ImageIcon(test.class.getResource("101����.png"));
	ImageIcon icon102 = new ImageIcon(test.class.getResource("102����.png"));
	ImageIcon icon103 = new ImageIcon(test.class.getResource("103������.png"));
	ImageIcon icon105 = new ImageIcon(test.class.getResource("105house.png"));
	ImageIcon icon106 = new ImageIcon(test.class.getResource("106volcano.png"));
	ImageIcon icon107 = new ImageIcon(test.class.getResource("107barn.png"));
	ImageIcon icon108 = new ImageIcon(test.class.getResource("108slime.png"));
	ImageIcon icon150 = new ImageIcon(test.class.getResource("150�ҽ�.png"));
	ImageIcon icon200 = new ImageIcon(test.class.getResource("200grass.png"));
	ImageIcon icon999 = new ImageIcon(test.class.getResource("000�հ�.png"));
	
	//��ɫ����ͼ
	ImageIcon walk = new ImageIcon(test.class.getResource("��ɫ����ͼ.png"));
	ImageIcon walk1 = new ImageIcon(test.class.getResource("��ɫͣ��ͼ.png"));
}
