package algorithm;

/**
 * @ClassName LeetCode_45
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/18 10:36
 */
public class LeetCode_45 {
	public static void main(String[] args) {
		int[] ints= {5,9,3,2,1,0,2,3,3,1,0,0};
		int jump = new LeetCode_45().jump(ints);
		System.out.println(jump);
	}

	public int jump(int[] nums) {
		int end = 0;
		int maxPosition = 0;
		int steps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			//找能跳的最远的
			if (i == end) { //遇到边界，就更新边界，并且步数加一
				maxPosition = Math.max(maxPosition, nums[i] + i);
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}
}
