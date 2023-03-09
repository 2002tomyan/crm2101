package 打表技巧;

public class AppleBag {

    public static int minBags(int apple){
        if(apple < 0){
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple/8;
        int rest = apple - 8*bag8;
        while (bag8 >= 0 && rest < 24){
            int restUse6 = minBagBase6(rest);
            if(rest != -1){
                bag6 = restUse6;
                break;
            }
            //剩下的数量不足6号袋装
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    public static int minBagBase6(int rest){
        return rest % 6 == 0 ? (rest/6) : -1;
    }

    public static void main(String[] args) {
        for (int apple = 1; apple <= 100 ; apple++) {
            System.out.println(apple + ":"+minBags(apple));
        }
    }
}
