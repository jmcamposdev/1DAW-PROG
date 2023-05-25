package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ImportarContactos {

    public static ArrayList<Contacto> importContactsTXT(String filePath) {
        ArrayList<Contacto> listaContactos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int numberOfContacts = Integer.parseInt(br.readLine());

            for (int i = 0; i < numberOfContacts; i++) {
                String[] contact = br.readLine().split(":");
                String name = contact[0];
                String phone = contact[1];

                listaContactos.add(new Contacto(name, phone));
            }

            if (numberOfContacts != listaContactos.size()) {
                listaContactos = null;
            }

        } catch (IOException ex) {
            listaContactos = null;
        }

        return listaContactos;
    }

    public static ArrayList<Contacto> importContactsXML(String filePath) {
        ArrayList<Contacto> listaContactos = new ArrayList<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // Creamos el Factory
            DocumentBuilder db = dbf.newDocumentBuilder(); // Inicializamos un nuevo Documento
            Document doc = db.parse(new File(filePath)); // Cargamos el XSPF

            NodeList list = doc.getElementsByTagName("contact"); // Buscamos todos los track

            for (int temp = 0; temp < list.getLength(); temp++) { // Iteramos todos los track
                Node node = list.item(temp); // Obtenemos el track
                if (node.getNodeType() == Node.ELEMENT_NODE) { // Si es un elemento
                    Element element = (Element) node; // Transformamos el Node (Track) a Element

                    // Obtenemos el contenido del <title>
                    String nombre = element.getElementsByTagName("name").item(0).getTextContent();
                    // Obtenemos el contenido del <location>
                    String telefono = element.getElementsByTagName("phone").item(0).getTextContent();
                    listaContactos.add(new Contacto(nombre, telefono));
                }

            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            listaContactos = null;
        }

        return listaContactos;
    }
}
