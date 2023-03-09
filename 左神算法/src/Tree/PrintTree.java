package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }
    /*
        先右，头，左
     */
    public static void printTree(Node head){
        System.out.println("Binary Tree:");
        printInOrder(head,0,"H",17);
        System.out.println();
    }

    public static void printInOrder(Node head,int height,String to,int len){ //len 自己的值占多少位
        if(head == null){
            return;
        }
        //先是右树
        printInOrder(head.right,height+1,"v",len);
        //如何打印当前节点

        String val = to + head.value + to; //把值处理好
        int lenM = val.length();//中间占位的长度
        //左侧预留的空间
        int lenL = (len - lenM) / 2;
        //右侧预留的空间
        int lenR = len - lenL - lenM;
        val = getSpace(lenL) + val + getSpace(lenR);//每一个值的严格长度
        System.out.println(getSpace(height*len) + val);

        //再是左树
        printInOrder(head.left,height+1,"^",len);
    }

    public static int maxWidthUseMap(Node head){
        if (head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // key在那一层，value
        HashMap<Node,Integer> levelMap = new HashMap<>();
        //头节点在第一层
        levelMap.put(head,1);
        //当前正在统计那一层
        int curLevel = 1;
        //当前层 或者 curLevel层的宽度是多少
        int curLevelNodes = 0;
        int max = 0; //最大值
        while (!queue.isEmpty()){
           Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);//当前节点在那一层
            if(cur.left != null){
                levelMap.put(cur.left,curNodeLevel+1);
                queue.add(cur.left);
            }
            if(cur.right != null){
                levelMap.put(cur.right,curNodeLevel+1);
                queue.add(cur.right);
            }
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            }else {
                max = Math.max(max,curLevelNodes);
                curLevel++;
                //当前层的节点数设置为1
                curLevelNodes = 1;
            }
        }
        max = Math.max(max,curLevelNodes);
        return max;
    }
    public static String getSpace(int num){
        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    //给二叉树的某一个节点，返回他（该节点）的后继节点（中序遍历到该节点，该节点的下一个节点是后继节点）
    //通过该节点找到头节点，有往上指的指针，可以找到头部，然后进行中序遍历，在中序遍历的结果中，找到该节点的下一个节点（后继节点），暴力解法，

    /*
        如果有右树，如果子是父的左孩子，父是当初节点的后继节点。右树上最左节点，整棵树最右的节点没有后继
        如果没有右树，那么，该节点是左树上最右的节点，那么后继节点便是头节点。
     */


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        printTree(head);
        int count = maxWidthUseMap(head);
        System.out.println(count);
    }
}
