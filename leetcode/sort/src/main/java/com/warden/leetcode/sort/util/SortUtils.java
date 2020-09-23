package com.warden.leetcode.sort.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class SortUtils {

	public static boolean isSorted(Comparable[] arr) {
		boolean res = doCheck(arr);
		System.out.println("结果：" + (res ? "已" : "未") + "排序");
		return res;
	}

	private static boolean doCheck(Comparable[] arr) {
		int len = arr.length;
		if (len <= 1) {
			return true;
		}
		for (int i = 1; i < len; i++) {
			Comparable cur = arr[i];
			Comparable pre = arr[i - 1];
			if (cur.compareTo(pre) < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * b是否小于a
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}

	public static void exch(Comparable[] arr, int a, int b) {
		Comparable temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void show(Comparable[] arr) {
		String s = Arrays.stream(arr).map(Comparable::toString).collect(Collectors.joining(","));
		System.out.println("排序后数组:" + s);
	}

}
