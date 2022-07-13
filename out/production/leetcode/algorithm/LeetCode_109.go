package leetcode

 type ListNode struct {
      Val int
      Next *ListNode
 }

type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
    //判断是否为null
    if head==nil {
        return nil;
    }
    if head.Next==nil {
        //返回一个TreeNode对象
        return &TreeNode{head.Val,nil,nil}
    }
    //声明ListNode类型变量 p，q,pre
    var p,q,pre *ListNode
    q=head
    p=head
    pre=nil
    //相当于while循环，(声明；判断；迭代)
    for;q!=nil&&q.Next!=nil;q=q.Next.Next {
        pre=p;
        p=p.Next;
    }
    //赋值为null
    pre.Next=nil;
    //声明并赋值一个TreeNode类型对象
    root:=&TreeNode{p.Val,nil,nil};
    root.Left=sortedListToBST(head);
    root.Right=sortedListToBST(p.Next);
    return root;
}
