package cn.bw.leetcode;

import java.util.LinkedList;

/***
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 *
 *
 *
 */
public class A225用队列实现栈 {

    class MyStack {

        private LinkedList<Integer> q1;
        private LinkedList<Integer> q2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q1 = new LinkedList<Integer>();
            q2 = new LinkedList<Integer>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            Integer remove=0;
            while (q1.size()>1) {

                remove = q1.remove();
                boolean add = q2.add(remove);

            }
            remove = q1.remove();
            LinkedList<Integer> temp = this.q1;
            this.q1 =q2;
            q2=temp;
            return remove;
        }

        /**
         * Get the top element.
         */
        public int top() {
            Integer remove=0;
            while (q1.size()>0) {

                remove = q1.remove();
                boolean add = q2.add(remove);
            }
            LinkedList<Integer> temp = this.q1;
            this.q1 =q2;
            q2=temp;
            return remove;
        }


        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty();
        }

    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
