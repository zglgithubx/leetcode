package algorithm;

import java.util.*;

/**
 * @ClassName LeetCode_39
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/07/13 09:18
 */
public class LeetCode_39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res=new ArrayList<>();
		dfs(res,new ArrayList<>(),candidates,target,0);
		return res;
	}
	public void dfs(List<List<Integer>> res, List<Integer> re,  int[] candidates, int target,int index){
		if(target==0){
			List<Integer> reClone=new ArrayList<>(re);
//			Collections.sort(reClone);
//			if(rset.add(reClone.toString())){
				res.add(new ArrayList<>(reClone));
//			}
			return;
		}
		if(index>candidates.length-1) return;
		//下一步寻找
		dfs(res,re,candidates,target,index+1);

		if(target-candidates[index]>=0){
			re.add(candidates[index]);
			//原地踏步寻找
			dfs(res, re, candidates, target-candidates[index] , index);
			re.remove(re.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates={100,200,4,12};
		int target=200;
		long start=System.currentTimeMillis();
		new LeetCode_39().combinationSum(candidates,target);
		long end=System.currentTimeMillis();
		System.out.println((end-start)+"ms");
	}
}
