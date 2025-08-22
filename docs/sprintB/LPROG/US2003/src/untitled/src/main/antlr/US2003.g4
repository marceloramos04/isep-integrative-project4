grammar US2003;

JOB_OPENING : 'Job Opening';
JOB_REQUIREMENTS : 'Job Requirements';
CANDIDATE_FIELDS : 'Candidate Fields';
EXPORT_TEMPLATE : 'Export Template';
DATA_FIELD : 'Data Field';

job_opening_description : JOB_OPENING LCURLY job_requirements_description COMMA candidate_fields_description RCURLY;
job_requirements_description : JOB_REQUIREMENTS LCURLY job_requirement_list RCURLY;
job_requirement_list : job_requirement (COMMA job_requirement)*;
job_requirement : DATA_FIELD COLON STRING;
candidate_fields_description : CANDIDATE_FIELDS LCURLY candidate_field_list RCURLY;
candidate_field_list : candidate_field (COMMA candidate_field)*;
candidate_field : DATA_FIELD COLON STRING | EMAIL | PHONE;

EMAIL : 'Email' COLON EMAIL_ADDRESS;
PHONE : 'Phone' COLON PHONE_NUMBER;

EMAIL_ADDRESS : EMAIL_PART '@' EMAIL_PART '.' EMAIL_PART;

fragment EMAIL_PART : [a-zA-Z0-9._%+-]+;

PHONE_NUMBER : [0-9]+;

STRING : [a-zA-Z @.0-9]+;
COLON : ':';
COMMA : ',';
LCURLY : '{';
RCURLY : '}';
WS : [ \t\r\n]+ -> skip;
