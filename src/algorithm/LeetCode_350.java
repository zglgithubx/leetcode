package algorithm;

import java.util.*;

/**
 * @ClassName LeetCode_350
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/11 09:48
 */
public class LeetCode_350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//将小数组放到map中，遍历大数组
		for (int num : nums1) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		int[] intersection = new int[nums1.length];
		int index = 0;
		//遍历大数组
		for (int num : nums2) {
			int count = map.getOrDefault(num, 0);
			if (count > 0) {
				intersection[index++] = num;
				count--;
				if (count > 0) {
					map.put(num, count);
				} else {
					map.remove(num);
				}
			}
		}
		return Arrays.copyOfRange(intersection, 0, index);
	}
}
