package neptunkod;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xPathNeptunkod {
    public static void main(String[] args) {
        try {
            File inputFile = new File("studentNeptunkod.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            // --- UTASÍTÁS SOROK FUTTATÁS UTÁN MEGJEGYZÉSBE TÉVE A KÉRÉS ALAPJÁN ---
            /*
            // 1) Válassza ki az összes student element, amely a class gyermekei!
            System.out.println("1) /class/student:");
            printNodes((NodeList) xPath.compile("/class/student").evaluate(doc, XPathConstants.NODESET));

            // 2) Válassza ki azt a student elemet, amely rendelkezik \"id\" attribútummal és értéke \"02\"!
            System.out.println("\n2) //student[@id='02']:");
            printNodes((NodeList) xPath.compile("//student[@id='02']").evaluate(doc, XPathConstants.NODESET));

            // 3) Kiválasztja az összes student elemet, függetlenül attól, hogy hol vannak a dokumentumban!
            System.out.println("\n3) //student:");
            printNodes((NodeList) xPath.compile("//student").evaluate(doc, XPathConstants.NODESET));

            // 4) Válassza ki a második student element, amely a class root element gyermeke!
            System.out.println("\n4) /class/student[2]:");
            printNodes((NodeList) xPath.compile("/class/student[2]").evaluate(doc, XPathConstants.NODESET));

            // 5) Válassza ki az utolsó student elemet, amely a class root element gyermeke!
            System.out.println("\n5) /class/student[last()]:");
            printNodes((NodeList) xPath.compile("/class/student[last()]").evaluate(doc, XPathConstants.NODESET));

            // 6) Válassza ki a utolsó előtti student elemet, amely a class root element gyermeke!
            System.out.println("\n6) /class/student[last()-1]:");
            printNodes((NodeList) xPath.compile("/class/student[last()-1]").evaluate(doc, XPathConstants.NODESET));

            // 7) Válassza ki az első két student elemet, amelyek a root element gyermekei!
            System.out.println("\n7) /class/student[position() <= 2]:");
            printNodes((NodeList) xPath.compile("/class/student[position() <= 2]").evaluate(doc, XPathConstants.NODESET));
            */

            // Fájlba írás (studentNeptunkod1.xml)
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("studentNeptunkod1.xml"));
            transformer.transform(source, result);
            System.out.println("XML sikeresen kiirva a studentNeptunkod1.xml fajlba.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Blokk forma [student id=" + element.getAttribute("id") + "]:");
                System.out.println("  Vezeteknev: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
                System.out.println("  Keresztnev: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
                System.out.println("  Becenev: " + element.getElementsByTagName("becenev").item(0).getTextContent());
                System.out.println("  Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
            }
        }
    }
}