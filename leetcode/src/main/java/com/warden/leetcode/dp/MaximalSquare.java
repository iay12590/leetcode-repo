package com.warden.leetcode.dp;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/8
 */
public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix = {
				{'1','0','1','1','1'},
				{'0','1','0','1','0'},
				{'1','1','0','1','1'},
				{'1','1','0','1','1'},
				{'0','1','1','1','1'}};
		System.out.println(new MaximalSquare().maximalSquare2(matrix));

	}

	/**
	 * dp[i][j]表示以i和j为右下顶点的正方形周长，
	 * matrix[i][j]=0时dp[i][j]=0
	 * matrix[i][j]=1时dp[i][j]=min(dp[i - 1][j],dp[i-1][j-1], dp[i][j - 1])
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int max = 0;
		int x = matrix.length;
		int y = matrix[0].length;
		int[][] dp = new int[x+1][y+1];
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i-1][j-1], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
	}

	public int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int max = 0;
		int x = matrix.length;
		int y = matrix[0].length;
		int[] dp = new int[y+1];
		int temp;
		int pre;
		for (int i = 1; i <= x; i++) {
			pre = 0;
			for (int j = 1; j <= y; j++) {
				temp = pre;
				pre = dp[j];
  				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(dp[j], Math.min(dp[j-1], temp)) + 1;
					max = Math.max(max, dp[j]);
				} else {
  					dp[j] = 0;
				}
			}
		}
		return max*max;
	}

}
