package algorithm;

import java.util.Stack;

/**
 * @ClassName LeetCode_52
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2021/12/06 11:28
 */
public class LeetCode_56 {

	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description 冒泡排序，超时
	 * @Date 2021/12/11 09:44
	 * @Param [intervals]
	 * @return int[][]
	 */
	public int[][] merge(int[][] intervals) {
		//冒泡排序
		int len=intervals.length;
		int l=0,r=1;
		int max=len;
		while(r<=max&&max>1){
			if(r==max){
				max--;
				l=0;
				r=1;
			}
			int left=intervals[l][0];
			int right=intervals[r][0];
			if(left>right){
				int[] mid=intervals[r].clone();
				intervals[r]=intervals[l].clone();
				intervals[l]=mid.clone();
			}
			l++;
			r++;
		}
		Stack<int[]> resu=new Stack<>();
		resu.push(intervals[0]);
		for(int j=1;j<len;j++){
			int[] current=resu.pop();

			int left=intervals[j][0];
			int right=intervals[j][1];
			if(current[1]<left){
				resu.push(current);
				resu.push(intervals[j]);
			}else if(current[1]<right){
				current[1]=intervals[j][1];
				resu.push(current);
			}else{
				resu.push(current);
			}
		}
		int[][] resule=new int[resu.size()][2];
		for(int m=0;m<resule.length;m++){
			resule[m]=resu.pop();
		}
		return resule;
	}
	public int[][] merge1(int[][] intervals) {
		int max=0;
		for(int[] interval:intervals){
			max= Math.max(max, interval[1]);
		}
		int[] ints=new int[max+1];
		for(int[] interval:intervals){
			for(int i=interval[0];i<interval[1];i++){
				ints[i]=1;
			}
			ints[interval[1]]=ints[interval[1]]==1?1:2;
		}
		for(int i:ints){
			System.out.println("i:"+i);
		}
		Stack<Integer> left=new Stack<>();
		Stack<Integer> right=new Stack<>();
		for(int i=0;i<ints.length;i++){
			if(i==0&&ints[i]==2){
				left.push(i);
				right.push(i);
				continue;
			}
			if(i==0&&ints[i]==1){
				left.push(i);
				continue;
			}
			if(ints[i]==1&&ints[i-1]==0){
				left.push(i);
				continue;
			}
			if(ints[i]==1&&ints[i-1]==2){
				left.push(i);
				continue;
			}

			if(ints[i]==2&&ints[i-1]==0){
				left.push(i);
				right.push(i);
				continue;
			}

			if(ints[i]==2&&ints[i-1]==2){
				left.push(i);
				right.push(i);
				continue;
			}
			if(ints[i]==2&&ints[i-1]==1){
				right.push(i);
				continue;
			}
			if(i==ints.length-1&&ints[i]==2){
				right.push(i);
			}
		}
		int leng=right.size();
		int[][] result=new int[leng][2];
		for(int i=0;i<result.length;i++){
			result[i][0]=left.pop();
			result[i][1]=right.pop();
		}
		for(int[] ii:result){
			System.out.println("ii[left]:"+ii[0]);
			System.out.println("ii[right]:"+ii[1]);
		}
		return result;
	}

	public static void main(String[] args) {

		int[][] ins={{2,4},{5,7},{4,5},{3,5},{5,7},{1,1}};
		new LeetCode_56().merge1(ins);
	}
}
