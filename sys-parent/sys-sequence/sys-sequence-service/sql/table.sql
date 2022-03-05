use admin;
drop table  if exists template;
create table template
(
    id              varchar(32) not null primary key comment '主键id',
    name            varchar(32) comment '模板名',
    temp            varchar(64) comment '模板',
    length          varchar(20) comment '长度',
    create_time     varchar(20) comment '创建时间',
    create_user     varchar(32) comment '创建人',
    update_time     varchar(20) comment '更新时间',
    update_user     varchar(32) comment '更新人'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '流水模板表';

select * from template;


create table sequnce(
    name varchar(20) not null primary key comment '序列名',
    value INT(11) UNSIGNED ZEROFILL NOT NULL comment '序列编号'
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 comment '序列表';

select * from sequnce;
select * from template
