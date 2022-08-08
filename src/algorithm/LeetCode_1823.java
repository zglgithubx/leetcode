package algorithm;

/**
 * @ClassName LeetCode_1823
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/08 09:59
 */
public class LeetCode_1823 {
	public static void main(String[] args) {
			System.out.println(new LeetCode_1823().findTheWinner(5, 4));
	}
	public int findTheWinner(int n, int k) {
		int[] ints=new int[n];
		for(int i=0;i<n;i++){
			ints[i]=i+1;
		}
		return dfs(n,ints,0,k);
	}
	/**
	 index:每次游戏的起始点
	 */
	public int dfs(int count,int[] ints,int index,int k){
		if(count==1){
			return ints[index];
		}
		//开始游戏
		int len=ints.length;
		int newK=k-1;
		while(newK>0){
			if(ints[index]!=0){
				newK--;
			}
			if(index==len-1){
				index=0;
			}else{
				index++;
			}
		}
		//判断特殊情况，下一位也为0
		while(ints[index]==0){
			if(index==len-1&&ints[index]==0){
				index=0;
			}else{
				index++;
			}
		}
		ints[index]=0;


		//计算下一个起始点
		if(index==len-1){
			index=-1;
		}
		int newIndex=index+1;
		for(int i=newIndex;i<len;i++){
			if(ints[i]!=0){
				newIndex=i;
				break;
			}
			if(i==len-1&&ints[i]==0){
				i=-1;
			}
		}
		return dfs(count-1,ints,newIndex,k);
	}
}
