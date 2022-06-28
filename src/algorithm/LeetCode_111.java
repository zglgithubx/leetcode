package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName leetcode_111
 * @Description
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * @Author zhuguangliang
 * @Date 2021/09/27 11:30
 **/
public class LeetCode_111 {
    class QueueNode{
        TreeNode node;
        int depth;
        public QueueNode(TreeNode node,int depth){
            this.node=node;
            this.depth=depth;

        }
    }
    /**
     * @Author zhuguangliang
     * @Description 此法为广度优先搜索，引入queueNode对象，用来存node和该node的深度。
     * 先添加根节点进入队列，然后进入循环，取出队列节点，判断左右节点的是否为null,如果都为null说明为叶子节点，直接返回最小深度，如果不是，则将左节点或右节点放到队列。
     * 利用了队列的先进先出的特点，实现树的左右子节点存储
     * @Date 21:50 2021/09/27
     * @Param [root]
     * @return int
     **/
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<QueueNode> queue=new LinkedList<>();
        //向队列中添加元素
        queue.offer(new QueueNode(root,1));
        while(!queue.isEmpty()){
            //返回第一个元素并删除
            QueueNode nodeDepth=queue.poll();
            TreeNode node= nodeDepth.node;
            int depth=nodeDepth.depth;
            if(node.left==null&&node.right==null){
                return depth;
            }
            if(node.left!=null){
                queue.offer(new QueueNode(node.left,depth+1));
            }
            if(node.right!=null){
                queue.offer(new QueueNode(node.right,depth+1));
            }
        }
        return 0;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
