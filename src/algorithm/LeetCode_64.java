package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName LeetCode_64
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/24 11:15
 */
public class LeetCode_64 {
	public static void main(String[] args) {
		int[][] grid1 = {{
				1, 3, 1
		}, {
				1, 5, 1
		}, {
				4, 2, 1
		}
		};
		int[][] grid2 = {{
				1, 2, 3}, {
				4, 5, 6}};
		int i = new LeetCode_64().minPathSum1(grid2);
		System.out.println(i);
	}
	public int minPathSum1(int[][] grid){
		int x=grid.length;
		int y=grid[0].length;
		int[][] res=new int[x][y];
		res[0][0]=grid[0][0];

		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(i==0&&j==0){
					continue;
				}
				int left=0,top=0;
				if(j-1>=0){
					left=res[i][j-1];
				}else{
					left=res[i-1][j];
				}
				if(i-1>=0){
					top=res[i-1][j];
				}else{
					top=res[i][j-1];
				}
				res[i][j]=grid[i][j]+Math.min(left,top);
			}
		}

		return res[x-1][y-1];
	}

	public int minPathSum(int[][] grid) {
		List<Integer> res=new ArrayList<>();
		back(grid,0,0,0,res);
		Collections.sort(res);
		return res.get(0);
	}
	public void back(int[][] grid,int x,int y,int count,List<Integer> res){
		if(x==grid.length-1&&y==grid[0].length-1){
			res.add(count+grid[x][y]);
			return;
		}
		if(x<grid.length-1){
			back(grid,x+1,y,count+grid[x][y],res);
		}
		if(y<grid[0].length-1){
			back(grid,x,y+1,count+grid[x][y],res);
		}

	}

}
