package datastructure;

import java.util.Arrays;

/**
 * @ClassName LeeCode_88
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/10 11:48
 */
public class LeeCode_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//判断特殊情况
		if(m==0){
			// System.out.println(nums2);
			//  return;
		}
		if(n==0){
			// System.out.println(nums1);
			// return;
		}
		for(int i=m;i<nums1.length;i++){
			nums1[i]=nums2[i-m];
		}
		Arrays.sort(nums1);
	}
}
