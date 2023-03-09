package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxSearchSubTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //给定二叉树的头节点head,返回这颗二叉树中最大的头节点
    //搜素二叉树：整颗树上没有重复值，左树的值比我下，右树的值比我大

    /*
        X 无关
            左树上满足的二叉搜索子树最大节点个数   右树最大   的大小
        X 有关
            X为头的数
            左树都是搜索二叉树 右树也是搜索二叉树
            左 max < X
            右 min > X

      左树  左大子搜 size
                   是不是搜索二叉树
                   isAllBST
                   max
      右树   最大子搜 size
                     是不是搜索二叉树
                     isAllBST
                     min
      求全集
            子树
                size
                boolean isAllBST
                max
                min
     */

    public static class Info {
        public boolean isAllBST;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(boolean is, int size, int mi, int ma) {
            isAllBST = is;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

        public static Info process(Node X) {
            if (X == null) {
//            return new Info(true,0,0,0);
                return null;
            }

            Info leftInfo = process(X.left);

            Info rightInfo = process(X.right);

            int min = X.value;
            int max = X.value;

            if (leftInfo != null) {
                min = Math.min(min, leftInfo.min);
                max = Math.max(max, leftInfo.max);
            }

            if (rightInfo != null) {
                min = Math.min(min, rightInfo.min);
                max = Math.max(max, rightInfo.max);
            }

            //可能性1
            int maxSubBSTSize = 0;
            if (leftInfo != null) {
                maxSubBSTSize = leftInfo.maxSubBSTSize;
            }
            if (rightInfo != null) {
                maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
            }

            //可能性2
            boolean isAllBST = false;
            if (      //左树整体要是搜索二叉树
                    (leftInfo == null ? true : leftInfo.isAllBST)
                            &&
                            (rightInfo == null ? true : rightInfo.isAllBST)
                            &&
                            (leftInfo == null ? true : leftInfo.max < X.value)
                            &&
                            (rightInfo == null ? true : rightInfo.min > X.value)
            ) {
                maxSubBSTSize =
                        (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                                + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                                + 1;
                isAllBST = true;
            }
            return new Info(isAllBST, maxSubBSTSize, min, max);
        }
    public static int process2(Node head){
        return process(head).maxSubBSTSize;
    }


    public static int preValue = Integer.MIN_VALUE;
    //判断一棵树是否是搜索二叉树
    public static boolean checkBST1(Node head){
        if(head == null){
            return true;
        }

        boolean isLeftBst = checkBST1(head.left);

        if(!isLeftBst){
            return false;
        }
        if(head.value <= preValue){
            return false;
        }else {
            preValue = head.value;
        }
        return checkBST1(head.right);
    }
    //判断一棵树是否是搜索二叉树
    public static boolean checkBST2(Node head){
        List<Node> inOrderList = new ArrayList<>();
        boolean flag = false;
        process2(head,inOrderList);
        for (int i = 1;i<inOrderList.size();i++){
            if(inOrderList.get(i).value > inOrderList.get(i-1).value){
                flag = true;
            }
        }
        return flag;
    }
    public static void process2(Node head,List<Node> inOrderList){
        if(head == null){
            return;
        }
        process2(head.left,inOrderList);
        inOrderList.add(head);
        process2(head.right,inOrderList);
    }

    public static boolean checkBST(Node head){
        if(head != null){
            int preValue = Integer.MIN_VALUE;

            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    if(head.value <= preValue){
                        return false;
                    }else {
                        preValue = head.value;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }
}

