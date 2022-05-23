package sort;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/21 17:04
 */
public class HeapSort {
	void heapify(int[] tree,int n,int i){
		if(i==n){
			return;
		}
		int c1=2*i+1;
		int c2=2*i+2;
		int max=i;
		if(c1<n&&tree[c1]>tree[max]){
			max=c1;
		}
		if(c2<n&&tree[c2]>tree[max]){
			max=c2;
		}
		if(max!=i){
			swap(tree,i,max);
			heapify(tree,n,max);
		}
	}
	void swap(int[] tree,int left,int right){
		int mid=tree[left];
		tree[left]=tree[right];
		tree[right]=mid;
	}

	void buildHeapify(int[] tree,int n){
		int len=(n-2)/2;
		for(int i=len;i>=0;i--){
			heapify(tree,n,i);
		}
	}
	void sort(int[] tree){
		int n=tree.length;
		buildHeapify(tree,n);
		for(int i=n-1;i>=0;i--){
			swap(tree,i,0);
			heapify(tree,i,0);
		}
	}

	public static void main(String[] args) {
		int[] tree ={2,5,3,1,10,4};
		new HeapSort().sort(tree);

		System.out.println(Arrays.toString(tree));


	}


}
