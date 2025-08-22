grammar JobRequirements;


ID: [-_A-Za-z]+;
SPECIAL_CHAR: [()'".,;];
INT: [0-9]+;
DOUBLE: [0-9]+ ('.'|',') [0-9]+ | INT;
NEWLINE: '\r'? '\n';
//MULTIPLE_ANSWER: ID (',' ID)*;

BLANK: [ \t]+ -> skip;

start: (NEWLINE| requirement | comment)+ EOF;

comment: '#' (ID|SPECIAL_CHAR)* NEWLINE*;

requirement: descrip=(ID|SPECIAL_CHAR)+ ':' answer NEWLINE*;

answer: INT | DOUBLE | textAnswers;

textAnswers: ID (',' ID)*;