package Offer;

import java.util.Stack;

/**
 * @ClassName Offer_35
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/12 12:00
 */
public class Offer_35 {
	public Node copyRandomList(Node head) {
		if(head==null){
			return null;
		}
		Node result=new Node(head.val);
		while (head.next !=null) {
			result.next=head.next;
			result.val=head.val;
			result.random=head.random;
		}
		Stack<Integer> stack=new Stack<>();
		stack.empty();
		return result;

	}
}
class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
