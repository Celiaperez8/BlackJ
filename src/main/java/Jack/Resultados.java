package Jack;

import java.io.FileOutputStream;
import java.io.IOException;
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

    public class Resultados {
        private String archivo;

        public Resultados(String archivo) {
            this.archivo = archivo;
        }

        public void guardarResultado(int puntuacion) {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Resultados");
                doc.appendChild(rootElement);


                Element resultadoElement = doc.createElement("Resultado");
                rootElement.appendChild(resultadoElement);


                Element puntuacionElement = doc.createElement("Puntuacion");
                puntuacionElement.appendChild(doc.createTextNode(String.valueOf(puntuacion)));
                resultadoElement.appendChild(puntuacionElement);


                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new FileOutputStream(archivo));
                transformer.transform(source, result);

                System.out.println("Resultado guardado en el archivo " + archivo);
            } catch (ParserConfigurationException | TransformerException | IOException e) {
                e.printStackTrace();
            }
        }
    }


