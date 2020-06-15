package com.warden.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/15
 */
public class SuperEggDrop {

	public static void main(String[] args) {
		System.out.println(new SuperEggDrop().superEggDrop(2, 100));
		System.out.println(new SuperEggDrop().superEggDrop2(2, 100));
		System.out.println(new SuperEggDrop().dp2(2, 100));
	}

	public int superEggDrop(int K, int N) {
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<>(K-1);
		for (int i = 2; i <= K; i++) {
			memo.put(i, new HashMap<>(N));
		}
		return dp(K, N, memo);
	}

	public int superEggDrop2(int K, int N) {
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<>(K-1);
		for (int i = 2; i <= K; i++) {
			memo.put(i, new HashMap<>(N));
		}
		return binarySearchDp(K, N, memo);
	}

	public int dp(int k, int n, Map<Integer, Map<Integer, Integer>> memo) {
		if (k == 1) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		Map<Integer, Integer> subMap = memo.get(k);
		Integer value = subMap.get(n);
		if (value != null) {
			return value;
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			res = Math.min(res, Math.max(dp(k, n - i, memo), dp(k - 1, i - 1, memo)) + 1);
		}
		subMap.put(n, res);
		return res;
	}

	/**
	 *	for (int i = 1; i <= n; i++) {
	 * 		res = Math.min(res, Math.max(dp(k, n - i, memo), dp(k - 1, i - 1, memo)) + 1);
	 * 	}
	 * 	该状态转移方程为：dp[k, n] = min(Math.max(dp(k, n - i), dp(k - 1, i - 1)) + 1), 1 <= i<= n;
	 * 	当k固定是，dp(k, n - i) 随i递减， dp(k - 1, i - 1)随i递增，Math.max(dp(k, n - i), dp(k - 1, i - 1)两个直线为v型
	 * 	求最小值，即两个直线相交处最小，转化为二分法求相等值问题
	 * @param k
	 * @param n
	 * @param memo
	 * @return
	 */
	public int binarySearchDp(int k, int n, Map<Integer, Map<Integer, Integer>> memo) {
		if (k == 1) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		Map<Integer, Integer> subMap = memo.get(k);
		Integer value = subMap.get(n);
		if (value != null) {
			return value;
		}
		int res = Integer.MAX_VALUE;
		int left = 1;
		int right = n;
		int mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			int broken = binarySearchDp(k -1, mid - 1, memo);
			int notBroken = binarySearchDp(k, n - mid, memo);
			if (broken > notBroken) {
				right = mid - 1;
				res = Math.min(res, broken + 1);
			} else {
				left = mid + 1;
				res = Math.min(res, notBroken + 1);
			}
		}
		subMap.put(n, res);
		return res;
	}

	/**
	 * 反向思考：dp(k, m)表示给定k个鸡蛋，允许抛m次，能够到达的最大楼层
	 * 当前剩余m次搜索，假设在i处进行搜索，有两种情况，碎和不碎
	 * 不管碎与不碎，m次搜索的总楼数=楼上+楼下+本层
	 * 即 dp(k, m) = dp(k, m - 1) + dp(k - 1, m - 1) + 1
	 */
	public int dp2(int k, int n) {
		int[][] dp = new int[k+1][n+1];
		int m = 0;
		while (dp[k][m] < n) {
			m++;
			for (int i = 1; i <= k; i++) {
				dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
			}
		}
		return m;
	}

}
