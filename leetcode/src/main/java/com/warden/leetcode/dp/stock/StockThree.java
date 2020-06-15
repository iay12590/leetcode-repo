package com.warden.leetcode.dp.stock;

/**
 * 股票最佳时机3：
 * 最多完成两笔交易
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class StockThree {

	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(new StockThree().dp(prices));
	}

	/**
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
	 */
	public int dp(int[] prices) {
		int len = prices.length;
		int[] dp0 = new int[3];
		int[] dp1 = new int[3];
		for (int i = 0; i < 3; i++) {
			dp1[i] = Integer.MIN_VALUE;
		}
		for (int i = 0; i < len; i++) {
			int temp = 0;
			for (int k = 1; k <= 2; k++) {
				//dp[i-1][k-1][0]，下一轮会使用到
				int t = dp0[k];
				dp0[k] = Math.max(dp0[k], dp1[k] + prices[i]);
				dp1[k] = Math.max(dp1[k], temp - prices[i]);
				temp = t;
			}
		}
		return dp0[2];
	}

}
