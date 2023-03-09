package Tree;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMaxHappy {

    public static class Employee{
        public int happy;
        public List<Employee> nexts;

        public Employee(int h){
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static int maxHappy2(Employee boss){
        if(boss == null){
            return 0;
        }
        Info all = process2(boss);
        return Math.max(all.yes,all.no);
    }

    public static class Info{
        public int yes;
        public int no;

        public Info(int y,int n){
            yes = y;
            no = n;
        }
    }

    public static Info process2(Employee x){
        //如果来
        if(x.nexts.isEmpty()){
            return new Info(x.happy,0);
        }

        int yes = x.happy;
        int no = 0;
        for (Employee next: x.nexts){
            Info nextInfo = process2(next);
            //来的时候，整棵树的最大快乐值
            yes += nextInfo.no;
            //不来文档时候，最大的快乐值
            no += Math.max(nextInfo.yes,nextInfo.no);
        }
        return new Info(yes,no);
    }
}
