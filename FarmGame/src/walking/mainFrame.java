package walking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ��Ϸ������
 * 
 *
 */
@SuppressWarnings("serial")
public class mainFrame extends JFrame implements gameConfig {
	// ��Ϸ���
	JPanel panel;

	public mainFrame() {
		init();

	}

	/**
	 * ���ô���
	 */
	public void init() {
		this.setTitle(title);
		this.setSize(frameX, frameY);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(3);
		// ������Ϸ���
		panel = setpanel();

		this.add(panel);
		this.setVisible(true);
		// ��װ���̼�����
		PanelListenner plis = new PanelListenner();
		this.addKeyListener(plis);

		// ���������ƶ��߳�
		People player = new People();
		player.start();
		NPC npc = new NPC();
		npc.start();
		// player2.start();

		// ����ˢ������߳�
		UpdateThread ut = new UpdateThread(panel);
		ut.start();
	}

	/**
	 * ������Ϸ���
	 */
	public JPanel setpanel() {
		JPanel panel = new MyPanel();
		panel.setPreferredSize(new Dimension(panelX, panelY));
		panel.setLayout(null);
		panel.setBackground(Color.black);
		panel.setBackground(Color.GRAY);

		return panel;
	}

	class PanelListenner extends KeyAdapter {
		// ����������
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_W:
				People.up = true;
				People.towards = 1;
				break;
			case KeyEvent.VK_S:
				People.down = true;
				People.towards = 2;
				break;
			case KeyEvent.VK_A:
				People.left = true;
				People.towards = 3;
				break;
			case KeyEvent.VK_D:
				People.right = true;
				People.towards = 4;
				break;
			case KeyEvent.VK_J:
				People.chop1 = true;
				break;
			case KeyEvent.VK_K:
				People.chop2 = true;
				break;
			case KeyEvent.VK_L:
				People.chop3= true;
			default:
				break;
			}
		}

		// �������ͷ�
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_W:
				People.up = false;
				People.up1 = 0;
				break;
			case KeyEvent.VK_S:
				People.down = false;
				People.down1 = 0;
				break;
			case KeyEvent.VK_A:
				People.left = false;
				People.left1 = 0;
				break;
			case KeyEvent.VK_D:
				People.right = false;
				People.right1 = 0;
				break;
			case KeyEvent.VK_J:
				People.chop1 = false;
				break;
			case KeyEvent.VK_K:
				People.chop2 = false;
				break;
			case KeyEvent.VK_L:
				People.chop3 = false;
			default:
				break;
			}
		}
	}

	class MyPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			// �ҵ���ɫ�Աߵ��زģ��������Ҹ�5��
			for (int i = People.getI() - 10; i <= People.getI() + 10; i++) {
				for (int j = People.getJ() - 10; j <= People.getJ() + 10; j++) {
					// �����һ��û�г���
					if (i >= 0 && j >= 0 && i < ReadMapFile.map1.length
							&& j < ReadMapFile.map1[0].length) {
						// ����һ��Ԫ��
						ImageIcon icon = GetMap.int2icon(ReadMapFile.map1[i][j]);
						g.drawImage(icon.getImage(), (People.px - elesize / 2)
								+ ((j - People.getJ()) * elesize)
								- (People.mx % elesize),
								(People.py - elesize / 2)
										+ ((i - People.getI()) * elesize)
										- (People.my % elesize), elesize,
								elesize, null);
						// �ڶ���
						// if(ReadMapFile.map2[i][j]!=105){
						ImageIcon icon2 = GetMap
								.int2icon(ReadMapFile.map2[i][j]);
						g.drawImage(icon2.getImage(), (People.px - elesize / 2)
								+ ((j - People.getJ()) * elesize)
								- (People.mx % elesize),
								(People.py - elesize / 2)
										+ ((i - People.getI()) * elesize)
										- (People.my % elesize), icon2
										.getImage().getWidth(getParent()),
								icon2.getImage().getHeight(getParent()), null);
						String temp;
						temp = i + " ";
						temp += j + "";
						g.drawString(temp, (People.px - elesize / 2)
								+ ((j - People.getJ()) * elesize)
								- (People.mx % elesize),
								(People.py - elesize / 2)
										+ ((i - People.getI()) * elesize)
										- (People.my % elesize));

					}
				}
			}
			int i = 7;
			int j = 25;
			ImageIcon icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px - elesize / 2)
					+ ((j - People.getJ()) * elesize) - (People.mx % elesize),
					(People.py - elesize / 2) + ((i - People.getI()) * elesize)
							- (People.my % elesize), 400, 200, null);

			i = 7;
			j = 15;
			icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px - elesize / 2)
					+ ((j - People.getJ()) * elesize) - (People.mx % elesize),
					(People.py - elesize / 2) + ((i - People.getI()) * elesize)
							- (People.my % elesize), 200, 200, null);

			i = 7;
			j = 38;
			icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px - elesize / 2)
					+ ((j - People.getJ()) * elesize) - (People.mx % elesize),
					(People.py - elesize / 2) + ((i - People.getI()) * elesize)
							- (People.my % elesize), 400, 200, null);

			i = 10;
			j = 59;
			icon = GetMap.int2icon(ReadMapFile.map2[i][j]);
			g.drawImage(icon.getImage(), (People.px - elesize / 2)
					+ ((j - People.getJ()) * elesize) - (People.mx % elesize),
					(People.py - elesize / 2) + ((i - People.getI()) * elesize)
							- (People.my % elesize), 100, 200, null);
			People.draw(g);
		}
	}
}
