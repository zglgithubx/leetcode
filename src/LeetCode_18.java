import java.util.*;

/**
 * @ClassName LeetCode_18
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/12 21:07
 */
public class LeetCode_18 {
	public static void main(String[] args) {
//		int[] nums = {91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,
//		-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,
//		-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,
//		85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,
//		-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,
//		-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,
//		-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,
//		17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,
//		-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,
//		-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,
//		90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,
//		90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,
//		74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,
//		39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,
//		-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,
//		9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,
//		3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,
//		-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,
//		30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245};
//		int target = -236727523;

		int[] nums={1,-2,-5,-4,-3,3,3,5};
		int target=-11;

		long start=System.currentTimeMillis();
		System.out.println(new LeetCode_18().fourSum(nums, target));
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start)+"ms");
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums.length<4){
			return new ArrayList<>();
		}
		Map<Integer,Integer> map=new HashMap<>();
		for(int i:nums){
			if(map.containsKey(i)){
				map.put(i,map.get(i)+1);
			}else{
				map.put(i,1);
			}
		}
		List<Integer> list=new ArrayList<>();
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			Integer key=entry.getKey();
			Integer value=entry.getValue();
			value=value>4?4:value;
			for(int i=0;i<value;i++){
				list.add(key);
			}
		}
		nums=new int[list.size()];
		for(int i=0;i<nums.length;i++){
			nums[i]=list.get(i);
		}
		Arrays.sort(nums);
		int newLen=0;
		int[] newNums = new int[0];
		if(nums.length<=100){
			newNums=nums.clone();
		}else if(target<nums[0]){
			if(target<0){
				for(int i=0;i<nums.length;i++){
					if(nums[i]>0){
						newLen=i;
						break;
					}
				}
				newNums=new int[newLen];
				System.arraycopy(nums, 0, newNums, 0, newNums.length);

			}
			if(target>0){
				return new ArrayList<>();
			}
		}else if(target>nums[nums.length-1]){
			if(target>0){
				for(int i=0;i<nums.length;i++){
					if(nums[i]>=0){
						newLen=i;
						break;
					}
				}
				newNums=new int[nums.length-newLen];
				if (nums.length - newLen >= 0)
					System.arraycopy(nums, newLen, newNums, 0, nums.length - newLen);
			}
			if(target<0){
				return new ArrayList<>();
			}
		}else{
			newNums=nums.clone();
		}
		List<List<Integer>> res=new ArrayList<>();
		combinationSelect(newNums,0,res,new HashSet<>(),new ArrayList<>(),0,target);
		return res;
	}
	void combinationSelect(int[] dataList, int dataIndex,List<List<Integer>> res, Set<String> set,List<Integer> resultList, int resultIndex,int target) {
		if (resultIndex == 4) { // 全部选择完时，输出组合结果
			int count=resultList.get(0)+resultList.get(1)+resultList.get(2)+resultList.get(3);
			if(count==target){
				if(set.add(resultList.toString())){
					res.add(new ArrayList<>(resultList));
				}
			}
			return;
		}
		for (int i = dataIndex; i < dataList.length -(3-resultIndex); i++) {
			resultList.add(resultIndex,dataList[i]);
			combinationSelect(dataList, i + 1, res,set,resultList, resultIndex + 1,target);
			resultList.remove(resultIndex);
		}
	}
}
