package com.warden.leetcode.dp;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2020/5/2 0002.
 */
public class FullKnapsack {

    public static void main(String[] args) {
        //字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
        String reg = "^[+-]?\\d*(\\.\\d+)?(\\d+[Ee][+-]?\\d+)?$";

        Pattern p = Pattern.compile(reg);
        boolean b = p.matcher("e9").find();
        System.out.println(b);

//        int amount = 0;
//        int[] coins = {};
//        System.out.println(new FullKnapsack().stateCompress(amount, coins));
    }

    public int fullKnapsack(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <=  coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    //dp[i-1][j] 不选择
                    //可重复选择
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int stateCompress(int amount, int[] coins) {



        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin < 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

}
