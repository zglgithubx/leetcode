package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_142
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/16 10:56
 */
public class LeetCode_142 {
	public static void main(String[] args) {

	}
	public ListNode detectCycle(ListNode head) {
		ListNode hea=head;
		Set<ListNode> visited=new HashSet<>();
		while(hea!=null){
			if(visited.contains(hea)){
				return hea;
			}
			visited.add(hea);
			hea=hea.next;
		}
		return null;
	}
	public ListNode detectCycle1(ListNode head) {
		ListNode pos = head;
		Set<ListNode> visited = new HashSet<ListNode>();
		while (pos != null) {
			if (visited.contains(pos)) {
				return pos;
			} else {
				visited.add(pos);
			}
			pos = pos.next;
		}
		return null;
	}

}
