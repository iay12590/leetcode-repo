package com.warden.leetcode.search;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/9
 */
public class SimpleSqrt {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);

			System.out.println(new SimpleSqrt().mySqrt(i));
			System.out.println("=====");
		}
	}

	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int left = 0;
		int right = x;
		while (right - left > 1) {
			int mid = ((left^right)>>1) + (left&right);

			if (x/mid >= mid) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
