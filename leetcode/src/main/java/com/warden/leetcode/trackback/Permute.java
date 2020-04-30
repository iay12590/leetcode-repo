package com.warden.leetcode.trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/29
 */
public class Permute {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> list = new Permute().permute(nums);
		for (List<Integer> resList : list) {
			System.out.println(resList);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		LinkedList<Integer> track = new LinkedList<Integer>();
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		trackBack(nums, track, res);
		return res;
	}

	private void trackBack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
		//满足条件，保存结果并返回
		if (track.size() == nums.length) {
			res.add(new ArrayList<Integer>(track));
			return;
		}
		//遍历选择列表(这里遍历全部，并把已选去掉，当做选择列表)
		for (int num : nums) {
			if (track.contains(num)) {
				continue;
			}
			//选择
			track.add(num);
			//进入下层决策，是否满足在下层决策做决定
			trackBack(nums, track, res);
			//撤销选择
			track.removeLast();
		}

	}


}
