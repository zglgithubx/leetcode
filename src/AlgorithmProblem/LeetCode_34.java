package AlgorithmProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AlgorithmProblem.LeetCode_34
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/01 09:56
 */
public class LeetCode_34 {
	public int[] searchRange(int[] nums, int target) {
		int[] res=new int[2];
		res[0]=-1;
		res[1]=-1;


		int l=0,r=nums.length;
		if(r==0){
			return res;
		}
		while(l<r){
			int m=(r-l)/2+l;
			if(nums[m]>=target){
				r=m;
			}else{
				l=m+1;
			}
		}
		List<Integer> list=new ArrayList<>();
		for(int i=l+1;i<nums.length;i++){
			if(nums[i]==target){
				list.add(i);
			}
		}
		if(l<nums.length){
			res[0]=nums[l]==target?l:-1;
			if(list.size()==0){
				if(nums[l]==target){
					res[1]=l;
				}
			}else{
				res[1]=list.get(list.size()-1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums={2,2};
		new LeetCode_34().searchRange(nums,3);

	}
}
