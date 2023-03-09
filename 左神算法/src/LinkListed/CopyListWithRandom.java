package LinkListed;

import java.util.HashMap;

public class CopyListWithRandom {

    /**
     * 定义其结构
     */
    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int data){
            this.value = data;
        }
    }
    //使用了哈希表 笔试
    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            //cur老
            //map.get(cur)新节点
            //cur的克隆节点的next指针就这样指 向map的老节点的next指针
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //不使用哈希表的方法 面试
    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //1 -> 2
        //1 -> 1' -> 2
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //set copy node rand
        // 1 -> 1' -> 2 -> 2'
        while (cur != null){
            //cur 老
            //cur.next  新 copy
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        //head head.next是新节点的头部
        Node res = head.next;
        cur = head;
        //split
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next:null;
            cur = next;
        }
        return res;
    }


}
