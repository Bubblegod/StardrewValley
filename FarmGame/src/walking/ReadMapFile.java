package walking;

/**
 * �����ͼ�ļ�
 * 
 *
 */
public class ReadMapFile {
	// ���徲̬���������飬��������ӵ�ͼ�ļ��ж�ȡ����������ͼ����
	static int[][] map1;
	static int[][] map2;
	static int[][] map3;

	/**
	 * �����ͼ
	 * 
	 * @param path
	 *            ��ͼ�ļ�λ��
	 */
	static void readfile() {
		try {
			// ������ʱ���˳�����ζ�����ͼ�ļ��е�������ͼ����
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
