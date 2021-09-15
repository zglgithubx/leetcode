import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName No15
 * @Description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zhuguangliang
 * @Date 2021/09/14 21:55
 **/
public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(nums,new ArrayList<>(),new ArrayList<>(),list);
        //将list集合进行去重
        List<List<Integer>> newList=list.stream().distinct().collect(Collectors.toList());
        return newList;
    }
    /**
     * @Author zhuguangliang
     * @Description 用递归的方式，将所有组合排列出来，然后再进行筛选过滤
     * @Date 20:58 2021/09/15
     * @Param [nums, used, track, res]
     * nums：题目提供的数组
     * user：记录使用nums元素的索引
     * track：每种组合
     * res：结果集合
     * @return void
     **/
    public void backTrack(int[] nums,List<Integer> used, List<Integer> track,List<List<Integer>> res){
        //递归结束条件，如果track的长度为3，说明已经有一个组合生成了
        if(track.size()==3){
            //检查该组合是否符合条件：集合元素之和为0
            if(check(track)){
                List<Integer> list=new ArrayList<>(track);
                Collections.sort(list);
                res.add(list);
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            //如果发现，nums中某个索引，已经加入了组合中，将排除这种选择
            if(used.contains(i)){
                continue;
            }
            //将nums的元素加入到track中
            track.add(nums[i]);
            //将nums的索引，记录在used中，代表这个索引已经使用过
            used.add(i);
            //进入下一层递归
            backTrack(nums,used,track, res);
            //从递归中跳出后，将会继续上一层的下一选择，将used中最后一个移除
            used.remove(used.size()-1);
            //将track中最后一个元素移除，进入下一个选择
            track.remove(track.size()-1);
        }
    }
    /**
     * @Author zhuguangliang
     * @Description 判断list集合是否符合条件
     * @Date 21:12 2021/09/15
     * @Param [list]
     * @return boolean
     **/
    public boolean check(List<Integer> list){
        int sum=0;
        for(Integer integer:list){
            sum+=integer;
        }
        return sum==0;
    }
}
