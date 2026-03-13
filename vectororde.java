import java.util.Arrays;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[100];
        int i = 0;

        System.out.println("Digite numeros inteiros ou qualquer letra para parar):");

        while (sc.hasNextInt() && i < vetor.length) {
            vetor[i] = sc.nextInt();
            i++;
        }

        System.out.print("Vetor original: ");
        for (int j = 0; j < i; j++) {
            System.out.print(vetor[j] + ", ");
        }

        System.out.print("\nVetor ordenado: ");
        Arrays.sort(vetor, 0, i);
        for (int j = 0; j < i; j++) {
            System.out.print(vetor[j] + " ");
        }
    }
}