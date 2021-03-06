/**
 * 动态规划
 * 1 状态和选择
 * 状态：描述当前局面(类似于归纳法中i=n-1时的状况)
 * 选择：在n-1的情况下进行下一步选择
 * 2 dp数组，描述中间状态，i=n时的状态可通过dp[i-1][...]和选择进行确定，如下
 * for (状态1 in 状态1下的所有选择)
 *     for (状态2 in 状态2下的所有选择)、
 *          ......
 *          dp[状态1][状态2]...[状态n] = 择优(选择1， 选择2，...)
 *
 * 状态压缩：
 *
 * 状态压缩：使用i-1推导i的状态，其实只需要保存i-1的状态即可
 * 选择时从后往前遍历，避免推导（i，w) 时w-num[i]并不是i-1的状态，而是在i状态被修改过的
 *
 *  * for (状态1 in 状态1下的所有选择)
 *     for (状态2 in 状态2下的所有选择)
 *          ......
 *          //根据上一状态的dp[j]获取当前状态值
 *          dp[j]= f(dp[j])
 *
 *  状态->选择->状态转移
 */
package com.warden.leetcode.dp;