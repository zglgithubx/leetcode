package AlgorithmProblem;

/**
 * @ClassName AlgorithmProblem.LeetCode_76
 * @Description TODO
 * @Author ZhuGuangLiang
 * @Date 2021/11/05 09:41
 */
public class LeetCode_76 {
    public String minWindow(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        if(sLen==0||tLen==0||sLen<tLen){
            return "";
        }
        //window窗口是为了记录t的字符出现频率，用128个数组空间是为了代表所有字符的，
        int[] window=new int[128];
        //tFreq记录t所有字符的出现频率
        int[] tFreq=new int[128];
        for(char c:t.toCharArray()){
            //字符c可以做为索引，因为字符可以自动进行类型转换向Integer转
            tFreq[c]++;
        }
        //表示窗口中内部包含了T中字符的个数，窗口内单个字符个数等于T中对应的
        int dis=0;
        int minLne=sLen+1;
        int begin=0;
        int left=0,right=0;

        while(right<sLen){
            char current=s.charAt(right);
            //s的中字符，t中不出现则right向右移动，扩大窗口
            if(tFreq[current]==0){
                right++;
                continue;
            }
            //窗口中字符频率小于tFreq的频率时，说明窗口中的字符还没将其中一个字符覆盖完全
            if(window[current]<tFreq[current]){
                dis++;
            }
            //记录窗口中t的字符出现的频率
            window[current]++;
            right++;
            while(dis==tLen){
                char currenT=s.charAt(left);
                //更新最小覆盖子串
                if(right-left<minLne){
                    minLne=right-left;
                    begin=left;
                }
                //缩小窗口
                if(window[currenT]==0){
                    left++;
                    continue;
                }
                //窗口中包含t的字符频率刚好等于tFreq中的字符出现的频率，dis减一跳出循环，继续扩大窗口
                if(window[currenT]==tFreq[currenT]){
                    dis--;
                }
                window[currenT]--;
                left++;
            }
        }
        if(minLne==sLen+1){
            return "";
        }
        return s.substring(begin,begin+minLne);
    }

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String result=new LeetCode_76().minWindow(s,t);
        System.out.println(result);

    }
}
