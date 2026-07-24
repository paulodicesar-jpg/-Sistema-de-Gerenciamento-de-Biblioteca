
package classes;
import java.util.ArrayList;


public class FichaConservacao implements GerenciarFichaConservacao {
   private int codigo;
   private Obra obra;
   private ArrayList<Intervencao> listaIntervencao;
   private int proximoCodigo = 1;
   
   public FichaConservacao (int codigo, Obra obra) {
       this.codigo = codigo;
       this.obra = obra;
       this.listaIntervencao = new ArrayList();
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public ArrayList<Intervencao> getListaIntervencao() {
        return listaIntervencao;
    }

    public void setListaIntervencao(ArrayList<Intervencao> listaIntervencao) {
        this.listaIntervencao = listaIntervencao;
    }
   
    @Override
    public void inserirIntervencao(String nome, double custo, String relato, Categoria categoria, Colaborador colaborador) {
        String dataAtual = "31/05/2026";
        Intervencao nova = new Intervencao(proximoCodigo, nome, dataAtual, relato, custo, categoria, colaborador);

        listaIntervencao.add(nova);
        proximoCodigo++;
    }

    @Override
    public String retornarTodasIntervencoes() { 
        String relatorio = "";
        for (Intervencao i : listaIntervencao) {
            relatorio += "Código: " + i.getCodigo() + 
                         " - Situação: " + i.getNome() + 
                         " - Colaborador: " + i.getColaborador().getNomeCompleto() + 
                         " - Categoria: " + i.getCategoria().getNome() + 
                         " - Data: " + i.getData() + 
                         "- Relato: " + i.getRelato() + "\n";
        }
        return relatorio;
    }

    @Override
    public String retornarFichaConservacaoCompleta() {
        return "=== Ficha de Conservação ===\n" +
               "OBRA: " + obra.getTituloObra() + " | ISBN: " + obra.getISBN() + "\n" +
               "----------------------------\n" +
               retornarTodasIntervencoes() + 
               "----------------------------\n" +
               "Total Investido: R$ " + calcularCustoTotal() + "\n" +
               "Total de Intervenções: " + quantidadeDeIntervencoes();
    }

    @Override
    public double calcularCustoTotal() {
        double total = 0;
        for (Intervencao i : listaIntervencao) {
            total += i.getCusto();
        }
        return total;
    }  

    @Override
    public int quantidadeDeIntervencoes() {
        return listaIntervencao.size();
    }

    @Override
    public String toString() {
        return "FichaConservacao{" + "codigo=" + codigo + ", obra=" + obra + ", listaIntervencao=" + listaIntervencao + '}';
    }
   
}
