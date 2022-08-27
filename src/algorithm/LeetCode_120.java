package algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode_120
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/27 09:14
 */
public class LeetCode_120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[][] res=new int[triangle.size()][];
		int x=triangle.size();
		for(int i=0;i<x;i++){
			int y=triangle.get(i).size();
			res[i]=new int[y];
			for(int j=0;j<y;j++){
				int top=0;
				int left=0;
				if(i-1>=0){
					int len=triangle.get(i-1).size();

					if(j<len){
						top=triangle.get(i-1).get(j);
					}
					if(j-1<len&&j>0){
						left=triangle.get(i-1).get(j-1);
					}
				}
				int min=Math.min(top,left);
				res[i][j]=triangle.get(i).get(j)+min;
			}
		}
		int[] newRes=res[x-1];
		System.out.println(Arrays.toString(newRes));
		Arrays.sort(newRes);
		return newRes[0];
	}
}
