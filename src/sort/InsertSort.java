package sort;

/**
 * @ClassName InsertSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/10 21:02
 */

public class InsertSort {

	void insertSort(int[] nums){
		for(int i=0;i<nums.length-1;i++){
			int right=i+1;
			int curI=i;
			while(right>=0&&curI>=0){
				if(nums[right]>=nums[curI]){
					break;
				}
				exchange(nums,curI,right);
				right--;
				curI--;
			}
		}
	}

	public void exchange(int[] nums,int left,int right){
		int mid=nums[left];
		nums[left]=nums[right];
		nums[right]=mid;
	}

	public static void main(String[] args) {
//		InsertSort i=new InsertSort();
//		int[] nums={1,1,1,0};
//		i.insertSort(nums);
	}

}
