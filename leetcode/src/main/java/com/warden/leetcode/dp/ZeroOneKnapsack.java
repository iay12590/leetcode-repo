package com.warden.leetcode.dp;

/**
 * 动态规划之0-1背包
 * Created by Administrator on 2020/5/2 0002.
 */
public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int wight = 4;int num = 3;
        int[] val = {4,2,3};
        int[] wt = {2,1,3};
        System.out.println(new ZeroOneKnapsack().stateCompress(wight, num, wt, val));
    }

    public int knapsack(int weight, int num, int[] wt, int[] val) {
        int[][] dp = new int[num+1][weight+1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= weight; j++) {
                if (j - wt[i-1] < 0) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j - wt[i-1]] + val[i-1], dp[i - 1][j]);
                }
            }
        }
        return dp[num][weight];
    }

    public int stateCompress(int weight, int num, int[] wt, int[] val) {
        int[] dp = new int[weight+1];
        for (int i = 0; i < num; i++) {
            //从后往前遍历
            for (int j = 1; j >= weight; j++) {
                if (j - wt[i] < 0) {
                    //背包放不下无需修复(为了看清楚每个步骤把这一步放出来，实际可以省略)
                    dp[j] = dp[j];
                } else {
                    //修改dp[j]，获取在i状态下 weight = j时的最大值
                    dp[j] = Math.max(dp[j - wt[i]] + val[i], dp[j]);
                }
            }
        }
        return dp[weight];
    }

}
