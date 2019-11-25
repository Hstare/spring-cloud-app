create table permission(
id int not null PRIMARY key auto_increment,
parent_id INT default 0 comment '父权限id',
name varchar(50) comment '权限名',
permission_desc VARCHAR(255) comment '权限描述',
create_time datetime,
update_time datetime
)