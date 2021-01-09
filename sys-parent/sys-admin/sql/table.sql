create database sysmanage;
use sysmanage;
drop table  if exists s_dict;
create table s_dict(
	id varchar(32) not null primary key comment '主键id',
    dict_type varchar(32) comment '字典类型',
    cn_name varchar(64) comment '中文名',
    en_name varchar(64) comment '英文名',
    create_time varchar(20) comment '创建时间',
    update_time varchar(20)comment '修改时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '数据字典表';
