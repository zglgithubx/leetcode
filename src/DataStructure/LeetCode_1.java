package DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode_1
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/10 09:03
 */
public class LeetCode_1 {
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 用map去存储值和下标，key为值，value为数组下标，遍历整个数组，找到与当前元素和等于目标值得元素，如果没有，则把当前的元素天添加到map中 
	 * @Date 2022/02/10 10:17 
	 * @Param [nums, target]
	 * @return int[]
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map=new HashMap<>();

		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])){
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		return new int[0];
	}

}
