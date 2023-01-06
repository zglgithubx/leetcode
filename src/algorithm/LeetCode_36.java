package algorithm;

import java.util.HashMap;

/**
 * @ClassName LeetCode_36
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/14 10:24
 */
public class LeetCode_36 {
	public boolean isValidSudoku(char[][] board) {
		HashMap<Character,Integer> row;
		HashMap<Character,Integer> col;
		char[][] newBoard=new char[9][9];
		for(int i=0;i<9;i++){
			row=new HashMap<>();
			col=new HashMap<>();
			for(int j=0;j<9;j++){
				char r=board[i][j];
				newBoard[(i/3)*3+j/3][(i%3)*3+j%3]=board[i][j];
				if(r!='.'){
					if(!row.containsKey(r)){
						row.put(r,1);
					}else{
						return false;
					}
				}
				r=board[j][i];
				if(r!='.'){
					if(!col.containsKey(r)){
						col.put(r,1);
					}else{
						return false;
					}
				}
			}
		}
		for(int i=0;i<9;i++){
			row=new HashMap<>();
			for(int j=0;j<9;j++){
				char r=newBoard[i][j];
				if(r!='.'){
					if(!row.containsKey(r)){
						row.put(r,1);
					}else{
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] x={
				{'.','.','.','.','5','.','.','1','.'},
				{'.','4','.','3','.','.','.','.','.'},
				{'.','.','.','.','.','3','.','.','1'},
				{'8','.','.','.','.','.','.','2','.'},
				{'.','.','2','.','7','.','.','.','.'},
				{'.','1','5','.','.','.','.','.','.'},
				{'.','.','.','.','.','2','.','.','.'},
				{'.','2','.','9','.','.','.','.','.'},
				{'.','.','4','.','.','.','.','.','.'}};
		Boolean y=new LeetCode_36().isValidSudoku(x);
		System.out.println(y);
	}

}
