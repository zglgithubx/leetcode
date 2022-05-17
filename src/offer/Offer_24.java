package offer;

import java.util.Stack;

/**
 * @ClassName Offer_24
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/12 16:12
 */
public class Offer_24 {
	public ListNode reverseList(ListNode head) {
		if(head==null){
			return head;
		}
		Stack<Integer> stack=new Stack<>();
		stack.push(head.val);
		while(head.next!=null){
			head=head.next;
			stack.push(head.val);
		}
		stack.push(head.val);
		ListNode result=new ListNode(stack.pop());
		result=result.next;
		while(!stack.empty()){
			result.val=stack.pop();
			result=result.next;
		}
		return result;
	}
	public  ListNode reverseList1(ListNode head) {
		ListNode current = head;
		ListNode pre = null;
		while (current != null) {
			ListNode next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}

	public static void main(String[] args) {

	}
}
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}
