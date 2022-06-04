package sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/18 21:13
 */
public class MergeSort {

	static void mergeSort(int[] arr,int[] reg,int start,int end){
		if (start>=end){
			return;
		}
		int len=end-start,mid=(len>>1)+start;
		int start1=start,end1=mid;
		int start2=mid+1,end2=end;
		mergeSort(arr,reg,start1,end1);
		mergeSort(arr,reg,start2,end2);
		int k=start;
		while(start1<=end1&&start2<=end2){
			reg[k++]=arr[start1]<arr[start2]?arr[start1++]:arr[start2++];
		}
		while(start1<=end1){
			reg[k++]=arr[start1++];
		}
		while(start2<=end2){
			reg[k++]=arr[start2++];
		}
		for(k=start;k<=end;k++){
			arr[k]=reg[k];
		}
	}

	public static void main(String[] args) {
		int[] ins={4,1,3,5,6,2};
		int[] reg=new int[ins.length];
		mergeSort(ins,reg,0,ins.length-1);
		System.out.println(Arrays.toString(reg	));
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
