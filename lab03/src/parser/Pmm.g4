grammar Pmm;

program:
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