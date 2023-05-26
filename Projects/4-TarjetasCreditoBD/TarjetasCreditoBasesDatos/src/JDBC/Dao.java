package JDBC;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define métodos abstractos para realizar
 * las operaciones CRUD (create, read, update and delete)
 * en objetos de tipo T.
 * DAO (Data Access Object)
 * @author josemaria
 */

public interface Dao<T> {
    /**
     * Lee un objeto de tipo T a partir del id.
     * @param id el ID del objeto a leer
     * @return el objeto de tipo T encontrado o null si no existe
     * @throws SQLException si ocurre un error en la operación de lectura
     */
    T read (String id) throws SQLException;
    
    /**
     * Lee todos los objetos de tipo T almacenados.
     * @return una lista con todos los objetos de tipo T encontrados
     * @throws SQLException si ocurre un error en la operación de lectura
     */
    List<T> readAll() throws SQLException;
    
    /**
     * Inserta un nuevo objeto de tipo T.
     * @param t el objeto de tipo T a insertar
     * @throws SQLException si ocurre un error en la operación de inserción
     */
    void insert(T t) throws SQLException;
    
    /**
     * Actualiza un objeto de tipo T.
     * @param t el objeto de tipo T a actualizar
     * @throws SQLException si ocurre un error en la operación de actualización
     */
    void update(T t) throws SQLException;
    
    /**
     * Elimina un objeto de tipo T.
     * @param t el objeto de tipo T a eliminar
     * @throws SQLException si ocurre un error en la operación de eliminación
     */
    void delete(T t) throws SQLException;
    
}
