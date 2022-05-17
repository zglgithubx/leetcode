package datastructure;

/**
 * @ClassName LeetCode_19
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/16 16:36
 */
public class LeetCode_19 {
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 移除倒数第n个节点
	 * @Date 2022/02/17 08:45
	 * @Param [head, n]
	 * @return DataStructure.ListNode
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//定义一个0为虚拟头节点在链表的头节点前面
		ListNode dummy = new ListNode(0, head);
		int length = getLength(head);
		ListNode cur = dummy;
		//遍历前length-n个节点
		for (int i = 0; i < length - n; i++) {
			cur = cur.next;
		}
		//遍历之后，将当前节点的next指针指向当前节点的下下节点
		cur.next = cur.next.next;
		//返回虚拟头节点的下一节点就是头节点
		return dummy.next;
	}

	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 获取链表的长度
	 * @Date 2022/02/17 08:44
	 * @Param [head]
	 * @return int
	 */
	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			++length;
			head = head.next;
		}
		return length;
	}


}
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val = val;
	}
	public ListNode(int val, datastructure.ListNode node){
		this.val = val;
		this.next=node;
	}
}

