package JPA.exceptions;

/**
 * Clase que representa una excepción de un objeto preexistente.
 * Se lanza cuando se intenta crear un objeto que ya existe.
 * Se utiliza para evitar que se creen objetos que ya existen.
 * Hereda de la clase Exception.
 */
public class PreexistingEntityException extends Exception {
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
