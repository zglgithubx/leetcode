/**
 * @ClassName LeetCode_567
 * @Description TODO
 * @Author ZhuGuangLiang
 * @Date 2021/11/09 17:42
 */
public class LeetCode_567 {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len=s1.length();
        int s2Len=s2.length();
        if(s2Len<s1Len){
            return false;
        }
        int[] s1Freq=new int[26];
        int[] window=new int[26];
        int s1Sort=0;
        for(char c:s1.toCharArray()){
            s1Freq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(s1Freq[i]>0){
                s1Sort++;
            }
        }
        int left=0,right=0;
        int distance=0;
        while(right<s2Len){
            char current=s2.charAt(right);
            if(s1Freq[current-'a']>0){
                window[current-'a']++;
                if(window[current-'a']==s1Freq[current-'a']){
                    distance++;
                }
            }
            right++;
            while(s1Sort==distance){
                if(right-left==s1Len){
                    return true;
                }
                char d=s2.charAt(left);
                if(s1Freq[d-'a']>0){
                    window[d-'a']--;
                    if(window[d-'a']<s1Freq[d-'a']){
                        distance--;
                    }
                }
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="hello";
        String s2="ooolleoooleh";
        boolean result=new LeetCode_567().checkInclusion(s1,s2);
        System.out.println(result);
    }
}
