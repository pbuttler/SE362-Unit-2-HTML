
package editor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

import org.w3c.tidy.Node;
import org.w3c.tidy.Tidy;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/

/**
 *
 * @author naw7961
 */
public class EditorChecker {
    
    public boolean validator(String currentBuffer){
        Tidy tidy = new Tidy();
        boolean isValid = false;
                String fileString = currentBuffer;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String html = "";
//		try {
//			BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(location) ) );
//		    StringBuffer text = new StringBuffer();
//		    String line = "";
//		    while (line != null) {
//		        text.append( line );
//		        line = br.readLine();
//		    }
//		    html = text.toString();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("File not found");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("IO Exception");
//		}
//		System.out.println(html);
        try {
	        Node node = tidy.parse(new ByteArrayInputStream(html.getBytes("UTF-8")), os);
	    } catch (UnsupportedEncodingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        System.out.println("False");
	    } 

	    if ((tidy.getParseErrors() > 0) || (tidy.getParseWarnings() > 0)) { 
                
                isValid = false;
	        System.out.println("Tidy Parser errors: " + tidy.getParseErrors());
	        System.out.println("Tidy Parser warnings: " + tidy.getParseWarnings());
	        return isValid;
	    } else{
	        //return with no error
	        System.out.println("True");
                isValid = true;
                return isValid;
	    }
            //return true;
    }
}
