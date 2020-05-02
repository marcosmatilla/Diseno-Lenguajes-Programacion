grammar Pmm;
@header{
    import ast.*;
    import ast.Program;
    import ast.definitions.Definition;
    import ast.definitions.FunctionDefinition;
    import ast.definitions.VariableDefinition;
    import ast.expresions.*;
    import ast.statements.*;
    import ast.types.*;
}
program returns [Program ast]: {ArrayList<Definition> defs = new ArrayList<Definition>();}
            (function_definition{defs.add($function_definition.ast);}|variable_definition{defs.addAll($variable_definition.ast);} ';')*
            main{defs.add($main.ast);} EOF {$ast = new Program(0,0,defs);}
        ;

/*Reglas Sintactico*/
/*Programa */
main returns [FunctionDefinition ast]: d='def' m='main' '('')'':' '{' function_body '}'  {$ast = new FunctionDefinition($d.getLine(), $d.getCharPositionInLine() + 1, $m.text, new FunctionType($d.getLine(), $d.getCharPositionInLine() + 1, new ArrayList<VariableDefinition>(), new VoidType($d.getLine(), $d.getCharPositionInLine() + 1)), $function_body.ast);}
                ;

function_definition returns [FunctionDefinition ast]: d='def' ID '(' ')' ':' '{' function_body '}' {$ast = new FunctionDefinition($d.getLine(), $d.getCharPositionInLine() + 1, $ID.text, new FunctionType($d.getLine(), $d.getCharPositionInLine()+1, new ArrayList<VariableDefinition>(), new VoidType($d.getLine(), $d.getCharPositionInLine()+1)), $function_body.ast);}
                    | d='def' ID '(' p=parameters')' ':' '{' function_body '}' {$ast = new FunctionDefinition($d.getLine(), $d.getCharPositionInLine() + 1, $ID.text, new FunctionType($d.getLine(), $d.getCharPositionInLine()+1, $p.ast, new VoidType($d.getLine(), $d.getCharPositionInLine()+1)), $function_body.ast);}
                    | d='def' ID function_type'{' function_body '}' {$ast = new FunctionDefinition($d.getLine(), $d.getCharPositionInLine() + 1, $ID.text, $function_type.ast, $function_body.ast);}
                    ;

function_type returns[FunctionType ast]: c='(' parameters ')' ':' return_type {$ast = new FunctionType($c.getLine(), $c.getCharPositionInLine() + 1, $parameters.ast, $return_type.ast);}
            ;

variable returns [Variable ast]: ID{$ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text);}
        ;

parameters returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]: (v1=variable_definition {$ast.addAll($v1.ast);}(',' v2=variable_definition{$ast.addAll($v2.ast);})*)?
            ;

variable_definition returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]: id1=ID {$ast.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, null));}
                            (',' id2=ID{$ast.add(new VariableDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, new VoidType(0,0)));})* ':' type {for (VariableDefinition i: $ast) {i.setType($type.ast);}}
		            ;


function_body returns [List<Statement> ast = new ArrayList<Statement>()]:
                | (variable_definition ';' {$ast.addAll($variable_definition.ast);})+ statements{$ast.addAll($statements.ast);}
                | (variable_definition ';' {$ast.addAll($variable_definition.ast);})+
                | statements{$ast.addAll($statements.ast);}
                ;

/*Types*/
type returns [Type ast]: simple_type {$ast = $simple_type.ast;}
        | array {$ast = $array.ast;}
        | struct_type {$ast = $struct_type.ast;}
        ;

simple_type returns [Type ast]: i='int' {$ast = new IntType($i.getLine(), $i.getCharPositionInLine() + 1);}
            | d='double' {$ast = new RealType($d.getLine(), $d.getCharPositionInLine() + 1);}
            | c='char' {$ast = new CharType($c.getLine(), $c.getCharPositionInLine() + 1);}
            ;

return_type returns [Type ast]: simple_type {$ast = $simple_type.ast;}
            | v='void' {$ast = new VoidType($v.getLine(), $v.getCharPositionInLine() + 1);}
            ;

array returns [ArrayType ast]: c='['INT_CONSTANT']' type {$ast = new ArrayType($c.getLine(), $c.getCharPositionInLine() + 1, $type.ast, LexerHelper.lexemeToInt($INT_CONSTANT.text));}
        ;

struct_type returns [StructureType ast]: st='struct' '{' struct_fields '}'  {$ast = new StructureType($st.getLine(), $st.getCharPositionInLine() + 1 , $struct_fields.ast);}
        ;

struct_fields returns [ArrayList<StructureField> ast = new ArrayList<StructureField>()]: (id1=ID {$ast.add(new StructureField($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, null));}
                    (',' id2=ID{$ast.add(new StructureField($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, null));})* ':' type {for (StructureField i: $ast) {i.setType($type.ast);}} ';')*
            ;

/*Statement*/
statement returns [ArrayList<Statement> ast = new ArrayList<Statement>()]: assigment {$ast.add($assigment.ast);}
        | invokeFunction ';' {$ast.add($invokeFunction.ast);}
        | return_statement {$ast.add($return_statement.ast);}
        | while_statement {$ast.add($while_statement.ast);}
        | ifElse {$ast.add($ifElse.ast);}
        | input {$ast.addAll($input.ast);}
        | print {$ast.addAll($print.ast);}
        ;

statements returns [ArrayList<Statement> ast = new ArrayList<Statement>()]:
 (statement{$ast.addAll($statement.ast);})+
          ;

print returns [List<Print> ast = new ArrayList<Print>()]: p='print' e1=expression{$ast.add(new Print($p.getLine(), $p.getCharPositionInLine() + 1, $e1.ast)); }
                            (',' e2=expression{$ast.add(new Print($p.getLine(), $p.getCharPositionInLine() + 1, $e2.ast)); })*';'
        ;

input returns [List<Input> ast  =new ArrayList<Input>()]: i='input' e1=expression{$ast.add(new Input($i.getLine(), $i.getCharPositionInLine() + 1, $e1.ast)); }
                                                               (',' e2=expression{$ast.add(new Input($i.getLine(), $i.getCharPositionInLine() + 1, $e2.ast)); })*';'
        ;

return_statement returns [Return ast]: r='return' e=expression';' {$ast = new Return($r.getLine(), $r.getCharPositionInLine() + 1, $e.ast);}
        ;

assigment returns [Assigment ast]: e1=expression '=' e2=expression';' {$ast = new Assigment($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1, $e1.ast, $e2.ast);}
        ;

ifElse returns [IfElse ast]: op='if' e=expression ':' s1=statement {$ast = new IfElse($op.getLine(), $op.getCharPositionInLine() + 1, $e.ast, $s1.ast);}
        | op='if' e=expression ':' s1=statement 'else' '{' ss2=statements '}' {$ast = new IfElse($op.getLine(), $op.getCharPositionInLine() + 1, $e.ast, $s1.ast, $ss2.ast);}
        | op='if' e=expression ':' s1=statement 'else' s2=statement {$ast = new IfElse($op.getLine(), $op.getCharPositionInLine() + 1, $e.ast, $s1.ast, $s2.ast);}
        | op='if' e=expression ':' '{' ss1=statements '}' {$ast = new IfElse($op.getLine(), $op.getCharPositionInLine() + 1, $e.ast, $ss1.ast);}
        | op='if' e=expression ':' '{' ss1=statements '}' 'else' s2=statement {$ast = new IfElse($op.getLine(), $op.getCharPositionInLine() + 1, $e.ast, $ss1.ast, $s2.ast );}
        | op='if' e=expression ':' '{' ss1=statements '}' 'else' '{' ss2=statements '}' {$ast = new IfElse($op.getLine(), $op.getCharPositionInLine() + 1, $e.ast, $ss1.ast, $ss2.ast );}

        ;

while_statement returns [While ast]: op='while' expression ':' '{' statements '}' {$ast = new While($op.getLine(), $op.getCharPositionInLine() + 1, $expression.ast, $statements.ast );}
        | op='while' expression ':' statement {$ast = new While($op.getLine(), $op.getCharPositionInLine() + 1, $expression.ast, $statement.ast );}
        ;

/*Expression */
expression returns [Expresion ast]: ID {$ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text);}
            | INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($INT_CONSTANT.text));}
            | CHAR_CONSTANT {$ast = new CharLiteral($CHAR_CONSTANT.getLine(),$CHAR_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
            | REAL_CONSTANT {$ast = new RealLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
            | '(' expression ')' {$ast = $expression.ast;}
            | op='!' expression {$ast = new Negation($op.getLine(), $op.getCharPositionInLine() + 1, $expression.ast);}
            | e1=expression '['e2=expression']' {$ast = new Indexer($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1,$e1.ast, $e2.ast);}
            | e1=expression '.' ID {$ast = new FieldAccess($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1, $e1.ast, $ID.text);}
            | e1=expression op=('*'|'/'|'%') e2=expression {$ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1, $e1.ast, $e2.ast, $op.text);}
            | e1=expression op=('+'|'-') e2=expression {$ast = new Arithmetic($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1, $e1.ast, $e2.ast, $op.text);}
            | e1=expression ('>'|'>='|'<'|'<='|'!='|'==') e2=expression {$ast = new Comparation($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1, $e1.ast, $e2.ast, $op.text);}
            | e1=expression ('&&'|'||') e2=expression {$ast = new Logic($e1.start.getLine(), $e1.start.getCharPositionInLine() + 1, $e1.ast, $e2.ast, $op.text);}
            | op='('simple_type')' expression {$ast = new Cast($op.getLine(), $op.getCharPositionInLine() + 1, $expression.ast, $simple_type.ast);}
            | op='-' expression {$ast = new UnaryMinus($op.getLine(), $op.getCharPositionInLine() + 1, $expression.ast);}
            | invokeFunction {$ast = $invokeFunction.ast;}
            ;

invokeFunction returns [InvokeFunction ast]: variable'(' expressions ')' {$ast = new InvokeFunction($variable.start.getLine(), $variable.start.getCharPositionInLine() + 1, $expressions.ast, $variable.ast);}
            ;

expressions returns [ArrayList<Expresion> ast = new ArrayList<Expresion>()]:
            | e1=expression{$ast.add($e1.ast); } (',' e2=expression{$ast.add($e2.ast); })*
		;


/* Reglas Lexico*/
INT_CONSTANT: '0'
            | [1-9][0-9]*
            ;

REAL_CONSTANT:REAL[Ee][+|-]?INT_CONSTANT
            | REAL
            | INT_CONSTANT[Ee][+|-]?INT_CONSTANT
            ;

REAL: INT_CONSTANT?'.'INT_CONSTANT
            | INT_CONSTANT'.'INT_CONSTANT?
            ;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: (LETTER|'_')(LETTER|'_'|DIGIT)*
            ;

CHAR_CONSTANT: '\''.'\''
                | '\'' '\\n' '\''
                |'\'' '\\t' '\''
                | '\'''\\'INT_CONSTANT*'\''
                ;

COMMENT: '#'.*?('\n'|EOF) -> skip
            ;

MULTIPLE_COMMENT: '"""'.*?'"""' -> skip
            ;

WHITE_SPACE:  ' ' -> skip
            ;

TAB: '\t'  -> skip
            ;

NEW_LINE: '\n' -> skip
            ;

RET: '\r' -> skip
            ;