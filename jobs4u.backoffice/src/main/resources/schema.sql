--drop table if exists application;
--drop table if exists job_opening;
--drop table if exists candidate;
---drop table if exists user;

create table candidate (
        candidate_id bigint not null,
        phone_number bigint not null,
        email varchar(255) not null,
        name varchar(255) not null,
        primary key (candidate_id)
);

create table job_opening (
                             job_type tinyint check (job_type between 0 and 1),
                             number_vacancies integer not null,
                             working_mode tinyint check (working_mode between 0 and 2),
                             idjobopening bigint not null,
                             address varchar(255),
                             company_name varchar(255),
                             job_description varchar(255),
                             job_title varchar(255),
                             primary key (idjobopening)
);

create table application (
                             application_id bigint not null,
                             candidate_id bigint,
                             job_offer_id bigint,
                             email_content varchar(255),
                             files varchar(255),
                             primary key (application_id)
);


create table app_user(
    role     tinyint check (role between 0 and 3),
    status   tinyint check (status between 0 and 1),
    id       bigint not null,
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    primary key (id)
);

insert into application (email_content, files, job_offer_id, application_id) values ('', '', '1', '1');

select * from application;
