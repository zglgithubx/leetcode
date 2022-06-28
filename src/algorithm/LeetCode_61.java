package algorithm;

/**
 * @ClassName LeetCode_61
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/21 21:12
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class LeetCode_61 {
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 递归解法
	 *
	 * @Date 2022/06/21 21:14
	 * @Param [head, k]
	 * @return AlgorithmProblem.ListNode
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null){
			return head;
		}
		//计算链表长度
		ListNode temp= head;
		int len=1;
		while(temp.next!=null){
			temp=temp.next;
			len++;
		}
		if(len<=1){
			return head;
		}
		//如果长度小于K，出现循环，找到最少的旋转次数
		if(k>=len){
			k%=len;
		}
		//进入递归的旋转链表，每次移动一次
		return rotate(head,k,0);
	}

	public ListNode rotate(ListNode head,int k,int index){
		if(index==k){
			return head;
		}
		//声明temp节点，作为倒数第二个节点
		ListNode temp= head;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		//找到最后一个节点
		ListNode last=temp.next;
		//将倒数第二个节点指向null
		temp.next=null;
		//将最后一个节点指向头部节点
		last.next= head;
		return rotate(last,k,index+1);
	}

	public static void main(String[] args) {
		int x='0'-0;
		System.out.println(x);
	}
}
