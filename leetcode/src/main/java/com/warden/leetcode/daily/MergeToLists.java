package com.warden.leetcode.daily;

import com.warden.leetcode.common.struct.ListNode;
import com.warden.leetcode.common.struct.Node;

/**
 * Created by Administrator on 2020/5/1 0001.
 */
public class MergeToLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode first = result;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                result.next = l2;
                l2 = l2.next;
            } else {
                result.next = l1;
                l1 = l1.next;
            }
            result = result.next;
        }
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }
        return first.next;
    }

}
