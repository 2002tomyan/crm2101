package LinkListed;

import java.util.Stack;

public class MyStackGetMin {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStackGetMin(){
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(int newNum){
        if(this.minStack.isEmpty()){
            this.minStack.push(newNum);
        }
        else if(newNum < getMin()){
            this.minStack.push(newNum);
        }
        else
        {
            int newMin = this.minStack.peek();
            this.minStack.push(newMin);
        }
        this.dataStack.push(newNum);
    }

    public int pop(){
        if(this.dataStack.isEmpty())
            throw new RuntimeException("你的栈是空的");
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public int getMin(){
        if(this.minStack.isEmpty())
            throw new RuntimeException("栈是空的");
        return this.minStack.peek();
    }
}
