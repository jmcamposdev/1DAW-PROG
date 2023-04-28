package contactlist;

import java.util.ArrayList;

public class ContactList {
    private final ArrayList<Contact> contactArrayList;

    public ContactList() {
        contactArrayList = new ArrayList<>();
    }

    public void addContact(){
        String name = GetData.getString("Ingrese el nombre del contacto: ");
        String address = GetData.getString("Ingrese la dirección: ");
        int telephone = GetData.getInt("Ingrese el número de teléfono: ");
        String email = GetData.getString("Ingrese el email: ");
        Contact contact = new Contact(name, address, telephone, email);
        contactArrayList.add(contact);
    }

    public void removeContact(){
        if (contactArrayList.isEmpty()){
            System.out.println("No tienes Contactos todavía");
        } else{
            System.out.println("\nEliminar Contacto");
            String removeName = GetData.getString("Ingrese el nombre del contacto a eliminar: ");
            int index = contactArrayList.indexOf(new Contact(removeName));
            if (index != -1){
                System.out.println("Se ha eliminado el contacto con éxito");
                contactArrayList.remove(index);
            } else {
                System.out.println("No se ha encontrado el contacto");
            }
        }
    }

    public void searchContacts(){
        if (contactArrayList.isEmpty()){
            System.out.println("No tienes Contactos todavía");
        } else {
            String searchName = GetData.getString("Ingrese el nombre del contacto a buscar: ");
            ArrayList<Contact> searchArray = new ArrayList<>();
            for (Contact contact : contactArrayList) {
                if (contact.getName().equals(searchName)) {
                    searchArray.add(contact);
                }
            }
            if (searchArray.isEmpty()){
                System.out.println("No se ha encontrado resultados");
            } else {
                showContacts(searchArray);
            }
        }
    }

    public void showContacts(){
        showContacts(contactArrayList);
    }

    private void showContacts(ArrayList<Contact> contactArrayList){
        int index = 1;
        if ( contactArrayList.isEmpty()){
            System.out.println("No tienes Contactos todavía");
        } else {
            System.out.println("\nListado de contactos: ");
            contactArrayList.stream().map(contact -> index + ") " + contact.getName() + " | " + contact.getAddress() + " | " + contact.getTelephone() + " | " + contact.getEmail()).forEach(System.out::println);
            System.out.println(" ");
        }
    }

}
