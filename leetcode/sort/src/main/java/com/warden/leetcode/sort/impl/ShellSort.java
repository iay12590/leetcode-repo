package com.warden.leetcode.sort.impl;

import com.warden.leetcode.sort.AbstractSort;
import com.warden.leetcode.sort.util.SortUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 希尔排序 间距=3*h+1的插入排序
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class ShellSort extends AbstractSort {

	private int count;

	public ShellSort(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Comparable[] sort(Comparable[] arr) {
		int len = arr.length;
		for (Integer gap : getGap(len)) {
//			System.out.println(gap);
			sort(arr, gap);
		}
		return arr;
	}

	private List<Integer> getGap(int len) {
		LinkedList<Integer> list = new LinkedList<>();
		int gap = 1;
		list.add(gap);
		while (gap < len / 3) {
			gap = gap * 3 + 1;
			list.addFirst(gap);
		}
		return list;
	}

	private void sort(Comparable[] arr, int gap) {
		int len = arr.length;
		for (int i = gap; i < len; i++) {
			for (int j = i; j >= gap; j-= gap) {
				if (SortUtils.less(arr[j - gap], arr[j])) {
					SortUtils.exch(arr, j - gap, j);
				} else {
					break;
				}
			}
		}
	}
}
