grammar Pmm;	

program:
       ;
  		 
INT_CONSTANT: '0' | [1-9][0-9]*
            ;

REAL: INT_CONSTANT?'.'[0-9]+ | INT_CONSTANT'.'INT_CONSTANT?
            ;

