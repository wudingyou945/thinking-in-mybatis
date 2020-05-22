drop table if exists tb_card;

create table tb_card (
id int primary key auto_increment,
code varchar(18)
);

insert into tb_card(code) values ('432801198009191038');

drop table if exists tb_person;

create table tb_person (
id int primary key auto_increment,
name varchar(18),
sex varchar(18),
age int,
card_id int unique,
CONSTRAINT `idx_tb_person_card_id` FOREIGN KEY (`card_id`) REFERENCES `tb_card` (`id`)
);

insert into tb_person(name, sex, age, card_id) values ('jack','男',23,1) ;