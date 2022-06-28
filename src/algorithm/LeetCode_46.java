package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName No46
 * @Description
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @Author zhuguangliang
 * @Date 2021/09/22 08:30
 **/
public class LeetCode_46 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int[] nums={1,2,3};
        permute(nums);
        long end=System.currentTimeMillis();
        System.out.println("用时："+(end-start)+"ms");
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        back(res,nums,new ArrayList<>());
        for(List<Integer> re:res){
            System.out.println(re.toString());
        }
        System.out.println(res.size());
        return res;
    }
    public static void back(List<List<Integer>> res,int[] nums,List<Integer> re){
        if(re.size()==nums.length){
            //重新创建集合，保证每个结果对象都是唯一的。
            res.add(new ArrayList<>(re));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(re.contains(nums[i])){
                continue;
            }
            re.add(nums[i]);
            back(res,nums,re);
            re.remove(re.size()-1);
        }
    }
}
