/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author josemaria
 */
public class ExportarContactos {
    public static boolean exportarTXT(String filePath, ArrayList<Contacto> listaContactos) {
        File fichero = new File(filePath);
        boolean isExportado;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            bw.write(listaContactos.size()+"\n");
            for (Contacto contacto : listaContactos) {
                bw.write(contacto.getTitular() + ":" + contacto.getNumero()+"\n");
            }
            isExportado = true;
        } catch (IOException ex) {
            isExportado = false;
        }
        return isExportado;
    }
    
    public static boolean exportarXML(String filePath, ArrayList<Contacto> listaContactos) {
        File file = new File(filePath);
        boolean isExport;
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            
            // Documento
            Document doc = docBuilder.newDocument();
            
            // Creamos el elemento playlist con atributos de versión y espacio de nombres
            Element rootElement = doc.createElement("contacts");
            
            // Contact
            for (Contacto c : listaContactos) {
                Element contact = doc.createElement("contact"); // Creamos el Track
                
                contact.appendChild(createElementWithTextContent(doc, "name", c.getTitular()));                
                contact.appendChild(createElementWithTextContent(doc, "phone", c.getNumero()));
                
                rootElement.appendChild(contact);
            }

            // Añadimos todo al documento
            doc.appendChild(rootElement);

            // Creamos el Transformer para transformar a XML
            Transformer tranformer = TransformerFactory.newInstance().newTransformer();
            
            tranformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Indentar el Documento XML
            tranformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // Establece la codificación en UTF-8
            
            // Creamos un objeto StreamResult que especifica el archivo donde se guardará el resultado de la transformación
            StreamResult result = new StreamResult(file);
            // Creamos un objeto DOMSource que contiene el documento XML a transformar
            DOMSource source = new DOMSource(doc);
            
            // Transformamos el documento XML contenido en el objeto DOMSource en el resultado especificado por el objeto StreamResult
            tranformer.transform(source, result);
            
            isExport = true;
        } catch (TransformerException | ParserConfigurationException ex) {
            isExport = false;
        }
        
        return isExport;
    }
    
    /**
     * Método el cual crea un elemento con la etiqueta
     * pasada por parámetro asignándole contenido en su interior.
     * @param doc Documento XML
     * @param tagName Nombre de la Etiqueta XML
     * @param textContent Texto del interior de la etiqueta
     * @return Devuelve un elemento XML
     */
    private static Element createElementWithTextContent(Document doc, String tagName, String textContent) {
        Element element = doc.createElement(tagName); // Creamos un nuevo elemento con el nombre de etiqueta especificado
        element.setTextContent(textContent); // Establecemos el contenido de texto del elemento
        return element; // Devolvemos el elemento creado
    }
}
