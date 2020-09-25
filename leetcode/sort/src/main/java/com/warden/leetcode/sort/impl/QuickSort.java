package com.warden.leetcode.sort.impl;

import com.warden.leetcode.sort.AbstractSort;
import com.warden.leetcode.sort.util.SortUtils;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class QuickSort extends AbstractSort {

	private int count;

	public QuickSort(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Comparable[] sort(Comparable[] arr) {
		sort(arr, 0, arr.length -1);
		return arr;
	}

	public void sort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int j = partition(arr, lo, hi);
		sort(arr, lo, j -1);
		sort(arr, j+1, hi);
	}


	int partition(Comparable[] arr, int lo, int hi) {
		//分层 [lo, j-1] [j] [j+1,hi]
		int i = lo;
		int j = hi + 1;
		Comparable sep = arr[i];
		while (true) {

			while (SortUtils.less(sep, arr[++i])) {
				if (i == hi) {
					break;
				}
			}
			while (SortUtils.less(arr[--j],	sep)) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			SortUtils.exch(arr, i, j);
		}
		SortUtils.exch(arr, lo, j);
		return j;
	}
}
