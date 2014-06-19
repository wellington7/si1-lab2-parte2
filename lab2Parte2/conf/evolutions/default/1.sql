# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cupom_desconto (
  id                        bigint not null,
  nome_do_cliente           varchar(255),
  valor                     double,
  constraint pk_cupom_desconto primary key (id))
;

create sequence cupom_desconto_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists cupom_desconto;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists cupom_desconto_seq;

