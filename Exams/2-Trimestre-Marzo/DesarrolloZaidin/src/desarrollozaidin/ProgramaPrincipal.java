package desarrollozaidin;

import desarrollozaidin.Funciones.GetData;

import java.util.ArrayList;

public class ProgramaPrincipal {
    // Variables Si
    public static final int OPCION_AÑADIR_PROGRAMADOR = 1;
    public static final int OPCION_AÑADIR_COMERCIAL = 2;
    public static final int OPCION_ELIMINAR_EMPLEADO = 3;
    public static final int OPCION_ELIMINAR_EMPLEADOS = 4;
    public static final int OPCION_LISTAR_EMPLEADOS = 5;
    public static final int OPCION_CALCULAR_COSTE_TOTAL_PROGRAMADORES = 6;
    public static final int OPCION_CALCUALAR_COSTE_TOTAL_EMPLEADOS = 7;
    public static final int OPCION_LISTAR_N_MEJORES_COMERCIALES = 8;
    public static final int OPCION_SALIR = 9;

    // OPCIONES DE AÑADIR EMPLEADO
    public static final String OPCION_PROGRAMADOR = "OPCION_PROGRAMADOR";
    public static final String OPCION_COMERCIAL = "OPCION_COMERCIAL";


    public static void main(String[] args) {
        boolean salida = false;
        Empresa empresa;
        System.out.println(imprimirBienvenida());
        String nombreEmpresa = GetData.getString("Ingrese el nombre de la Empresa: ");
        empresa = new Empresa(nombreEmpresa);

        while (!salida) {
            System.out.println(imprimirMenu());
            int userOption = GetData.getInt("Ingrese una opción (1 - 9): ",1,9 );

            switch (userOption) {
                case OPCION_AÑADIR_PROGRAMADOR -> {
                    if (añadirEmpleado(empresa, OPCION_PROGRAMADOR)) {
                        System.out.println("Se ha añadido con exito.");
                    } else {
                        System.out.println("Ya existe otro Programador con el mismo Nombre y Apellidos.");
                    }
                }
                case OPCION_AÑADIR_COMERCIAL -> {
                    if (añadirEmpleado(empresa, OPCION_COMERCIAL)) {
                        System.out.println("Se ha añadido con exito.");
                    } else {
                        System.out.println("Ya existe otro Comercial con el mismo Nombre y Apellidos.");
                    }
                }
                case OPCION_ELIMINAR_EMPLEADO -> {
                    String nombre = GetData.getString("Ingrese el nombre del Empleado a Eliminar: ");
                    String apellidos = GetData.getString("Ingrese los apellidos del Empleado a Eliminar: ");
                    if (empresa.eliminarEmpleado(nombre,apellidos)) {
                        System.out.println("Se ha Eliminado el Empleado correctamente");
                    } else {
                        System.out.println("No se ha encontrado el Empleado");
                    }
                }
                case OPCION_ELIMINAR_EMPLEADOS -> {
                    String apellidos = GetData.getString("Ingrese una Expresion Regular de Apellidos a Eliminar: ");
                    int empleadosEliminados = empresa.eliminarEmpleados(apellidos);
                    System.out.println("Se han eliminado "+empleadosEliminados+" empleados");
                }
                case OPCION_LISTAR_EMPLEADOS ->{
                    System.out.println(empresa);
                }
                case OPCION_CALCULAR_COSTE_TOTAL_PROGRAMADORES ->  {
                    System.out.println("El coste Total de los Programadores es: "+empresa.calcularCosteProgramadores());
                }
                case OPCION_CALCUALAR_COSTE_TOTAL_EMPLEADOS -> {
                    System.out.println("El coste Total de los Empleados es: "+empresa.calcularCosteEmpleados());
                }
                case OPCION_LISTAR_N_MEJORES_COMERCIALES -> {
                    int numeroDeComerciales = empresa.getNumeroComerciales();
                    if (numeroDeComerciales == 0) {
                        System.out.println("No poseemos Comerciales Actualmente.");
                    } else {
                        int numeroComercialesAListar = GetData.getInt("Ingrese el número de Comerciales que deseas listar (1 - "+numeroDeComerciales+"): ",1,numeroDeComerciales);
                        ArrayList<Comercial> mejoresComerciales = empresa.mejoresComerciales(numeroComercialesAListar);
                        for (int i = 0; i < mejoresComerciales.size(); i++) {
                            Comercial comercial = mejoresComerciales.get(i);
                            System.out.println(i+1+". "+comercial.getNombre()+" "+comercial.getApellidos()+" - "+"Número de Ventas "+comercial.getNumeroVentasRealizada());
                        }
                    }
                }
                case OPCION_SALIR -> salida = true;
                default -> System.out.println("Opción no Válida");
            }
        }

    }


    public static boolean añadirEmpleado (Empresa empresa, String tipoEmpleado) {
        boolean estaEmpleadoAñadido = false;
        Empleado nuevoEmpleado = null;
        String nombre = GetData.getString("Ingrese el nombre del Empleado: ");
        String apellidos = GetData.getString("Ingrese los apellidos del Empleado: ");
        int salarioBase = GetData.getInt("Ingrese el Salario Base. Debe de ser positivo: ",1);
        int añosEmpresa = GetData.getInt("Ingrese los años en la empresa. (años >= 0): ",0);

        switch (tipoEmpleado) {
            case OPCION_PROGRAMADOR -> {
                String lenguajeDeProgramacion = GetData.getString("Ingrese el Lenguaje de Programacion: ");
                int plusSalarial = GetData.getInt("Ingrese el Plus Salarial. (plus >= 0): ",0);
                int numeroProyectos = GetData.getInt("Ingrese el Número de Proyectos en los que esta inmerso (proyectos >= 0): ",0);
                nuevoEmpleado = new Programador(nombre,apellidos,salarioBase,añosEmpresa,lenguajeDeProgramacion,plusSalarial,numeroProyectos);
            }
            case OPCION_COMERCIAL -> {
                ZonaVentas zonaVentas = getZonaVentas();
                int numeroDeVetasRealizada = GetData.getInt("Ingrese el número de Ventas Realizada. Mínimo 0: ",0);
                nuevoEmpleado = new Comercial(nombre,apellidos,salarioBase,añosEmpresa,zonaVentas,numeroDeVetasRealizada);
            }
        }

        estaEmpleadoAñadido = empresa.añadirEmpleado(nuevoEmpleado);
        return estaEmpleadoAñadido;
    }

    public static ZonaVentas getZonaVentas () {
        for (ZonaVentas zonaVenta : ZonaVentas.values()) {
            System.out.println(zonaVenta.ordinal()+1+". "+zonaVenta);
        }

        return ZonaVentas.values()[GetData.getInt("A que zona pertenece (1 - 3): ",1,3)-1];
    }


    public static String imprimirBienvenida() {
        return "Bienvenido al Programad e Gestión de Empresa.\n" +
                "Primero de todo vamos a crear la Empresa.";
    }

    public static String imprimirMenu() {
        return """
                1. Añadir Programador.
                2. Añadir Comercial.
                3. Eliminar empleado.
                4. Eliminar empleados.
                5. Listar empleados.
                6. Calcular coste total Programadores.
                7. Calcular coste total Empleados.
                8. Listar los n mejores comerciales.
                9. Salir.""";
    }

}
