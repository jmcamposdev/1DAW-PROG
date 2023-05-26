package JPA.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una excepción de un objeto huérfano.
 * Se lanza cuando se intenta eliminar un objeto que tiene objetos relacionados.
 * Se utiliza para evitar que se eliminen objetos relacionados.
 * Hereda de la clase Exception.
 */
public class IllegalOrphanException extends Exception {
    private List<String> messages;
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }
    public List<String> getMessages() {
        return messages;
    }
}
