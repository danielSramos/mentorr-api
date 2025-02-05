-- create table company
-- (
--     id   serial
--         primary key,
--     name varchar(100) null
-- );
--
-- create table knowledge_area
-- (
--     id   serial
--         primary key,
--     name varchar(100) null
-- );
--
-- create table mentoring_status
-- (
--     id   serial
--         primary key,
--     name varchar(50) null
-- );
--
-- create table nationality
-- (
--     id      serial
--         primary key,
--     country varchar(100) null
-- );
--
-- create table position
-- (
--     id   serial
--         primary key,
--     name varchar(100) not null
-- );
--
-- create table role
-- (
--     id   serial
--         primary key,
--     name varchar(100) null
-- );
--
-- create table skill
-- (
--     id                serial
--         primary key,
--     name              varchar(100) null,
--     knowledge_area_id int          not null,
--     constraint skill_knowledge_area_id_fk
--         foreign key (knowledge_area_id) references knowledge_area (id)
-- );
--
-- create table "user"
-- (
--     id                serial
--         primary key,
--     email             varchar(50)   not null,
--     password          varchar(500)  not null,
--     name              varchar(100)  null,
--     profile_image     bytea         null,
--     nationality_id    int           null,
--     short_description varchar(1000) null,
--     verified          boolean       null,
--     created_at        timestamp     null,
--     updated_at        timestamp     null,
--     constraint user_nationality_id_fk
--         foreign key (nationality_id) references nationality (id)
-- );
--
-- create table mentoring_plan
-- (
--     id         serial primary key,
--     cost       int      null,
--     user_id int      not null,
--     duration   interval null,  -- Use interval para durações
--     constraint mentoring_plan_user_id_fk
--         foreign key (user_id) references "user" (id)
-- );
--
-- create table mentoring
-- (
--     id                  serial primary key,
--     date                timestamp null,  -- timestamp para data e hora
--     mentoring_status_id int      not null,
--     mentor_id           int      not null,
--     constraint mentoring_mentoring_status_id_fk
--         foreign key (mentoring_status_id) references mentoring_status (id),
--     constraint mentoring_user_id_fk
--         foreign key (mentor_id) references "user" (id)
-- );
--
-- create table review
-- (
--     id           serial
--         primary key,
--     rating       int           null,
--     comment      varchar(2000) null,
--     mentoring_id int           not null,
--     created_at   timestamp     null,
--     constraint review_mentoring_id_fk
--         foreign key (mentoring_id) references mentoring (id)
-- );
--
-- create table mentoring_client
-- (
--   id serial primary key,
--   mentoring_id  int not null, -- FK para a mentoria
--   client_id     int not null, -- FK para o cliente (usuário)
--   constraint mentoring_client_mentoring_id_fk
--       foreign key (mentoring_id) references mentoring (id),
--   constraint mentoring_client_client_id_fk
--       foreign key (client_id) references "user" (id)
-- );
--
-- create table user_role
-- (
--     id serial primary key,
--     user_id int not null,
--     role_id int not null,
--     created_at timestamp,
--     constraint user_role_role_id_fk
--         foreign key (role_id) references role (id),
--     constraint user_role_user_id_fk
--         foreign key (user_id) references "user" (id)
-- );
--
-- create table user_company
-- (
--     id         serial
--         primary key,
--     user_id    int not null,
--     company_id int not null,
--     role    varchar(100) null,
--     constraint user_company_company_id_fk
--         foreign key (company_id) references company (id),
--     constraint user_company_user_id_fk
--         foreign key (user_id) references "user" (id)
-- );
--
-- create table user_knowledge_area
-- (
--     id                serial
--         primary key,
--     user_id           int not null,
--     knowledge_area_id int not null,
--     constraint user_knowledge_area_knowledge_area_id_fk
--         foreign key (knowledge_area_id) references knowledge_area (id),
--     constraint user_knowledge_area_user_id_fk
--         foreign key (user_id) references "user" (id)
-- );
--
-- create table user_position
-- (
--     id          serial
--         primary key,
--     user_id     int not null,
--     position_id int null,
--     constraint user_position_position_id_fk
--         foreign key (position_id) references position (id),
--     constraint user_position_user_id_fk
--         foreign key (user_id) references "user" (id)
-- );
--
-- create table user_skill
-- (
--     id       serial
--         primary key,
--     user_id  int not null,
--     skill_id int not null,
--     constraint user_skill_skill_id_fk
--         foreign key (skill_id) references skill (id),
--     constraint user_skill_user_id_fk
--         foreign key (user_id) references "user" (id)
-- );
