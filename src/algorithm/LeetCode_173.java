package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName LeetCode_173
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/07/19 09:04
 */
public class LeetCode_173 {
	class BSTIterator {

		TreeNode root;
		List<Integer> list;
		int i=0;

		public BSTIterator(TreeNode root) {
			this.root=root;
			list=new ArrayList<>();
			loop(root,list);
		}


		public int next() {
			return list.get(i++);

		}

		public boolean hasNext() {
			return i < list.size();
		}

		//转移法，将中序遍历树中的元素，将其放入集合中
		public void loop(TreeNode root, List<Integer> listNode){
			if(root==null){
				return;
			}
			loop(root.left,listNode);
			listNode.add(root.val);
			loop(root.right,listNode);
		}
	}
	class BSTIterator1 {
		TreeNode root;
		//记录过程节点
		Stack<TreeNode> stack;

		public BSTIterator1(TreeNode root) {
			this.root=root;
			stack=new Stack<>();
		}

		//迭代法
		public int next() {
			//向左遍历
			while(root!=null){
				stack.push(root);
				root=root.left;
			}
			//此时的root为null,取出上一个节点
			root=stack.pop();
			int res=root.val;
			//向右遍历
			root=root.right;
			return res;
		}

		public boolean hasNext() {
			return root!=null|| !stack.isEmpty();
		}

	}
}
