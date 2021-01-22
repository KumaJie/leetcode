package leetcode;

/**
 * @author Kuma
 * @date 2021年1月22日
 * 2.两数相加
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
//        记录链表尾部
        ListNode tail = null;
//        进位
        int carry = 0;
        while (l1 != null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            if (result == null){
                result = new ListNode(sum % 10);
                tail = result;
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return result;
    }
}
