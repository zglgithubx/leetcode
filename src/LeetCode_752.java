import java.util.*;

/**
 * @ClassName LeetCode_752
 * @Description
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zhuguangliang
 * @Date 2021/09/30 16:21
 **/

public class LeetCode_752 {
    String upOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='9'){
            ch[j]='0';
        }
        else{
            ch[j]+=1;
        }
        return new String(ch);
    }
    String downOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='0'){
            ch[j]='9';
        }
        else{
            ch[j]-=1;
        }
        return new String(ch);
    }
    int openLock1(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deads.contains(cur))
                    continue;
                /* 判断是否到达终点 */
                if (cur.equals(target))
                    return step;
                /* 将一个节点的未遍历相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = upOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = downOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }

    public static void main(String[] args) {
        String[] deads={"0201","0101","0102","1212","2002"};
        String target="0202";
        int res= new LeetCode_752().openLock1(deads,target);
        System.out.println(res);
    }
}

