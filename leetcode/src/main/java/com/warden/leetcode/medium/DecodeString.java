package com.warden.leetcode.medium;

import java.net.InetAddress;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/28
 */
public class DecodeString {

	public static void main(String[] args) {
		String s = "4[ab]3[cd2[e]]";
		System.out.println(new DecodeString().decodeString(s));
	}

	public String decodeString(String s) {
		return  helper(s,0);
	}

	private int curIndex;
	public String helper(String data,int index){
		StringBuilder res=new StringBuilder();
		int time=0;
		while (index<data.length()){
			char ch=data.charAt(index);
			if (ch>='0'&&ch<='9')
				time=time*10+ch-'0';
			else if (ch=='['){//递归开始
				String item=helper(data,index+1);
				while (time>0) {
					res.append(item);
					time--;
				}
				index=curIndex;
			}else if (ch==']'){
				curIndex=index;
				return res.toString();
			}else {
				res.append(data.charAt(index));
			}
			++index;
		}
		return res.toString();
	}
}
