package method;

/**
 * @ClassName dichotomy
 * @Description 二分法查找学习
 * @Author ZhuGuangLiang
 * @Date 2021/10/14 11:15
 */
public class Dichotomy {
    /*
     * @Author ZhuGuangLiang
     * @Description 此法可以寻找第一次匹配到目标的下标即左边界
     * @Date 15:35 2021/10/14
     * @Param [nums, target]
     * @return int
     **/
    int binarySearchLeft(int[] nums,int target){
        //定义为左闭右开
        int left=0,right=nums.length;
        //结束循环的条件为left==right
        while(left<right){
            int mid=left+(right-left)/2;
            //如果匹配到目标值，右边界向左移动
            if(nums[mid]==target){
                right=mid;
            //如果大于目标值，右边界移动到中间
            }else if(nums[mid]>target){
                right=mid;
            //如果小于目标值，左边界移动到中间的位置+1的索引
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return left;
    }
    /*
     * @Author ZhuGuangLiang
     * @Description 此法可以寻找中最后一次匹配到目标的索引
     * @Date 15:38 2021/10/14
     * @Param [nums, target]
     * @return int
     **/
    int binarySearchRight(int[] nums,int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            //如果匹配到目标，左边界向右移动，
            if(nums[mid]==target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,2,3};
        int target=2;
        int result=new Dichotomy().binarySearchLeft(nums,target);
        System.out.println(result);
    }

}
