package com.warden.leetcode.bit;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/2
 */
public class SumNums {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(new SumNums().sumNums(n));
	}

	public int sumNums(int n) {
		int[] t = new int[1];
		sum(n, t);
		return t[0];
	}

	public boolean sum(int n, int[] t) {
		t[0] += n;
		System.out.println(n);
		return (n > 0) && (sum(n-1, t));
	}

}
