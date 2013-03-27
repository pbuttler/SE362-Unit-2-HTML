/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author innod_000
 */
public class Utilities {
    
    public static String[] readFileToArray(File file) throws IOException {
        
        java.io.FileReader reader  = new java.io.FileReader(file);
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(reader);
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;
        while (null != (line = bufferedReader.readLine())) {
            lines.add(line);
        }
        
        String[] linesAsArray = lines.toArray(new String[lines.size()]);
        
        return linesAsArray;
    }
    
    public static String readFileToString(File file)  throws IOException {
        
        java.io.FileReader reader  = new java.io.FileReader(file);
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(reader);
        
        String line = null;
        String outputString = "";
        while (null != (line = bufferedReader.readLine())) {
            outputString += String.format("%s\n", line);
        }
        
        return outputString;
    }
    
    public static String arrayToString(String[] lines) {
    
        String outputString = "";
        for( String line : lines) {
            outputString += String.format("%s\n", line);
        }
        
        return outputString;
    
    }
    
}
