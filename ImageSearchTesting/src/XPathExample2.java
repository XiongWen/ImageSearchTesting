/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shawn
 */
import java.io.IOException;
import java.util.List;
 
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
  
public class XPathExample2 {
//    private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/rss.xml?edition=int";
  
    
    
    
    private static String imgResultSource = "https://www.google.com.au/search?tbs=simg:CAESpAEaoQELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjzFtoM4AjIFNIN3wvfCOcL7RQaIK0fqlUUxM_1AMJWB6Na89I44EusgIx7fF_1AQGiF7HytoDAsQjq7-CBoKCggIARIEVu2-vAwLEJ3twQkaNQoGCgRsb2dvCgYKBHRleHQKBgoEZm9udAoNCgthbGxveSB3aGVlbAoMCgphdXRvbW9iaWxlDA&q=audi+logo&tbm=isch&sa=X&ei=PTh0U8ajC8ftkgWa-4DYAg&ved=0CDgQsw4&biw=1280&bih=635";
    public static void main(String[] args) throws JDOMException, IOException {
  
        // read the XML into a JDOM2 document.
        SAXBuilder jdomBuilder = new SAXBuilder();
        Document jdomDocument = jdomBuilder.build(imgResultSource);
  
        // use the default implementation
        XPathFactory xFactory = XPathFactory.instance();
        // System.out.println(xFactory.getClass());
  
        // select all links
        XPathExpression<Element> expr = xFactory.compile("//*[@id='rg']", Filters.element());
        List<Element> links = expr.evaluate(jdomDocument);
        for (Element linkElement : links) {
            System.out.println(linkElement.getValue());
        }
  
        // select all links in image element
        expr = xFactory.compile("//image/link", Filters.element());
        List<Element> links2 = expr.evaluate(jdomDocument);
        for (Element linkElement : links2) {
            System.out.println(linkElement.getValue());
        }
  
        // get the media namespace
        Namespace media = jdomDocument.getRootElement().getNamespace("media");
        // find all thumbnail elements from the media namespace where the
        // attribute widht has a value > 60
        expr = xFactory.compile("//media:thumbnail[@width>60.00]", Filters.element(), null, media);
        // find the first element in the document and get its attribute named 'url'
        System.out.println(expr.evaluateFirst(jdomDocument).getAttributeValue("url"));
                 
  
        // find the child element of channel whose name is title. find the
        // descendant of item with name title.
        Element firstTitle = xFactory.compile("//channel/child::item/descendant::title", Filters.element()).evaluateFirst(jdomDocument);
        System.out.println(firstTitle.getValue());
  
    }
  
}