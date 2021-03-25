package leetcode;

/**
 * @author Kuma
 * @date 2021年3月25日
 * 82. 删除排序链表中的重复元素 II
 */
public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int tmp;
        while (head != null){
            tmp = head.val;
            if (head.next != null && head.next.val == tmp){
                while (head.val == tmp){
                    head = head.next;
                    if (head == null){
                        cur.next = head;
                        break;
                    }
                }
            }else {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
