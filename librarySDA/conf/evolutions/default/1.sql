# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                            bigserial not null,
  title                         varchar(255) not null,
  author                        varchar(255) not null,
  description                   varchar(800) not null,
  rental_id                     bigint,
  book_status                   varchar default 'AVAILABLE',
  constraint uq_book_rental_id unique (rental_id),
  constraint pk_book primary key (id)
);

create table penalty (
  id                            bigserial not null,
  payment_date                  timestamp not null,
  penalty_status                varchar default 'NOT_PAYED',
  ammount                       float not null,
  user_id                       bigint,
  constraint pk_penalty primary key (id)
);

create table rental (
  id                            bigserial not null,
  loan_date                     timestamp,
  return_date                   timestamp,
  rental_status                 varchar default 'NOT_RETURNED',
  penalty_id                    bigint,
  book_id                       bigint not null,
  user_id                       bigint,
  constraint uq_rental_penalty_id unique (penalty_id),
  constraint uq_rental_book_id unique (book_id),
  constraint pk_rental primary key (id)
);

create table users (
  id                            bigserial not null,
  first_name                    varchar(255) not null,
  last_name                     varchar(255) not null,
  email                         varchar(255) not null,
  password                      varchar(255) not null,
  account_status                varchar default 'ACTIVE',
  account_role                  varchar default 'USER',
  registration_date             timestamp,
  constraint uq_users_email unique (email),
  constraint pk_users primary key (id)
);

alter table book add constraint fk_book_rental_id foreign key (rental_id) references rental (id) on delete restrict on update restrict;

alter table penalty add constraint fk_penalty_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_penalty_user_id on penalty (user_id);

alter table rental add constraint fk_rental_penalty_id foreign key (penalty_id) references penalty (id) on delete restrict on update restrict;

alter table rental add constraint fk_rental_book_id foreign key (book_id) references book (id) on delete restrict on update restrict;

alter table rental add constraint fk_rental_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_rental_user_id on rental (user_id);


# --- !Downs

alter table if exists book drop constraint if exists fk_book_rental_id;

alter table if exists penalty drop constraint if exists fk_penalty_user_id;
drop index if exists ix_penalty_user_id;

alter table if exists rental drop constraint if exists fk_rental_penalty_id;

alter table if exists rental drop constraint if exists fk_rental_book_id;

alter table if exists rental drop constraint if exists fk_rental_user_id;
drop index if exists ix_rental_user_id;

drop table if exists book cascade;

drop table if exists penalty cascade;

drop table if exists rental cascade;

drop table if exists users cascade;

