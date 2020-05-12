package com.warden.leetcode.daily;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/11
 */
public class MyPow {

	public static void main(String[] args) {
		System.out.println(new MyPow().myPow(2.0, 5));
	}

	public double myPow(double x, int n) {
		double res = 1.0;
		for (int i = n; i != 0; i = i / 2) {
			if (i % 2 != 0) {
				res *= x;
			}
			x *= x;
		}
		return n < 0 ? 1/res : res;
	}

}
