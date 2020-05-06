package com.warden.leetcode.string;

import java.util.Arrays;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/6
 */
public class KMP {

	public static void main(String[] args) {
		String a = "ababcd";
		String txt = "1faababcdsef";
		System.out.println(new KMP().search(txt, a));
	}

	public int search(String txt, String pat) {
		int[][] dp = dp(pat);
		int next = 0;
		for (int i = 0; i < txt.length(); i++) {
			next = dp[next][txt.charAt(i)];
			if (next == pat.length()) {
				return i - pat.length() + 1;
			}
		}
		return -1;
	}

	private int[][] dp(String pat) {
		int m = pat.length();
		int[][] dp = new int[m][256];
		dp[0][pat.charAt(0)] = 1;
		//x:影子状态
		//x从0开始，i从1开始，x记录的是和当前状态具有相同前缀的最大索引，不匹配时回退在这个位置，根据历史数据获取回退后的状态
		//x落后于i,dp[x][pat.charAt(i)];总是已经计算好的
		int x = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < 256; j++) {
				dp[i][j] = dp[x][j];
			}
			dp[i][pat.charAt(i)] = i + 1;
			//当x状态时，如果字符匹配，x加1，不匹配则往前找相同前缀
			x = dp[x][pat.charAt(i)];
		}
		return dp;
	}

}
