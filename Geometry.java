import java.util.Scanner;

interface FormasGeometricas {
    final double PI = 3.14159;

    float calcularArea();
    float calcularPerimetro();
}

class Circulo implements FormasGeometricas {
    double raio;


    public Circulo(double raio) {
        this.raio = raio;
    }

    public float calcularArea() {
        return (float) (PI * Math.pow(raio, 2));
    }

    public float calcularPerimetro() {
        return (float) (2 * PI * raio);
    }

    public float calcularArea(double raio) {
        return (float) (PI * Math.pow(raio, 2));
    }

    public float calcularPerimetro(double raio) {
        return (float) (2 * PI * raio);
    }
}

class Retangulo implements FormasGeometricas {
    double b, a;


    public Retangulo(double b, double a) {
        this.b = b;
        this.a = a;
    }

    public float calcularArea() {
        return (float) (b * a);
    }

    public float calcularPerimetro() {
        return (float) ((2 * b) + (2 * a));
    }

    public float calcularArea(double lmaior, double lmenor) {
        return (float) (lmaior * lmenor);
    }

    public float calcularPerimetro(double lmaior, double lmenor) {
        return (float) ((2 * lmaior) + (2 * lmenor));
    }
}

public class Geometry {
    public static void main(String[] args) {
        System.out.println("\n\nCalcular area de formas geometricas\n");

        Circulo c1 = new Circulo();
        Retangulo r1 = new Retangulo();

        System.out.println("Area do circulo de raio 10: " + c1.calcularArea(10));
        System.out.println("\nArea do retangulo 12x3 " + r1.calcularArea(12, 3));


        Scanner sc = new Scanner(System.in);
        FormasGeometricas[] inventario = new FormasGeometricas[100];
        int i = 0;

        while (true) {
            System.out.println("\nQual forma geometrica deseja criar? (1-Circulo, 2-Retangulo, 0-Sair)");
            int opt = sc.nextInt();

            if (opt == 0) break;

            switch (opt) {
                case 1:
                    System.out.println("Digite o raio do seu circulo: ");
                    double r = sc.nextDouble();

                    inventario[i] = new Circulo(r);
                    System.out.println("Objeto criado com sucesso!");
                    i++;
                    break;
                case 2:
                    System.out.println("Digite a base do seu retangulo: ");
                    double b = sc.nextDouble();
                    System.out.println("Digite a altura do seu retangulo: ");
                    double a = sc.nextDouble();

                    inventario[i] = new Retangulo(b, a);
                    System.out.println("Objeto criado com sucesso!");
                    i++;
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }

        for (int j = 0; j < i; j++) {
            String tipo = inventario[j].getClass().getSimpleName();
            System.out.println(tipo + " - Area: " + inventario[j].calcularArea() + " | Perimetro: " + inventario[j].calcularPerimetro());
        }
        
        sc.close();
    }
}