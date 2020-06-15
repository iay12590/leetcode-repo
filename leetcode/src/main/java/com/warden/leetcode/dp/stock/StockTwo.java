package com.warden.leetcode.dp.stock;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class StockTwo {

	public static void main(String[] args) {
		int[] prices = {1,2};
		System.out.println(new StockTwo().dp(prices));
	}

	public int maxProfit(int[] prices) {
		return dp(prices);
	}

	/**
	 * 不限交易次数，
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k - 1][0] - price[i])
	 *             =  max(dp[i-1][k][1], dp[i-1][k][0] - price[i])
	 * 与k无关，去除k
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - price[i])
	 */
	public int dp(int[] prices) {
		int len = prices.length;
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			int temp = dp0;
			dp0 = Math.max(dp0, dp1 + prices[i]);
			dp1 = Math.max(dp1, temp - prices[i]);
		}
		return dp0;
	} 
	

}
