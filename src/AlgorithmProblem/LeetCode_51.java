package AlgorithmProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AlgorithmProblem.LeetCode_51
 * @Description TODO
 * @Author zhuguangliang
 * @Date 2021/09/22 09:36
 **/
public class LeetCode_51 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        solveNQueens(4);
        long end=System.currentTimeMillis();
        System.out.println("用时："+(end-start)+"ms");

    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] re=new char[n][n];
        for(char[] r:re){
            Arrays.fill(r,'.');
        }
        List<List<String>> res=new ArrayList<>();
        back(res,re,0);
        for(List<String> list:res){
            System.out.println(list.toString());
        }
        return res;
    }
    /**
     * @Author zhuguangliang
     * @Description 此方法为递归法，方法中的re为准符合条件的棋盘，这个棋盘始终没变，只是其中的元素发生了变动。
     * @Date 15:44 2021/09/22
     * @Param [res, re, row]
     * row为即将摆放皇后的行
     * @return void
     **/
    public static void back(List<List<String>> res,char[][] re,int row){
        //结束循环的条件
       if(row==re.length){
           List<String> list=new ArrayList<>();
           for(char[] r:re){
               list.add(new String(r));
           }
           res.add(list);

           return;
       }
       int n=re.length;
       //对列进行遍历
       for(int col=0;col<n;col++){
           //判断当前坐标是否重复
           if(!isValid(re,row,col)){
               continue;
           }
           //进行选择
           re[row][col]='Q';
           //进入下次循环，此时的行数+1
           back(res,re,row+1);
           //撤销选择
           re[row][col]='.';
       }
    }
    public static boolean isValid(char[][] re,int row,int col){
        int n=re.length;
        //检查列是否有重复的皇后
        for(char[] r:re){
            if(r[col]=='Q'){
                return false;
            }
        }
        //检查右上方是否有重复的皇后
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(re[i][j]=='Q'){
                return false;
            }
        }
        //检查左上方是否有重复的皇后
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(re[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

}
