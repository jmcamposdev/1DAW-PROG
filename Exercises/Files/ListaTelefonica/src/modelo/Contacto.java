package modelo;

public class Contacto {
    public final String NUM_PATTERN = "\\d+";
    private String titular;
    private String numero;
    
    public Contacto (String titular, String numero) {
        if (titular.isBlank()) {
            throw new IllegalArgumentException("El titular no puede estar en blanco");
        }
        if (!numero.matches(NUM_PATTERN)) {
            throw new IllegalArgumentException("El número debe de ser numérico");
        }
        
        this.titular = titular;
        this.numero = numero;
    }
    
    public Contacto (Contacto contacto) {
        this.titular = contacto.titular;
        this.numero = contacto.numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (!titular.isBlank())
            this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero.matches(NUM_PATTERN))
            this.numero = numero;
    }
}
