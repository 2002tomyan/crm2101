package Tree;

import java.util.LinkedList;

public class CompleteBinaryTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //任意节点，若只右孩子，没有左孩子 ，直接false
    //在 （1）不违规的条件下，如果遇到左右两个孩子不双全的情况，当前节点都必须是叶节点 那整棵树便是完全二叉树,才是TRUE,否则是false
    public static boolean isCompleteBinaryTree(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;

            if(
                    (leaf && (l != null || r != null)) //如果遇到左右孩子不双全的情况,有发现当前节点不是叶节点
                ||
                    (l == null && r != null)  //左孩子为空（无），右孩子有节点
            ){
                return false;
            }

            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);

        boolean completeBinaryTree = isCompleteBinaryTree(head);
        System.out.println(completeBinaryTree);
    }
}
