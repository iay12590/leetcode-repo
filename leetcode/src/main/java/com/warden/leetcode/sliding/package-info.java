/**
 * 滑动窗口
 * void slidingWindow(string s, string t) {
 *     unordered_map<char, int> need, window;
 *     for (char c : t) need[c]++;
 *     int left = 0, right = 0;
 *     //保存need中以满足条件的个数，避免每次判断都要遍历两个map
 *     int valid = 0;
 *     while (right < s.size()) {
 *         // c 是将移入窗口的字符
 *         char c = s[right];
 *         // 右移窗口
 *         right++;
 *         // 进行窗口内数据的一系列更新
 *         ...
 *         // debug 输出的位置
 *         printf("window: [%d, %d)\n", left, right);
 *         //根据业务判断是否需要缩小窗口
 *		   while (window needs shrink) {
 *		       // d 是将移出窗口的字符
 *		       char d = s[left];
 *		       left++;
 *		       // 进行窗口内数据的一系列更新
 *		       ...
 *		   }
 *     }
 * }
 */
package com.warden.leetcode.sliding;

