package algorithm;

/**
 * @ClassName Leet
 * @Description
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author ZhuGuangLiang
 * @Date 2021/11/04 10:19
 */
public class LeetCode_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,tail=null;
        int middle=0;
        while (l1!=null||l2!=null){
            int lo=l1!=null?l1.val:0;
            int lt=l2!=null?l2.val:0;
            int sum=lo+lt+middle;
            if(head==null){
                head=tail=new ListNode(sum%10);
            }else{
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            middle=sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(middle>0){
            tail.next=new ListNode(middle);
        }
        return head;

    }

    public static void main(String[] args) {

        new LeetCode_2();
    }
}

