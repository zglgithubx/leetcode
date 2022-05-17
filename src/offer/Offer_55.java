package offer;

/**
 * @ClassName Offer_55
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/14 22:37
 */
public class Offer_55 {
	public String reverseLeftWords(String s, int n) {
		StringBuffer result=new StringBuffer();
		char[] chars=s.toCharArray();
		char[] charR=new char[chars.length];
		int len=chars.length;
		for(int i=0;i<chars.length;i++){
			if(i<n){
				charR[len-(n-i)]=chars[i];
			}else{
				charR[i-n]=chars[i];
			}
		}
		for(char c:charR){
			result.append(c);
		}
		return new String(result);
	}
}
