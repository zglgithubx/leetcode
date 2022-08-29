package algorithm;

/**
 * @ClassName LeetCode_97
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/29 11:21
 */
public class LeetCode_97 {
	public static void main(String[] args) {
//		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
//		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		String s1="aa",s2="ab",s3="aaba";
		boolean interleave = new LeetCode_97().isInterleave(s1, s2, s3);
		System.out.println(interleave);
	}
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1=s1.length();
		int len2=s2.length();
		int len3=s3.length();
		if(len1==0){
			return s2.equals(s3);
		}
		if(len2==0){
			return s1.equals(s3);
		}
		if(len1+len2!=len3){
			return false;
		}
		int middleLen=0,i1=0,i2=0;
		boolean isS1=false;
		for(int i=0;i<len3;i++){
			if(middleLen==0){
				char cur1=s1.charAt(i1);
				char cur3=s3.charAt(i);
				if(cur1==cur3){
					isS1=true;
				}
			}
			if(isS1){
				if(middleLen==0){
					while(i1<len1){
						char c1=s1.charAt(i1);
						char c3=s3.charAt(i);
						if(c1==c3){
							middleLen++;
						}else{
							break;
						}
						i1++;
						i++;
					}
					if(middleLen==0){
						return false;
					}
					i--;
					isS1=false;
				}else{
					while(middleLen>0&&i1<len1){
						char c1=s1.charAt(i1);
						char c3=s3.charAt(i);
						if(c1==c3){
							middleLen--;
						}else{
							return false;
						}
						i1++;
						i++;
					}
					i--;
				}
			} else{
				if(middleLen==0){
					while(i2<len2){
						char c2=s2.charAt(i2);
						char c3=s3.charAt(i);
						if(c2==c3){
							middleLen++;
						}else{
							break;
						}
						i2++;
						i++;
					}
					if(middleLen==0){
						return false;
					}
					i--;
					isS1=true;
				}else{
					while(middleLen>0&&i2<len2){
						char c2=s2.charAt(i2);
						char c3=s3.charAt(i);
						if(c2==c3){
							middleLen--;
						}else{
							return false;
						}
						i2++;
						i++;
					}
					i--;
				}
			}
		}
		return true;
	}
}
