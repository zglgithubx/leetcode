import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode_4
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2021/12/16 10:13
 */
public class LeetCode_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n=nums2.length;
		int[] result;
		if(m==0&&n>0){
			result=nums2.clone();
		}else if(n==0&&m>0){
			result=nums1.clone();
		}else if(m==0&&n==0){
			return 0.00000;
		}else{
			List<Integer> numSet=new ArrayList<>();
			for(int i:nums1){
				numSet.add(i);
			}
			for(int i:nums2){
				numSet.add(i);
			}
			Integer[] res=new Integer[numSet.size()];
			numSet.toArray(res);
			result=new int[m+n];
			for(int i=0;i<res.length;i++){
				result[i]=res[i];
			}
			Arrays.sort(result);
		}
		double mid;
		int resLen=result.length;
		if(resLen%2==0){
			double left=result[resLen/2];
			double right=result[resLen/2-1];
			mid=(left+right)/2;
		}else if(resLen==1){
			mid=result[0];
		}else{
			mid=result[(resLen-1)/2];
		}
		BigDecimal bd=new BigDecimal(mid);
		return bd.setScale(5,BigDecimal.ROUND_DOWN).doubleValue();
	}

	public static void main(String[] args) {
		int[] nums1={0,0};
		int[] nums2={-1,0,1};
		System.out.println(new LeetCode_4().findMedianSortedArrays(nums1,nums2));
	}
}
