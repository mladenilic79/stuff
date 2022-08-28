package d_external;

import java.io.*;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParsing {

    public static void main(String[] args) throws ParserConfigurationException,
            FileNotFoundException, TransformerConfigurationException, 
            TransformerException, SAXException, IOException {

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< parsing xml >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // parsing objects
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        // optional stuff
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        
        DocumentBuilder db = dbf.newDocumentBuilder();
        // excepting document
        Document doc = db.parse("bookss.xml");
        // optional but recomended ?
        doc.getDocumentElement().normalize();

        // return whole document (root element)
        Element root = doc.getDocumentElement();
        // get document doctype
        System.out.println("doctype " + doc.getDoctype());
        // printing root element
        System.out.println("root element name :" + root.getNodeName());
        // get type of root element
        System.out.println("root node type :" + root.getNodeType());
        // get text content of whole fajl
        System.out.println("text content " + root.getTextContent());

        System.out.println();
        System.out.println("osnova dovde, traversing odavde");
        System.out.println();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< getting nods >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // list nodes by tag name
        NodeList nList = root.getElementsByTagName("book");
        
        // get node / element
        Node nNode1 = nList.item(0);
        Element eElement1 = (Element) nNode1;
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< specification >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // gets node name dependant on its type
        System.out.println("node name " + nNode1.getNodeName());
        // gets node type
        System.out.println("node type " + nNode1.getNodeType());
        // gets name of the tag
        System.out.println("element1 methods " + eElement1.getTagName());
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< navigation >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // gets nodeList of child nodes
        System.out.println("children " + nNode1.getChildNodes());
        // gets specific child
        System.out.println("specific child " + nNode1.getChildNodes().item(0));
        // gets children
        System.out.println("first child " + nNode1.getFirstChild());
        System.out.println("last child " + nNode1.getLastChild());
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< values >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // value dependent on its type
        System.out.println("node value " + nNode1.getNodeValue());
        // get text
        System.out.println("text content " + nNode1.getTextContent());
        // gets attribute if it is element
        System.out.println("attributes " + nNode1.getAttributes().item(0));
        System.out.println("attributes " 
                + nNode1.getAttributes().item(0).getNodeValue());
        // gets attribute value by name
        System.out.println("attribute " + eElement1.getAttribute("isbn"));
        // gets attribute node by name
        System.out.println("attribute " + eElement1.getAttributeNode("isbn"));

        System.out.println();
        System.out.println("traversing dovde, looping odavde");
        System.out.println();
        
        for (int i = 0; i < nList.getLength(); i++) {
            
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            
            // examples of combinations
            System.out.println(
                    eElement.getElementsByTagName(
                            "title").item(0).getTextContent());
            System.out.println(nList.item(i).getFirstChild().getTextContent());
        }

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< editing xml >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // create nodes
        Element book = doc.createElement("book");
        Element title = doc.createElement("title");
        Element author = doc.createElement("author");
        // append nodes
        book.appendChild(title);
        book.appendChild(author);
        root.appendChild(book);
        // set attributes
        book.setAttribute("id", "03");
        book.setAttribute("isbn", "223445");
        // set content
        title.setTextContent("kako se kalio celik");
        author.setTextContent("isac Asimov");

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< writing xml >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // override fajl
        String outputURL = "bookss.xml";
        // transitioning object
        DOMSource xmlDoc = new DOMSource(doc);
        // transitioning objects
        StreamResult result = new StreamResult(new FileOutputStream(outputURL));
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        transformer.transform(xmlDoc, result);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // parsing with getElementById requires xml doctype present in document
        
        // parsing xml
        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder db2 = dbf2.newDocumentBuilder();
        Document doc2 = db2.parse("books.xml");
        
        // get element by id is document interface method
        Element book2 = doc2.getElementById("02");
        // get text content
        System.out.println(book2.getTextContent());
        
    }
    
}
