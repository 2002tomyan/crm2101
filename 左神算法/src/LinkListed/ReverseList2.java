package LinkListed;

public class ReverseList2 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverseDanList(Node head){
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

    public static class DoubleNode{
        public DoubleNode next;
        public DoubleNode last;
        public int value;
        public DoubleNode(int value){
            this.value = value;
        }
    }

    public static DoubleNode reverserDoubleList(DoubleNode head){
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

    public static Node removeValue(Node head,int num){
        //判断头节点是否要删除
        while (head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        //头节点排除完毕，到第一个要删除的节点
        // 当前节点的前一个节点
        Node pre = head;
        //当前节点
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
