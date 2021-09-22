import java.util.Arrays;

/**
 * @ClassName No322
 * @Description
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zhuguangliang
 * @Date 2021/09/16 21:48
 **/
public class LeetCode_322 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int[] coins={2,5,7,10};
        int amount=14;
        System.out.println(coinChange1(coins,amount));
        long end=System.currentTimeMillis();
        System.out.println("用时："+(end-start)+"ms");
    }
    /**
     * @Author zhuguangliang
     * @Description 此方法是贪心策略，但是没有考虑特殊情况：从最大数值的金额开始取。
     * @Date 17:15 2021/09/19
     * @Param
     * @return
     **/
    public static int coinChange(int[] coins, int amount) {
        //对数组排序
        Arrays.sort(coins);
        //right代表最右边的索引
        int right=coins.length-1;
        //sum硬币最接近amount的金额
        int sum=0;
        int coinSum=0;
        while(sum<amount){
            if(right<0){
                break;
            }
            if((amount-sum)>=coins[right]){
                int count=(amount-sum)/coins[right];
                coinSum+=count;
                sum+=count*coins[right];
            }
            right--;
        }
        System.out.println(sum);
        System.out.println(amount);
        if(sum<amount){
            return -1;
        }
        return coinSum;
    }
    /**
     * @Author zhuguangliang
     * @Description 此方法是迭代数组法，将目标零钱从0开始寻找最优解
     * @Date 20:32 2021/09/19
     * @Param [coins, amount]
     * @return int
     **/
    public static int coinChange1(int[] coins,int amount){
        //创建用来存储0到目标数值的数组，长度为amount+1
        int[] amounts=new int[amount+1];
        //将数组用amount+1填满所有，作为所有每种情况的最大值
                Arrays.fill(amounts,amount+1);
        //        //将第一种情况目标金额为0的时候，结果0
        amounts[0]=0;
        //外层for循环遍历所有状态的所有取值。
        for(int i=0;i<amounts.length;i++){
            //内层for循环在遍历所有选择的最小值
            for(int coin:coins){
                //如果子问题无解，跳过
                if(i-coin<0){
                    continue;
                }
                //amounts[i-coin]+1的目的是，如果刚好有一枚硬币可以组合成该金额，这种情况的结果为1
                amounts[i]=Math.min(amounts[i],1+amounts[i-coin]);
            }
        }
        for(int mount:amounts){
            System.out.println(mount);
        }
        return (amounts[amount]==amount+1)?-1:amounts[amount];
    }
}
