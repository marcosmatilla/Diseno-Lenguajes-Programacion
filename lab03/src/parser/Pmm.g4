grammar Pmm;

program: ifElse
       ;

/* Reglas Sintactico*/
variable_definition: variables ':' type ';'
		;

variables: ID
		| variables ',' ID
		;

type: simple_type
        | array
        | struct
        ;

simple_type: 'int'
    | 'double'
    | 'char'
    ;

array: '['INT_CONSTANT']' type
    ;

struct: 'struct' '{' struct_body '}'
	;

struct_body: variable_definition
		| struct_body variable_definition
		;

sentence: funtion_invocation_as_statement
        | while
        | ifElse
        | read
        | write
        | return
        ;

read: 'print' expressions ';'
        ;

write:
        ;

return: 'return' expressions ';'
        ;

ifElse: 'if ' expressions ':' sentence
        | 'if' expressions 'else'
        ;

funtion_invocation_as_statement: ID '('expressions')'
        ;

while : 'while' expression ':' '{' sentence '}'
        | 'while' expression ':' sentence
        ;

expression: ID
            | INT_CONSTANT
            | CHAR_CONSTANT
            | REAL_CONSTANT
            | '(' expression ')'
            | '[' expression ']'
            | '!' expression
            |'(' simple_type ')' expression
            | expression '[' expression ']'
            | expression '.' ID
            | expression'.'expression
            | expression ('*'|'/') expression
            | expression ('+'|'-') expression
            | expression ('%') expression
            | expression ('>'|'>='|'<'|'<='|'!='|'==') expression
            | expression ('&&'|'||') expression
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

ID: [aA-zZ_][aA-zZ_0-9]*
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