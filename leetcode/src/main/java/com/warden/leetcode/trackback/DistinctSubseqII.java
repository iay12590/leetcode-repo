package com.warden.leetcode.trackback;

import java.util.LinkedList;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/19
 */
public class DistinctSubseqII {

	private int res = 0;

	public static void main(String[] args) {
		String a = "aba";
 		System.out.println(new DistinctSubseqII().distinctSubseqII(a));
	}

	public int distinctSubseqII(String S) {
		if (S == null ) {
			return 0;
		}
		return dp(S);
	}

	//dp
	public int dp(String S) {
		final long mod = (long) 1e9 + 7;
		long[] end = new long[26];
		long sum = 0;
		long inc = 0;
		for (char c : S.toCharArray()) {
			//dp[i+1] = 2 * dp[i] + 1 - dp[k],k为char[i+1]上一次出现的位置[0,k]和[0, k-i][i+1]重复了
			//dp[i+1]只和dp[i]、dp[k]相关k 属于[0, 25]
			inc = end[c - 'a'];
			end[c - 'a'] = (sum + 1) % mod;
			inc = end[c - 'a'] - inc;
			sum = (sum + inc + mod) % mod;
		}
		return (int) sum;
	}

	//超时
	private void trackBack(int level, String S, int start, int len) {
		if (level > 0) {
			res++;
			res = res % 100000007;
		}
		if (level == len) {
			return;
		}
		boolean[] useCount = new boolean[26];
		int c = 0;
		for (int i = start; i < len; i++) {
			char ch = S.charAt(i);
			//本轮已经使用过
			if (useCount[ch - 'a']) {
				continue;
			}
			//使用
				useCount[ch - 'a'] = true;
			trackBack(level + 1, S, i + 1, len);
			if (++c == 26) {
				break;
			}
		}
	}

}
