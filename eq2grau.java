System.out.println("x1 = "+x1+"\n");import java.util.Scanner;

class Funcao {
    private int a, b, c;

    public setCoeficientes(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float calcularDelta() {
        float delta = Math.pow(b, 2) - 4 * a * c;
        return delta;
    }

    public void calcularRaizes() {
        float delta = calcularDelta();
        float x1, x2;
        if (delta<0) {
            System.out.println("O valor de delta = "+delta+" faz com que essa função não possua raízes reais.\n");
        }
        if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("O valor de delta = 0 faz com que essa função possua apenas uma raíz, x = "+x1+".\n");
        }
        if (delta>0) {
            x1 = (-b + Math.sqrt(delta))/(2*a);
            x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("O valor de delta = "+delta+" faz com que essa função possua duas raízes reais.\n");
            System.out.println("x1 = "+x1+"\n");
            System.out.println("x2 = "+x2+"\n");
        }
    }
}

class ex1 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva os coeficientes da sua função de segundo grau:\n");
        System.out.println("a: "); a = scanner.nextInt();
        System.out.println("b: "); b = scanner.nextInt();
        System.out.println("c: "); c = scanner.nextInt();

        Funcao f = new Funcao(a, b, c);
        f.calcularRaizes();
    }
}