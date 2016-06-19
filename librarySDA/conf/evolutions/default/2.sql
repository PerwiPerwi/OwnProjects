# --- !Ups
create EXTENSION pgcrypto;

INSERT INTO book(title, author, description)
VALUES ('W pustyni i w puszczy', 'Henryk Sienkiwicz', 'Opis ksiazki'),
        ('Szklany tron. Tom 4. Królowa Cieni', 'Maas Sarah J.', 'Opis ksiazki Maas Sarah J.'),
        ('Przygoda fryzjera damskiego', 'Eduardo Mendoza', 'Opis ksiazki 3');

