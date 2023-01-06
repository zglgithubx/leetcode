package algorithm;

/**
 * @ClassName LeetCode_566
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/12 08:44
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_566 {
	public int[][] matrixReshape(int[][] mat, int r, int c) {
		//将m,n参数作为二维数组的行数和列数
		int m=mat.length;
		int n=mat[0].length;
		//判断特殊情况
		if(r*c>m*n||r*c<m*n){
			return mat;
		}
		int[][] result=new int[r][c];
		//x/c代表重塑之后的行数，x%c代表重塑之后的列数，x/n代表重塑前的行数，x%n代表重塑前的列数
		for (int x = 0; x < m * n; ++x) {
			result[x / c][x % c] = mat[x / n][x % n];
		}
		return result;
	}
}
