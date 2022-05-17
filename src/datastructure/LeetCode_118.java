package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_118
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/12 08:46
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class LeetCode_118 {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result=new ArrayList<>();

		for(int i=0;i<numRows;i++){
			List<Integer> nums=new ArrayList<>();
			if(i==0){
				nums.add(1);
				result.add(nums);
				continue;
			}
			nums.add(1);
			for(int j=1;j<i;j++){
				int l=result.get(i-1).get(j-1);
				//右上角的位置在其的正上方
				int r=result.get(i-1).get(j);
				nums.add(l+r);
			}
			nums.add(1);
			result.add(nums);

		}

		return result;
	}

}
