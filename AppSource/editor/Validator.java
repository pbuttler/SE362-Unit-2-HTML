import java.util.*;
import org.jsoup.*;
import org.jsoup.safety.Whitelist;
/**
 * 
 * @author Helrumyc
 *
 *$Id$
 *
 *$Log$
 *
 */

public class Validator{

	private String validation;
	private boolean isValid = false;
	private Whitelist whiteList;
	
	@SuppressWarnings("static-access")
	public Validator(String v){
		validation = v;
		whiteList = new Whitelist();
		whiteList.basicWithImages();
	}
	
	public boolean validate(){
		isValid = Jsoup.isValid(validation, whiteList);
		return isValid;
		
	}
}
