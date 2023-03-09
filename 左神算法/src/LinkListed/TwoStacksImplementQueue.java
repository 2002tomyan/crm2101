package LinkListed;

import java.util.Stack;

public class TwoStacksImplementQueue {
    public static class TwoStacksQueue{
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStacksQueue(){
            popStack = new Stack<>();
            pushStack = new Stack<>();
        }

        //push栈中的数据向pop栈中导入数据
        private void pushToPop(){
            if(popStack.isEmpty()){
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
        }

        public void add(int pushInt){
            pushStack.push(pushInt);
            pushToPop();
        }

        public int poll(){
            if(pushStack.isEmpty() && popStack.isEmpty())
                throw new RuntimeException("队列为空");
            pushToPop();
            return popStack.pop();
        }

        public int peek(){
            if(pushStack.isEmpty() && popStack.isEmpty())
                throw new RuntimeException("队列为空");
            pushToPop();
            return popStack.peek();
        }
    }
}
