package poo.EjerciciosLibro.Pizza;

public enum Tipos {
    MARGARITA ("salsa de tomate,queso mozzarella, hojas de albaha"),
    CUATRO_QUESOS ("salsa de tomate,queso Fontina,Parmigiano Reggiano,Mozzarella,Gorgonzola , hojas de albaha"),
    FUNGHI ("salsa de tomate,parmesano,champiñon,mozzarella");

    final String ingredientes;
    Tipos(String ingredientes) {
        this.ingredientes = ingredientes;
    }

}
