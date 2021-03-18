package leetcode;

import java.util.List;

/**
 * @author Kuma
 * @date 2021年3月18日
 * 206. 反转链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode tail = cur;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            tail.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
