create table role(
id int not null PRIMARY key auto_increment,
parent_id INT default 0 comment '父角色id',
name varchar(50) comment '角色名',
role_desc VARCHAR(255) comment '角色描述',
create_time datetime,
update_time datetime
)