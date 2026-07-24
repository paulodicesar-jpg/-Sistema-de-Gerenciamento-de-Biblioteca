

package classes;


public class Bibliotecario extends Colaborador {
    private int numeroCRB;
    private String areaAtuacao;

    public Bibliotecario(int codigoInterno, String nomeCompleto, String telefone, int numeroCRB, String areaAtuacao) {
        super(codigoInterno, nomeCompleto);
        this.getTelefones().add(telefone);  
        this.numeroCRB = numeroCRB;
        this.areaAtuacao = areaAtuacao;
    }

    public int getNumeroCRB() {
        return numeroCRB;
    }

    public void setNumeroCRB(int numeroCRB) {
        this.numeroCRB = numeroCRB;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    
    @Override
    public String toString() {
    return "Bibliotecario{" +
            super.toString() +
            ", CRB ='" + numeroCRB + '\'' +
            ", Area ='" + areaAtuacao + '\'' +
            '}';
    }

}
