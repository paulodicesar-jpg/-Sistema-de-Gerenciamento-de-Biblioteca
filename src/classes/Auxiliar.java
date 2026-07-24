package classes;

public class Auxiliar extends Colaborador {
    private String turnoTrabalho;

    public Auxiliar(int codigoInterno, String nomeCompleto, String telefone, String turnoTrabalho) {
        super(codigoInterno, nomeCompleto);
        this.getTelefones().add(telefone); 
        this.turnoTrabalho = turnoTrabalho;
    }

    public String getTurnoTrabalho() {
        return turnoTrabalho;
    }

    public void setTurnoTrabalho(String turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }
    
    public void validarTurno(String turno) {
    if (turno.equalsIgnoreCase("manhã") || turno.equalsIgnoreCase("tarde") || turno.equalsIgnoreCase("noite")) {
        this.turnoTrabalho = turno; 
    } else {
        this.turnoTrabalho = "Não definido";
    }
}
    
    @Override
    public String toString() {
        return "Auxiliar{" +
                super.toString() +
                ", turnoTrabalho='" + turnoTrabalho + '\'' +
                '}';    
    }
}