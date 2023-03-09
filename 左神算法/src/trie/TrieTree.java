package trie;

import java.util.HashMap;

public class TrieTree {

    //node的结构定义
    public static class Node1{
        public int pass;
        public int end;
        public Node1[] nexts;
        public Node1(){
            pass = 0;
            end = 0;
            // 0  a
            // 1  b
            // 2  c
            // ...
            // 25 z
            // next[i] == null   i方向的路不存在
            // next[i] != null   i方向的路存在
            nexts = new Node1[26]; //a - z 的小写字母
        }
    }
    //数的定义
    public static class Trie1{
        //只留头节点
        private Node1 root;

        public Trie1(){
            //只new一个头节点
            root = new Node1();
        }
        //插入
        public void insert(String word){
            if(word == null){
                return;
            }
            //将word转为字符类型的数组
            char[] str = word.toCharArray();
            //箭头刚开始指向头节点
            Node1 node = root;
            node.pass++;
            //遍历字符串
            for (int i = 0; i < str.length; i++) {
                //由字符决定走那一条路
                int path = str[i] - 'a';
                if(node.nexts[path] == null){
                    node.nexts[path] = new Node1();
                }
                //node跳到这个节点
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }
        //word这个单词插入了几次
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            Node1 node = root;
            int index = 0;// p 和 e只在树上过
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
        //在所有加入的字符串中；有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        //删除
        public void delete(String word){
            if(search(word) != 0){
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if(--node.nexts[index].pass == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
    }


    public static class Node2{
        public int pass;
        public int end;
        public HashMap<Integer,Node2> nexts;

        public Node2(){
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Trie2{
        private Node2 root;

        public Trie2(){
            root = new Node2();
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chas = word.toCharArray();
            Node2 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chas.length; i++) {
                index = (int) chas[i];
                if(!node.nexts.containsKey(index)){
                    node.nexts.put(index,new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = (int) chars[i];
                if(!node.nexts.containsKey(index)){
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        public int predixNumber(String pre){
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = (int) chars[i];
                if(!node.nexts.containsKey(index)){
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }

        public void delete(String word){
            if(search(word) != 0){
                char[] chars = word.toCharArray();
                Node2 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = (int) chars[i];
                    if(--node.nexts.get(index).pass == 0){
                        node.nexts.remove(index);
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }
    }
}
