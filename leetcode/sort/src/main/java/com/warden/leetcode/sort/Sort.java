package com.warden.leetcode.sort;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/23
 */
public interface Sort {

	int getCount();

	void init();

	Comparable[] sort();

	Comparable[] sort(Comparable[] arr);
}
