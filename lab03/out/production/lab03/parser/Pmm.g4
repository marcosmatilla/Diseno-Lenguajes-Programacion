grammar Pmm;	

program:
       ;
  		 
INT_CONSTANT: '0' | [1-9][0-9]*
            ;

REAL_CONSTANT: INT_CONSTANT?'.'([1-9][0-9]*)?
            ;

