package com.warden.leetcode.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/7/7
 */
public class NSum {

	public static void main(String[] args) {
		int[] nums  = {0,0,0};
		List<int[]> res = new NSum().nsum(nums, 0, 3);
		res.forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	private List<int[]> nsum(int[] nums, int target, int n) {
		Arrays.sort(nums);
		List<LinkedList<Integer>> temp = nsum(nums, 0, target, n);
		if (temp == null) {
			return Collections.emptyList();
		}
		List<int[]> res = new ArrayList<>(temp.size());
		temp.forEach(t -> {
			int[] arr = new int[t.size()];
			for (int i = 0; i < t.size(); i++) {
				arr[i] = t.get(i);
			}
			res.add(arr);
		});
		return res;
	}

	private List<LinkedList<Integer>> nsum(int[] nums, int start, int target, int n) {
		int lo = start;
		int hi = nums.length - 1;
		if (hi - lo < n - 1|| n < 2) {
			return  null;
		}
		if (n == 2) {
			return twoSum(nums, lo, target);
		}
		LinkedList<LinkedList<Integer>> res = new LinkedList<>();
		while (lo < hi) {
			int cur = nums[lo];
			List<LinkedList<Integer>> temp = nsum(nums, lo + 1, target - cur, n - 1);
			if (temp != null && temp.size() > 0) {
				temp.forEach(list -> {
					list.addFirst(cur);
					res.add(list);
				});
			}
			while (lo < hi && nums[lo] == cur) {
				lo++;
			}
		}
		return res;
	}

	private List<LinkedList<Integer>> twoSum(int[] nums, int start, int target) {
		int lo = start;
		int hi = nums.length - 1;
		List<LinkedList<Integer>> res = new ArrayList<>();
		while (lo < hi) {
			int left = nums[lo];
			int right = nums[hi];
			int sum = left + right;
			if (sum > target) {
				while (lo < hi && nums[hi] == right) {
					hi--;
				}
			} else if (sum < target) {
				while (lo < hi && nums[lo] == left) {
					lo++;
				}
			} else {
				LinkedList<Integer> temp = new LinkedList<>();
				temp.add(left);
				temp.add(right);
				res.add(temp);
				while (lo < hi && nums[lo] == left) {
					lo++;
				}
				while (lo < hi && nums[hi] == right) {
					hi--;
				}
			}
		}
		return res;
	}

}
