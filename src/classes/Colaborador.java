package classes;


import java.util.ArrayList;
import java.util.List;

public abstract class Colaborador {
    private int codigoInterno;
    private String nomeCompleto;
    private ArrayList<String> telefones;

    public Colaborador (int codigoInterno, String nomeCompleto) {
        this.codigoInterno = codigoInterno;
        this.nomeCompleto = nomeCompleto;
        this.telefones = new ArrayList<>();
    }

    public int getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(int codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = (ArrayList<String>) telefones;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigoInterno=" + codigoInterno + 
                ", nomeCompleto=" + nomeCompleto + 
                ", telefones=" + telefones + '}';
    }     
      
}
