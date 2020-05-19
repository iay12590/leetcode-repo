package com.warden.leetcode.trackback;

/**
 * 带对角线的n皇后问题
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/19
 */
public class TotalNQueens {

	public static void main(String[] args) {
		System.out.println(new TotalNQueens().totalNQueens(4));
	}

	public int backtrack(int row,
						 int hills,
						 int next_row,
						 int dales,
						 int count,
						 int n) {
		int columns = (1 << n) - 1;

		if (row == n) {
			count++;
		} else {
			// 当前行可用的列
			// ! 表示 0 和 1 的含义对于变量 hills, next_row and dales的含义是相反的
			// [1 = 未被占据，0 = 被占据]

			//hills 表示正斜线占用
			//dales 表示负斜线占用
			int free_columns = columns & ~(hills | next_row | dales);
			while (free_columns != 0) {
				// 保留第一个1
				int curr_column = (- free_columns) & free_columns;
				free_columns ^= curr_column;
				//当占用col列，下一行的col+1列禁用,再下一行的col+2禁用，以此类推 即(hills | curr_column) << 1
				//当占用col列，下一行的col-1列禁用即(dales | curr_column) >> 1
				count = backtrack(row + 1,
						(hills | curr_column) << 1,
						next_row | curr_column,
						(dales | curr_column) >> 1,
						count, n);
			}
		}
		return count;
	}

	public int totalNQueens(int n) {
		if (n==0) return 1;
		return backtrack(0,0,0,0,0,n);
	}


}
