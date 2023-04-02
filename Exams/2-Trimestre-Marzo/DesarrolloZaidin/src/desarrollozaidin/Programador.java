package desarrollozaidin;


/**
 * Clase que representa un Programador es una subClase de Empleado
 * La clase se compone de:
 * <ul>
 *     <li>Los valores de Empleado</li>
 *     <li>Lenguaje de Programación: No debe de estar vacío o contener solo espacios</li>
 *     <li>Plus Salarial: El plus Salarial del Programados no puede ser negativo</li>
 *     <li>Numero de Proyectos: El número de Proyectos en el que esta inmerso no puede ser negativo</li>
 * </ul>
 * @see Empleado
 */
public class Programador extends Empleado{
    private String lenguajeDeProgramacion;
    private int plusSalarial;
    private int numeroProyectos;

    /**
     * Constructor de Progrmador crea un nuevo Obj Programador. Con los Valores:
     * Nombre, apellidos, Salario base, años trabajados en la empresa, lenguaje de programacio,
     * plus salarial, número de proyectos.
     * @param nombre El nombre del Empleado. No puede estar vacío o contener solo espacios en blanco
     * @param apellidos Los apellidos del Empleado. No puede estar vacío o contener solo espacios en blanco
     * @param salarioBase El Salario Base el empleado debe de ser un número positivo distinto de 0.
     * @param años Los años de Experiencia en la Empresa. Debe de ser un número positivo incluido el 0.
     * @param lenguajeDeProgramacio El lenguaje de Programacion del Programador no puede estar vacío o contener solo espacios.
     * @param plusSalarial El plus Salario no puede ser un número negativo, mínimo 0.
     * @param numeroProyectos El número de Proyectos en el que esta inmerso no puede ser un número negativo.
     * @throws IllegalArgumentException Si el Nombre introducido está vacío o contiene solo espacios en blanco
     * @throws IllegalArgumentException Si los Apellidos introducidos está vacío o contiene solo espacios en blanco
     * @throws IllegalArgumentException Si el Salario Base introducido es un número negativo.
     * @throws IllegalArgumentException Si los Años introducidos son un número negativo.
     * @throws IllegalArgumentException Si el Lenguaje de Programacion está vacío o contiene solo espacios.
     * @throws IllegalArgumentException Si el Plus Salaria es un número negativo
     * @throws IllegalArgumentException Si el número de Proyectos es un número negativo
     */
    public Programador(String nombre, String apellidos, int salarioBase, int años, String lenguajeDeProgramacio, int plusSalarial, int numeroProyectos) {
        super(nombre, apellidos, salarioBase, años);
        if (lenguajeDeProgramacio.isBlank()) {
            throw new IllegalArgumentException("El lenguaje de Programación no puede estar vacío");
        }
        if (plusSalarial < 0) {
            throw new IllegalArgumentException("El Plus Salarial no puede ser negativo");
        }
        if (numeroProyectos < 0) {
            throw new IllegalArgumentException("El número de Proyectos no puede ser negativo");
        }
        this.lenguajeDeProgramacion = lenguajeDeProgramacio;
        this.plusSalarial = plusSalarial;
        this.numeroProyectos = numeroProyectos;
    }

    /**
     * Constructor Copia recibe un Programador y realiza una copia profunda de todos sus valores
     * @param programador El Objeto Programador a copiar
     */
    public Programador (Programador programador) {
        super(programador.getNombre(),programador.getApellidos(),programador.getSalarioBase(),programador.getAños());
        this.lenguajeDeProgramacion = programador.lenguajeDeProgramacion;
        this.plusSalarial = programador.plusSalarial;
        this.numeroProyectos = programador.numeroProyectos;
    }

    /**
     * Devuelve la el lenguaje de programacion del Programador
     * @return el lenguaje de programacion del Programador
     */
    public String getLenguajeDeProgramacion() {
        return lenguajeDeProgramacion;
    }

    /**
     * Modifca el Lenguaje de Programación del programador lo modificará si el pasado por parámetor no esta vacío o contiene solo espacios
      * @param lenguajeDeProgramacio El nuevo lenguaje de programacion
     */
    public void setLenguajeDeProgramacion(String lenguajeDeProgramacio) {
        if (!lenguajeDeProgramacio.isBlank())
            this.lenguajeDeProgramacion = lenguajeDeProgramacio;
    }

    /**
     * Devuelve el Plus Salaria del Programador
     * @return el Plus Salaria del Programador
     */
    public int getPlusSalarial() {
        return plusSalarial;
    }

    /**
     * Modifica el Plus Salarial del Programador lo modificará si el pasado por parámetro es positivo o 0
     * @param plusSalarial El nuevo Plus Salaria
     */
    public void setPlusSalarial(int plusSalarial) {
        if (plusSalarial >= 0)
            this.plusSalarial = plusSalarial;
    }

    /**
     * Devuelve el Número de Proyectos
     * @return el Número de Proyectos
     */
    public int getNumeroProyectos() {
        return numeroProyectos;
    }

    /**
     * Modifica el Número de Proyectos del Programador lo modificará si el pasado por parámetro es positivo o 0
     * @param numeroProyectos El nuevo número de proyectos
     */
    public void setNumeroProyectos(int numeroProyectos) {
        if (numeroProyectos >= 0)
            this.numeroProyectos = numeroProyectos;
    }

    /**
     * Devuelve una representaciion en forma de String del Objeto Programador
     * @return Devuelve una cadena de Texto con la información del Programador
     */
    @Override
    public String toString() {
        return "Programador: " + "\n" +
                super.toString() + "\n" +
                "Lenguaje de Programación: " + this.lenguajeDeProgramacion + "\n" +
                "Plus Salarial: " + this.plusSalarial + "\n" +
                "Numero de Proyectos:" + this.numeroProyectos;
    }

    /**
     * Método sobreescrito que calcula el Salario del Programador.
     * El salario se suma 100 euros por cada trienio en la empresa
     * mas el Plus Salarial.
     * @return
     */
    @Override
    public double calcularSalario() {
        return getSalarioBase() + this.plusSalarial +  (numeroTrienios() * 100);
    }
}
