package leetcode;

/**
 * @author Kuma
 * @date 2021年3月27日
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Lc22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }
        int count = len - k;
        tail = head;
        for (int i = 0; i < count; i++) {
            tail = tail.next;
        }
        return tail;
    }
}
