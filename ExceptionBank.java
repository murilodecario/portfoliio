import java.util.Scanner;

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaBancaria {
    double saldo = 100.0;
    String titular = "Aluno";

    void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para sacar R$ " + valor);
        }
        this.saldo -= valor;
        System.out.println("Saque realizado! Novo saldo: R$ " + this.saldo);
    }
}

public class ExceptionBank {    
    public static void main(String[] s) {
        ContaBancaria minhaConta = new ContaBancaria();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Titular: "+minhaConta.titular+" | Saldo: "+minhaConta.saldo);
        System.out.println("Digite quanto gostaria de sacar.");
        
        try {
            double valor = sc.nextDouble();
            minhaConta.sacar(valor); 
        } catch (SaldoInsuficienteException e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}