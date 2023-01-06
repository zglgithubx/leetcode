package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode_217
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/09 11:03
 */
public class LeetCode_217 {
	public static void main(String[] args) {

	}
	public boolean containsDuplicate(int[] nums) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int nu:nums){
			if(map.containsKey(nu)){
				return true;
			}
			map.put(nu,0);
		}
		return false;
	}
}
