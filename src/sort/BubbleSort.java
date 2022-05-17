package sort;

/**
 * @ClassName BubbleSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/02 20:16
 * 冒泡排序
 */
public class BubbleSort {
	public void mySort(int[] noSort){
		int l=0;
		int r=noSort.length-1;
		while(l<r){
			int x=noSort[l];
			if(noSort[l]>noSort[r]){
				noSort[l]=noSort[r];
				noSort[r]=x;
			}
			r--;
			if(l==r){
				l++;
				r=noSort.length-1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BubbleSort bubbleSort=new BubbleSort();
		int[] noSort={9,12,24,8,7,6,5,4,3,2,1,0};
		bubbleSort.mySort(noSort);


	}
}
