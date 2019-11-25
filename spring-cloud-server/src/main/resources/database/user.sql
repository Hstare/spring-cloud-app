create table user (
id BIGINT UNSIGNED not null PRIMARY key auto_increment,
name VARCHAR(255),
id_card VARCHAR(255) COMMENT '身份证号',
user_name VARCHAR(255) COMMENT '用户登录名',
password VARCHAR(255),
age TINYINT UNSIGNED,
avatar VARCHAR(300),
sex TINYINT,
phone VARCHAR(255),
email VARCHAR(255),
state TINYINT DEFAULT 0 comment '状态 0-正常状态；1-被锁定；2-已废弃',
create_time datetime,
update_time datetime
)