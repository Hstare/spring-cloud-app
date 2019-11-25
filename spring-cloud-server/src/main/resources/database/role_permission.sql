create table role_permission(
id int not null PRIMARY key auto_increment,
role_id INT,
permission_id INT,
permission_type int comment '权限类型，0-可访问；1-可授权'
)