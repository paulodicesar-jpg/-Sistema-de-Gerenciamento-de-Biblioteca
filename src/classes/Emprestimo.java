//Além de estar obrigatoriamente associado a uma obra e a um leitor, cada empréstimo 
//possui um código, data de saída, data prevista para devolução, valor da multa (caso ocorra) e status (ativo ou devolvido). 

package classes;


public class Emprestimo {
    private Obra obra;
    private Leitor leitor;
    private int codigo;
    private String dataSaida, dataPrevista;
    private double valorMulta;
    private boolean status;

    public Emprestimo(Obra obra, Leitor leitor, int codigo, String dataSaida, String dataPrevista, double valorMulta, boolean status) {
        
        if (codigo <= 0) {
        throw new IllegalArgumentException("O código do empréstimo deve ser maior que zero.");
        }
        if (valorMulta < 0) {
            throw new IllegalArgumentException("O valor da multa não pode ser negativo.");
        }
        
        this.obra = obra;
        this.leitor = leitor;
        this.codigo = codigo;
        this.dataSaida = dataSaida;
        this.dataPrevista = dataPrevista;
        this.valorMulta = valorMulta;
        this.status = status;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "obra=" + obra + ", leitor=" + leitor + ", codigo=" + codigo + ", dataSaida=" + dataSaida + ", dataPrevista=" + dataPrevista + ", valorMulta=" + valorMulta + ", status=" + status + '}';
    }

}
