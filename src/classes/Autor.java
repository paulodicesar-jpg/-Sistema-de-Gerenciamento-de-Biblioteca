

package classes;


public class Autor {
    private String nomeAutor; 
    private String nacionalidade;
    
    public Autor(String nomeAutor, String nacionalidade) {
        this.nomeAutor = nomeAutor;
        this.nacionalidade = nacionalidade;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Autor{" + "nomeAutor=" + nomeAutor + ", nacionalidade=" + nacionalidade + '}';
    }

   
}
