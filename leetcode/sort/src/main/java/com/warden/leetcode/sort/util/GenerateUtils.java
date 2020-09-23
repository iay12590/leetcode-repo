package com.warden.leetcode.sort.util;

import java.util.Random;

/**
 * 生成数据
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class GenerateUtils {

	public static Comparable[] disorder(int n) {
		Integer[] res = new Integer[n];
		Random random = new Random();
		long rand = n * 5;
		int bound = (int) Math.min(rand, (long) Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			res[i] = random.nextInt(bound);
		}
		return res;
	}


}
