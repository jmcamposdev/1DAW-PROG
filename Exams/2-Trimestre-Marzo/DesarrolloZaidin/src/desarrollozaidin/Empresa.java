package desarrollozaidin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  Clase que representa una Empresa con su nombre y una lista de Empleados
 * @see Comercial
 * @see Programador
 */
public class Empresa {
    private String nombre;
    private ArrayList<Empleado> empleados;

    /**
     * El constructor de Empresa el nombre no puede estar vacío o contener solo espacios inicializa la lista de empleados
     * @param nombre
     */
    public Empresa(String nombre) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede estar vacío o contener solo espacios");
        }
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Método para añadir un empleado la empresa no puede existir dos empleados con la misma profesionalidad y  el mismo nombre y apellidos
     * @param e El nuevo empleado a añadir
     * @return Devolverá true si se ha añadido y false en caso contrario
     */
    public boolean añadirEmpleado(Empleado e) {
        boolean empleadoAñadido = !empleados.contains(e);
        if (empleadoAñadido) {
            Empleado nuevoEmpleado;
            if (e instanceof Programador) {
                nuevoEmpleado = new Programador((Programador) e);
                empleados.add(nuevoEmpleado);
            } else if (e instanceof Comercial) {
                nuevoEmpleado = new Comercial((Comercial) e);
                empleados.add(nuevoEmpleado);
            } else {
                empleadoAñadido = false;
            }
        }
        return empleadoAñadido;
    }

    /**
     * Método que añadirá todo los posibles empleados de la lista pasado por parámetro
     * si ya existe no los añaden
     * @param listaEmp  la lista de empleados
     * @return Devuelve el número de empleados añadimos
     */
    public int añadirEmpleados (ArrayList<Empleado> listaEmp) {
        int empleadosAñadidos = 0;
        for (Empleado e :listaEmp) {
            if (añadirEmpleado(e)){
                empleadosAñadidos++;
            }
        }
        return empleadosAñadidos;
    }

    /**
     * Elimina todos los empleados que tengan el nombre y apellidos
     * @param nombre El nombre a eliminar
     * @param apellido Los apellidos a eliminar
     * @return Devuelve true si ha eliminado y false en caso contrario
     */
    public boolean eliminarEmpleado (String nombre, String apellido) {
        return empleados.removeIf(empleadoExistente -> empleadoExistente.getNombre().equals(nombre) && empleadoExistente.getApellidos().equals(apellido));
    }

    /**
     * Elimina todos lo empleados que conincidad con la expresion regular de apellidos
     * @param apellidos La expresion regular
     * @return Devuelve el número de empleados eliminados
     */
    public int eliminarEmpleados (String apellidos) {
        Pattern pattern = Pattern.compile(apellidos);
        int numeroDeEmpleadosEliminados = 0;
        Iterator <Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado empleado = it.next();

            if (pattern.matcher(empleado.getApellidos()).find()) {
                it.remove();
                numeroDeEmpleadosEliminados++;
            }
        }
        return numeroDeEmpleadosEliminados;
    }

    /**
     * Calcula el costo total de los programadores
     * @return el costo total de los programadores
     */
    public double calcularCosteProgramadores() {
        double costeTotalProgramadores = 0;
        for (Empleado e : empleados) {
            if (e instanceof Programador) {
                costeTotalProgramadores += e.calcularSalario();
            }
        }
        return costeTotalProgramadores;
    }

    /**
     * Devuelve los mejores comerciales
     * @param n La cantidad de comerciales a devolver
     * @return Devuelve la lista copiada
     * @throws IllegalArgumentException Si n es invalida esta fuera del rango
     */
    public ArrayList<Comercial> mejoresComerciales (int n) {
        ArrayList<Comercial> comerciales = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e instanceof Comercial) {
                comerciales.add(new Comercial((Comercial) e));
            }
        }

        if (n > comerciales.size()) {
            throw new IllegalArgumentException("El valor pasado sobre pasa la cantidad de comerciales existentes en la Empresa");
        }

        comerciales.sort(new OrdenarMejoresComerciales());
        List<Comercial> mejoresComerciales = comerciales.subList(0,n);
        return new ArrayList<>(mejoresComerciales);
    }

    /**
     * Calcula el coste de todos los empleados
     * @return Calcula el coste de todos los empleados
     */
    public double calcularCosteEmpleados() {
        double costeEmpleados = 0;
        for (Empleado e : empleados) {
            costeEmpleados += e.calcularSalario();
        }
        return costeEmpleados;
    }

    /**
     * Devuelve el número de comerciales que hay en la empresa
     * @return Devuelve el número de comerciales que hay en la empresa
     */
    public int getNumeroComerciales () {
        int numeroComerciales = 0;
        for (Empleado e : empleados) {
            if (e instanceof Comercial) numeroComerciales++;
        }
        return numeroComerciales;
    }

    /**
     * Representa en formato string una empresa
     * @return Devuelve una cadena de texto con el nombre de la empresa y el listado de los empleados con su nombre, profesión
     */
    @Override
    public String toString() {
        StringBuilder empresaString = new StringBuilder();
        empresaString.append("Empresa: ").append(this.nombre).append("\n");
        empresaString.append("Empleados: ").append("\n");
        if (empleados.isEmpty()) {
            empresaString.append("No poseemos Empleados actualmente");
        } else {
            for (int i = 0; i < empleados.size(); i++) {
                empresaString.append(i+1).append(". ").append(empleados.get(i) instanceof Programador ? "Programador - " : "Comercial - ").append(empleados.get(i).getNombre()).append(" ").append(empleados.get(i).getApellidos()).append("\n");
            }
        }
        return empresaString.toString();
    }
}
