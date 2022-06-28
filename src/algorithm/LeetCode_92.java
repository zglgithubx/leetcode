package algorithm;

/**
 * @ClassName LeetCode_92
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/27 21:54
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_92 {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy=new ListNode(-1,head);
		ListNode cur=dummy;
		int index=1;
		int len=right-left;
		//间隔为0
		if(len==0){
			return head;
		}
		while(cur.next!=null){
			ListNode pre=cur;
			cur=cur.next;

			//间隔为1
			if(len==1&&index==left){
				int temp=cur.val;
				cur.val=cur.next.val;
				cur.next.val=temp;
				break;
			}else if(index==left){
				ListNode mid=new ListNode(-1,cur);
				ListNode last=null;
				ListNode temp=mid;
				while(temp.next!=null){
					temp=temp.next;
					if(index==right){
						if(temp.next!=null){
							last=temp.next;
						}
						temp.next=null;
						break;
					}
					index++;
				}
				mid=mid.next;
				mid=exchange(mid);
				ListNode newMid=mid;
				while(newMid.next!=null){
					newMid=newMid.next;
				}
				newMid.next=last;
				pre.next=mid;
				break;
			}
			index++;
		}
		return dummy.next;
	}
	public ListNode exchange(ListNode head){
		ListNode res=null;
		while(head!=null){
			res=new ListNode(head.val,res);
			head=head.next;
		}
		return res;
	}


	public ListNode reverseBetween1(ListNode head, int left, int right) {
		ListNode dummy=new ListNode(-1,head);
		ListNode cur=dummy;
		int index=1;
		int len=right-left;
		//间隔为0
		if(len==0){
			return head;
		}
		while(cur.next!=null){
			ListNode pre=cur;
			cur=cur.next;
			//间隔为1
			if(len==1&&index==left){
				int temp=cur.val;
				cur.val=cur.next.val;
				cur.next.val=temp;
				break;
			}else if(index==left){
				//开始反转区间内的节点
				//创建新动态指针last
				ListNode last=cur;
				//创建nm作为反转后的链表
				ListNode nm=null;
				while(index<=right){
					nm=new ListNode(last.val,nm);
					last=last.next;
					index++;
				}
				//创建node标记链表头节点
				ListNode node=nm;
				//遍历nm,将其作为移动节点，移到链表末尾
				while(nm.next!=null){
					nm=nm.next;
				}
				//将nm和链表last连接
				nm.next=last;
				//将首部和中间链表连接
				pre.next=node;
				break;
			}
			index++;
		}
		return dummy.next;
	}



}
