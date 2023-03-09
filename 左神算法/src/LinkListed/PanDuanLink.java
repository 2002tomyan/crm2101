package LinkListed;

import java.util.HashSet;

public class PanDuanLink {

    public static class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }
    //判断链表是否有环，如果有环，返回入环的第一个节点，否则，返回空
    //用HashSet可以判断是否有环，能判断第一个入环的节点
    public static Node isRing(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        HashSet<Node> hashSet = new HashSet<>();
        Node cur = head;
        Node findFirstRing = null;
        while (cur != null){
            if (!hashSet.contains(cur)){
                hashSet.add(cur);
                cur = cur.next;
            }else {
                findFirstRing = cur;
                break;
            }
        }
        return findFirstRing;
    }

    //快慢指针
    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }



    //loop1 == null && loop2 == null
    //两个无环链表如何相交  相交之后有公共部分
    //使用哈希表
    public static Node wuRing(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        HashSet<Node> hashSet = new HashSet<>();
        Node cur = head1;
        while (cur != null){
            hashSet.add(cur);
            cur = cur.next;
        }
        Node cur2 = head2;
        Node findFirst = null;
        while (cur2!=null){
            if(!hashSet.contains(cur2)){
                cur2 = cur2.next;
            }else {
                findFirst = cur2;
            }
        }
        return findFirst;
    }

    //如果两个链表都无环，返回第一个相交的节点，如果不相交，返回null
    public static Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next!= null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next!= null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1:head2; //谁长谁为cur1
        cur2 = cur1 == head1 ? head2 : head1; //谁短，谁为cur2

        n = Math.abs(n);
        while ( n != 0 && cur1.next != null){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2 && cur1.next != null && cur2 != null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    //两个有环链表，返回第一个相交的节点，如果不相交返回null
    public static Node boothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;

        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    //主方法
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个无环链表的相交问题
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        //两个有环链表的相交问题
        if(loop1 != null && loop2 != null){
            return boothLoop(head1,loop1,head2,loop2);
        }
        //一个有环，一个无环不可能相交
        return null;
    }
}
