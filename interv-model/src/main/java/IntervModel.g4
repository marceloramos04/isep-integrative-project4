grammar IntervModel;

start: entry+ EOF;

entry: comment? question;

comment: '#' sentence NEWLINE;

question: questionDescrip option* answer;

questionDescrip: QUESTION_ID descrip=sentence NEWLINE;

option: INDEX choice=sentence NEWLINE;

answer: ANSWER_ID answer_c=answer_value NEWLINE*;

answer_value: DATE | RANGE | TIME | INT (',' INT)* | DOUBLE | sentence;

//answer: dateAnswer
//| rangeAnswer
//| timeAnswer
//| multipleChoiceAnswer
//| doubleAnswer
//| intAnswer
//| textAnswer;
//
//dateAnswer: ANSWER_ID answer_c=DATE NEWLINE*;
//rangeAnswer: ANSWER_ID answer_c=RANGE NEWLINE*;
//timeAnswer: ANSWER_ID answer_c=TIME NEWLINE*;
//multipleChoiceAnswer: ANSWER_ID answer_c=multipleChoice NEWLINE*;
//doubleAnswer: ANSWER_ID answer_c=DOUBLE NEWLINE*;
//intAnswer: ANSWER_ID answer_c=INT NEWLINE*;
//textAnswer: ANSWER_ID answer_c=text NEWLINE*;

sentence: TEXT+;

QUESTION_ID: 'Q:';
ANSWER_ID: 'A:';

DATE: DAY DATE_SEPARATOR MONTH DATE_SEPARATOR YEAR;

RANGE: INT '-' INT;

TIME: HOUR ':' MINUTE;

INDEX: INT'.';

DOUBLE: INT ('.'|',') INT;
INT: DIGIT+;
DIGIT: [0-9];

TEXT: ALL_CHAR+;
ALL_CHAR: ~[ \t\r\n];
//WORD: [a-zA-Z]+;
//PUNCTUATION: [,.;:?!];
//SPECIAL_CHAR: [-(){}[\]<>@#$%^&*_+=~`|\\'"];

YEAR: DIGIT DIGIT DIGIT DIGIT;
MONTH: '0' [1-9] | '1' [0-2];
DAY: '0' [1-9] | [12][0-9] | '3' [01];
DATE_SEPARATOR: '/';

HOUR: '0' DIGIT | '1' DIGIT | '2' [0-4];
MINUTE: [0-5] DIGIT | '60';

NEWLINE: '\r'? '\n';
BLANK: [ \t]+ -> skip;