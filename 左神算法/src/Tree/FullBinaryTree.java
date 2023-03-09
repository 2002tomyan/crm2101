package Tree;

public class FullBinaryTree {

    //最大深度 L
    //节点个数 N
    //满二叉树 N = 2 的 L 次方 - 1
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static class Info{
        public int height;
        public int nodes;

        public Info(int h,int n){
            height = h;
            nodes = n;
        }
    }

    public static Info process(Node X){
        if(X == null) {
            return new Info(0, 0);
        }
            Info leftData = process(X.left);
            Info rightData = process(X.right);

            int height = Math.max(leftData.height, rightData.height) + 1;
            int nodes = leftData.nodes + rightData.nodes + 1;
            return new Info(height,nodes);
    }

    public static boolean isFull(Node head){
        if(head == null){
            return true;
        }
        Info data = process(head);

        //1 << data.height = data.height的2次方
        return data.nodes == 1 << data.height - 1;
    }
}
