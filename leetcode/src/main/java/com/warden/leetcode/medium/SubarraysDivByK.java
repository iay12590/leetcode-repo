package com.warden.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 被k整除的连续子数组
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/27
 */
public class SubarraysDivByK {

	public static void main(String[] args) {
		int[] A = {4,5,0,-2,-3,1};
		int k = 5;
		System.out.println(new SubarraysDivByK().subarraysDivByK(A, k));
	}

	public int subarraysDivByK(int[] A, int K) {
		//k > 1
		if (A == null || A.length == 0) {
			return 0;
		}
		int sum = 0;
		int[] res = new int[K];
		res[0] = 1;
		int count = 0;
		for (int a : A) {
			a = ((a % K) + K ) % K;
			count += res[(sum + a) % K];
			sum += a;
			sum = (sum + K) % K;
			res[sum]++;
		}
		return count;
	}

}
