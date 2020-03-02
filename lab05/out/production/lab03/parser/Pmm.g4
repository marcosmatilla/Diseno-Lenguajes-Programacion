grammar Pmm;
@header{

}
program returns [Program ast]: (function_definition|variable_definition)* main EOF
        ;

/* Reglas Sintactico*/
/*Programa */
main: 'def' 'main' '(' ')' ':' return_type '{' function_body '}'
                ;

function_definition: 'def' ID '(' parameters ')' ':' return_type '{' function_body '}'
                    ;

parameter: variables ':' type
            ;

parameters:
            | parameter
            | parameters ',' parameter
            ;

function_body:
                | variable_definitions statements
                | variable_definitions
                | statements
                ;

variable_definition: variables ':' type ';'
		            ;

variable_definitions : variable_definition
                        | variable_definitions  variable_definition
                        ;

variables: ID (',' ID)*
		;

/*Types*/
type: simple_type
        | array
        | struct
        ;

simple_type: 'int'
            | 'double'
            | 'char'
            ;

return_type :
            | simple_type
            | 'void'
            ;

array: '['INT_CONSTANT']' type
        ;

struct: 'struct' '{' struct_body '}'
        ;

struct_body: variable_definition
            | struct_body variable_definition
            ;

/*Statement*/
statement: assigment
        |invokeFunction ';'
        | return_statement
        | while_statement
        | ifElse
        | read
        | write
        ;

statements: statement
          | statements statement
          ;

read: 'print' expressions ';'
        ;

write: 'input' expressions ';'
        ;

return_statement: 'return' expression ';'
        ;

assigment: expression '=' expression';'
        ;

ifElse: 'if' expressions ':' statement+
        |'if' expressions ':'  statement+ 'else' statement
        ;

while_statement : 'while' expression ':' '{' statements '}'
        | 'while' expression ':' statement
        ;

/*Expression */
expression returns [Expression ast]: ID
            | INT_CONSTANT
            | CHAR_CONSTANT
            | REAL_CONSTANT
            | '(' expression ')'
            | '[' expression ']'
            | '!' expression
            | expression '[' expression ']'
            | expression '.' ID
            | expression'.'expression
            | expression ('*'|'/') expression
            | expression ('+'|'-') expression
            | expression ('%') expression
            | expression ('>'|'>='|'<'|'<='|'!='|'==') expression
            | expression ('&&'|'||') expression
            |'('simple_type')' expression
            | invokeFunction
            ;

invokeFunction: ID '(' parameter_list ')'
            ;

parameter_list:
                | expressions
                ;

expressions: expression
		| expressions ',' expression
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