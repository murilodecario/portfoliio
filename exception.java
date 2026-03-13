import java.util.Scanner;

public class exception {
    public static void main(String[] s) {
        Scanner sc = new Scanner(System.in);
        boolean erro; 

        do {
            System.out.println("Digite um numero inteiro:");
            String str = sc.nextLine(); 
            try {
                int numero = Integer.parseInt(str);
                System.out.println("Sucesso! O numero digitado foi: " + numero);
                erro = false; 
            } catch (NumberFormatException e) {
                System.out.println("Erro: '" + str + "' nao e um numero valido. Tente novamente.");
                erro = true; 
            }
        } while (erro);

        sc.close();
        System.out.println("Fim do programa.");
    }
}