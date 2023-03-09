package LinkListed;

public class UserArrayForQueue {

    public static class MyQueue{
        private final int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi=0;
            polli=0;
            size=0;
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit)
                throw new RuntimeException("栈满了，不能在加了");
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0)
                throw new RuntimeException("栈空了，不能在拿了");
            size--;
            int value = arr[polli];
            polli = nextIndex(polli);
            return value;
        }

        public int nextIndex(int i){
            return i < limit - 1 ? i+1 : 0;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    public static class MyQueue2{
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private int limit;

        public MyQueue2(int limit){
            arr = new int[limit];
            polli=0;
            pushi=0;
            size=0;
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit)
                throw new RuntimeException("栈满了，不能在加了");
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0)
                throw new RuntimeException("栈空了，不能在取了");
            size--;
            int value = arr[polli];
            polli = nextIndex(polli);
            return value;
        }

        public boolean isEmpty(){
            return size==0;
        }
        public int nextIndex(int i){
            return i<limit?i+1:0;
        }
    }

    public static  class MyQueue3{
        private int pushi;
        private int[] arr;
        private int polli;
        private int limit;
        private int size;

        public MyQueue3(int limit){
            arr = new int[limit];
            polli = 0;
            pushi = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit)
                throw new RuntimeException("数组满了，不能在加入数据了");
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0)
                throw new RuntimeException("数组为空，不能在取数据了");
            size--;
            int value = arr[polli];
            polli = nextIndex(polli);
            return value;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public int nextIndex(int i){
            return i < limit ? i+1 : 0;
        }
    }
}
