/**
 * @ClassName LeetCode_5
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2021/12/17 21:32
 */
public class LeetCode_5 {
	public String longestPalindrome(String s) {
		int l=s.length();
		if(l==1){
			return s;
		}else if(l==2){
			char[] chars=s.toCharArray();
			return chars[0]==chars[1]?s:s.substring(0,1);
		}
		int start = 0;
		int end = 0;
		int max=0;
		for(int i=1;i<l-1;i--){
			start=0;
			end=i;
			while(end<l){
				if(check(s,start,end)){
					max=end-start+1;
					i=max;
					break;
				}
				start++;
				end++;
			}
		}
		return max>0?s.substring(start,start+max):s.substring(0,1);
	}
	public boolean check(String s,int start,int end){
		char[] chars=s.toCharArray();
		int count=end-start+1;
		int time=count%2==0?count/2:(count-1)/2;
		boolean result=true;
		for(int i=0;i<time;i++){
			if(chars[start++]!=chars[end--]){
				result=false;
				break;
			}
		}
		return result;
	}

	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description
	 * 1、遍历字符串
	 * 2、从第一个字符开始，以这个字符为中心，向两边扩散
	 * 3、在扩散的过程中，如果遇到越界直接继续下次循环
	 * @Date 2022/01/11 20:25
	 * @Param [s]
	 * @return java.lang.String
	 */
	Integer max=0;
	public String longestPalindrome1(String s){
		int l=s.length();
		char[] chars=s.toCharArray();
		if(l==1){
			return s;
		}else if(l==2){
			return chars[0]==chars[1]?s:s.substring(0,1);
		}
		String maxStr = "";
		for(int i=1;i<chars.length;i++){
			String res=move(i,chars,s);
			if(res!=null){
				maxStr=res;
			}
		}
		return maxStr;
	}
	public String move(int i,char[] chars,String s){
		int l=chars.length;
		if(i+1==l){
			return null;
		}
		//判断第i个字符旁边的字符和自己是否相同
		if(max==0){
			max=1;
		}
		int start;
		int end;
		if(chars[i]==chars[i+1]){
			//偶数的回文序列
			start=i-max;
			end=i+1+max;
			if(end>=l){
				return null;
			}
			while(i-max>=0&&i+1+max<l){
				if(check(s,start,end)){
					max+=1;
				}else{
					return null;
				}
			}
			return s.substring(i-max+1,i+max+1);
		}else{
			//奇数的回文序列
			start=i-max;
			end=i+max;
			if(end>=l){
				return null;
			}
			while(i-max>=0&&i+max<l){
				if(check(s,start,end)){
					max+=1;
				}else{
					return null;
				}
			}
			return s.substring(i-max+1,i+max);
		}
	}

	public String longestPalindrome2(String s){
		int l=s.length();
		char[] chars=s.toCharArray();
		if(l==1){
			return s;
		}else if(l==2){
			return chars[0]==chars[1]?s:s.substring(0,1);
		}
		String maxStr = "";
		for(int i=0;i<chars.length;i++){
			String res1=getStr(s,i,i+1);
			String res2=getStr(s,i,i);
			maxStr=maxStr.length()>res1.length()?maxStr:res1;
			maxStr=maxStr.length()>res2.length()?maxStr:res2;
		}
		return maxStr;
	}
	public String getStr(String s,int l,int r){
		while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
			l--;
			r++;
		}
		return s.substring(l+1,r);
	}

	public static void main(String[] args) {
		Long start=System.currentTimeMillis();
//		String s="jhgtrclvzumufurdemsogfkpzcwgyepdwucnxrsubrxadnenhvjyglxnhowncsubvdtftccomjufwhjupcuuvelblcdnuchuppqpcujernplvmombpdttfjowcujvxknzbwmdedjydxvwykbbamfnsyzcozlixdgoliddoejurusnrcdbqkfdxsoxxzlhgyiprujvvwgqlzredkwahexewlnvqcwfyahjpeiucnhsdhnxtgizgpqphunlgikogmsffexaeftzhblpdxrxgsmeascmqngmwbotycbjmwrngemxpfakrwcdndanouyhnnrygvntrhcuxgvpgjafijlrewfhqrguwhdepwlxvrakyqgstoyruyzohlvvdhvqmzdsnbtlwctetwyrhhktkhhobsojiyuydknvtxmjewvssegrtmshxuvzcbrabntjqulxkjazrsgbpqnrsxqflvbvzywzetrmoydodrrhnhdzlajzvnkrcylkfmsdode";
		String s="ccc";
		String result=new LeetCode_5().longestPalindrome2(s);
		Long end=System.currentTimeMillis();
		System.out.println("用时："+(end-start)+"ms");
		System.out.println("result:"+result);

	}
}
