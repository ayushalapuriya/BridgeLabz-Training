import java.util.*;
public class MatrixManipulation {

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

    // Method to add two matrices
    public static int[][] addMatrices(int[][] matrix1,int[][] matrix2) {
        int rows=matrix1.length;
        int cols=matrix1[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                result[i][j]=matrix1[i][j]+matrix2[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] matrix1,int[][] matrix2) {
        int rows=matrix1.length;
        int cols=matrix1[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                result[i][j]=matrix1[i][j]-matrix2[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1,int[][] matrix2) {
        int rows1=matrix1.length;
        int cols1=matrix1[0].length;
        int cols2=matrix2[0].length;
        int[][] result=new int[rows1][cols2];
        for(int i=0;i<rows1;i++) {
            for(int j=0;j<cols2;j++) {
                result[i][j]=0;
                for(int k=0;k<cols1;k++) {
                    result[i][j]=result[i][j]+matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input for matrix dimensions
        System.out.print("Enter number of rows for Matrix A: ");
        int rows1=sc.nextInt();
        System.out.print("Enter number of columns for Matrix A: ");
        int cols1=sc.nextInt();

        System.out.print("Enter number of rows for Matrix B: ");
        int rows2=sc.nextInt();
        System.out.print("Enter number of columns for Matrix B: ");
        int cols2=sc.nextInt();

        // Create random matrices
        int[][] matrixA=createRandomMatrix(rows1,cols1);
        int[][] matrixB=createRandomMatrix(rows2,cols2);

        // Display matrices
        System.out.println("\nMatrix A:");
        displayMatrix(matrixA);
        System.out.println("\nMatrix B:");
        displayMatrix(matrixB);

        // Addition
        if(rows1==rows2 && cols1==cols2) {
            int[][] sum=addMatrices(matrixA,matrixB);
            System.out.println("\nMatrix A + Matrix B:");
            displayMatrix(sum);
        } else {
            System.out.println("\nAddition not possible: Matrices have different dimensions");
        }

        // Subtraction
        if(rows1==rows2 && cols1==cols2) {
            int[][] diff=subtractMatrices(matrixA,matrixB);
            System.out.println("\nMatrix A - Matrix B:");
            displayMatrix(diff);
        } else {
            System.out.println("\nSubtraction not possible: Matrices have different dimensions");
        }

        // Multiplication
        if(cols1==rows2) {
            int[][] product=multiplyMatrices(matrixA,matrixB);
            System.out.println("\nMatrix A * Matrix B:");
            displayMatrix(product);
        } else {
            System.out.println("\nMultiplication not possible: Columns of A must equal rows of B");
        }

        sc.close();
    }
}
