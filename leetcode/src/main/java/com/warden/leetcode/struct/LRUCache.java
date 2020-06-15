package com.warden.leetcode.struct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/25
 */
public class LRUCache {

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(2, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(2));
	}

	private int capacity;

	private Map<Integer, Node> cache;

	private Node first;

	private Node last;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
	}

	public int get(int key) {
		Node value = cache.get(key);
		if (value == null) {
			return -1;
		}
		remove(value);
		addLast(value);
		return value.value;
	}

	public void put(int key, int value) {
		Node v = cache.get(key);
		if (v != null) {
			remove(v);
			cache.remove(v.key);
		} else {
			if (capacity == cache.size()) {
				Node f = removeFirst();
				cache.remove(f.key);
			}
		}
		v = new Node(key, value);
		cache.put(key, v);
		addLast(v);
	}


	private Node removeFirst() {
		Node f = first;
		if (first != null) {
			first = first.next;
		}
		return f;
	}

	public void remove(Node node) {
		Node pre = node.pre;
		Node next = node.next;
		if (pre != null) {
			pre.next = next;
		}
		if (next != null) {
			next.pre = pre;
		}
		if (first == node) {
			first = next;
		}
		if (last == node) {
			last = pre;
		}
		node.next = null;
		node.pre = null;
	}

	private void addLast(Node node) {
		if (last == null) {
			first = node;
			last = node;
			return;
		}
		last.next = node;
		node.pre = last;
		last = node;
	}

}

class Node {

	Node pre;

	Node next;

	Integer key;

	Integer value;

	public Node(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Node node = (Node) o;

		return value != null ? value.equals(node.value) : node.value == null;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}