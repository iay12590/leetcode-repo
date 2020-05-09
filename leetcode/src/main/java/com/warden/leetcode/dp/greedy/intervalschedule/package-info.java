/**
 * Created by Administrator on 2020/5/4 0004.
 * 区间调度：求给定区间集合最大不相交集合
 * 贪心，排序后总是选end最小的集合
 * 1 按end排序
 * 2 取最小end1，遍历去掉start > end1 的区间
 * 3 取第一个未相加区间，重复2
 */
package com.warden.leetcode.dp.greedy.intervalschedule;