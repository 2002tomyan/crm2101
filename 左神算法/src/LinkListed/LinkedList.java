package LinkListed;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedList {

    public static class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    //奇数的时候返回中点，偶数的时候返回上中点
    public static Node midOrUpMidNode(Node head){
        if(head ==null || head.next ==null|| head.next.next==null){
            return head;
        }
        //链表有3个或3个以上的节点
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //笔试的时候
    public static Node midOrUpMidNode1(Node head){
        if(head ==null || head.next ==null|| head.next.next==null){
            return head;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null){
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size()-1)/2);
    }

    //奇数的时候返回中点，偶数的时候返回下中点
    public static Node midOrDownNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //链表的节点至少有两个或者两个以上
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //奇数长度返回中点前一个，偶数长度返回上中点前一个
    public static Node preMidOrPreUpMid(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        //至少要有3个节点
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //奇数长度返回中点前一个，偶数长度返回下中点前一个
    public static Node preMidOrPreDownMid(Node head){
        if(head == null || head.next ==null){
            return null;
        }
        if(head.next.next == null){
            return head;
        }
        //两个节点或者两个节点以上
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //判断链表是否为回文
    public static boolean huiWenLinkList(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur.next != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if(stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean huiWenLinkList2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;//n3  -> save last node 要记一下
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }


    /**
     * 把单链表按照某值返回左边小，中间相等，右边大
     */
    //笔试中的写法
    public static Node leftMinMiddleEqualsRightMax(Node head,int value) {
        if (head == null) {
            return head;
        }
        //获取链表的长度
        Node cur = head;
        int i = 0;
        while (cur.next != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,value);
        for (i = 1;i != nodeArr.length; i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] arrNode,int pivot){
        int small = -1;
        int big = arrNode.length;
        int index = 0;

        while (index < big){
            if(arrNode[index].value == pivot){
                index++;
            }else if(arrNode[index].value < pivot){
                small++;
                swap(arrNode,index,small);
                index++;
            }else {
                big--;
                swap(arrNode,index,big);
            }
        }
    }
    public static void swap(Node[] arr,int i,int j){
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //面试的时候，<区 =区 >区
    public static Node listPartition2(Node head,int pivot){
        Node sH = null;
        Node sT = null;

        Node eH = null;
        Node eT = null;

        Node mH = null;
        Node mT = null;

        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;

            if(head.value <pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if(mH == null){
                    mH = head;
                    mT = head;
                }else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        //小于区域的尾部连等于区域的头 等于区域的尾部连接大于区域的头
        if(sT != null){ //判断有没有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){ //如果有小于区域和等于区域
            eT.next = mH;
        }

        //判断有没有小于区域的头
        return sH != null ? sH :(eH != null ? eH:mH);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
