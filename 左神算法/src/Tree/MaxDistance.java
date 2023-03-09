package Tree;

public class MaxDistance {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //给定一棵二叉树的头节点X,任何两个节点之间都存在距离，返回整棵二叉树的最大距离
    //向左树要信息
    //向右树要信息
    // 常见分类
    //  1.整棵树的最大距离不通过X节点（与 X 无关）  左树上的最大距离 或者 右树上的最大距离 （左树 和 右树上的最大距离哪一个最大求出即可 最大距离和高度）
    //  2.与 X 有关的。先是X左树上离他最远的点，一直走到 X 右树上离他最远的点  即X左树的高度+头节点+X右树的高度

    public static class Info{
        public int maxDistance;
        public int height;

        public Info(int dis,int h){
            maxDistance = dis;
            height = h;
        }
    }

    public static Info process(Node X){
        if(X == null){
            return new Info(0,0);
        }

        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        //
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height+ rightInfo.height+1);
        return new Info(maxDistance,height);
    }

    public static int maxDistance(Node head){
        return process(head).maxDistance;
    }

}
