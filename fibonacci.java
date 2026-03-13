import java.util.Scanner;

class Fibonacci {
    public int fibo(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return (fibo(n-1) + fibo(n-2));
    }
}

class ex2{
    public static void main(String args[]){
        System.out.println("Sequencia de Fibonacci\n\n");
        Scanner sc = new Scanner(System.in);
        Fibonacci f = new Fibonacci();

        System.out.println("Digite qual termo da sequencia de Fibonacci quer consultar: "); int n = sc.nextInt();
        int fib = f.fibo(n);

        System.out.println("O "+n+"o termo da sequencia é: "+fib);
        sc.close();
    }
}