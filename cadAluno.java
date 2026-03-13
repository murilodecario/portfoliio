import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Endereco {
    protected String rua, cidade, estado, cep;
    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}

class Pessoa {
    protected String nome, datanasc, rg, tel;
    protected Endereco endereco;

    public Pessoa(String nome, String datanasc, String rg, Endereco endereco, String tel) {
        this.nome = nome;
        this.datanasc = datanasc;
        this.rg = rg;
        this.tel = tel;
        this.endereco = endereco;
    }
}

class Aluno extends Pessoa {
    protected String ra;
    protected float cr;

    public Aluno(Pessoa p, String ra, float cr) {
        super(p.nome, p.datanasc, p.rg, p.endereco, p.tel);
        this.ra = ra;
        this.cr = cr;
    }

    public void alterarDados(String novoNome, String novaDN, String novoRg, String novoTel, String novoRa, float novoCr, Endereco novoEnd) {
        this.nome = novoNome;
        this.datanasc = novaDN;
        this.rg = novoRg;
        this.tel = novoTel;
        this.ra = novoRa;
        this.cr = novoCr;
        this.endereco = novoEnd;
    }
}

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno[] lista = new Aluno[100];
        int i = 0, opt1 = -1;

        while (opt1 != 0) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Exibir todos os alunos");
            System.out.println("3. Alterar dados");
            System.out.println("0. Sair");
            opt1 = sc.nextInt();
            sc.nextLine();

            switch (opt1) {
                case 1 -> {
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("Data Nasc: "); String dn = sc.nextLine();
                    System.out.print("RG: "); String rg = sc.nextLine();
                    System.out.print("Tel: "); String tel = sc.nextLine();
                    System.out.print("Rua: "); String rua = sc.nextLine();
                    System.out.print("Cidade: "); String cid = sc.nextLine();
                    System.out.print("Estado: "); String est = sc.nextLine();
                    System.out.print("CEP: "); String cep = sc.nextLine();
                    System.out.print("RA: "); String ra = sc.nextLine();
                    System.out.print("CR: "); float cr = sc.nextFloat();
                    sc.nextLine();

                    Endereco end = new Endereco(rua, cid, est, cep);
                    Pessoa p = new Pessoa(nome, dn, rg, end, tel);
                    lista[i] = new Aluno(p, ra, cr);
                    i++;
                    System.out.println("Aluno " + nome + " cadastrado com sucesso.");
                }
                case 2 -> {
                    if (i == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.print("Ordenar por: 1-Nome | 2-RA | 3-CR: ");
                        int opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1 -> Arrays.sort(lista, 0, i, Comparator.comparing(a -> a.nome));
                            case 2 -> Arrays.sort(lista, 0, i, Comparator.comparing(a -> a.ra));
                            case 3 -> Arrays.sort(lista, 0, i, Comparator.comparing(a -> a.cr));
                        }
                        System.out.println("\nAlunos ordenados: ");
                        for (int j = 0; j < i; j++) {
                            System.out.println("Nome: " + lista[j].nome + "\nRA: " + lista[j].ra + "\nCR: " + lista[j].cr);
                            System.out.println("---------------------------------");
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Digite o RA para busca: ");
                    String raBusca = sc.nextLine();
                    Aluno found = null;

                    for (int j = 0; j < i; j++) {
                        if (lista[j].ra.equals(raBusca)) {
                            found = lista[j];
                            break;
                        }
                    }

                    if (found != null) {
                        System.out.print("Novo Nome: "); String nome = sc.nextLine();
                        System.out.print("Nova Data Nasc: "); String dn = sc.nextLine();
                        System.out.print("Novo RG: "); String rg = sc.nextLine();
                        System.out.print("Novo Tel: "); String tel = sc.nextLine();
                        System.out.print("Nova Rua: "); String rua = sc.nextLine();
                        System.out.print("Nova Cidade: "); String cid = sc.nextLine();
                        System.out.print("Novo Estado: "); String est = sc.nextLine();
                        System.out.print("Novo CEP: "); String cep = sc.nextLine();
                        System.out.print("Novo RA: "); String ra = sc.nextLine();
                        System.out.print("Novo CR: "); float cr = sc.nextFloat();
                        sc.nextLine();

                        Endereco endAtt = new Endereco(rua, cid, est, cep);
                        found.alterarDados(nome, dn, rg, tel, ra, cr, endAtt);
                        System.out.println("Alteração concluída com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado");
                    }
                }
            }
        }
    }
}