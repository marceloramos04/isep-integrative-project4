grammar InterviewTemplate;

start
    : QUESTION+ EOF
    ;

QUESTION
    : 'Q: ' TEXT '\n' 'A: ' (TEXT | YES | NO) '\n'
    ;

TEXT
    : [a-zA-Z0-9,.'?!\-]+ // accepts letters, numbers, spaces, and some punctuation
    ;

YES
    : 'Yes' | 'Y' | 'yes' | 'y' | 'YES'
    ;

NO
    : 'No' | 'N' | 'no' | 'n' | 'NO'
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
