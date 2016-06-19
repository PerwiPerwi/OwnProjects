# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  id                            bigserial not null,
  contact_name                  varchar(255) not null,
  contact_data_id               bigint not null,
  user_id                       bigint not null,
  registration_date             timestamp,
  constraint uq_contact_contact_data_id unique (contact_data_id),
  constraint pk_contact primary key (id)
);

create table contact_data (
  id                            bigserial not null,
  email                         varchar(255) not null,
  country                       varchar(255),
  zip_code                      varchar(255),
  city                          varchar(255),
  street                        varchar(255),
  description                   varchar(4000),
  phone_number                  varchar(255),
  constraint pk_contact_data primary key (id)
);

create table account (
  id                            bigserial not null,
  name                          varchar(255) not null,
  first_name                    varchar(255) not null,
  last_name                     varchar(255) not null,
  password                      varchar(255) not null,
  account_role                  varchar default 'USER',
  created_by                    varchar default 'WEBSITE',
  email                         varchar(255) not null,
  profil_picture                varchar default 'defaultPicture.png',
  registration_date             timestamp,
  constraint uq_account_name unique (name),
  constraint uq_account_email unique (email),
  constraint pk_account primary key (id)
);

alter table contact add constraint fk_contact_contact_data_id foreign key (contact_data_id) references contact_data (id) on delete restrict on update restrict;

alter table contact add constraint fk_contact_user_id foreign key (user_id) references account (id) on delete restrict on update restrict;
create index ix_contact_user_id on contact (user_id);


# --- !Downs

alter table if exists contact drop constraint if exists fk_contact_contact_data_id;

alter table if exists contact drop constraint if exists fk_contact_user_id;
drop index if exists ix_contact_user_id;

drop table if exists contact cascade;

drop table if exists contact_data cascade;

drop table if exists account cascade;

