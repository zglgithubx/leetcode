import java.util.*;

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

	public List<List<String>> groupAnagrams(String[] strs) {
		String[] newStr=new String[strs.length];
		for(int i=0;i<strs.length;i++){
			char[] chars = strs[i].toCharArray();
			int[] charCount=new int[26];
			for(char c:chars){
				int cur=charCount[c-97];
				cur++;
				charCount[c-97]=cur;
			}
			newStr[i]= Arrays.toString(charCount);
		}
		Map<String,List<String>> resMap=new HashMap<>();
		for(int i=0;i<newStr.length;i++){
			List<String> list;
			if(resMap.containsKey(newStr[i])){
				list=resMap.get(newStr[i]);
				list.add(strs[i]);
			}else {
				list=new ArrayList<>();
				list.add(strs[i]);
			}
			resMap.put(newStr[i],list);
		}
		return (List<List<String>>) resMap.values();

	}
	//思路：创建一个map集合，存储每个单词，转成字符串存到新的字符串数组中，然后再将字符串添加到sort中
	public static void main(String[] args) {
		String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};


	}
}

