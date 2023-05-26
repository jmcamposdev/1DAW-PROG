package JPA.exceptions;

/**
 * Clase que representa una excepción de un objeto inexistente.
 * Se lanza cuando se intenta acceder a un objeto que no existe.
 * Se utiliza para evitar que se acceda a objetos que no existen.
 * Hereda de la clase Exception.
 */
public class NonexistentEntityException extends Exception {
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
