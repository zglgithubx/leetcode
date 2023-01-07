package method;

/**
 * @ClassName DynamicPlanning
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2023/01/06 21:33
 */
public class DynamicPlanning {

}
class Test1{
	public static void main(String[] args) {
		Test1 test1=new Test1();
		test1.test();


	}
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description
	 * 机器人从开始位置到目标位置有几种方式：
	 * 假如有：1，2，3，4，5，6，7这些位置。
	 * 假如机器人初始位置在4，目标为7，机器人用4步移动到目标有几种方式。
	 * 条件：在边界位置的机器人只能往内部移动
	 * @Date 2023/01/06 21:34
	 * @Param []
	 * @return void
	 *
	 */
	public void test(){
		int n=4;
		int start=2;
		int target=4;
		int k=4;
		int res=back(start,k,target,n);
		System.out.println(res);
	}

	//cur:当前位置，sur:还差几步完成，target:目标，n:总步数
	public int back(int cur,int sur,int target,int n){
		if(sur==0){
			return cur==target?1:0;
		}
		if(cur==1){
			return back(cur+1,sur-1,target,n);
		}
		if(cur==n){
			return back(cur-1,sur-1,target,n);
		}
		return back(cur+1,sur-1,target,n)+back(cur-1,sur-1,target,n);

	}
}
