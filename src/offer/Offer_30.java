package offer;

import java.util.Stack;

/**
 * @ClassName Offer_30
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/11 20:03
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Offer_30 {
	//定义两个栈，一个为数据栈A,一个为辅助栈B
	Stack<Integer> A,B;
	public Offer_30() {
		A=new Stack<>();
		B=new Stack<>();
	}

	/**
	 * @Author ZhuGuangLiang <786945363@qq.com>
	 * @Description A栈放入所有元素，B栈降序放入元素，当发现元素比之前大，则复制一份B栈中栈顶元素
	 * @Date 2022/02/11 20:35
	 * @Param [x]
	 * @return void
	 */
	public void push(int x) {
		A.push(x);
		if(B.isEmpty()){
			B.push(x);
		}else{
			if(B.peek()>x){
				B.push(x);
			}else{
				B.push(B.peek());
			}
		}
	}

	public void pop() {
		A.pop();
		B.pop();
	}

	public int top() {
		return A.peek();
	}

	public int min() {
		return B.peek();
	}
}
