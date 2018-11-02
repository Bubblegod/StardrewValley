package walking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 游戏主窗体
 * 
 *
 */
public class mainFrame extends JFrame implements gameConfig{
	//游戏面板
	JPanel panel;
	
	public mainFrame() {
		init();
		
	}
	/**
	 * 设置窗体
	 */
	public void init(){
		this.setTitle(title);
		this.setSize(frameX, frameY);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(3);
		//创建游戏面板
		panel = setpanel();
		
		this.add(panel);
		this.setVisible(true);
		//安装键盘监听器
		PanelListenner plis = new PanelListenner();
		this.addKeyListener(plis);
		
		//启动人物移动线程
		Player player = new Player();
		player.start();
		
		//启动刷新面板线程
		UpdateThread ut = new UpdateThread(panel);
		ut.start();
	}
	
	/**
	 * 设置游戏面板
	 */
	public JPanel setpanel(){
		JPanel panel = new MyPanel();
		panel.setPreferredSize(new Dimension(panelX, panelY));
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
		return panel;
	}
	
	/**
	 * 内部游戏按键监听类
	 * @author yy
	 *
	 */
	class PanelListenner extends KeyAdapter{
		//当按键按下
		public void keyPressed(KeyEvent e){
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_UP:
				Player.up = true;
				Player.towards = 1;
				break;
			case KeyEvent.VK_DOWN:
				Player.down = true;
				Player.towards = 2;
				break;
			case KeyEvent.VK_LEFT:
				Player.left = true;
				Player.towards = 3;
				break;
			case KeyEvent.VK_RIGHT:
				Player.right = true;
				Player.towards = 4;
				break;

			default:
				break;
			}
		}
		//当按键释放
		public void keyReleased(KeyEvent e){
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_UP:
				Player.up = false;
				Player.up1 = 0;
				break;
			case KeyEvent.VK_DOWN:
				Player.down = false;
				Player.down1 = 0;
				break;
			case KeyEvent.VK_LEFT:
				Player.left = false;
				Player.left1 = 0;
				break;
			case KeyEvent.VK_RIGHT:
				Player.right = false;
				Player.right1 = 0;
				break;

			default:
				break;
			}
		}
	}
	/**
	 * 自定义内部游戏面板类
	 * @author yy
	 *
	 */
	class MyPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//找到角色旁边的素材，上下左右各5格
			for(int i=Player.getI()-6;i<=Player.getI()+6;i++){
				for(int j=Player.getJ()-6;j<=Player.getJ()+6;j++){
					//如果这一格没有超界
					if(i>=0&&j>=0&&i<ReadMapFile.map1.length&&j<ReadMapFile.map1[0].length){
						//画第一层元素
						ImageIcon icon = GetMap.int2icon(ReadMapFile.map1[i][j]);
						g.drawImage(icon.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//第二层
						ImageIcon icon2 = GetMap.int2icon(ReadMapFile.map2[i][j]);
						g.drawImage(icon2.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//第三层
//						ImageIcon icon3 = GetMap.int2icon(ReadMapFile.map3[i][j]);
//						g.drawImage(icon3.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
					}
				}
			}
			Player.draw(g);
		}
	}
}
