package leetcode;

/**
 * @author Kuma
 * @date 2021年3月25日
 * 82. 删除排序链表中的重复元素 II
 */
public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            ListNode next = head.next;
            while (next != null && next.val == head.val){
                next = next.next;
            }
            return deleteDuplicates(next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;

    }
}
