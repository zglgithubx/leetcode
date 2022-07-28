package test;

/**
 * @ClassName Test
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/07/26 11:14
 */
public class Test extends Locks{
	private int num;
	private String str;
	public Test(){};
	public Test(String str){
		this.str=str;
	}
	public String test(){
		return this.str;
	}

	public static void main(String[] args) {
		new Test();
	}
}
