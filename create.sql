create sequence produto_seq start with 1 increment by 50;
create sequence usuario_seq start with 1 increment by 50;
create table produto (quantidade number(10,0) not null, valor float(53) not null, id number(19,0) not null, usuario_id number(19,0), categoria varchar2(255 char), descricao varchar2(255 char), marca varchar2(255 char), modelo varchar2(255 char), nome varchar2(255 char), primary key (id));
create table usuario (id number(19,0) not null, email varchar2(255 char), nome varchar2(255 char), primary key (id));
alter table produto add constraint FK4qqkq7cmomd87obw16prilngw foreign key (usuario_id) references usuario;
create sequence produto_seq start with 1 increment by 50;
create sequence usuario_seq start with 1 increment by 50;
create table produto (quantidade number(10,0) not null, valor float(53) not null, id number(19,0) not null, usuario_id number(19,0), categoria varchar2(255 char), descricao varchar2(255 char), marca varchar2(255 char), modelo varchar2(255 char), nome varchar2(255 char), primary key (id));
create table usuario (id number(19,0) not null, email varchar2(255 char), nome varchar2(255 char), primary key (id));
alter table produto add constraint FK4qqkq7cmomd87obw16prilngw foreign key (usuario_id) references usuario;
