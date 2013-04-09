import javax.xml.validation.*;
import org.xml.sax.SAXException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import javax.xml.XMLConstants;

/**
 *
 * @author Helrumyc
 *
 * $Id$
 *
 * $Log$
 *
 */
public class ourValidator {

    private StreamSource source;
    private boolean isValid = false;
    private String filePath;

    public ourValidator(String f) {
        filePath = f;
    }

    public boolean validate() throws SAXException, IOException {
//        String schemaFactoryProperty = "javax.xml.SchemaFactory:" + XMLConstants.W3C_XML_SCHEMA_NS_URI;
//        
//        System.setProperty(schemaFactoryProperty, "org.apache.xerces.jaxp.validation.SMLSchemaFactory");
        

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        //System.out.println("POOP");
        File schemaLocation = new File("C:/Users/Helrumyc/Documents/NetBeansProjects/SE362-Unit-2-HTML/AppSource/editor/docbook.xsd");
        //System.out.println("POOP");
        Schema schema = factory.newSchema(schemaLocation);
        //System.out.println("POOP");
        Validator validator = schema.newValidator();
        String input = filePath;
        Source source = new StreamSource(input);

        try {
            validator.validate(source);
            System.out.println(input + " is valid");
        } catch (SAXException ex) {
            System.out.println(input + " is not valid because ");
            System.out.println(ex.getMessage());
        }
        return isValid;

    }

    public static void main(String[] args) throws SAXException, IOException {
        ourValidator test = new ourValidator("C:/Users/Helrumyc/Downloads/note.xml");
        test.validate();
    }
}
