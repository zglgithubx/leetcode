package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName LeetCode_93
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/07/27 17:25
 */
public class LeetCode_93 {
	public static void main(String[] args) {
		new LeetCode_93().restoreIpAddresses("101023");
	}
	public List<String> restoreIpAddresses(String s) {
		List<String> res=new ArrayList<>();
		//判断长度
		if(s.length()<4){
			return res;
		}
		//判断特殊情况
		if("0000".equals(s)){
			res.add("0.0.0.0");
			return res;
		}
		dfs(s,0,0,res,new ArrayList<>(),new HashSet<>());
		System.out.println(res);
		return res;
	}
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description
	 * 回溯：
	 * step：代表步数，对字符串截取的次数
	 * index：代表截取的位置索引
	 * res：结果集
	 * re：中间结果集合
	 * used：备忘录
	 * @Date 2022/07/28 10:23
	 * @Param [s, step, index, res, re, used]
	 * @return void
	 */
	public void dfs(String s, int step, int index, List<String> res, List<String> re, Set<String> used){
		//当截取次数为4，代表已经截取四次，结束回溯
		if(step==4){
			String r =re.toString();
			if(used.add(r)){
				r=r.replace("\"","").replace("[","").replace("]","").replace(",",".").replace(" ","");
				res.add(r);
			}
			return;
		}
		//循环次数为3次代表，最多能取3位数字
		for(int i=1;i<=3;i++){
			String substring = null;
			if(index+i<=s.length()){
				substring=s.substring(index, index + i);
			}
			//最后一次截取时，此时应该截取后部分所有的字符
			if(step==3){
				substring= s.substring(index);
			}
			//如果未进行截取，所有长度长度超出字符串的最大长度，结束循环
			if(substring==null||"".equals(substring)){
				break;
			}

			int len = substring.length();
			//判断截取的长度
			if(len>3){
				break;
			}
			int sub=Integer.parseInt(substring);
			//判断截取后的数字大小，不能超过255
			if(sub>255){
				break;
			}
			//排除012，011等不符合规范的数字
			if(Integer.parseInt(String.valueOf(substring.charAt(0)))==0&&len>1){
				break;
			}
			re.add(substring);
			dfs(s,step+1,index+i,res,re,used);
			re.remove(re.size()-1);
		}
	}


}
