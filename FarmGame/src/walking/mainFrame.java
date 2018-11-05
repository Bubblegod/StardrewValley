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
		People player = new People();
		player.start();
		NPC npc = new NPC();
		npc.start();
		//player2.start();
		
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
		panel.setBackground(Color.GRAY);
		
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
				People.up = true;
				People.towards = 1;
				break;
			case KeyEvent.VK_DOWN:
				People.down = true;
				People.towards = 2;
				break;
			case KeyEvent.VK_LEFT:
				People.left = true;
				People.towards = 3;
				break;
			case KeyEvent.VK_RIGHT:
				People.right = true;
				People.towards = 4;
				break;
			case KeyEvent.VK_J:
				People.chop1 = true;
				break;
			case KeyEvent.VK_K:
				People.chop2 = true;
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
				People.up = false;
				People.up1 = 0;
				break;
			case KeyEvent.VK_DOWN:
				People.down = false;
				People.down1 = 0;
				break;
			case KeyEvent.VK_LEFT:
				People.left = false;
				People.left1 = 0;
				break;
			case KeyEvent.VK_RIGHT:
				People.right = false;
				People.right1 = 0;
				break;
			case KeyEvent.VK_J:
				People.chop1 = false;
				break;
			case KeyEvent.VK_K:
				People.chop2 = false;
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
			for(int i=People.getI()-10;i<=People.getI()+10;i++){
				for(int j=People.getJ()-10;j<=People.getJ()+10;j++){
					//如果这一格没有超界
					if(i>=0&&j>=0&&i<ReadMapFile.map1.length&&j<ReadMapFile.map1[0].length){
						//画第一层元素
						ImageIcon icon = GetMap.int2icon(ReadMapFile.map1[i][j]);
						g.drawImage(icon.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), elesize, elesize, null);
						//第二层
						//if(ReadMapFile.map2[i][j]!=105){
						ImageIcon icon2 = GetMap.int2icon(ReadMapFile.map2[i][j]);
						g.drawImage(icon2.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), icon2.getImage().getWidth(getParent()),  icon2.getImage().getHeight(getParent()), null);
						String temp;
						temp=i+" ";
						temp+=j+"";
						g.drawString(temp, (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize));
						
						//第三层
//						ImageIcon icon3 = GetMap.int2icon(ReadMapFile.map3[i][j]);
//						g.drawImage(icon3.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), elesize, elesize, null);
					}
				}
			}
			int i=7;int j=25;
			ImageIcon icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), 400, 200, null);
			
			i=7;j=15;
			icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), 200, 200, null);
			
			i=7;j=38;
			icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), 400, 200, null);
			
			i=10;j=59;
			icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px-elesize/2)+((j-People.getJ())*elesize)-(People.mx%elesize), (People.py-elesize/2)+((i-People.getI())*elesize)-(People.my%elesize), 100, 200, null);
			People.draw(g);
		}
	}
}
