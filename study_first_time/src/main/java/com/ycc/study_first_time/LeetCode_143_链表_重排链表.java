package com.ycc.study_first_time;

import com.ycc.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ycc
 * @date 2022/2/24
 * @desc
 */
public class LeetCode_143_链表_重排链表 {

    /**
     * 将链表放入List中，根据List可以根据下标查找的特性进行重新排序
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode pre = head;
        while (pre != null) {
            list.add(pre);
            pre = pre.next;
        }
        int size = list.size();
        ListNode cur = null;
        int endIndex = size - 1;
        for (int i = 0; i <= endIndex; i++) {
            list.get(i).next = list.get(endIndex);
            if (cur != null) {
                cur.next = list.get(i);
            }
            cur = list.get(endIndex);
            endIndex--;
        }
        cur.next = null;
    }

}
