package leetcode;

import java.util.List;

/**
 * @author Kuma
 * @date 2021年3月18日
 * 92. 反转链表 II
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Lc92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail;
        ListNode next;
        ListNode cur;
        int count = 1;
        while (pre.next != null && count < left){
            pre = pre.next;
            count++;
        }
        cur = pre.next;
        tail = cur;
        while (cur != null && count <= right){
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            tail.next = next;
            cur = next;
            count++;
        }
        return dummy.next;
    }
}
