create table english_table
(
    id          int auto_increment
        primary key,
    name        varchar(255)  not null,
    state       int default 1 not null,
    create_time datetime      null,
    constraint english_table_pk
        unique (name)
)
    comment '历年试卷表,0正常,1没有';

create table exam_types
(
    id       int auto_increment
        primary key,
    language varchar(255) null
)
    comment '试卷类型表';

create table grade_table
(
    id         int auto_increment
        primary key,
    user_id    int          null,
    name       varchar(255) null,
    grade      int          null,
    created_at timestamp    null
)
    comment '成绩表';

create table japanese_table
(
    id          int auto_increment
        primary key,
    name        varchar(255)  not null,
    state       int default 1 not null,
    create_time datetime      null invisible,
    constraint japanese_table_pk
        unique (name)
)
    comment '历年试卷表,0正常，1没有';

create table japanese_table_topic
(
    id         int auto_increment
        primary key,
    name       varchar(255) null,
    topic      varchar(255) null,
    select1    varchar(255) null,
    select2    varchar(255) null,
    select3    varchar(255) null,
    select4    varchar(255) null,
    answer     char         null,
    created_at timestamp    null
)
    comment '试卷表';

create table user_select
(
    id         int auto_increment
        primary key,
    user_id    int          null,
    name       varchar(255) null,
    body       text         null comment '放答案，用-分割',
    created_at timestamp    null
)
    comment '之后改为用户操作的试卷答案';

create table users
(
    id         int auto_increment
        primary key,
    name       varchar(255) default '临时用户名' not null,
    username   varchar(255)                      not null,
    password   varchar(255) default '123456'     null,
    img        varchar(255)                      null,
    created_at timestamp                         null,
    constraint users_pk
        unique (username)
)
    comment '用户信息表';


