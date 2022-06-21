package AlgorithmProblem;

import java.util.Arrays;

/**
 * @ClassName AlgorithmProblem.LeetCode_105
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/07 09:09
 */
public class LeetCode_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode res=new TreeNode();
		build(preorder,inorder,res);
		return res;
	}
	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description
	 * 思路：
	 * 前序遍历一定满足：[根，左子树，右子树]
	 * 中序遍历一定满足：[左子树，根，右子树]
	 * 先从前序遍历的数组中找到根节点，找到位于中旬遍历的根节点，可以确定左子树，依次递归查询
	 * @Date 2022/06/07 09:51
	 * @Param [pre, in, res]
	 * @return void
	 */
	public void build(int[] pre,int[] in,TreeNode res){
		if(pre.length==0){
			return;
		}
		if(pre.length==1){
			res.val=pre[0];
			return;
		}
		int root=pre[0];
		res.val=root;
		int mid=0;
		for(int i=0;i<in.length;i++){
			if(root==in[i]){
				mid=i;
			}
		}
		int[] preL=new int[0],preR=new int[0],inL=new int[0],inR=new int[0];
		if(mid+1<=pre.length){
			preL= Arrays.copyOfRange(pre,1,mid+1);
		}
		if(mid+1<pre.length){
			preR=Arrays.copyOfRange(pre,mid+1,pre.length);
			inR=Arrays.copyOfRange(in,mid+1,in.length);
		}
		if(mid<=pre.length){
			inL=Arrays.copyOfRange(in,0,mid);
		}
		if(preL.length>0){
			res.left=new TreeNode();
		}
		if(preR.length>0){
			res.right=new TreeNode();
		}
		build(preL,inL,res.left);
		build(preR,inR,res.right);
	}
}
