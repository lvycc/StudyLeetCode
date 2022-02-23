package com.ycc.study_first_time;

/**
 * @author ycc
 * @date 2022/2/21
 * @desc
 */
public class LeetCode_02_两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l4= l1;
        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 开始先创建一个头节点，其实并不用来存储数据，只为了生成双指针
        ListNode head = new ListNode(-1);
        // 用于存储进位的数据
        int upgrade = 0;
        // 创建双指针用于迭代
        ListNode current = head;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + upgrade;
            upgrade = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (upgrade > 0) {
            current.next = new ListNode(upgrade);
        }
        return head.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
