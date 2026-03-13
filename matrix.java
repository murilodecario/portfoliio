import java.util.Scanner;

public class ex4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Soma de matrizes\n\n");

        System.out.println("Digite as dimensoes das suas matrizes: \n");
        System.out.println("Linhas: "); int m = sc.nextInt();
        System.out.println("Colunas : "); int n = sc.nextInt();

        int A[][] = new int[m][n];
        int B[][] = new int[m][n];
        int C[][] = new int[m][n];

        System.out.println("Vamos preencher sua matriz A\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("a" + (i + 1) + (j + 1) + ": "); A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Vamos preencher sua matriz B\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("b" + (i + 1) + (j + 1) + ": "); B[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matriz C = A+B:\n");
        for (int i = 0; i < m; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
                System.out.print(C[i][j]);
            }
            System.out.println("|");
        }
    }
}