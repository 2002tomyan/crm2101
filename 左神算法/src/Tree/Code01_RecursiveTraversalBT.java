package Tree;

import java.util.*;

public class Code01_RecursiveTraversalBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void f(Node head){
        if(head == null){
            return;
        }
        //  1
        f(head.left);
        //  2
        f(head.right);
        //  3
    }

    //先序遍历
    public static void pre(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    //中序
    public static void in(Node head){
        if(head == null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    //后序
    public static void pos(Node head){
        if(head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    //非递归的方式
    //自己设计压栈的方式实现，在面试中很好
    //非递归的先序遍历记住就可以了，记住流程
    /*
    首先将头节点放入栈中
    1）接下来弹出就打印
    2）如果有右孩子(不空)，压入右
    3）如果有左(不空)，压入左
     */

    //头左右
    public static void pre2(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head =  stack.pop();
                System.out.println(head.value);
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }
    //头右左

    /*
    弹出就打印
    如有左，压入左
    如有右，压入右
     */
    //后序遍历
    public static void pos2(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            Stack<Node> stack1 = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                stack1.push(head);
                if(head.left != null){
                    stack.push(head.left);
                }
                if(head.right != null){
                    stack.push(head.right);
                }
            }
            while (!stack1.isEmpty()){
                System.out.println(stack1.pop().value+" ");
            }
        }
        System.out.println();
    }

    //
    /*
     *  整条左边界依次入栈
     *  左边界处理完 发生了else 当1无法继续了，弹出节点并打印，来到右树继续执行
     */
    public static void in2(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (head != null || !stack.isEmpty()){
                //整条左边界依次入栈
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //2.用一个栈实现后序遍历
    public static void pro3(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && head != c.left && head != c.right){
                    stack.push(c.left);
                } else if(c.right != null && head != c.right){
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().value+" ");
                    head = c;
                }
            }
        }
    }

    //用一个栈来实现后序遍历
    public static void pop4(Node h){
        if(h != null){
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && h != c.left && h != c.right){
                    stack.push(c.left);
                }else if(c.right != null && h != c.right){
                    stack.push(c.right);
                }else{
                    System.out.println(stack.pop().value+" ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    //二叉树的按层遍历  宽度优先遍历 用队列实现的
    public static void level(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(head.value+" ");
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }
    /*
     public static int maxWidthUseMap2(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Integer> levelMap = new HashMap<>();
        queue.add(head);
        levelMap.put(head,1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodeLevel = (int) levelMap.get(cur);

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
                curLevelNodes = 1;
            }
        }
        //最后层没有新的层去结算它了
        max = Math.max(max,curLevelNodes);
        return max;
    }
     */
    //统计二叉树最大的宽度 某一层有几个节点，就有多大的宽度 用map的方式 经典面试题
    //二叉树 的最大宽度的节点
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
        //最后一层的结果集处理
        max = Math.max(max,curLevelNodes);
        return max;
    }

    //不使用map如何求二叉树的最大宽度  发现层结束的机制
    public static int maxWidthNoUseMap(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        Node curEnd = head; //当前层最右节点是谁
        Node nextEnd = null; //下一层，最右节点是谁
        int max = 0;
        int curLevelNodes = 0; //当前层的节点数
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if(cur == curEnd){
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }

    /*
        二叉树的序列化与反序列化
        1   可以用先序，中序，后序，按层遍历，来实现二叉树的序列化
        2   用什么方式序列化，就使用什么方式反序列化
        3   用空把这些补全
     */
    //先序方式序列化
    public static Queue<String> preSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        pres(head,ans);
        return ans;
    }
    public static void pres(Node head,Queue<String> ans){
        if(head == null){
            ans.add(null);
        }else {
            ans.add(String.valueOf(head.value));
            pres(head.left,ans);
            pres(head.right,ans);
        }
    }

    //建出整棵树
    public static Node buildByPreQueue(Queue<String> prelist){
        if(prelist == null || prelist.size() == 0){
            return null;
        }
        return preb(prelist);
    }

    public static Node preb(Queue<String> prelist){
        String value = prelist.poll();
        if(value == null){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }

    //按层遍历的序列化
    public static Queue<String> levelSerial(Node head){
        //序列化结果
        Queue<String> ans = new LinkedList<>();
        if(head == null){
            ans.add(null);
        }else {
            ans.add(String.valueOf(head.value));
            //队列
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()){
                head = queue.poll();
                if(head.left != null){
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                }else {
                    ans.add(null);
                }
                if(head.right != null){
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                }else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    //反序列化
    public static Node buildByLevelQueue(Queue<String> levelList){
        if(levelList == null || levelList.size() == 0){
            return null;
        }
        Node head = generateNode(levelList.poll()); //建立头节点
        Queue<Node> queue = new LinkedList<>();
        if(head != null){
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return head;
    }
    public static Node generateNode(String val){
        if(val == null){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
