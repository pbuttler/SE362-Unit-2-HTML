 package editor;

import java.util.ArrayList;

public class Validator {
	
	String currentString;
	String totalString;

	public Validator(){
		
	}
	
	public ArrayList<Object> parseBuffer(String BString){
		
		ArrayList<Object> Contents = new ArrayList<Object>();
		int mark = 0;
		
		for (int i = 0; i < BString.length(); i++){
		    char c = BString.charAt(i);
		    currentString += c;
		    totalString += c;
		    
		    if (c == '<'){
		    	mark = i;
		    	
		    	// save currentSting to the Contents array
		    	
		    	currentString = "";
		    	
		    }
		    else if (c == '>'){
		    	// extract between 'mark' and 'i' create construct
		    	// Set current string to construct Contents
		    	
		    	Construct newConstruct = new Construct(currentString);
		    	
		    	currentString = "";
		    }
		}
		
		return Contents;	
		
	}
}