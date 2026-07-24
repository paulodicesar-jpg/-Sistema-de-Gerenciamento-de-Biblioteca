
package classes;

import java.util.ArrayList;
import java.util.List;

public class Obra {
    private String tituloObra, editora;
    private int ISBN, ano;
    private List<Autor> autores; 

    public Obra(String tituloObra, String editora, int ISBN, int ano) {
        this.tituloObra = tituloObra;
        this.editora = editora;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autores = new ArrayList<>(); 
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Obra{" + "tituloObra=" + tituloObra + ", editora=" + editora + ", ISBN=" + ISBN + ", ano=" + ano + ", autores=" + autores + '}';
    }
    
}
