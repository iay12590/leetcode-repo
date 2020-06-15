package com.warden.leetcode.dp.stock;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class StockWithCoolDown {

	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(new StockWithCoolDown().dp(prices));
	}

	public int maxProfit(int[] prices) {
		return dp(prices);
	}

	/**
	 * 每次买出后隔一天才能买入
	 * 无限次数+冷冻期，需要一个字段记录dp[i-2]
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - price[i])
	 */
	public int dp(int[] prices) {
		int len = prices.length;
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		int dpPre = 0;
		for (int i = 0; i < len; i++) {
			//保存i-1,在i+1时使用
			int temp = dp0;
			//根据i-1计算i
			dp0 = Math.max(dp0, dp1 + prices[i]);
			dp1 = Math.max(dp1, dpPre - prices[i]);
			dpPre = temp;
		}
		return dp0;
	}

}
