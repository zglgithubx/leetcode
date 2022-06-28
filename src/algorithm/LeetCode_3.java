package algorithm;

import java.util.Arrays;

/**
 * @ClassName AlgorithmProblem.LeetCode_3
 * @Description TODO
 * @Author ZhuGuangLiang
 * @Date 2021/11/09 15:46
 */
public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        int l=s.length();
        //判断为单字符的时候，直接返回1
        if(l==1){
            return 1;
        }
        //定义一个窗口
        int[] window=new int[128];
        //定义两个指针
        int left=0,right=0;
        //定义子串的最大长度
        int m=0;
        while(right<l){
            char c=s.charAt(right);
            //如果当前的字符第一次进入窗口
            if(window[c]==0){
                //进入窗口并记录当前的次数
                window[c]++;
                //扩大窗口
                right++;
                //刷新子串最大长度
                m= Math.max(right - left, m);
                continue;
            }
            //如果发现重复字符，移动窗口
            left++;
            //更新right,从最左边开始
            right=left;
            //重置窗口的所有值。
            Arrays.fill(window, 0);
        }
        return m;
    }

    public static void main(String[] args) {
        String s="";
        int result=new LeetCode_3().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
