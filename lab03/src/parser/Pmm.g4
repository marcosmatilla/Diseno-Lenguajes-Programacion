grammar Pmm;

program:variable_definition
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

struct: STRUCT '{' struct_body '}'
	;

struct_body: variable_definition
		| struct_body variable_definition
		;

expression: ID
            | INT_CONSTANT
            | CHAR_CONSTANT
            | REAL_CONSTANT
            | '(' expression ')'
            | '[' expression ']'
            | expression '[' expression ']'
            | expression '.' ID
            | expression ('*'|'/') expression
            | expression ('+'|'-') expression
            | expression ('>'|'>='|'<'|'<='|'!='|'==') expression
            | expression ('&&'|'||') expression
            ;

expressions: expression
		| expressions ',' expression
		;

sent: expressions '=' expression ';'
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