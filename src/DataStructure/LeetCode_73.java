package DataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_73
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/14 21:46
 */
public class LeetCode_73 {
	public void setZeroes(int[][] matrix) {
		Set<Integer> x=new HashSet<>();
		Set<Integer> y=new HashSet<>();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==0){
					x.add(i);
					y.add(j);
				}
			}
		}
		for(int i:x){
			Arrays.fill(matrix[i], 0);
		}
		for(int i=0;i<matrix.length;i++){
			for(int j:y){
				matrix[i][j]=0;
			}
		}

	}
}
