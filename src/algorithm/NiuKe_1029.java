package algorithm;

import java.util.*;

/**
 * @ClassName AlgorithmProblem.NiuKe_1029
 * @Description
 * 链接：https://ac.nowcoder.com/acm/contest/18874/1029
 * 来源：牛客网
 *
 * 已知 n 个整数 x1,x2,…,xn，以及一个整数 k（k＜n）。从 n 个整数中任选 k 个整数相加，可分别得到一系列的和。例如当 n=4，k＝3，4 个整数分别为 3，7，12，19 时，可得全部的组合与它们的和为：
 * 3＋7＋12=22　　3＋7＋19＝29　　7＋12＋19＝38　　3＋12＋19＝34。
 * 现在，要求你计算出和为素数共有多少种。
 * 例如上例，只有一种的和为素数：3＋7＋19＝29）。
 * 输入
 * 4 3
 * 3 7 12 19
 *
 * 输出
 * 1
 *
 * @Author ZhuGuangLiang
 * @Date 2021/10/12 21:47
 */
public class NiuKe_1029 {

    public void back1(int index, int k,int[] nums,Stack<Integer> re, List<Integer> res){
        if(index==k){
            int x=0;
            for(int i:re){
                x+=i;
            }
            res.add(x);
        }else{
            int in=re.empty()?0: Arrays.binarySearch(nums,re.peek());
            for(int i=in;i<nums.length;i++){
                if(re.contains(nums[i])){
                    continue;
                }
                re.push(nums[i]);
                back1(index+1,k,nums,re,res);
                re.pop();
            }
        }
    }
    public void back2(int index, int k,int[] nums,Stack<Integer> re, List<Integer> res,List<Integer> used){
        if(index==k){
            res.add(re.peek());
        }else{
            int in=re.empty()?0: Arrays.binarySearch(nums,used.get(used.size()-1));
            for(int i=in;i<nums.length;i++){
                if(used.contains(nums[i])){
                    continue;
                }
                re.push(nums[i]+(re.empty()?0:re.pop()));
                used.add(nums[i]);
                back2(index+1,k,nums,re,res,used);
                used.remove(used.size()-1);
                re.push(re.pop()-nums[i]);
            }
        }
    }
    static int res=0;
    public static void back3(int index, int k,int[] nums,Stack<Integer> re,int now){
        if(index==k){
            int x=re.peek();
            boolean is=true;
            for(int i=2;i<x;i++){
                if(x%i==0){
                    is=false;
                    break;
                }
            }
            if(is){
                res++;
            }
        }else{
            for(int i=now;i<nums.length;i++){
                re.push(nums[i]+(re.empty()?0:re.pop()));
                back3(index+1,k,nums,re,i+1);
                re.push(re.pop()-nums[i]);
            }
        }
    }
}
