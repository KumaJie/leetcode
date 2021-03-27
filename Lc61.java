package leetcode;

/**
 * @author Kuma
 * @date 2021年3月27日
 * 61.旋转链表
 */
public class Lc61 {
    public ListNode rotateRight(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode tail = dummy;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }
        tail.next = dummy.next;
        int count = len - k % len;
        tail = dummy;
        for (int i = 0; i < count; i++) {
            tail = tail.next;
        }
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}
