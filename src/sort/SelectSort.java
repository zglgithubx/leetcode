package sort;

/**
 * @ClassName SelectSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/04/12 20:50
 */
public class SelectSort {
//	首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
//	再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
//	重复第二步，直到所有元素均排序完毕。
	public int[] selectSort(int[] noSort){
		for(int i=0;i<noSort.length;i++){
			for(int j=i;j<noSort.length;j++){
				int right=noSort[j];
				int left=noSort[i];
				int mid=left;
				if(left>right){

				}

			}
		}
		return null;
	}
}
