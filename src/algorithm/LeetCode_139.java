package algorithm;

import java.util.*;

/**
 * @ClassName LeetCode_139
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/31 09:54
 */
public class LeetCode_139 {
	public static void main(String[] args) {

		List<String> wordDict=new ArrayList<>();
//		String s="goalspecial";
//		wordDict.add("go");
//		wordDict.add("goal");
//		wordDict.add("goals");
//		wordDict.add("special");

		String s="aaaaaaa";
		wordDict.add("aaa");
		wordDict.add("aaaa");

		boolean b = new LeetCode_139().wordBreak(s, wordDict);
		System.out.println(b);
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String cur=s.substring(j, i);
				if (dp[j]&&wordDictSet.contains(cur)) {
					dp[i] = true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length()];
	}
}
