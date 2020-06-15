/**
 * 动态规划之股票问题：状态转移
 * dp状态: 是否持有股票
 * dp选择：买入、卖出、不操作
 * 定义dp数组：dp[天数][买入次数][是否持有]
 * 那么
 * 1）当前未持有最大收益 = 前一天未持有最大收益和前一天持有并卖出的最大收益的最大值
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - price[i])
 * for 0 <= i < n
 *     for 0 <= k <= K
 *         for s in (0, 1)
 *             dp[i][k][s] = max (buy, sell, rest)
 * @author JianHua.Lin
 * @date 2020/6/15
 * @version 1.0.0
 */
package com.warden.leetcode.dp.stock;