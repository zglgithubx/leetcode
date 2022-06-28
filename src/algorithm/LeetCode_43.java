package algorithm;

/**
 * @ClassName LeetCode_43
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/22 09:20
 */
public class LeetCode_43 {
	public String multiply(String num1, String num2) {
		if(num1.length()<num2.length()){
			String mid=num1;
			num1=num2;
			num2=mid;
		}
		int len1=num1.length();
		int len2=num2.length();

		if(len2==1){
			if("1".equals(num2)){
				return num1;
			}
			if("0".equals(num2)){
				return "0";
			}
		}

		String[] re=new String[len2];
		char[] num1Char=num1.toCharArray();
		char[] num2Char=num2.toCharArray();

		int index=0;
		for(int i=len2-1;i>=0;i--){
			StringBuilder temp=new StringBuilder();
			int cur2=num2Char[i]-48;
			int mid=0;
			for(int j=len1-1;j>=0;j--){
				int cur1=num1Char[j]-'0';
				int cur=cur1*cur2+mid;
				int mod=cur%10;
				mid=cur/10;
				temp.append(mod);
			}
			if(mid>0){
				temp.append(mid);
			}
			temp.reverse();
			for(int m=0;m<index;m++){
				temp.append(0);
			}
			temp.reverse();
			re[index]=temp.toString();
			index++;
		}
		StringBuilder res=new StringBuilder();
		index=0;
		for(int i=0;i<re[len2-1].length();i++){
			int count=0;
			for(String str:re){
				if(i<str.length()){
					count+=str.charAt(i)-'0';
				}
			}
			count+=index;
			res.append(count%10);
			index=count/10;
		}
		if(index>0){
			res.append(index);
		}
		res.reverse();
		return res.toString();
	}

	public static void main(String[] args) {
		String num1="498828660196";
		String num2="840477629533";
		String multiply = new LeetCode_43().multiply(num1, num2);
		System.out.println(multiply);
	}
}
