package LinkListed;

public class ReverseList {

    public static class Node{
        //单链表结构
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }

    public static class DoubleNode{
        //双链表结构
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data){
            this.value = data;
        }
    }

    //单链表基本实现机制
    public static Node reverseLinkedList(Node head){

        Node pre = null;
        Node next = null;

        while (head != null){

            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双链表基本实现机制
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){

        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null){

            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    //删除链表中的值
    public static Node removeValue(Node head,int num){

        //遍历整个链表
        //这是处理要删除头节点
        while (head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        //找到第一个不需要删除的位置
        //
        Node pre = head;
        Node cur = head;

        while (cur != null){
            if(cur.value == num){
                pre.next = cur.next;
            }
            else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
