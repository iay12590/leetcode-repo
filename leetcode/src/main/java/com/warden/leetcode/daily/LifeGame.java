package com.warden.leetcode.daily;

/**
 * @author JianHua.Lin
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * @version 1.0.0
 * @date 2020/4/3
 */
public class LifeGame {

	private static final int[] DX = {0, 0, 1, 1, 1, -1, -1, -1};
	private static final int[] DY = {-1, 1, -1, 0, 1, -1, 0, 1};

	public void gameOfLife(int[][] board) {
		int xL = board.length;
		int yL = board[0].length;
		for (int i = 0; i < xL; i++) {
			for (int j = 0; j < yL; j++) {
				int live = 0;
				for (int k = 0; k < 8; k++) {
					int x = i+DX[k];
					int y = j+DY[k];
					if (x < 0| y < 0 | x >= xL | y >= yL) {
						continue;
					}
					live += board[x][y] & 1;
				}
				int b = board[i][j] & 1;
				if (b == 0 && live == 3) {
					b = 1;
				} else if (b == 1 && (live < 2 || live > 3)) {
					b = 0;
				}
				board[i][j] += (b << 1);
			}
		}

		for (int i = 0; i < xL; i++) {
			for (int j = 0; j < yL; j++) {
				board[i][j] >>=1;
			}
		}

	}

}
