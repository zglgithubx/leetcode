package algorithm;

import java.util.*;

/**
 * @ClassName LeetCode_40
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/07/19 15:09
 */
public class LeetCode_40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> re = new ArrayDeque<>();
		int len = candidates.length;
		//数组一定要时有序的，才能进行深度递归
		Arrays.sort(candidates);
		//深度递归
		dfs(candidates, len, 0 , target, re, res);
		return res;
	}
	public void dfs(int[] candidates, int len, int index, int target, Deque<Integer> re, List<List<Integer>> res){
		//如果递归到叶子结点，节点值刚好等于0，那说明路径上的元素就是结果
		if(target == 0){
			//将路径上的结果加入返回结果集上
			res.add(new ArrayList<>(re));
			//退出递归
			return;
		}
		for(int i = index;i< len; i++){
			//大剪枝，如果在有序的情况下，当前元素已经大于目标数组元素
			//那说明后面的元素就不在需要遍历，原因后面的元素比当前元素更大。
			if(target- candidates[i] < 0){
				break;
			}
			//小剪枝，发生在同层， 可以自己在图上画一个在第一个节点取1后的几种情况就可以发现
			//如果同层的元素的值，相同，就不在需要递归了，
			//原因在有序的情况下，后面出现的元素都会相同，造成结果集也会相同
			if(i>index && candidates[i] == candidates[i-1]){
				continue;
			}
			//将数组的元素加入路径集合中
			re.addLast(candidates[i]);
			//进行深度递归下一层，所以i+1，
			//这边的重复，允许不同层重复，但是同层不能重复，
			dfs(candidates, len, i+1, target-candidates[i],re,res);
			//剪枝，将元素从末尾开始删除，
			//相当于将树，从叶子结点开始向根结点删除。
			re.removeLast();

		}
	}


	public static void main(String[] args) {
		int[] nums={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int target=30;
		List<List<Integer>> listList = new LeetCode_40().combinationSum2(nums, target);
		System.out.println(listList);
	}
}
