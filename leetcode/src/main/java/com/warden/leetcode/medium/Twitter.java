package com.warden.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/15
 */
public class Twitter {

	Map<Integer, LinkedList<Node>> tweetMap;
	Map<Integer, LinkedList<Integer>> followMap;

	private int order = 0;

	/** Initialize your data structure here. */
	public Twitter() {
		tweetMap = new HashMap<>();
		followMap = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		LinkedList<Node> list = tweetMap.computeIfAbsent(userId, k -> new LinkedList<>());
		if (list.size() == 10) {
			list.removeLast();
		}
		list.addFirst(new Node(tweetId, order++));
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		//多路归并排序
		LinkedList<Integer> list = followMap.get(userId);
		if (list == null || list.size() == 0) {
			return tweetMap.computeIfAbsent(userId, k -> new LinkedList<>()).stream().map(Node::getTweet).collect(Collectors.toList());
		}
		for (Integer followee : list) {

		}
		return  null;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) {
			return;
		}
		LinkedList<Integer> list = followMap.computeIfAbsent(followerId, k -> new LinkedList<>());
		list.add(followeeId);
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		LinkedList<Integer> list = followMap.get(followerId);
		if (list == null) {
			return;
		}
		list.remove((Integer) followeeId);
	}

	private static final class NodeWrapper {

		int size;

		Node first;

		Node last;

		void add(Node node) {

		}

	}

	private static final class Node {
		int order;
		int tweet;

		Node next;

		Node pre;

		public Node(int order, int tweet) {
			this.order = order;
			this.tweet = tweet;
		}

		public int getOrder() {
			return order;
		}

		public int getTweet() {
			return tweet;
		}
	}

}
