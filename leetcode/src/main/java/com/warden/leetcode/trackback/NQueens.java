//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
//
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
//
// Related Topics 回溯算法
// 👍 541 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
package com.warden.leetcode.trackback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NQueens {

	public static void main(String[] args) {
		List<List<String>> res = new NQueens().solveNQueens(4);
		System.out.println(res);
	}

	private String[] resultArr = null;

	public List<List<String>> solveNQueens(int n) {
		if (n == 0) {
			return Collections.emptyList();
		}
		initResultArr(n);
		//n皇后 回溯 判断合法性 斜线
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>(n);
		trackBack(n, 0, 0, 0, 0, res, temp);
		return res;
	}

	private void initResultArr(int n) {
		resultArr = new String[n];
		for (int k = 0; k < n; k++) {
			StringBuilder sb = new StringBuilder(n);
			for (int i = 0; i < n; i++) {
				if (i != k) {
					sb.append(".");
				} else {
					sb.append("Q");
				}
			}
			resultArr[k] = sb.toString();
		}

	}

	private void trackBack(int n, int row, int colume, int positiveHill, int negativeHill, List<List<String>> res, List<String> temp) {
		if (n == row) {
			List<String> list = new ArrayList<>(temp);
			res.add(list);
			return;
		}
		int allColums = (1 << n) - 1;
		int freeColums = allColums & ~(colume | positiveHill | negativeHill);
		while (freeColums != 0) {
			int cur = (-freeColums) & freeColums;
			freeColums = freeColums ^ cur;
			temp.add(get(cur));
			trackBack(n, row+1,
					colume | cur,
					(positiveHill | cur) << 1,
					(negativeHill | cur) >> 1,
					res,temp);
			//回溯
			temp.remove(temp.size() -1);
		}

	}

	private String get(int cur) {
		int b = 0;
		while (cur != 0) {
			cur = cur >> 1;
			b++;
		}
		return resultArr[b-1];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
