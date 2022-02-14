package Offer;

import java.util.HashMap;

/**
 * @ClassName Offer_35
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/12 12:00
 * 学习的视频地址：https://www.bilibili.com/video/BV1XE411L7CK?from=search&seid=11698283874163657659&spm_id_from=333.337.0.0
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_35 {
	public Node copyRandomList(Node head) {
		Node cur=head;

		HashMap<Node,Node> map=new HashMap<>();
		//第一次遍历将head链表所有元素存到哈希表
		while(cur!=null){
			map.put(cur,new Node(cur.val));
			cur=cur.next;
		}
		//将cur回到head指针
		cur=head;
		//再次遍历建立节点之间的关系
		while(cur!=null){
			//map.get()代表复制之后的链表节点
			map.get(cur).next=map.get(cur.next);
			map.get(cur).random=map.get(cur.random);
			cur=cur.next;
		}
		return map.get(head);
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
