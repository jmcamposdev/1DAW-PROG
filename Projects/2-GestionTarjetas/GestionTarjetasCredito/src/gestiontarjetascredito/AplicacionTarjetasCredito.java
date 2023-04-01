package gestiontarjetascredito;

import Funciones.GetData;
public class AplicacionTarjetasCredito {
    public static void main(String[] args) {
        TarjetaCredito[] tarjetasDeCredito = new TarjetaCredito[10]; // Numero de tarjetas
        int posicionDelSiguienteElemento = 0; // Donde se situara la siguiente tarjeta
        boolean salidaDelPrograma = false; // Almacena la salida del programa
        int opcionElegida; // Opción del Usuario
        while (!salidaDelPrograma){
            System.out.println(mostrarMenu()); // Mostramos el menu.
            opcionElegida = GetData.getInt("Ingrese la opción: ",1,5); // Pedimos al usuario que elija una opción
            switch (opcionElegida){ // Dependiendo de la opción elegida realizaos una acción u otra
                case 1 -> { // Crear Tarjeta
                    if (posicionDelSiguienteElemento == tarjetasDeCredito.length){ // Valiamos que exista espacio en el array de Tarjetas
                        System.out.println("No disponemos de mas espacio para crear otra tarjeta. Gracias");
                    } else {
                        TarjetaCredito nuevaTarjeta = crearTarjetaDeCredito(); // Creamos la tarjeta
                        boolean nifDuplicado = validarNIFDuplicado(tarjetasDeCredito,nuevaTarjeta.getNif(),posicionDelSiguienteElemento);  // Validamos que no este duplicado el NIF
                        if (nifDuplicado){
                            System.out.println("El NIF introducido ya esta en uso.");
                        } else {
                            // Añadimos la tarjeta y aumentamos la siguiente posicion de la tarjeta
                            tarjetasDeCredito[posicionDelSiguienteElemento++] = nuevaTarjeta;
                            System.out.println("Se ha creado la Tarjeta exitosamente");
                        }
                    }
                }
                case 2 ->{
                    if (posicionDelSiguienteElemento == 0){
                        System.out.println("No existen tarjetas, deberás crear al menos una.");
                    } else {
                        String nif = getNIF("Ingrese el NIF que desea eliminar: "); // Solicitamos y Validamos NIF
                        int posicionTarjeta = buscarTarjetaDeCredito(tarjetasDeCredito,nif,posicionDelSiguienteElemento); // Buscamos el NIF
                        if (posicionTarjeta == -1){ // Si lo encontramos se lo decimos
                            System.out.println("No se ha encontrado ninguna Tarjeta con NIF: "+nif);
                        } else { // Si existe eliminamos la tarjeta y restamos uno en la  posicionDelSiguienteElemento
                            eliminarTarjeta(tarjetasDeCredito,posicionTarjeta);
                            System.out.println("Se ha eliminado exitosamente la Tarjeta con NIF: "+nif);
                            posicionDelSiguienteElemento--;
                        }
                    }

                }
                case 3 ->{
                    if (posicionDelSiguienteElemento == 0){
                        System.out.println("No existen tarjetas, deberás crear al menos una.");
                    } else {
                        String nif = getNIF("Ingrese el NIF: "); // Solicitamos y Validamos el NIF
                        int posicionTarjeta = buscarTarjetaDeCredito(tarjetasDeCredito,nif,posicionDelSiguienteElemento); // Buscamos el NIF
                        if (posicionTarjeta == -1){ // Si no lo encontramos se lo decimos
                            System.out.println("No se ha encontrado ninguna Tarjeta con NIF: "+nif);
                        } else { // Si existe procedemos a desplegar el submenu
                            boolean salirDelSubmenu = false; // Controla la salida del SubMenu
                            int opcionElegidaSubmenu; // Almacena la opción del usuario
                            while (!salirDelSubmenu){
                                System.out.println(mostrarSubMenu()); // Mostramos el SubMenu
                                opcionElegidaSubmenu = GetData.getInt("Ingrese la opción: ",1,8); // Pedimos al usuario que elija una opción
                                switch (opcionElegidaSubmenu){ // Dependiendo de la opción elegida realizamos una acción u otra
                                    case 1 -> System.out.println("El número de la Tarjeta es: "+tarjetasDeCredito[posicionTarjeta].getNumeroTarjeta()); // Mostramos el número de la tarjeta
                                    case 2 -> System.out.println("El titular de la Tarjeta es: "+tarjetasDeCredito[posicionTarjeta].getTitular()); // Mostramos el Titular
                                    case 3 -> System.out.println("La Tarjeta caduca el: "+tarjetasDeCredito[posicionTarjeta].getMesCaducidad()+"/"+tarjetasDeCredito[posicionTarjeta].getAñoCaducidad()); // Mostramos la fecha de caducidad
                                    case 4 ->{ // Modificamos el PIN
                                        String nuevoPin = getPIN("Ingrese el PIN (Mínimo 4 dígitos): "); // Solicitamos y Validamos el PIN
                                        tarjetasDeCredito[posicionTarjeta].setPin(nuevoPin); // Actualizamos el PIN
                                        System.out.println("Se ha modificado con éxito");
                                    }
                                    case 5 ->{ // Realizamos un Pago
                                        double cantidadAPagar = getCantidad("Ingrese la cantidad a pagar: ",tarjetasDeCredito[posicionTarjeta].getLimite()); // Solicitamos y Validamos la cantidad a Pagar
                                        String concepto = getConcepto("Ingrese el  Concepto (Máximo 50 caracteres): "); // Solicitamos y Validamos el concepto
                                        boolean pagoRealizado = tarjetasDeCredito[posicionTarjeta].pagar(cantidadAPagar,concepto); // Intentamos realizar el Pago
                                        if (!pagoRealizado){ // Si no se realiza le advertimos del error
                                            System.out.println("No se puede realizar el pago ya que excederías el límite o ya has realiza mas de 50 movimientos");
                                        } else { // Si se realiza con existo se lo comentamos
                                            System.out.println("Pago realizado correctamente.");
                                        }
                                    }
                                    case 6 -> { // Consultar los movimientos
                                        if (tarjetasDeCredito[posicionTarjeta].numeroMovimientos() == 0){ // Validamos que haya realizamos al menos 1 movimiento
                                            System.out.println("No se han realizado Movimientos"); // En caso de no poseer movimiento le advertimos
                                        } else { // Si posee movimientos le pedimos cuantos desea mostrar con un Rango: 1 a Número de movimientos de la Tarjeta
                                            int movimientos = GetData.getInt("Cuantos movimientos dese ver:  ",1,tarjetasDeCredito[posicionTarjeta].numeroMovimientos());
                                            System.out.println(tarjetasDeCredito[posicionTarjeta].movimientos(movimientos)); // Mostramos los movimientos
                                        }

                                    }
                                    case 7 -> {
                                        if (tarjetasDeCredito[posicionTarjeta].numeroMovimientos() == 0){
                                            System.out.println("No has realizado movimiento todavía");
                                        } else {
                                            System.out.println("El gasto total asciende a: "+tarjetasDeCredito[posicionTarjeta].gastado()); // Mostramos los gastos totales de la tarjeta
                                        }

                                    }
                                    case 8 -> salirDelSubmenu = true; // Salir del SubMenu
                                    default -> System.out.println("Opción no reconocida inténtelo de nuevo"); // Mostrar en caso de que la opción no sea válida

                                }
                            }
                        }
                    }

                }
                case 4 -> {
                    if (posicionDelSiguienteElemento == 0){
                        System.out.println("No existen tarjetas, deberás crear al menos una.");
                    } else {
                        System.out.println("Los gastos totales son: "+gastosTotales(tarjetasDeCredito,posicionDelSiguienteElemento)); // Muestra la suma de los gastos de todas las tarjetas
                    }
                }
                case 5 ->{ // Salida del Programa
                    salidaDelPrograma = true;
                    System.out.println("Gracias por su visita!");
                }
                default -> System.out.println("Opción no reconocida inténtelo de nuevo"); // Mostrar en caso de que la opción no sea válida
            }
        }


    }
    /*-----------------------
        Crear Tarjeta De Crédito
    -----------------------*/
    public static TarjetaCredito crearTarjetaDeCredito(){ // Solicitamos todos los datos necesarios para Crear una Tarjeta
        String titular = getTitular("Ingrese el titular de la tarjeta (Mínimo 15 caracteres): "); // Solicitamos y Validamos el Titular
        String nif = getNIF("Ingrese el NIF: "); // Solicitamos y Validamos el NIF
        String pin = getPIN("Ingrese el PIN (Mínimo 4 dígitos): "); // Solicitamos y Validamos el PIN
        int limite = getLimite("Ingrese el límite de la tarjeta (500 - 5000): "); // Solicitamos y Validamos el Límite
        String numeroTarjeta = getTarjeta("Ingrese el número de la tarjeta: "); // Solicitamos y Validamos el número de la Tarjeta

        return new TarjetaCredito(titular,nif,pin,limite,numeroTarjeta); // Retornamos el Objeto Tarjeta
    }
    /*-----------------------
       Eliminar Tarjeta de Crédito
   -----------------------*/
    public static void eliminarTarjeta(TarjetaCredito[] tarjetasDeCredito, int posicion){
        System.arraycopy(tarjetasDeCredito,posicion+1,tarjetasDeCredito,posicion,tarjetasDeCredito.length-posicion-1);
        tarjetasDeCredito[tarjetasDeCredito.length-1] = null;
    }
    public static int buscarTarjetaDeCredito(TarjetaCredito[] tarjetasDeCredito,String nif,int tarjetasExistentes){
        int posicion = -1;
        boolean tarjetaEncontrada = false;
        for (int i = 0; i < tarjetasExistentes && !tarjetaEncontrada; i++) {
            if (tarjetasDeCredito[i].getNif().equals(nif)){
                posicion = i;
                tarjetaEncontrada = true;
            }
        }
        return posicion;
    }
    /*-----------------------
        NIF Duplicado
    -----------------------*/
    public static boolean validarNIFDuplicado(TarjetaCredito[] tarjetasDeCredito, String nif, int tarjetasExistentes){
        boolean nifDuplicado = false;
        for (int i = 0; i < tarjetasExistentes && !nifDuplicado; i++) {
            if (tarjetasDeCredito[i].getNif().equals(nif)){
                nifDuplicado = true;
            }
        }
        return nifDuplicado;
    }
    /*-----------------------
        Gastos Totales
    -----------------------*/
    public static double gastosTotales(TarjetaCredito[] tarjetasDeCredito,int tarjetasExistentes){
        double gastosTotales = 0;
        for (int i = 0; i < tarjetasExistentes; i++) {
            gastosTotales += tarjetasDeCredito[i].gastado();
        }
        return gastosTotales;
    }

    /*-----------------------
        Solicitudes
    -----------------------*/
    public static String getTitular(String mensaje){ // Validar Titular
        String titular;
        boolean datoValido;
        do {
            titular = GetData.getString(mensaje);
            datoValido = TarjetaCredito.validarTitular(titular);
            if (!datoValido)
                System.out.println("Valor del titular no válido inténtelo de nuevo. (Mínimo 15 caracteres)");
        } while (!datoValido);
        return titular;
    }
    public static String getNIF(String mensaje){ // Validar NIF
        String nif;
        boolean datoValido;
        do {
            nif = GetData.getString(mensaje);
            datoValido = TarjetaCredito.validarNIF_NIE_CIF(nif);
            if (!datoValido)
                System.out.println("Valor del NIF no válido inténtelo de nuevo");
        } while (!datoValido);
        nif = nif.toUpperCase();
        return nif;
    }
    public static String getPIN(String mensaje){ // Validar PIN
        String pin;
        boolean datoValido;
        do {
            pin = GetData.getString(mensaje);
            datoValido = TarjetaCredito.validarPin(pin);
            if (!datoValido)
                System.out.println("Valor del PIN no válido inténtelo de nuevo");
        } while (!datoValido);
        return pin;
    }
    public static int getLimite(String mensaje){ // Validar Límite
        int limite;
        boolean datoValido;
        do {
            limite = GetData.getInt(mensaje,500, 5000);
            datoValido = limite >= 500 && limite <= 5000;
            if (!datoValido)
                System.out.println("Valor del límite fuera del rango (500 - 5000)");
        } while (!datoValido);
        return limite;
    }
    public static String getTarjeta(String mensaje){ // Validar Tarjeta
        String numeroTarjeta;
        boolean datoValido;
        do {
            numeroTarjeta = GetData.getString(mensaje);
            datoValido = TarjetaCredito.validarDigitosTarjeta(numeroTarjeta);
            if (!datoValido){
                System.out.println("Inserte solo dígitos numéricos");
            } else {
                datoValido = TarjetaCredito.comprobarNumeroTarjeta(numeroTarjeta);
                if (!datoValido){
                    System.out.println("Tarjeta no válida. Inténtelo de nuevo");
                }
            }
        } while (!datoValido);
        return numeroTarjeta;
    }
    public static double getCantidad(String mensaje,int limite){ // Validar Cantidad
        double cantidadAPagar;
        boolean datoValido;
        do {
            cantidadAPagar = GetData.getDouble(mensaje,1,limite);
            datoValido = Movimiento.validarCantidad(cantidadAPagar);
            if (!datoValido){
                System.out.println("Cantidad no válida debe ser positiva");
            }
        } while (!datoValido);
        return cantidadAPagar;
    }
    public static String getConcepto(String mensaje){ // Validar Concepto
        String concepto;
        boolean datoValido;
        do {
            concepto = GetData.getString(mensaje);
            datoValido = Movimiento.validarConcepto(concepto);
            if (!datoValido){
                System.out.println("El concepto no puede permanecer vacío y debe poseer un máximo de 50 caracteres");
            }
        } while (!datoValido);
        return concepto;
    }
    /*-----------------------
        Mostrar Menus
    -----------------------*/
    // He utilizado Text Block, ya que muestran literalmente lo que escribo.
    public static String mostrarMenu(){
        return """
                1.- Crear Tarjeta de Crédito.
                2.- Eliminar Tarjeta de Crédito.
                3.- Gestionar Tarjeta de Crédito.
                4.- Consultar Gastos Totales.
                5.- Salir del Programa.
                """;
    }
    public static String mostrarSubMenu(){
        return """
                1.- Mostrar el número de tarjeta completo.
                2.- Mostrar el nombre del titular de la tarjeta.
                3.- Mostrar la fecha de caducidad.
                4.- Modificar el PIN.
                5.- Realizar un pago.
                6.- Consultar movimientos.
                7.- Consultar gasto total.
                8.- Volver al menú principal.
                """;
    }
}
