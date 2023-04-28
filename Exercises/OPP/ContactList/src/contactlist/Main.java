package contactlist;


public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        int playerNumber = 0;
        System.out.println("Bienvenido a la Lista de Contactos");
        while (playerNumber != 5){
            System.out.println("Indique con su número que opción deseas realizar");
            System.out.println("1) Agregar Contacto");
            System.out.println("2) Eliminar Contacto");
            System.out.println("3) Buscar Contacto");
            System.out.println("4) Listar Contactos");
            System.out.println("5) Salir de la aplicación");
            System.out.print("Integre su opción: ");
            playerNumber = GetData.getInt("Ingrese una opción (1 - 5):",1,5);
            switch (playerNumber){
                case 1 -> contactList.addContact();
                case 2 -> contactList.removeContact();
                case 3 -> contactList.searchContacts();
                case 4 -> contactList.showContacts();
                case 5 -> System.out.println("Gracias por usar la aplicación");
            }
        }
    }
}
