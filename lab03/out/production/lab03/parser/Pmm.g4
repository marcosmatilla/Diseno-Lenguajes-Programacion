grammar Pmm;	

program:
       ;
  		 
INT_CONSTANT: '0' | [1-9][0-9]*
            ;

REAL_CONSTANT:REAL'E'[+|-]INT_CONSTANT | INT_CONSTANT'e'INT_CONSTANT
            ;

REAL: INT_CONSTANT?'.'INT_CONSTANT | INT_CONSTANT'.'INT_CONSTANT?
            ;

