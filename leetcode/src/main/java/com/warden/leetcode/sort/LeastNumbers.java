package com.warden.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/6
 */
public class LeastNumbers {

	public static void main(String[] args) {
		//[]
		int[] arr = {0,0,0,2,0,5};
		int k = 1;
		System.out.println(Arrays.toString(new LeastNumbers().getLeastNumbers(arr, k)));
	}

	public int[] getLeastNumbers(int[] arr, int k) {
		if (arr == null || arr.length <= 0) {
			return arr;
		}
		if (k <= 0) {
			return new int[0];
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int cur : arr) {
			if (queue.size() < k) {
				queue.add(cur);
			} else {
				if (cur < queue.peek()) {
					queue.poll();
					queue.add(cur);
				}
			}
		}
		int[] result = new int[queue.size()];
		int i = 0;
		while (queue.peek()!=null) {
			result[i++] = queue.poll();
		}

		return result;
	}

}
