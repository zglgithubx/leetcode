/**
 * @ClassName Main
 * @Description TODO
 * @Author ZhuGuangLiang
 * @Date 2021/10/13 12:00
 */
import java.util.*;
public class Main {
    static int res=0;
    /**
     * @Author ZhuGuangLiang
     * @Description 利用回溯+栈
     * @Date 17:10 2021/10/17
     * @Param [index, k, nums, re, now]
     * index：记录每次取的数的数量，初始值为0，当index==k时代表，已经取了k个数字
     * k：题目中要求用的数的总量
     * nums：题目中输入的所有数
     * re：代表在每次取完之前的所有数之和
     * now：代表每次取的数在nums数组中的索引
     * @return void
     */
    public static void back2(int index, int k,int[] nums,Stack<Integer> re,int now){
        if(index==k){
            //此时栈中存的数为k个数的和
            int x=re.peek();
            //下面的步骤是为了验证该数是否为素数
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
                //把栈的数取出后和新加入的数相加，再重新加入到栈中
                re.push(nums[i]+(re.empty()?0:re.pop()));
                //进入下次循环
                back2(index+1,k,nums,re,i+1);
                //因为回溯之后，需要重新选择，需要把栈中的数取出，和当前的数相减再加入到栈中
                re.push(re.pop()-nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
                System.out.println(nums[i]);
            }
            back2(0,k,nums, new Stack<>(),0);
            System.out.println(res);
    }
}
