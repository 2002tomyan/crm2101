package 矩阵处理技巧;

public class RotateMatrix {

    public static void rotate(int[][] matrix){
        int a = 0;
        int b = 0;
        int c = matrix.length-1;
        int d = matrix[0].length - 1;

        while (a < c){
            rotateEdge(matrix,a++,b++,c--,d--);
        }

    }

    public static void rotateEdge(int[][] m,int a,int b,int c,int d){
        int temp = 0;
        for (int i = 0; i < d - b; i++) {
            temp = m[a][b+i];
            m[a][b+i] = m[c-i][b];
            m[c-i][b] = m[c][d-i];
            m[c][d-i] = m[a+i][d];
            m[a+i][d] = temp;
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.println(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
