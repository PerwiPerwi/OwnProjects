DROP SCHEMA IF EXISTS kontrola CASCADE;

CREATE SCHEMA kontrola;
CREATE TABLE kontrola.pasazer(
pasazer_id		BIGSERIAL,
pasazer_imie		VARCHAR(50) NOT NULL,
pasazer_nazwisko	VARCHAR(50) NOT NULL,
PRIMARY KEY (pasazer_id)
);

CREATE TABLE kontrola.straznik(
straznik_id		INT,
straznik_imie		VARCHAR(50) NOT NULL,
straznik_nazwisko	VARCHAR(50) NOT NULL,
stopien			VARCHAR(50)NOT NULL,
data_zatrudnienia	DATE NOT NULL default NOW(),
pensja			NUMERIC(10,2) NOT NULL CHECK (pensja>=0),
PRIMARY KEY(straznik_id)		
);

CREATE TABLE kontrola.lotnisko(
nazwa_portu		VARCHAR(50) NOT NULL,
PRIMARY KEY(nazwa_portu)
);

CREATE TABLE kontrola.numer_stanowiska(
numer_stanowiska_id	INT NOT NULL,
numer_stanowiska	INT NOT NULL,
nazwa_portu		VARCHAR(50) NOT NULL,
UNIQUE (numer_stanowiska_id),

CONSTRAINT numer_stanowiska_Fkey FOREIGN KEY(nazwa_portu)
REFERENCES kontrola.lotnisko(nazwa_portu)
ON DELETE CASCADE
);


CREATE TABLE kontrola.kontrola(
pasazer_id		INT8,
straznik_id		INT8,
nazwa_portu		VARCHAR(50) NOT NULL,
numer_stanowiska_id	INT NOT NULL,
wynik_kontroli		BOOLEAN NOT NULL,
czas_kontroli		TIMESTAMP NOT NULL,

CONSTRAINT pasazer_kontrolowany_Fkey FOREIGN KEY(pasazer_id)
REFERENCES kontrola.pasazer(pasazer_id)
ON DELETE CASCADE,

CONSTRAINT straznik_kontrolujacy_Fkey FOREIGN KEY(straznik_id)
REFERENCES kontrola.straznik(straznik_id)
ON DELETE CASCADE,

CONSTRAINT numer_stanowiska_Fkey FOREIGN KEY(numer_stanowiska_id)
REFERENCES kontrola.numer_stanowiska(numer_stanowiska_id)
ON DELETE CASCADE
);

CREATE TABLE kontrola.przyznane_nagrody(
straznik_id 		INT8
NOT NULL REFERENCES kontrola.straznik(straznik_id),
nazwa_nagrody 		VARCHAR(50) NOT NULL,
data_przyznania		DATE,
PRIMARY KEY(straznik_id, nazwa_nagrody, data_przyznania),
CONSTRAINT przyznane_nagrody_Fkey FOREIGN KEY(straznik_id)
REFERENCES kontrola.straznik(straznik_id)
ON DELETE CASCADE
);

CREATE INDEX pasazer_imie_nazwisko_idx ON kontrola.pasazer(pasazer_imie, pasazer_nazwisko);
CREATE INDEX klienci_skontrolowani_przez_straznika_idx ON kontrola.kontrola(pasazer_id, straznik_id);
CREATE INDEX lista_kontroli_w_okreslonym_stanowisku_w_danym_czasie_idx ON kontrola.kontrola(numer_stanowiska_id, czas_kontroli);


