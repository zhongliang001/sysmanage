create database sysmanage;
use sysmanage;
-- drop table  if exists s_dict;
create table s_dict(
	id varchar(32) not null primary key comment '主键id',
    dict_type varchar(32) comment '字典类型',
    cn_name varchar(64) comment '中文名',
    en_name varchar(64) comment '英文名',
    create_time varchar(20) comment '创建时间',
    update_time varchar(20)comment '修改时间',
    order_id char(2) comment '排序编号'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '数据字典表';
select * from s_dict;


create table s_user(
    id varchar(32) not null primary key comment '用户id',
    username varchar(32) comment '用户名',
    password varchar(64) comment '密码',
    real_name varchar(64) comment '真实姓名',
    sex char(1) comment '性别',
    phone_no varchar(11) comment '手机号',
    cert_type varchar(4) comment '证件类型',
    cert_no varchar(18) comment '证件号码',
    birthday varchar(10) comment '出生日期',
    last_login_time varchar(20) comment '上次登录时间',
    err_login_times int comment '连续密码错误次数',
    forbidden_login_time varchar(20) comment '禁止登录时间',
    forbidden_login_period int comment '禁止登录期限(天)',
    forbidden_reason varchar(5)comment '禁止登录原因',
    last_modify_pwd varchar(20) comment '上次修改密码时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户信息表';

create table s_menu(
    id varchar(32) not null primary key comment '菜单id',
    name varchar(64) comment '菜单名',
    path varchar(256) comment '菜单路由',
    component varchar(32) comment '菜单组件',
    parent_id varchar(32) comment '父菜单id'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '菜单表';

select id, name, path, file_path, parent_id from s_menu;

update s_menu set parent_id = null where id in('1','2','3');

alter table s_menu change component file_path varchar(32) comment '组件文件';
