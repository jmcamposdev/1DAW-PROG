package desarrollozaidin;

/**
 * Clase que representa un Empleado en una Empresa. Heredan de ella: Programador, Comercial.
 * Los atributos son:
 * <ul>
 *     <li>Nombre: El nombre del Empleado no puede estar vacío o contener espacios</li>
 *     <li>Apellidos: Los apellidos del Empleado no puede estar vacío o contener espacios</li>
 *     <li>Salario Base: El salario Base del Empleado debe ser positivo distinto de 0</li>
 *     <li>Años: Los años contratado en la Empresa. Debe de ser positivos o 0.</li>
 * </ul>
 *
 * Implementa la Interfaz Comparable.
 * La cual ordena de los empleados con mayor salario al de menor salario.
 * @see Programador
 * @see Comercial
 */
public abstract class Empleado implements Comparable<Empleado>{
    private String nombre;
    private String apellidos;
    private int salarioBase;
    private int años;

    /**
     * Constructor de la Clase Empleado, recibe Nombre, Apellidos, Salario Base, Años.
     * @param nombre El nombre del Empleado. No puede estar vacío o contener solo espacios en blanco
     * @param apellidos Los apellidos del Empleado. No puede estar vacío o contener solo espacios en blanco
     * @param salarioBase El Salario Base el empleado debe de ser un número positivo distinto de 0.
     * @param años Los años de Experiencia en la Empresa. Debe de ser un número positivo incluido el 0.
     * @throws IllegalArgumentException Si el Nombre introducido está vacío o contiene solo espacios en blanco
     * @throws IllegalArgumentException Si los Apellidos introducidos está vacío o contiene solo espacios en blanco
     * @throws IllegalArgumentException Si el Salario Base introducido es un número negativo.
     * @throws IllegalArgumentException Si los Años introducidos son un número negativo.
     */
    public Empleado(String nombre, String apellidos, int salarioBase, int años) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El valor del Nombre no puede estar vacío o contener solo espacios");
        }
        if (apellidos.isBlank()) {
            throw new IllegalArgumentException("El valor del Apellido no puede estar vacío o contener solo espacios");
        }
        if (salarioBase < 1) {
            throw new IllegalArgumentException("El salario insertado no puede ser negativo o ser 0");
        }
        if (años < 0) {
            throw new IllegalArgumentException("Los años no pueden ser negativos");
        }

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salarioBase = salarioBase;
        this.años = años;
    }

    /**
     * Devuelve el nombre del Empleado
     * @return El nombre del Empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del Empleado si el pasado por parámetro no esta vacío o contiene solo espacios en blanco.
     * @param nombre El nuevo nombre del Empleado
     */
    public void setNombre(String nombre) {
        if (!nombre.isBlank())
            this.nombre = nombre;
    }

    /**
     * Devuelve los Apellidos del Empleado
     * @return Los Apellidos del Empleado
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Modifica los Apellidos del Empleado si el pasado por parámetro no esta vacío o contiene solo espacios en blanco.
     * @param apellidos Los nuevos Apellidos del Empleado
     */
    public void setApellidos(String apellidos) {
        if (!apellidos.isBlank())
            this.apellidos = apellidos;
    }

    /**
     * Devuelve el Salario Base el Empleado
     * @return El Salario Base del Empleado.
     */
    public int getSalarioBase() {
        return salarioBase;
    }

    /**
     * Modifica el Salario Base el Empleado si el pasado por parámetro es positivo.
     * @param salarioBase El nuevo Salario Base el Empleado
     */
    public void setSalarioBase(int salarioBase) {
        if (salarioBase > 0)
            this.salarioBase = salarioBase;
    }

    /**
     * Devuleve los años trabajados del Empleado
     * @return Los años trabjados del empleado
     */
    public int getAños() {
        return años;
    }

    /**
     * Modifica los Años trabajdos del Empleado. Si lo pasado por parámetro son positivos o 0
     * @param años Los nuevos años del Empleado
     */
    public void setAños(int años) {
        if (años >= 0)
            this.años = años;
    }

    public int numeroTrienios() {
        return  años / 3;
    }

    public abstract double calcularSalario();


    /**
     * Devulve un string con formato de todos los valores del Empleado
     * @return Devueleve los valores de Empleados en un String
     */
    @Override
    public String toString() {
        return  "Nombre: " + this.nombre + " " + this.apellidos + "\n" +
                "Salario Base: " + this.salarioBase + "\n" +
                "Años: " + this.años;
    }


    /**
     * Valida si dos Empleados son iguales.
     * Son iguales cuando con el mismo objeto
     * o cuando poseen el mismo nombre y apellidos
     * @param obj El obj Empleado a comparar
     * @return Devolverá True si es igual o false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Empleado empleadoAComparar = (Empleado) obj;
        return this.nombre.equals(empleadoAComparar.nombre) && this.apellidos.equals(empleadoAComparar.apellidos);
    }


    /**
     * Método para comprar dos Empleados, se ordena los primero los que poseen mayor salario
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Empleado o) {
        return (int) (o.calcularSalario() - this.calcularSalario());
    }
}
