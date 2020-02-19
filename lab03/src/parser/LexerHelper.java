package parser;

import java.nio.charset.CharacterCodingException;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str){
		try {
			return Double.parseDouble(str);
		}
		catch (NumberFormatException e){
			System.out.println(e);
		}
		return -1.0;
	}

	public static char lexemeToChar(String str){
		if(str.length()==3){ //'a'
			return str.toCharArray()[1];
		}
		else if(str.equals("'\\n'")){
			return '\n';
		}
		else if(str.equals("'\\t'")){
			return '\t';
		}
		else{ // '\123'
			String cadena = str.substring(2,str.length()-1);
			char[] character = Character.toChars(Integer.parseInt(cadena));
			return character[0];
		}
	}
	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
