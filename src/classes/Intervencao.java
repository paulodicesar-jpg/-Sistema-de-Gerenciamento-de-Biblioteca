
package classes;

public class Intervencao {
    private int codigo;
    private String nome, data, relato;
    private double custo;
    private Categoria categoria;
    private Colaborador colaborador;

    public Intervencao(int codigo, String nome, String data, String relato, double custo, Categoria categoria, Colaborador colaborador) {
        this.codigo = codigo;
        this.nome = nome;
        this.data = data;
        this.relato = relato;
        this.custo = custo;
        this.categoria = categoria;
        this.colaborador = colaborador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "Intervencao{" + "codigo=" + codigo + ", nome=" + nome + ", data=" + data + ", relato=" + relato + ", custo=" + custo + ", categoria=" + categoria + ", colaborador=" + colaborador + '}';
    }

}