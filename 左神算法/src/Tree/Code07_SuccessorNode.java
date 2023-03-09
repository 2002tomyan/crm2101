package Tree;

public class Code07_SuccessorNode {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data){
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node){
        if(node == null){
            return node;
        }
        //如果有右树，找到右树上最左的节点，便是该节点的后继节点
        if(node.right != null){
            return getLeftMost(node.right);
        }else {
            //如果没有右树，先把 node 的父亲节点找到
            Node parent = node.parent;
            //当前节点是器父亲的右孩子
            while (parent != null && parent.right == node){
                //我来到父亲的位置
                node = parent;
                //父亲在往上
                parent = node.parent;
            }
            //我是我父亲的左孩子了，停
            return parent;
        }
    }
    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    //前驱节点
    //如果，如果一个节点有左树，左树上最右的节点变是前驱节点
    //否则，什么什么的。

    //打印折痕

    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }
    //i是节点层数，N是总共几层
    public static void printProcess(int i,int N,boolean down){
        if(i > N){
            return;
        }
        //true为凹 false为凸
        printProcess(i+1,N,true);
        System.out.println(down ? "凹":"凸");
        printProcess(i+1,N,false);
    }
    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
