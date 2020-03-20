package ast.errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
    private static List<ErrorType> errors;
    private static ErrorHandler EH = null;

    private ErrorHandler(){
        this.errors = new ArrayList<ErrorType>();
    }

    private synchronized static void createInstance() {
        if (EH == null) {
            EH = new ErrorHandler();
        }
    }

    public static ErrorHandler getEH(){
        if (EH == null) createInstance();
        return EH;
    }

    public boolean AnyError(){
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream ps){
        for(ErrorType e: errors){
            ps.print(e.toString() + "\n");
        }
    }

    public void AddError(ErrorType errorType){
        errors.add(errorType);
    }
}
