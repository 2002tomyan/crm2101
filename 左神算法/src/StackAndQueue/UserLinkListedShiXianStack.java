package StackAndQueue;

import LinkListed.ReverseList;
import LinkListed.ReverseList2;

public class UserLinkListedShiXianStack {

    //使用双链表结构实现队列
    //头部加减，尾部加减
    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;
        public DoubleNode(int value){
            this.value = value;
        }

    }

    public static class DoubleEndsQueue{
       public DoubleNode head;
       public DoubleNode tail;

       public void addFromHead(int value){
           //添加的节点
           DoubleNode cur = new DoubleNode(value);

           if(head == null){
               head = cur;
               tail = cur;
           }
           else {
               cur.next = head;
               head.last = cur;
               head = cur;
           }
       }
       public void addFromBottom(int value){
           DoubleNode cur = new DoubleNode(value);

           if(head == null){
               head = cur;
               tail = cur;
           }
           else {
               cur.last = tail;
               tail.next = cur;
               tail = cur;
           }
       }

       public int popFromHead(){
           if(head == null){
               return -1;
           }
           DoubleNode cur = head;
           if(head == tail){
               head = null;
               tail = null;
           }
           else {
               head = head.next;
               cur.next = null;
               head.last = null;
           }
           return cur.value;
       }

       public int popFromBottom(){
           if(head == null){
               return -1;
           }
           DoubleNode cur = tail;
           if(head == tail){
               head = null;
               tail = null;
           }
           else {
               tail = tail.last;
               cur.last = null;
               tail.next = null;
           }
           return cur.value;
       }
        public boolean isEmpty(){
            boolean flag = false;
            if(head==null) {
                flag = true;
            }
            return flag;
        }
    }


//栈
    public static class MyStack{
        private DoubleEndsQueue queue;

        public MyStack(){
            queue = new DoubleEndsQueue();
        }

        //从头部压入
        public void push(int value){
            queue.addFromHead(value);
        }
        //从头部弹出
        public int pop(){
            return queue.popFromHead();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    //队列
    public static class MyQueue{
        private DoubleEndsQueue queue;
        public MyQueue(){
            queue = new DoubleEndsQueue();
        }
        //从头部压入
        public void push(int value){
            queue.addFromHead(value);
        }
        //从尾部弹出
        public int pop(){
            return queue.popFromBottom();
        }
    }
}
