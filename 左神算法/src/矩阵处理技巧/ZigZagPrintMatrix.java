package 矩阵处理技巧;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix){
        int Ar = 0;
        int Ac = 0;
        int Br = 0;
        int Bc = 0;
        int Endr = matrix.length - 1;
        int Endc = matrix[0].length - 1;
        boolean fromUp = false; //判断是否是右上往左下打印

        while (Ar != Endr + 1){
            printLevel(matrix,Ar,Ac,Br,Bc,fromUp);
            //先往右，在往下
            Ar = Ac == Endc ? Ar+1 : Ar;
            Ac = Ac == Endc ? Ac : Ac + 1;

            //先往下，在往右
            Bc = Br == Endr ? Bc+1 : Bc;
            Br = Br == Endr ? Br : Br+1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m,int Ar,int Ac,int Br,int Bc,boolean fromUp){
        if(fromUp){
            while (Ar != Br + 1){
                System.out.print(m[Ar++][Ac--]+" ");
            }
        }else {
            while (Br != Ar -1){
                System.out.print(m[Br--][Bc++]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] score = new int[3][4];
        score[0][0] = 1;
        score[0][1] = 2;
        score[0][2] = 3;
        score[0][3] = 4;
        score[1][0] = 5;
        score[1][1] = 6;
        score[1][2] = 7;
        score[1][3] = 8;
        score[2][0] = 9;
        score[2][1] = 10;
        score[2][2] = 11;
        score[2][3] = 12;

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + "\t");
            }
            System.out.println("");
        }

        System.out.println("==========================");
        System.out.println(score.length);
        System.out.println(score[0].length);
        printMatrixZigZag(score);
    }



}
