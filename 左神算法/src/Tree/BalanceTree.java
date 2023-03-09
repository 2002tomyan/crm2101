package Tree;

public class BalanceTree {

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }
    //给定一颗二叉树的头节点head,返回这颗二叉树是不是平衡二叉树
    /*
        平衡二叉树:
        假设以x为节点的树，得到想要的答案，要获取那些信息
                        左子树可以给我信息，右子树也可以给我信息
        什么是平衡树，在一棵二叉树中，左树的高度和右树的高度相差必须<=1
        1.左树是平衡的，左平否？高度
        2.右树是平衡的 右平否？ 高度
        3.|左树 - 右树| < 2

        列出了以x为头的可能性
     */

    //信息返回的结构体
    public static class Info{
        public boolean isBalanced;
        public int height;
        public Info(boolean b,int n){
            isBalanced = b;
            height = n;
        }
    }

    public static Info process2(Node X){
        //当X为空的时候，返回的信息
        if(X == null){
            return new Info(true,0);
        }
        //左树所给的信息
        Info leftInfo = process2(X.left);
        //右树所给的信息
        Info rightInfo = process2(X.right);
        //我当前的高度，左树的高度，右树的高度，最大值在加头节点的高度
        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        boolean isBalanced = true;
        if(!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height- rightInfo.height)>2){
            isBalanced = false;
        }
        return new Info(isBalanced,height);
    }

    public static boolean isBalanced2(Node head){
        return process2(head).isBalanced;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);

        boolean balanced2 = isBalanced2(head);
        System.out.println(balanced2);
    }
}
