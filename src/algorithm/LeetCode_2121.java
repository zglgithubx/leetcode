package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AlgorithmProblem.LeetCode_2121
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/15 21:02
 */
public class LeetCode_2121 {
	public long[] getDistances(int[] arr) {
		Map<Integer, List<Integer>> map=new HashMap<>();
		long[] result=new long[arr.length];
		for(int i=0;i<arr.length;i++){
			List<Integer> list;
			if(map.containsKey(arr[i])){
				list=map.get(arr[i]);
			}else{
				list=new ArrayList<>();
			}
			list.add(i);
			map.put(arr[i],new ArrayList<>(list));
		}
		for(int i=0;i<arr.length;i++){
			List<Integer> curIndex=map.get(arr[i]);
			long res=0L;

			for(Integer j:curIndex){
				int cur=i-j;
				cur=cur>=0?cur:cur*(-1);
				res+=cur+0L;
			}
			result[i]=res;

		}
		return result;
	}

	public static void main(String[] args) {
		int[] x={2,1,3,1,2,3,3};
		new LeetCode_2121().getDistances(x);
	}
}
