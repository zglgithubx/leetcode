package sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/04/13 10:22
 */
public class QuickSort {
	public static void quickSort(int[] arr, int left, int right){
		if (left < right){
			// 把数组分块
			int pivot = partition(arr, left, right);
			System.out.println(Arrays.toString(arr));
			// 基准元素左边递归
			quickSort(arr, left, pivot-1);
			// 基准元素右边递归
			quickSort(arr, pivot+1, right);
		}
	}

	public static int partition(int[] arr, int left, int right){
		int pivot = arr[left];        	// 选取第一个为基准元素
		while(left<right){
			/* 先从右往移动，直到遇见小于 pivot 的元素 */
			while (left<right && arr[right]>=pivot){
				right--;
			}
			arr[left] = arr[right];         // 记录小于 pivot 的值
			/* 再从左往右移动，直到遇见大于 pivot 的元素 */
			while(left<right && arr[left]<=pivot){
				left++;
			}
			arr[right] = arr[left];         // 记录大于 pivot 的值
		}
		arr[left] = pivot;            		// 记录基准元素到当前指针指向的区域
		return left;						// 返回基准元素的索引
	}

	public static void main(String[] args) {
		int[] noSort={2,1,4,3,5};
		quickSort(noSort,0,4);
	}
}
