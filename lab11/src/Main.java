import ast.Program;
import codegenerator.OffSetVisitor;
import errorhandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.PmmLexer;
import parser.PmmParser;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;
import visitors.codegenerator.ExecuteCGVisitor;

import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String... args) throws Exception {
		if (args.length<1) {
			System.err.println("Please, pass me the input file.");
			return;
		}

		String inputFileName = args[0];
		FileReader fr = null;
		try{
			fr = new FileReader(inputFileName);
		}
		catch(Exception e){
			System.err.print("Could not open file " + inputFileName);
		}

		String outputFileName;
		if(args.length >= 2) {
			outputFileName = args[1];
		} else {
			outputFileName = "output.txt";
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(inputFileName);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PmmParser parser = new PmmParser(tokens);
		Program ast = parser.program().ast;

		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new TypeCheckingVisitor(), null);
		ast.accept(new OffSetVisitor(), null);
		ast.accept(new ExecuteCGVisitor(inputFileName, outputFileName), null);

		// * Check errors
		if(ErrorHandler.getEH().AnyError()){
			// * Show errors
			ErrorHandler.getEH().showErrors(System.err);
		}
		/*else{
			// * The AST is shown
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorTree("Introspector", model);
		}*/
	}
}
