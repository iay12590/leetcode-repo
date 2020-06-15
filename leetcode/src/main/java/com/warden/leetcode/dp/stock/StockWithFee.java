package com.warden.leetcode.dp.stock;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class StockWithFee {

	public static void main(String[] args) {
		int[] prices = {1, 3, 2, 8, 4, 9};
		System.out.println(new StockWithFee().dp(prices, 2));
	}

	public int maxProfit(int[] prices, int fee) {
		return dp(prices, fee);
	}

	/**
	 * 买入时扣除手续费(卖出时扣除会超过Integer表示的负数范围)
	 * dp[i][0] = max(dp[i - 1][0], dp[i-1][1] + price[i] - fee)
	 * dp[i][1] = max(dp[i - 1][1], dp[i-1][0] - price[i])
	 */
	private int dp(int[] prices, int fee) {
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		for (int price : prices) {
			int temp = dp0;
			dp0 = Math.max(dp0, dp1 + price);
			dp1 = Math.max(dp1, temp - price - fee);
		}
		return dp0;
	}

}
