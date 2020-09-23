package com.warden.leetcode.sort.impl;

import com.warden.leetcode.sort.AbstractSort;
import com.warden.leetcode.sort.util.SortUtils;

import java.util.Arrays;

/**
 * 归并排序
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public class MergeSort extends AbstractSort {

	private int count;

	public MergeSort(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Comparable[] sort(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		doSort(arr, aux);
		return arr;
	}

	private void doSort(Comparable[] arr, Comparable[] aux) {
		int len = arr.length;
		for (int step = 1 ; step < len; step *= 2) {
			for (int i = 0; i < len - step; i += step * 2) {
				merge(arr, i, i + step - 1, Math.min(i + step + step -1, len -1), aux);
			}
		}
	}

	/**
	 * lo-mid
	 * mid+1 -> hi
	 */
	private void merge(Comparable[] arr, int lo, int mid, int hi, Comparable[] aux) {
		int s1 = lo;
		int s2 = mid+1;
		for (int i = lo; i <= hi; i++) {
			aux[i] = arr[i];
		}
		for (int i = lo; i <= hi; i++) {
			if (s2 > hi) {
				arr[i] = aux[s1++];
			} else if (s1 > mid) {
				arr[i] = aux[s2++];
			} else if (SortUtils.less(aux[s1], aux[s2])){
				arr[i] = aux[s2++];
			} else {
				arr[i] = aux[s1++];
			}
		}
	}

}
