package algorithm;

/**
 * @ClassName LeetCode_86
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/23 21:54
 */
public class LeetCode_86 {
	public ListNode partition(ListNode head, int x) {

		ListNode dummy=new ListNode(-1,head);
		ListNode cur=dummy;
		while(cur.next!=null){
			if(cur.next.val<x){
				cur=cur.next;
			}else{
				ListNode right=cur.next;
				while(right.next!=null){
					if(right.next.val<x){
						break;
					}
					right=right.next;
				}
				ListNode node1=cur.next;
				ListNode node2=right.next;

				if(node1!=null&&node2!=null){
					cur.next=node2;
					cur=cur.next;
					right.next.next=node1;
					right.next=node2.next;
				}else{
					break;
				}
			}
		}
		return dummy.next;
	}

	public ListNode partition1(ListNode head, int x) {

		ListNode small = new ListNode(0);
		ListNode smallHead = small;
		ListNode large = new ListNode(0);
		ListNode largeHead = large;
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}
		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
	}

}
