package AlgorithmProblem;

/**
 * @ClassName AlgorithmProblem.LeetCode_24
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/21 09:15
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class LeetCode_24 {
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 递归解法
	 * 例如：1——>2——>3——>4
	 * 终止条件：当前节点为null，或者下一个节点为 null
	 * 函数内：将 2 指向 1，1 指向下一层的递归函数，最后返回节点 2
	 * @Date 2022/06/21 09:16
	 * @Param [head]
	 * @return AlgorithmProblem.ListNode
	 */
	public ListNode swapPairs(ListNode head) {
		//判断是否终止
		if (head == null || head.next == null) {
			return head;
		}
		//暂时保存第2节点
		ListNode newHead = head.next;
		//使第1个节点指向下一层的递归函数
		head.next = swapPairs(newHead.next);
		//使第2个节点指向1
		newHead.next = head;
		return newHead;
	}

	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 迭代解法
	 * 例如：1——>2——>3——>4
	 * 创建虚拟头节点0，将0指向head，得到0——>1——>2——>3——>4
	 * 将0指向2，将1指向3，将2指向1
	 * 返回虚拟头结点的下一个节点
	 * @Date 2022/06/21 09:19
	 * @Param [head]
	 * @return AlgorithmProblem.ListNode
	 */
	public ListNode swapPairs1(ListNode head) {
		//创建虚拟头节点0
		ListNode dummy=new ListNode(0);
		//将0指向head
		dummy.next=head;
		//新建一个移动节点temp，初始值为虚拟头节点
		ListNode temp=dummy;
		//循环结束条件，下一个节点为空&&下下一个节点为空
		while(temp.next!=null&&temp.next.next!=null){
			//保存节点1
			ListNode node1=temp.next;
			//保存节点2
			ListNode node2=temp.next.next;
			//将虚拟头节点指向节点2，0——>2
			temp.next=node2;
			//将节点1指向节点3，1——>3
			node1.next=node2.next;
			//将节点2指向节点1，2——>1
			node2.next=node1;
			//此时节点顺序为：0——>2——>1——>3——>4
			//移动节点temp到节点1，执行下一循环
			temp=node1;

		}
		return dummy.next;

	}

}
