package algorithm;

/**
 * @ClassName LeetCode_50
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/01 17:03
 */
public class LeetCode_50 {
	 public double myPow1(double x, int n) {
	     double res=1.00000;
	     if(n==0||x==res){
	         return res;
	     }
	     if(x*-1==res){
	         return n%2==0?1:-1;
	     }
	     if(n==-2147483648||x==0){
	         return res*0;
	     }
	     int len=n<0?n*-1:n;
		 for(int i=0;i<len;i++){
			 res=res*x;
		 }
	     return n<0?1.0/res:res;
	 }
	public double myPow(double x, int n) {
		long N = n;
		return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	}

	public double quickMul(double x, long N) {
		if (N == 0) {
			return 1.0;
		}
		double y = quickMul(x, N / 2);
		return N % 2 == 0 ? y * y : y * y * x;
	}
}
