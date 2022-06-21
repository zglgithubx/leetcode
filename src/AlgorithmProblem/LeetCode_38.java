package AlgorithmProblem;

/**
 * @ClassName AlgorithmProblem.LeetCode_38
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/20 20:42
 */
public class LeetCode_38 {
	public String countAndSay(int n) {
		String s= String.valueOf(1);
		return back(n,1,s);

	}
	public String back(int n,int index,String s){
		if(index>n-1){
			return s;
		}
		char[] chars=s.toCharArray();
		char curChar=chars[0];
		int count=0;
		StringBuilder newStr=new StringBuilder();
		for(int i=0;i<chars.length;i++){
			if(curChar==chars[i]){
				count++;
				if(i==chars.length-1){
					newStr.append(count).append(curChar);
				}
			}else{
				newStr.append(count).append(curChar);
				curChar=chars[i];
				count=0;
				i--;
			}
		}
		return back(n,index+1,newStr.toString());
	}

	public static void main(String[] args) {
		String res=new LeetCode_38().countAndSay(5);
		System.out.println(res);
	}
}
