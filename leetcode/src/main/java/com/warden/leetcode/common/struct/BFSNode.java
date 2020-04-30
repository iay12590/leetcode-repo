package com.warden.leetcode.common.struct;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/29
 */
public class BFSNode implements Node{

	private int value;

	public BFSNode(int value) {
		this.value = value;
	}

	private Node[] neibor;

	public Node[] abj() {
		return neibor;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node[] getNeibor() {
		return neibor;
	}

	public void setNeibor(Node[] neibor) {
		this.neibor = neibor;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
