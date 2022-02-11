package DataStructure;

/**
 * @ClassName LeetCode_121
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/11 14:39
 */
public class LeetCode_121 {
	public int maxProfit(int[] prices) {
		int min=0;
		int max=0;
		//用dp存储利润值
		int[] dp=new int[prices.length-1];
		for(int i=1;i<prices.length;i++){
			int x=prices[i]-prices[min];
			if(x<0){
				min=i;
			}else{
				dp[i-1]=x;
			}

		}
		for(int i:dp){
			max=i>max?i:max;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] prices= {7,1,5,3,6,4};
		int result=new LeetCode_121().maxProfit(prices);
		System.out.println(result);
	}
}
