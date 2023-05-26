package JDBC;

import modelo.Movimiento;
import modelo.TarjetaCredito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el Modelo DAO (Data Access Object) de Tarjeta
 * el cual crea, lee, actualiza y borra datos sobre la tarjeta
 * también inserta y borra datos sobre su entidad Débil Movimiento.
 * Todas las operaciones las realiza a través de JDBC
 * @author josemaria
 */
public class TarjetaCreditoDAO implements Dao<TarjetaCredito> {
    private final Connection conexion; // Conexión con la base de datos
    private final String USER = "postgres"; // Usuario de la base de datos
    private final String PASSWORD = ""; // Contraseña de la base de datos
    private final String URL = "jdbc:postgresql://localhost:5432/tarjetacredito"; // URL de la base de datos

    /**
     * Constructor de la clase TarjetaCreditoDAO el cual se conecta con la base de datos
     * creando una conexión con la base de datos
     */
    public TarjetaCreditoDAO() throws SQLException {
        conexion = getConnection();
    }

    /**
     * Método privado el cual se conecta con la base de datos y 
     * devuelve la conexión en caso de fallo devolverá null.
     * @return Devuelve la Conexión o null si a ocurrido algún error
     * al tratar de conectarse
     */
    private Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }

    /**
     * Método encargado de cerrar la conexión si está abierta
     */
    public void closeConnection() throws SQLException{
        if (conexion != null) {
            conexion.close();
        }
    }

    /**
     * Método que lee una tarjeta de la base de datos la encuentra en
     * basándonos en el número de Tarjeta que se le pasa por parámetro.
     * Si no la encuentra devolverá null.
     * @param numeroTarjeta Número de la Tarjeta a encontrar
     * @return Devolverá la Tarjeta si la ha encontrado y null en caso contrario
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    @Override
    public TarjetaCredito read(String numeroTarjeta) throws SQLException  {
        TarjetaCredito tarjetaCredito = null; // Tarjeta que se devolverá
        // Si la conexión no es null y el número de tarjeta es válido
        if (conexion != null && TarjetaCredito.validarDigitosTarjeta(numeroTarjeta)) {
            String query = "SELECT * FROM tarjetacredito WHERE numero_tarjeta = ?"; // Query para obtener la tarjeta
            try (PreparedStatement statement = conexion.prepareStatement(query)){ // Se crea un Statement
                statement.setString(1, numeroTarjeta); // Se añade el número de tarjeta a la query
                ResultSet result = statement.executeQuery(); // Se ejecuta la query
                if (result.next()) { // Si ha encontrado la tarjeta
                    tarjetaCredito = extractTarjetaFromResultSet(result); // Se extrae la tarjeta
                    // Se añaden los movimientos a la tarjeta
                    cargarMovimientos(tarjetaCredito, readAllMovimientos(tarjetaCredito));
                }
            }
        }
        return tarjetaCredito;
    }

    /**
     * Método que lee todas las tarjetas de la base de datos.
     * @return Devolverá un List vacío si no ha encontrado ninguna tarjeta en caso contrario 
     * devolverá el objeto List con x longitud
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    @Override
    public List<TarjetaCredito> readAll() throws SQLException {
       List<TarjetaCredito> tarjetas = new ArrayList<>(); // Lista de tarjetas
       TarjetaCredito tarjetaCredito; // Tarjeta que se añadirá a la lista
       if (conexion != null) { // Si la conexión no es null
           String query = "SELECT * FROM tarjetacredito"; // Query para obtener todas las tarjetas
           try (Statement statement = conexion.createStatement()) { // Se crea un Statement
               ResultSet result = statement.executeQuery(query); // Se ejecuta la query
               while (result.next()) { // Mientras haya tarjetas
                   tarjetaCredito = extractTarjetaFromResultSet(result); // Se extrae la tarjeta
                   // Se añaden los movimientos a la tarjeta
                   cargarMovimientos(tarjetaCredito, readAllMovimientos(tarjetaCredito));
                   tarjetas.add(tarjetaCredito); // Se añade la tarjeta a la lista
               }
           }
       }
         return tarjetas;
    }
    
    /**
     * Método que lee todos los movimientos realizados de la Tarjeta
     * pasada por parámetro, devolverá una lista con los movimientos realizados
     * si no ha realizado ningún movimiento la lista estará vacía
     * @param tarjetaCredito Tarjeta de la cual se obtendrán todos los movimientos
     * que ha realizado
     * @return Devolverá una lista con los movimientos que ha realizado si no ha 
     * realizado ningún movimiento la lista estará vacía
     */
    private List<Movimiento> readAllMovimientos(TarjetaCredito tarjetaCredito) throws SQLException{
        List<Movimiento> movimientos = new ArrayList<>();
        if (conexion != null) {
            String query = "SELECT * FROM movimientos WHERE id_numero_tarjeta = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, tarjetaCredito.getNumeroTarjeta());
                ResultSet result = statement.executeQuery();
                movimientos = extractMovimientosFromResultSet(result);
            }
        }
        return movimientos;
    }


    /**
     * Método que actualiza la tarjeta pasada en la base de datos, si
     * no existe la tarjeta en la base de datos no se realizará ningún cambio
     * en caso contrario se actualizarán todos los datos en base a los datos 
     * del Objeto Tarjeta pasado por parámetro
     * @param tarjetaCredito La Tarjeta de credito a actualizar en la base de datos
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    @Override
    public void update(TarjetaCredito tarjetaCredito) throws SQLException {
        if (conexion != null) {
            String query = "UPDATE tarjetacredito SET titular = ?, nif = ?, pin = ?, limite = ?, mes_caducidad = ?, anio_caducidad = ?, cvv = ? WHERE numero_tarjeta = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                insertarDatosStatement(tarjetaCredito, statement);
                statement.setString(7, tarjetaCredito.getCvv());
                statement.setString(8, tarjetaCredito.getNumeroTarjeta());
                statement.executeUpdate();
            }
        }
    }

    /**
     * Método privado encargado de insertar los datos de la tarjeta
     * pasada por parámetro al PreparedStatement pasado por parámetro
     * @param tarjetaCredito Objeto Tarjeta a cargar en el PreparedStatement
     * @param statement Objeto PreparedStatement en el que se cargarán los datos de la tarjeta
     * @throws SQLException Lanzará la excepción si no se puede insertar los datos en el PreparedStatement o
     * sobre pasa los campos.
     */
    private void insertarDatosStatement(TarjetaCredito tarjetaCredito, PreparedStatement statement) throws SQLException {
        statement.setString(1, tarjetaCredito.getTitular());
        statement.setString(2, tarjetaCredito.getNif());
        statement.setString(3, tarjetaCredito.getPin());
        statement.setInt(4, tarjetaCredito.getLimite());
        statement.setInt(5, tarjetaCredito.getMesCaducidad());
        statement.setInt(6, tarjetaCredito.getAñoCaducidad());
    }

    /**
     * Método para eliminar una tarjeta de la base de datos
     * la tarjeta se limpiará basándonos en el número de tarjeta
     * si no existe ninguna tarjeta con ese número no se realizará
     * ninguna modificación
     * @param tarjetaCredito El objeto Tarjeta a eliminar de la base de datos
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    @Override
    public void delete(TarjetaCredito tarjetaCredito) throws SQLException {
        if (conexion != null) {
            String query = "DELETE FROM tarjetacredito WHERE numero_tarjeta = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, tarjetaCredito.getNumeroTarjeta());
                statement.executeUpdate();
            }
        }
    }
    
    /**
     * Método para eliminar una lista de tarjetas de la base de datos
     * se eliminarán basándonos en el número de la tarjeta
     * @param listaTarjetas Lista de Tarjetas a eliminar de la base de datos
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    public void delete(ArrayList<TarjetaCredito> listaTarjetas) throws SQLException {
        for (TarjetaCredito tarjeta: listaTarjetas) {
            this.delete(tarjeta);
        }
    }

    /**
     * Método para insertar una nueva tarjeta a la base de datos.
     * En la base de datos se guardarán todos los atributos necesarios.
     * Se guardará en la base de datos si no existe otra tarjeta con el mismo número
     * @param t Nueva Tarjeta a insertar en la base de datos
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    @Override
    public void insert(TarjetaCredito t) throws SQLException{
        if (conexion != null) {
            String query = "INSERT INTO tarjetacredito (titular, nif, pin, limite, mes_caducidad, anio_caducidad, numero_tarjeta, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                insertarDatosStatement(t, statement);
                statement.setString(7, t.getNumeroTarjeta());
                statement.setString(8, t.getCvv());
                statement.executeUpdate();
            }
        }
    }
    
    /**
     * Método para insertar un nuevo movimiento en la base de datos
     * se insertará el movimiento referenciado a la tarjeta de Credito pasada por
     * parámetro.
     * @param movimiento Movimiento a insertar en la base de datos
     * @param tarjetaCredito Tarjeta en la que se registrará el nuevo movimiento
     * @throws SQLException Lanzará la excepción si ha ocurrido algún error al realizar
     * la operación con la base de datos
     */
    public void insertMovimiento (Movimiento movimiento, TarjetaCredito tarjetaCredito) throws SQLException {
        if (conexion != null) {
            String query = "INSERT INTO movimientos (id_numero_tarjeta, cantidad, concepto, fecha) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, tarjetaCredito.getNumeroTarjeta());
                statement.setDouble(2, movimiento.getCantidad());
                statement.setString(3, movimiento.getConcepto());
                statement.setTimestamp(4, Timestamp.valueOf(movimiento.getFecha()));
                statement.executeUpdate();
            }
        }
    }

    /**
     * Método privado para extraer una tarjeta del ResultSet pasado por parámetro.
     * @param result Objeto ResultSet para leer la tarjeta
     * @return Devolverá el objeto TarjetaCredito leído del ResultSet
     * @throws SQLException Lanzará excepción si el ResultSet no posee todos los parámetros necesarios
     */
    private TarjetaCredito extractTarjetaFromResultSet(ResultSet result) throws SQLException {
        return new TarjetaCredito(
                result.getString("titular"),
                result.getString("nif"),
                result.getString("pin"),
                result.getInt("limite"),
                result.getInt("mes_caducidad"),
                result.getInt("anio_caducidad"),
                result.getString("numero_tarjeta"),
                result.getString("cvv")
        );
    }

    /**
     * Método privado para extraer un movimiento del ResultSet pasado por parámetro.
     * @param result Objeto ResultSet para leer el Movimiento
     * @return Devolverá el objeto Movimiento leído del ResultSet
     * @throws SQLException Lanzará excepción si el ResultSet no posee todos los parámetros necesarios
     */
    private List<Movimiento> extractMovimientosFromResultSet(ResultSet result) throws SQLException{
        List<Movimiento> movimientos = new ArrayList<>();
        while (result.next()) {
            Movimiento movimiento = new Movimiento(
                    result.getDouble("cantidad"),
                    result.getString("concepto"),
                    result.getTimestamp("fecha").toLocalDateTime()
                    );
            movimientos.add(movimiento);
        }
        return movimientos;
    }

    private void cargarMovimientos(TarjetaCredito tarjetaCredito, List<Movimiento> movimientos) {
        for (Movimiento movimiento: movimientos) {
            tarjetaCredito.pagar(movimiento);
        }
    }
}
