package com.warden.leetcode.sort;

import com.warden.leetcode.sort.util.GenerateUtils;
import com.warden.leetcode.sort.util.SortUtils;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public abstract class AbstractSort implements Sort {

	private Comparable[] arr;

	@Override
	public void init() {
		int n = getCount();
		this.arr = GenerateUtils.disorder(n);
	}

	@Override
	public Comparable[] sort() {
		return sort(arr);
	}

}
