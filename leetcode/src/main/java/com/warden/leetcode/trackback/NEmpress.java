package com.warden.leetcode.trackback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * N皇后
 *
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/29
 */
public class NEmpress {

	private static final char EMPRESS = 'Q';
	private static final char NON_EMPRESS = '-';
	private static final Map<Integer, String> EMPRESS_MAP = new HashMap<Integer, String>();

	public static void main(String[] args) {
		int n = 8;
		List<List<String>> result = new NEmpress().nEmpress(n);
		for (List<String> list : result) {
			System.out.println("==================");
			for (String str : list) {
				System.out.println(str);
			}
		}
		List<String> temp = new ArrayList<>();
	}

	public List<List<String>> nEmpress(int n) {
		List<List<String>> res = new LinkedList<List<String>>();
		LinkedList<String> track = new LinkedList<String>();
		LinkedList<Integer> tempTrack = new LinkedList<Integer>();
		trackBack(n, res, track, tempTrack);
		return res;
	}

	private void trackBack(int n, List<List<String>> res, LinkedList<String> track, LinkedList<Integer> tempTrack) {
		//满足条件
		if (tempTrack.size() == n) {
			res.add(new LinkedList<String>(track));
			return;
		}
		//遍历选择列表
		for (int i = 0; i < n; i++) {
			if (tempTrack.contains(i)) {
				continue;
			}
			//做选择
			tempTrack.add(i);
			track.add(getStr(n, i));
			trackBack(n, res, track, tempTrack);
			//撤销选择
			tempTrack.removeLast();
			track.removeLast();
		}
	}

	private String getStr(int n, int index) {
		String str = EMPRESS_MAP.get(n);
		if (str == null) {
			StringBuilder sb = new StringBuilder(n);
			for (int i = 0; i < n; i++) {
				if (i != index) {
					sb.append(NON_EMPRESS);
				} else {
					sb.append(EMPRESS);
				}
			}
			str = sb.toString();
			EMPRESS_MAP.put(index, str);
		}
		return str;
	}
}
