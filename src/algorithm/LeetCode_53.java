package algorithm;

/**
 * @ClassName LeetCode_53
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/09 21:34
 */
public class LeetCode_53 {
	public int maxSubArray(int[] nums) {
		int len=nums.length;
		int[][] visited=new int[len][len+1];
		int max= nums[0];
		for(int i=0;i<visited.length;i++){
			visited[i]=new int[len-i];
			for(int j=i;j<len;j++){
				int before=0;
				if(i!=0){
					before=visited[i-1][j-i];
				}
				int after=before+nums[j];
				max= Math.max(after, max);
				visited[i][j-i]=after;
			}
		}
		return max;
	}

	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 动态规划解法，记录前一步的最大值，累加到遍历结束
	 * @Date 2022/02/10 08:56
	 * @Param [nums]
	 * @return int
	 */
	public int maxSubArray1(int[] nums) {
		int len=nums.length;
		int[] visited=new int[len];
		visited[0]=nums[0];
		//设置初始值为nums[0],不能设置为0，0大于负数
		int max=nums[0];
		for(int i=1;i<len;i++){
			int pre=visited[i-1];
			visited[i]=pre>0?nums[i]+pre:nums[i];
			max= Math.max(max, visited[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] nums={-2,-1};
		int max=new LeetCode_53().maxSubArray1(nums);
		System.out.println(max);

	}
}
