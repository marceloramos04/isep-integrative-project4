grammar Requirements;

ID: [-_A-Za-z]+;

SPECIAL_CHAR: [()'".,;];

INT: [0-9]+;

DOUBLE: [0-9]+ ('.'|',') [0-9]+ | INT;

NEWLINE: ('\r'? '\n')+;

ENDLINE: NEWLINE;

BLANK: [ \t]+ -> skip;

start: (NEWLINE| requirement | comment)+ EOF;

comment: '#' (ID|SPECIAL_CHAR)* ENDLINE;

requirement: int_answer_requirement | double_answer_requirement | single_option_requirement | multiple_options_requirement;

int_answer_requirement: (ID|SPECIAL_CHAR)+ ':' INT ENDLINE;

double_answer_requirement: (ID|SPECIAL_CHAR)+ ':' DOUBLE ENDLINE;

single_option_requirement: (ID|SPECIAL_CHAR)+ ':' ID ENDLINE;

multiple_options_requirement: (ID|SPECIAL_CHAR)+ ':' ID (',' + ID)* ENDLINE;