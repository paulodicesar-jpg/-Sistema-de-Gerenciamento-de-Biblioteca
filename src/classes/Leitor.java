package classes;

public class Leitor {
    private int cpf;
    private String nome; 

    public Leitor(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Leitor{" + "cpf=" + cpf + ", nome=" + nome + '}';
    }
}