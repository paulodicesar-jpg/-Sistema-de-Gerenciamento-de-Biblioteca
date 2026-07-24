
package classes;

public class Categoria {
    private String nome;
    private int codigo;

    public Categoria(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nome=" + nome + ", codigo=" + codigo + '}';
    }

}
