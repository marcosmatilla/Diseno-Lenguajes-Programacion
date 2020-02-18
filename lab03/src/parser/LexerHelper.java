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
		try{
			return str.charAt(0);
		}
		catch (IllegalArgumentException e){
			System.out.print(e);
		}
		return ' ';
	}
	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
