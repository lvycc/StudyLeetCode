package com.ycc.study_first_time;

import com.ycc.common.ListNode;

/**
 * @author ycc
 * @date 2022/2/24
 * @desc
 */
public class LeetCode_24_递归_两两交换链表中的节点 {

    /**
     * 递归
     * 先确定终止条件，当前节点为null或者当前节点的下一个节点为null结束
     * 利用中间变量替换位置，递归确定后续节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }

}
