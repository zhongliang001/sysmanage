-- create database admin CHARACTER SET utf8 COLLATE utf8_general_ci;
use admin;
-- drop table  if exists dict;
create table dict
(
    id          varchar(32) not null primary key comment '主键id',
    dict_type   varchar(32) comment '字典类型',
    cn_name     varchar(64) comment '中文名',
    en_name     varchar(64) comment '英文名',
    create_time varchar(20) comment '创建时间',
    update_time varchar(20) comment '修改时间',
    dict_desc        varchar(60) comment '字典描述',
    order_id    char(2) comment '排序编号'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '数据字典表';
select *
from dict;


create table user
(
    id                     varchar(32) not null primary key comment '用户id',
    username               varchar(32) comment '用户名',
    password               varchar(64) comment '密码',
    real_name              varchar(64) comment '真实姓名',
    sex                    char(1) comment '性别',
    phone_no               varchar(11) comment '手机号',
    cert_type              varchar(4) comment '证件类型',
    cert_no                varchar(18) comment '证件号码',
    birthday               varchar(10) comment '出生日期',
    last_login_time        varchar(20) comment '上次登录时间',
    err_login_times        int comment '连续密码错误次数',
    forbidden_login_time   varchar(20) comment '禁止登录时间',
    forbidden_login_period int comment '禁止登录期限(天)',
    forbidden_reason       varchar(5) comment '禁止登录原因',
    last_modify_pwd        varchar(20) comment '上次修改密码时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户信息表';


create table menu
(
    id        varchar(32) not null primary key comment '菜单id',
    name      varchar(64) comment '菜单名',
    path      varchar(256) comment '菜单路由',
    parent_id varchar(32) comment '父菜单id',
    file_path varchar(32) comment '组件文件'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '菜单表';

create table role
(
    id varchar(10) not null primary key comment '角色id',
    name varchar(20) comment '角色名',
    remark varchar(100) comment '角色描述'
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 comment '角色表';

create table user_role(
    id varchar(10) not null primary key comment 'id',
    role_id varchar(10) comment '角色id',
    user_id varchar(10) comment '用户id'
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 comment '用户角色表';

create table action (
                        id varchar(10) not null primary key comment '操作id',
                        name varchar(20) comment '操作名称',
                        oper varchar(20) comment '操作',
                        menu_id varchar(32) comment '菜单id'
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 comment '操作表'