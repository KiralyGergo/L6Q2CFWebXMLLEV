package l6q2cfdom;
import java.io.File;
import java.io.IOException;

import java.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DOMszabvany {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new(pathname:"XMLL6Q2CF.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuiler = factory.newDocumentBuilder();
        Document doc = dBuiler.parse(xmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element:"+doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("etterem");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element:"+nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem=(Element) nNode;
                String id = elem.getAttribute(name:"ekod");
                Node nodel = elem.getElementsBytagName("Nev".item(index:0));
                String nev = nodel.getTextContent();
                Node nodel = elem.getElementsBytagName("varos".item(index:0));
                String nev = nodel.getTextContent();
                Node nodel = elem.getElementsBytagName("utca".item(index:0));
                String nev = nodel.getTextContent();
                Node nodel = elem.getElementsBytagName("hazszam".item(index:0));
                String nev = nodel.getTextContent();
                Node nodel = elem.getElementsBytagName("csillag".item(index:0));
                String nev = nodel.getTextContent();

                String adr = city +"; " + street +" utca " + number + ".";

                System.out.println(id);
                System.out.println(name);
                System.out.println(adr);
                System.out.println(stars);

            }
        }

    }
}