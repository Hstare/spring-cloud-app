create table user_role(
id int not null PRIMARY key auto_increment,
user_id INT,
role_id INT,
create_time datetime,
update_time datetime
)