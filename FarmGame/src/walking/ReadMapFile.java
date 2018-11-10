package walking;

/**
 * 读入地图文件
 * 
 *
 */
public class ReadMapFile {
	// 定义静态的三个数组，用来保存从地图文件中读取到的三个地图数组
	static int[][] map1;
	static int[][] map2;
	static int[][] map3;

	/**
	 * 读入地图
	 * 
	 * @param path
	 *            地图文件位置
	 */
	static void readfile() {
		try {
			// 按保存时候的顺序依次读出地图文件中的三个地图数组
			int i = 400;
			int j = 400;
			map1 = new int[i][j];
			map2 = new int[i][j];
			map3 = new int[i][j];
			for (int ii = 0; ii < i; ii++) {
				for (int jj = 0; jj < j; jj++) {
					map1[ii][jj] = 1;
					map2[ii][jj] = 0;
					map3[ii][jj] = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
