# --- !Ups
create EXTENSION pgcrypto;
INSERT INTO account(name, first_name, last_name, password, email, account_role,registration_date)
VALUES ('Admin','Jan','Nowak',crypt('admin',gen_salt('bf')),'admin@admin.com','ADMIN',NOW()),
  ('User','Piotr','Kowalski',crypt('user',gen_salt('bf')),'user@user.com','USER',NOW());

# --- !Downs

