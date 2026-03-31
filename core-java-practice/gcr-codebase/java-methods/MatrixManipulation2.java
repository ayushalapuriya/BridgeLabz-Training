import java.util.*;
public class MatrixManipulation2 {

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows,int cols) {
        int[][] matrix=new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                matrix[i][j]=(int)(Math.random()*10);
            }
        }
        return matrix;
    }

    // Method to find the transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] transpose=new int[cols][rows];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                transpose[j][i]=matrix[i][j];
            }
        }
        return transpose;
    }

    // Method to find the determinant of a 2x2 matrix
    public static double determinant2x2(int[][] matrix) {
        return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
    }

    // Method to find the determinant of a 3x3 matrix
    public static double determinant3x3(int[][] matrix) {
        double det=matrix[0][0]*(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])
                  -matrix[0][1]*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])
                  +matrix[0][2]*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);
        return det;
    }

    // Method to find the inverse of a 2x2 matrix
    public static double[][] inverse2x2(int[][] matrix) {
        double det=determinant2x2(matrix);
        if(det==0) return null;
        double[][] inverse=new double[2][2];
        inverse[0][0]=matrix[1][1]/det;
        inverse[0][1]=-matrix[0][1]/det;
        inverse[1][0]=-matrix[1][0]/det;
        inverse[1][1]=matrix[0][0]/det;
        return inverse;
    }

    // Method to find the inverse of a 3x3 matrix
    public static double[][] inverse3x3(int[][] matrix) {
        double det=determinant3x3(matrix);
        if(det==0) return null;
        double[][] inverse=new double[3][3];
        inverse[0][0]=(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])/det;
        inverse[0][1]=(matrix[0][2]*matrix[2][1]-matrix[0][1]*matrix[2][2])/det;
        inverse[0][2]=(matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1])/det;
        inverse[1][0]=(matrix[1][2]*matrix[2][0]-matrix[1][0]*matrix[2][2])/det;
        inverse[1][1]=(matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0])/det;
        inverse[1][2]=(matrix[0][2]*matrix[1][0]-matrix[0][0]*matrix[1][2])/det;
        inverse[2][0]=(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0])/det;
        inverse[2][1]=(matrix[0][1]*matrix[2][0]-matrix[0][0]*matrix[2][1])/det;
        inverse[2][2]=(matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0])/det;
        return inverse;
    }

    // Method to display an integer matrix
    public static void displayMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    // Method to display a double matrix
    public static void displayDoubleMatrix(double[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                System.out.printf("%.2f\t",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input for matrix size
        System.out.print("Enter matrix size (2 for 2x2 or 3 for 3x3): ");
        int size=sc.nextInt();

        // Create random matrix
        int[][] matrix=createRandomMatrix(size,size);
        System.out.println("\nOriginal Matrix:");
        displayMatrix(matrix);

        // Find transpose
        int[][] transpose=transposeMatrix(matrix);
        System.out.println("\nTranspose of Matrix:");
        displayMatrix(transpose);

        // Find determinant
        double det=0;
        if(size==2) {
            det=determinant2x2(matrix);
            System.out.println("\nDeterminant of 2x2 Matrix: "+det);
        } else if(size==3) {
            det=determinant3x3(matrix);
            System.out.println("\nDeterminant of 3x3 Matrix: "+det);
        }

        // Find inverse
        if(size==2) {
            double[][] inverse=inverse2x2(matrix);
            if(inverse!=null) {
                System.out.println("\nInverse of 2x2 Matrix:");
                displayDoubleMatrix(inverse);
            } else {
                System.out.println("\nInverse does not exist (determinant is 0)");
            }
        } else if(size==3) {
            double[][] inverse=inverse3x3(matrix);
            if(inverse!=null) {
                System.out.println("\nInverse of 3x3 Matrix:");
                displayDoubleMatrix(inverse);
            } else {
                System.out.println("\nInverse does not exist (determinant is 0)");
            }
        }

        sc.close();
    }
}
