package Offer;

import java.util.Stack;

/**
 * @ClassName Offer_09
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/02/11 17:25
 */
public class Offer_09 {
	//创建两个栈，用来添加元素的栈add，用来删除的栈del
	Stack<Integer> add;
	Stack<Integer> del;
	public Offer_09() {
		add= new Stack<>();
		del=new Stack<>();
	}

	public void appendTail(int value) {
		add.push(value);
	}

	public int deleteHead() {
		if(del.empty()){
			if(add.empty()){
				return -1;
			}
			while (!add.empty()) {
				del.push(add.pop());
			}
		}
		return del.pop();
	}

}
