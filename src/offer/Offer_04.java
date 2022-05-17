package offer;

/**
 * @ClassName Offer_04
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/15 09:18
 */
public class Offer_04 {
	public boolean findNumberIn2DArray1(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = 0, column =  matrix[0].length - 1;
		while (row < matrix.length && column >= 0) {
			int num = matrix[row][column];
			if (num == target) {
				return true;
			} else if (num > target) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix.length==0){
			return false;
		}
		int startX=matrix.length-1;
		int startY=matrix[0].length-1;
		for(int i=matrix.length-1;i>-1;i--){
			if(matrix[i][0]>=target&&matrix[i][matrix[i].length-1]<=target){
				startX=i;
				startY=matrix[i].length-1;
			}
		}
		return back(matrix,target,startX,startY);
	}

	public boolean back(int[][] matrix,int target,int x,int y){
		if(x>-1&&y>-1){
			int cur=matrix[x][y];
			if(cur==target){
				return true;
			}
			return back(matrix,target,x,y-1)||back(matrix,target,x-1,y);
		}
		return false;
	}

	public static void main(String[] args) {
//		int[][] matrix= {
//				{1,2,3,4,5},
//				{6,7,8,9,10},
//				{11,12,13,14,15},
//				{16,17,18,19,20},
//				{21,22,23,24,25}};
//		int[][] matrix={{1,2}};
		int[][] matrix= {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}};
		boolean numberIn2DArray = new Offer_04().findNumberIn2DArray(matrix, 5);
		System.out.println(numberIn2DArray);
	}
}
