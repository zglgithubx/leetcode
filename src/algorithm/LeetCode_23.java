package algorithm;

/**
 * @ClassName AlgorithmProblem.LeetCode_23
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/19 17:13
 */
public class LeetCode_23 {
	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists,0,lists.length-1);
	}
	public ListNode merge(ListNode[] lists,int l,int r){
		if(l==r){
			return lists[l];
		}
		if(l>r){
			return null;
		}
		int mid=(l+r)>>1;
		return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
	}

	public ListNode mergeTwoLists(ListNode a,ListNode b){
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		ListNode head=new ListNode(0);
		ListNode tail=head,aTail=a,bTail=b;
		while(aTail!=null&&bTail!=null){
			if(aTail.val<bTail.val){
				tail.next=aTail;
				aTail=aTail.next;
			}else{
				tail.next=bTail;
				bTail=bTail.next;
			}
			tail=tail.next;
		}
		tail.next = (aTail != null ? aTail : bTail);
		return head.next;
	}
}
