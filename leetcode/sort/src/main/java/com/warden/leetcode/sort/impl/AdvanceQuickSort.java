package com.warden.leetcode.sort.impl;

import com.warden.leetcode.sort.util.SortUtils;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/25
 */
public class AdvanceQuickSort extends QuickSort {

	private static final int THRESHOLD = 20	;

	private static final InsertionSort INSERTION_SORT = new InsertionSort(0);

	public AdvanceQuickSort(int count) {
		super(count);
	}

	@Override
	public void sort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		if (hi - lo <= THRESHOLD) {
			INSERTION_SORT.sort(arr, lo, hi);
		} else {
			before(arr, lo, hi);
			int j = partition(arr, lo, hi);
			sort(arr, lo, j -1);
			sort(arr, j+1, hi);
		}
	}

	private void before(Comparable[] arr, int lo, int hi) {
		int mid = (lo + hi) >> 1;
		int sep  = lo;
		if ((SortUtils.less(arr[mid], arr[lo]) && SortUtils.less(arr[hi], arr[mid])) || (SortUtils.less(arr[lo], arr[mid]) && SortUtils.less(arr[mid], arr[hi]))) {
			sep = mid;
		} else if ((SortUtils.less(arr[hi], arr[lo]) && SortUtils.less(arr[mid], arr[hi])) || (SortUtils.less(arr[hi], arr[mid]) && SortUtils.less(arr[lo], arr[hi]))) {
			sep = hi;
		}
		SortUtils.exch(arr, sep, lo);
	}

}
