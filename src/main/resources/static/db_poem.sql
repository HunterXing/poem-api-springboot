create table tb_classify
(
    id            int(16)      null,
    classify_name varchar(255) null comment '类型名称'
);

create index id
    on tb_classify (id);

create table tb_dept
(
    id   int          null comment '部门id',
    name varchar(255) null comment '部门名称'
);

create index id
    on tb_dept (id);

create table tb_poems
(
    id          varchar(50)        not null comment '诗词歌赋id'
        primary key,
    title       varchar(50)        null comment '题目',
    author      varchar(50)        null comment '作者',
    chapter     varchar(50)        null comment '章节  （适用于 诗经 论语）',
    section     varchar(50)        null comment '回       （适用于 诗经 论语）',
    classify_id int(16)  default 1 null,
    content     longtext           null comment '内容',
    create_time varchar(50)        null comment '创建时间',
    poem_img    varchar(255)       null comment '诗词配图',
    isPublish   int(2)   default 0 null,
    hot         int(128) default 0 null
);

create index author
    on tb_poems (author);

create index title
    on tb_poems (title);

create table tb_user
(
    id       varchar(255) default '' not null comment '主键ID'
        primary key,
    name     varchar(30)             null comment '姓名',
    age      int                     null comment '年龄',
    email    varchar(50)             null comment '邮箱',
    dept_id  int                     null,
    account  varchar(32)             null,
    password varchar(64)             null,
    constraint dept_id
        foreign key (dept_id) references tb_dept (id)
);

