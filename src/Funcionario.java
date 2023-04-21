import java.util.Scanner;

public class Funcionario implements ModeloCrud {
    int id;
    String nome;
    String cidade;
    String uf;

    Scanner scanner = new Scanner(System.in);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public void incluir() {
        System.out.print("Digite o id: ");
        this.id = scanner.nextInt();
        scanner.nextLine(); //Limpa a linha
        System.out.print("\nDigite o nome: ");
        this.nome = scanner.nextLine();
        System.out.print("\nDigite a cidade: ");
        this.cidade = scanner.nextLine();
        System.out.print("\nDigite a uf: ");
        this.uf = scanner.nextLine();
    }

    @Override
    public void alterar() {
        System.out.println("Digite o id: ");
        int novoId = scanner.nextInt();
        int opcao;
        String novoNome;
        String novaCidade;
        String novaUF;

        if (novoId == this.id) {
            System.out.println("Digite 1 para alterar o nome, 2 para alterar a cidade e 3 para alterar a UF");
            opcao = scanner.nextInt();
            scanner.nextLine(); //Limpar
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome: ");
                    novoNome = scanner.nextLine();
                    this.nome = novoNome;
                    break;
                case 2:
                    System.out.println("Digite a cidade: ");
                    novaCidade = scanner.nextLine();
                    this.cidade = novaCidade;
                    break;
                case 3:
                    System.out.println("Digite a uf: ");
                    novaUF = scanner.nextLine();
                    this.uf = novaUF;
                    break;
                default:
                    System.out.println("Numero invalido.");
                    break;
            }
        } else System.out.println("Numero invalido.");
    }

    @Override
    public void excluir() {
        System.out.println("Digite o id para excluir: ");
        int idExclusao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        if (idExclusao == this.id) {
            System.out.println("Funcionário excluído com sucesso.");
            this.setId(0);
            this.setNome("");
            this.setCidade("");
            this.setUf("");
        } else {
            System.out.println("ID inválido.");
        }
    }


    @Override
    public void recuperar() {
        System.out.println("Digite o id para recuperar: ");
        int idRecuperado = scanner.nextInt();
        if (idRecuperado == this.id) {
            System.out.println(this.toString());
        } else {
            System.out.println("Id não localizado.");
        }
    }

    @Override
    public void validar() {
        System.out.println("O id digitado não existe: " + validacao());
    }

    private boolean validacao() {
        System.out.println("Digite o id para validar: ");
        int idValidacao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        if (idValidacao != this.id) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
