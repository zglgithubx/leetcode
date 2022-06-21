package AlgorithmProblem;

/**
 * @ClassName AlgorithmProblem.LeetCode_10
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/02 22:20
 */
public class LeetCode_10 {
	public boolean isMatch(String s, String p) {
		char[] charP=p.toCharArray();
		char[] charS=s.toCharArray();
		int used=0;
		for(int i=0;i<charP.length;i++){
			int cur= charP[i];
			switch(cur){
				case 42:
					//匹配到*
					int pre= charP[i - 1];
					if(pre==46){
						return true;
					}else{
						charP[i]=charP[i-1];
						return newP(s,new StringBuffer(String.valueOf(charP)),charS.length-charP.length,charP[i-1]);
					}
				case 46:
					//匹配到.
					used++;
					break;
				default:
					if(charP[i]==charS[i]){
						used++;
					}else{
						return false;
					}
			}
		}
		return used==s.length();
	}
	public boolean newP(String s,StringBuffer n,int diff,char a){
		for(int i=0;i<diff;i++){
			n.append(a);
		}
		for(int i=0;i<n.length();i++){
			int cur=n.charAt(i);
			if(cur!=46){
				if(s.charAt(i)!=n.charAt(i)){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aab", p = "c*a*b";

		boolean match = new LeetCode_10().isMatch(s, p);
		System.out.println(match);
	}
}
