package contactlist;

import java.util.Objects;
import java.util.Scanner;

public class Contact {
    private String name;
    private String address;
    private int telephone;
    private String email;

    public Contact(String name, String address, int telephone, String email){
        if (name == null || name.equals("")){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (address == null || address.equals("")){
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        if (telephone <= 0){
            throw new IllegalArgumentException("El número de teléfono no puede ser negativo");
        }
        if (email == null || email.equals("")){
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public Contact(String name){
        this(name, "Calle Desconocida", 1, "desconocido");
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getTelephone(){
        return telephone;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
