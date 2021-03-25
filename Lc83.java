package leetcode;

/**
 * @author Kuma
 * @date 2021年3月25日
 * 83. 删除排序链表中的重复元素
 */
public class Lc83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            ListNode next = head.next;
            while (next != null && next.val == head.val){
                next = next.next;
            }
            head.next = deleteDuplicates(next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}