package com.warden.leetcode.dp.stock;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class StockFour {

	/**
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
	 * dp[i][k] 只依赖于dp[i-1][k]和dp[i-1][k-1] 使用dp0[k+1]记录第i-1次每个k的情况，相当于dp数组分别按k=0, 1,2 进行计算，
	 * 然后进行压缩为dp[k+1]
	 * 注意
	 * 2）交易次数大于天数一半时，相当于无限制
	 *
	 */
	public int dp(int[] prices, int k) {
		//k交易次数
		if (k > (prices.length >>1)) {
			return dp(prices);
		}
		int[] dp0 = new int[k+1];
		int[] dp1 = new int[k+1];
		for (int i = 0; i < k+1; i++) {
			dp1[i] = Integer.MIN_VALUE;
		}
		for (int price : prices) {
			for (int j = k; j >= 1; j--) {
				dp1[j] = Math.max(dp1[j], dp0[j-1] - price);
				dp0[j] = Math.max(dp0[j], dp1[j] + price);
			}
		}
		return dp0[k];
	}

	public int dp(int[] prices) {
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		for (int price : prices) {
			int temp = dp0;
			dp0 = Math.max(dp0, dp1 + price);
			dp1 = Math.max(dp1, temp - price);
		}
		return dp0;
	}

}
