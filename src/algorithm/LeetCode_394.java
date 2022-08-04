package algorithm;

/**
 * @ClassName LeetCode_234
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/03 09:35
 */
public class LeetCode_394 {
	public static void main(String[] args) {
		String res=new LeetCode_394().decodeString("");
		System.out.println(res);

//		new LeetCode_294().decodeString("a2[c]");
	}

	public String decodeString(String s) {
		return dfs(s, 0)[0];
	}

	public String[] dfs(String s, int index) {
		StringBuilder res = new StringBuilder();
		String[] res_return = new String[2];
		int num = 0;
		for (int i = index; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				num = num * 10 + c - '0';
			else if (c == '[') {
				String[] tmep_res = dfs(s, i + 1);
				for (int j = 0; j < num; j++) res.append(tmep_res[0]);
				i = Integer.parseInt(tmep_res[1]);
				num = 0;
			} else if (c == ']') {
				res_return[0] = res.toString();
				res_return[1] = String.valueOf(i);
				return res_return;
			} else res.append(c);
		}
		res_return[0] = res.toString();
		return res_return;
	}
}
