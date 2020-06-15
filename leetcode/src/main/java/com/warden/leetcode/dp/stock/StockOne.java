package com.warden.leetcode.dp.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class StockOne {

	public static void main(String[] args) {
		int[] prices = {1,2};
		System.out.println(new StockOne().dp(prices));
		System.out.println(new StockOne().dp2(prices));
		System.out.println(new StockOne().dp3(prices));
	}

	public int maxProfit(int[] prices) {
		return dp2(prices);
	}


	/**
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
	 */
	public int dp(int[] prices) {
		int len = prices.length;
		int[][][] dp = new int[prices.length][2][2];
		for (int i = 0; i < len; i++) {
			for (int k = 0; k <= 1; k++) {
				if (i - 1 < 0) {
					dp[i][k][0] = 0;
					dp[i][k][1] = - prices[i];
					continue;
				}
				if (k == 0) {
					dp[i][k][0] = 0;
					dp[i][k][1] = Integer.MIN_VALUE;
					continue;
				}
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
			}
		}
		return dp[len - 1][1][0];
	}

	/**
	 * 当k = 0时，dp = 0
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
	 *             = max(dp[i-1][k][1], - price[i])
	 * 因此k状态都是一样的，可以去除k状态
	 */
	public int dp2(int[] prices) {
		int len = prices.length;
		int[][] dp = new int[prices.length][2];
		for (int i = 0; i < len; i++) {
			if (i - 1 < 0) {
				dp[i][0] = 0;
				dp[i][1] = - prices[i];
				continue;
			}
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], - prices[i]);

		}
		return dp[len - 1][0];
	}

	public int dp3(int[] prices) {
		int len = prices.length;
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			dp0 = Math.max(dp0, dp1 + prices[i]);
			dp1 = Math.max(dp1, - prices[i]);
		}
		return dp0;
	}


	/**
	 * 回溯 超时
	 */
	public int trackBack(int[] prices) {
		List<Integer> buyList = new ArrayList<>(1);
		return trackBack(prices, buyList, 0);
	}

	public int trackBack(int[] prices, List<Integer> buy, int index) {
		if (index == prices.length) {
			return 0;
		}
		int s1;
		if (buy.size() == 0) {
			if (index == prices.length - 1) {
				return 0;
			}
			//买或不买
			buy.add(prices[index]);
			int b1 = trackBack(prices, buy, index+1);
			buy.clear();
			int b2 = trackBack(prices, buy, index+1);
			s1 = Math.max(b1, b2);
		} else {
			//卖
			int cur = buy.get(0);
			buy.clear();
			int b1 = prices[index] - cur;
			buy.add(cur);
			//不卖
			int b2 = trackBack(prices, buy, index+1);

			s1 = Math.max(b1, b2);
		}
		return s1;
	}

}
