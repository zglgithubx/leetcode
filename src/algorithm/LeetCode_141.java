package algorithm;
/**
 * @ClassName LeetCode_141
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/15 19:50
 */
public class LeetCode_141 {
	public boolean hasCycle(ListNode head) {
		ListNode fast=head;
		ListNode solw=head;
		if(head==null){
			return false;
		}
		while(solw.next!=null&&fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			solw=solw.next;
			if(fast==solw){
				return true;
			}
		}
		return false;
	}
}

