package com.warden.leetcode.dp;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/15
 */
public class CountPalindromicSubsequences {

	public static void main(String[] args) {
		String a = "bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada";
		System.out.println(new CountPalindromicSubsequences().countPalindromicSubsequences(a));
	}

	public long countPalindromicSubsequences(String S) {
		int M = 100000007;
		int len;
		if (S == null || (len = S.length()) <= 0) {
			return 0;
		}
		long[][] dp = new long[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
		//状态转移方程dp[i][j]表示i-j范围内数量
		//当S[i]!=S[j]是  dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
		//当S[i]==S[j]时
		// 	1）dp[i][j] = dp[i+1][j-1] * 2 + 2; [i+1,j-1]没有S[i]
		// 	2）dp[i][j] = dp[i+1][j-1] * 2 + 1; [i+1,j-1]有一个S[i]
		// 	3）dp[i][j] = dp[i+1][j-1] * 2 - dp[l+1][r-1]; [i+1,j-1]有两个S[i]
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				char si = S.charAt(i);
				char sj = S.charAt(j);
				if (si != sj) {
					dp[i][j] =  dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
				} else {
					int left = i + 1;
					int right = j - 1;
					dp[i][j] =  dp[i+1][j -1] << 1;
					while (left < j) {
						if (S.charAt(left) == si) {
							break;
						}
						left++;
					}
					while (right > i) {
						if (S.charAt(right) == si) {
							break;
						}
						right--;
					}
					if (left == right) {
						dp[i][j] += 1;
					} else if (left > right){
						dp[i][j] += 2;
					} else {
						dp[i][j] -= dp[left+1][right-1];

						System.out.println(dp[left+1][right-1]);
						System.out.println(dp[i][j]);
					}
				}
				dp[i][j] =  dp[i][j] % M;
			}
		}

		return dp[0][len -1];
	}

}
