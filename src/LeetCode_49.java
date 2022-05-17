import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class LeetCode_49 {
	//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
	//字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

	//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
	//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

	//输入: strs = [""]
	//输出: [[""]]

	//输入: strs = ["a"]
	//输出: [["a"]]
	public List<Character> sortChar(List<Character> chars){
		if(chars.size()==1){
			return chars;
		}
		List<Character> left=new ArrayList<>();
		List<Character> right= new ArrayList<>();
		char mid=chars.get(0);
		for(int i=1;i<chars.size();i++){
			if(chars.get(i)<=mid){
				left.add(chars.get(i));
			}else{
				right.add(chars.get(i));
			}
		}
		List<Character> res =new ArrayList<>();
		if(left.size()>0){
			res.addAll(sortChar(left));
		}
		res.add(mid);
		if(right.size()>0){
			res.addAll(sortChar(right));
		}
		return res;
	}

	public String[][] test(String[] strings){
		Set<String> re=new HashSet<>();
		List<String[]> res=new ArrayList<>();
		for(String str:strings){
			char[] chars=str.toCharArray();
			List<Character> list=new ArrayList<>();
			for(char c:chars){
				list.add(c);
			}
			String newStr = sortChar(list).toString().replaceAll(",","").replace("[","").replace("]","");

			if(!re.add(newStr)){
				String[] strings1=new String[re.size()];
				res.add(re.toArray(strings1));
				re=new HashSet<>();
				re.add(newStr);
			}
		}
		String[][] res1=new String[res.size()][];
		for(int i=0;i<res1.length;i++){
			res1[i]=res.get(i);
		}
		return res1;
	}
	public static void main(String[] args) {
		String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
		String[][] test = new LeetCode_49().test(strings);
		for(String[] strings1:test){
			for(String string:strings1){
				System.out.print(string+",");
			}
		}
	}
}

