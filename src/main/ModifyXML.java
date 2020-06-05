package main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModifyXML {
    public static void modifyxml(File file, String input) throws ParserConfigurationException, SAXException, IOException, TransformerException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        Node creditoraccount = doc.getElementsByTagName("CdtrAcct").item(0);

        NodeList list = creditoraccount.getChildNodes();
        System.out.println(list.toString());

        for (int i=0;i<list.getLength();i++)
        {
            Node node = list.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                if("IBAN".equals(element.getNodeName())) {
                    element.setTextContent(input);
                    System.out.println("Content has been correctly modified");
                    System.out.println(element.getTextContent());
                }
            }
        }
    }
}
