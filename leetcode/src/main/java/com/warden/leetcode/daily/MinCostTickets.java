package com.warden.leetcode.daily;

/**
 *
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，
 * 你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

 火车票有三种不同的销售方式：

 一张为期一天的通行证售价为 costs[0] 美元；
 一张为期七天的通行证售价为 costs[1] 美元；
 一张为期三十天的通行证售价为 costs[2] 美元。
 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/6
 */
public class MinCostTickets {

	public static void main(String[] args) {
		String s = "f新";
		System.out.println(s.length());
		System.out.println(s.charAt(0));
		System.out.println((int


				)s.charAt(1));
	}

	public int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[365 + 1];
		dp[0] = 0;
		int dayLen = days.length;
		for (int day1 : days) {
			dp[day1] = -1;
		}
		for (int i = 1; i<= 365; i++) {
			if (dp[i] == 0) {
				dp[i] = dp[i-1];
				continue;
			}
			//选择使用哪一种票(并不一定是当天买)，入场时使用的票只有这三种情况
			int day = dp[Math.max(0, i - 1)] + costs[0];
			int week = dp[Math.max(0, i - 7)] + costs[1];
			int month = dp[Math.max(0, i - 30)] + costs[2];
			dp[i] = Math.min(Math.min(day, week), month);
		}
		return dp[365];
	}

}
