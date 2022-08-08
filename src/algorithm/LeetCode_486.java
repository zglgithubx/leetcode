package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_486
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/04 10:37
 */
public class LeetCode_486 {
	public static void main(String[] args) {
		int x=2<<3;
		System.out.println(x);
	}
	public boolean PredictTheWinner(int[] nums) {
		List<Integer> list=new ArrayList<>();
		for(int i:nums){
			list.add(i);
		}
		if(nums.length%2==0){
			return true;
		}
		return dfs1(list,0,0,0);
	}
	public boolean dfs1(List<Integer> list,int a,int b,int step){
//		System.out.println(a+","+b);
		if(list.size()==0){
			System.out.println(a+","+b);
			return a>=b;
		}
		int f=list.get(0);
		int l=0;
		if(list.size()>1){
			l=list.get(list.size()-1);
		}
		if(step==0){
			if(f>=l){
				list.remove(0);
				return dfs1(list,a+f,b,step+1);
			}else{
				list.remove(list.size()-1);
				return dfs1(list,a+l,b,step+1);
			}
		}else{
			List<Integer> newList=new ArrayList<>(list);
			newList.remove(0);
			if(!dfs1(newList,a,b+f,0)){
				list.remove(list.size()-1);
				return dfs1(list,a,b+l,0);
			}else{
				return true;
			}
		}
	}

}
