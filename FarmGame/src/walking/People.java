package walking;

import java.awt.Graphics;

/**
 * 角色类
 *
 *
 */
public class People extends Thread implements gameConfig {
	// 角色中点相对游戏面板的位置(在游戏中是不变的)
	static int px = panelX / 2;
	static int py = panelY / 2;
	// 角色中点在整张地图中的位置(设置人最开始中点的位置一定要是一个元素中心的位置，要不然这种移动就会出问题 - -！)
	static int x = 375;
	static int y = 375;
	// 角色的偏移量（实现像素点移动关键的部分,一定要给个初始值，要不然到边界出现负数）
	static int mx = 50;
	static int my = 50;
	// 角色的步长
	static int step = 5;
	// 角色是否移动
	static boolean up = false;
	static boolean down = false;
	static boolean left = false;
	static boolean right = false;
	// 角色的朝向 1,2,3,4分别代表上下左右(用来处理角色不移动时的朝向问题，后面要写与npc对话之类的估计用得上)
	static int towards = 2;
	// 角色的移动累积量（这个就是用来控制循环的变化4张角色图片来达成动态移动的）
	static int up1 = 0;
	static int down1 = 0;
	static int left1 = 0;
	static int right1 = 0;
	// 砍树
	static boolean chop1 = false;
	static boolean chop2 = false;
	static boolean chop3 = false;

	@Override
	public void run() {
		while (true) {
			moveUD();
			moveLR();
			if (chop1 == true || chop2 == true || chop3 == true)
				cut_down_the_tree();
			try {
				Thread.sleep(11);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 砍树
	public void cut_down_the_tree() {
		int tree_x = 0, tree_y = 0;
		// 向上
		if (towards == 1) {
			tree_x = y / elesize - 1;
			tree_y = x / elesize;
		} else if (towards == 2) {
			tree_x = y / elesize + 1;
			tree_y = x / elesize;
		} else if (towards == 3) {
			tree_x = y / elesize;
			tree_y = x / elesize - 1;
		} else if (towards == 4) {
			tree_x = y / elesize;
			tree_y = x / elesize + 1;
		}
		if ((ReadMapFile.map2[tree_x][tree_y] == 200 ||ReadMapFile.map2[tree_x][tree_y] >= 100 && ReadMapFile.map2[tree_x][tree_y] <= 103) && chop1) {
			ReadMapFile.map2[tree_x][tree_y] = 0;
		} else if (ReadMapFile.map1[tree_x][tree_y] == 1 && chop2 && ReadMapFile.map2[tree_x][tree_y] == 0) {
			ReadMapFile.map1[tree_x][tree_y] = 5;
			ReadMapFile.map2[tree_x][tree_y] = 0;
		} else if (ReadMapFile.map1[tree_x][tree_y] == 5 && chop3) {
			//int newx = tree_x, newy = tree_y;
			//growTime gt = new growTime();
			//gt.start();
			//if (growTime.flag == 2) {
				ReadMapFile.map2[tree_x][tree_y] = 103;
				ReadMapFile.map1[tree_x][tree_y] = 1;
			//	growTime.flag = 0;
			//}
		}
	}

	/**
	 * 角色上下移动的方法
	 */
	public void moveUD() {
		if (up) {
			// 当按住上键时，给up1加1，当up1大于20时候又置为0，达成循环
			up1++;
			if (up1 >= 20) {
				up1 = 0;
			}
			// 如果角色当前位置上方的数组值不为0（角色上方有物体挡着）：这里处理的是角色一个格子内部的移动，不能移动到上面一格
			if (ReadMapFile.map2[y / elesize - 1][x / elesize] != 0
					&& ReadMapFile.map2[y / elesize - 1][x / elesize] != 200) {
				int y1 = (y / elesize - 1) * elesize + elesize / 2;
				if ((y - y1) * (y - y1) >= elesize * elesize) {
					y = y - step;
					my = my - step;
				}
			} else if (ReadMapFile.map2[y / elesize - 1][x / elesize] == 0
					|| ReadMapFile.map2[y / elesize - 1][x / elesize] == 200) {// 上方没物体，可以继续向上移动
				y = y - step;
				my = my - step;
			}
		} else if (down) {
			down1++;
			if (down1 >= 20) {
				down1 = 0;
			}
			if (ReadMapFile.map2[y / elesize + 1][x / elesize] != 0
					&& ReadMapFile.map2[y / elesize + 1][x / elesize] != 200) {
				int y1 = (y / elesize + 1) * elesize + elesize / 2;
				if ((y - y1) * (y - y1) >= elesize * elesize) {
					y = y + step;
					my = my + step;
				}
			} else if (ReadMapFile.map2[y / elesize + 1][x / elesize] == 0
					|| ReadMapFile.map2[y / elesize + 1][x / elesize] == 200) {
				y = y + step;
				my = my + step;
			}
		}
	}

	/**
	 * 角色左右移动的方法
	 */
	public void moveLR() {
		if (left) {
			left1++;
			if (left1 >= 20) {
				left1 = 0;
			}
			if (ReadMapFile.map2[y / elesize][x / elesize - 1] != 0
					&& ReadMapFile.map2[y / elesize][x / elesize - 1] != 200) {
				int x1 = (x / elesize - 1) * elesize + elesize / 2;
				if ((x - x1) * (x - x1) >= elesize * elesize) {
					x = x - step;
					mx = mx - step;
				}
			} else if (ReadMapFile.map2[y / elesize][x / elesize - 1] == 0
					|| ReadMapFile.map2[y / elesize][x / elesize - 1] == 200) {
				x = x - step;
				mx = mx - step;
			}
		} else if (right) {
			right1++;
			if (right1 >= 20) {
				right1 = 0;
			}
			if (ReadMapFile.map2[y / elesize][x / elesize + 1] != 0
					&& ReadMapFile.map2[y / elesize][x / elesize + 1] != 200) {
				int x1 = (x / elesize + 1) * elesize + elesize / 2;
				if ((x - x1) * (x - x1) >= elesize * elesize) {
					x = x + step;
					mx = mx + step;
				}
			} else if (ReadMapFile.map2[y / elesize][x / elesize + 1] == 0
					|| ReadMapFile.map2[y / elesize][x / elesize + 1] == 200) {
				x = x + step;
				mx = mx + step;
			}
		}
	}

	public static void draw(Graphics g) {
		// 如果角色不在移动中
		if (!up && !down && !left && !right) {
			if (towards == 1) {// 如果角色移动的最后朝向为上
				g.drawImage(walk1.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
						People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 96 * 3, 96, 96 * 4, null);
			} else if (towards == 2) {// 最后移动朝向下
				g.drawImage(walk1.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
						People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 0, 96, 96, null);
			} else if (towards == 3) {// 最后移动朝向左
				g.drawImage(walk1.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
						People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 96, 96, 96 * 2, null);
			} else if (towards == 4) {// 最后移动朝向右
				g.drawImage(walk1.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
						People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 96 * 2, 96, 96 * 3, null);
			}
		} else {// 如果角色在移动中
			if (up) {
				// 通过up1的值，来决定画哪一张图片
				if (up1 < 5) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 96 * 3, 96, 96 * 4, null);
				} else if (up1 < 10) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96, 96 * 3, 96 * 2, 96 * 4,
							null);
				} else if (up1 < 15) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 2, 96 * 3, 96 * 3, 96 * 4,
							null);
				} else {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 3, 96 * 3, 96 * 4, 96 * 4,
							null);
				}
			} else if (down) {
				if (down1 < 5) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 0, 96, 96, null);
				} else if (down1 < 10) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96, 0, 96 * 2, 96, null);
				} else if (down1 < 15) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 2, 0, 96 * 3, 96, null);
				} else {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 3, 0, 96 * 4, 96, null);
				}
			} else if (left) {
				if (left1 < 5) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 96, 96, 96 * 2, null);
				} else if (left1 < 10) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96, 96, 96 * 2, 96 * 2, null);
				} else if (left1 < 15) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 2, 96, 96 * 3, 96 * 2,
							null);
				} else {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 3, 96, 96 * 4, 96 * 2,
							null);
				}

			} else if (right) {
				if (right1 < 5) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 0, 96 * 2, 96, 96 * 3, null);
				} else if (right1 < 10) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96, 96 * 2, 96 * 2, 96 * 3,
							null);
				} else if (right1 < 15) {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 2, 96 * 2, 96 * 3, 96 * 3,
							null);
				} else {
					g.drawImage(walk.getImage(), People.px - elesize / 2 - 15, People.py - elesize / 2 - 25,
							People.px - elesize / 2 + 65, People.py - elesize / 2 + 55, 96 * 3, 96 * 2, 96 * 4, 96 * 3,
							null);
				}
			}
		}
	}

	// 得到角色在数组中的位置I
	public static int getI() {
		return (y - (playersize / 2)) / 50;
	}

	// 得到角色在数组中的位置J
	public static int getJ() {
		return (x - (playersize / 2)) / 50;
	}
}
