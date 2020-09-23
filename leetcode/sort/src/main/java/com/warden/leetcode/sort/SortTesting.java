package com.warden.leetcode.sort;

import com.warden.leetcode.sort.impl.InsertionSort;
import com.warden.leetcode.sort.impl.MergeSort;
import com.warden.leetcode.sort.impl.ShellSort;
import com.warden.leetcode.sort.util.SortUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class SortTesting {

	public static void main(String[] args) {
		Sort s1 = new ShellSort(15000);
		Sort s2 = new InsertionSort(15000);
		Sort s3 = new MergeSort(15000);
		List<Sort> list = new ArrayList<>(2);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		test(list, 5);
	}

	private static void test(Sort sort) {
		sort.init();
		Comparable[] a = sort.sort();
		SortUtils.isSorted(a);
		SortUtils.show(a);
	}

	private static void test(List<Sort> list, int time) {
		list.forEach(s -> test(s, time));
	}

	private static void test(Sort sort, int time) {
		long used = 0;
		for (int i = 0; i < time; i++) {
			sort.init();
			long start = System.currentTimeMillis();
			Comparable[] arr = sort.sort();
			long end = System.currentTimeMillis();
			SortUtils.isSorted(arr);
			used += (end - start);
		}
		System.out.println("sort:" + sort.getClass() + ", 花费：" + used / time);
	}

}
