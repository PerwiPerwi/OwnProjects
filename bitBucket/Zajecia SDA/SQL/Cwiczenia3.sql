-- === 3.1 INSERT =============

-- dodanie jednego wiersza
INSERT INTO klient (  imie, nazwisko, rok_urodzenia, plec, data_zalozenia)
 VALUES ( 'Tomasz', 'Nowak', '1975-01-03', 'M', '2014-08-01');

SELECT * FROM klient WHERE nazwisko='Nowak'

-- dodanie paru wierszy
INSERT INTO klient (  imie, nazwisko, rok_urodzenia, plec, data_zalozenia)
 VALUES ( 'Jan', 'Kowalewski', '1974-01-03', 'M', '2014-09-01'),
        ( 'Maciej', 'Kowalewski', '1974-01-02', 'M', '2014-09-01');

-- dodawanie wierszy na podstawie selecta
INSERT INTO klient (  imie, nazwisko, rok_urodzenia, plec, data_zalozenia) 
SELECT 'Alfred' , nazwisko, rok_urodzenia, plec, data_zalozenia FROM klient WHERE imie='Jan' AND nazwisko='Kowalski';

SELECT * FROM klient WHERE nazwisko='Kowalski'

-- ===== 3.2 DELETE ====
DELETE FROM klient WHERE imie='Maciej' AND nazwisko='Kowalewski'; 

-- UWAGA!! Nie podanie waunku na końcu mozę skasować wszystkie wiersze w tabeli'
-- Do kasowania wszystkich wierszy w tabeli lepiej użyć komendy TRUNCATE TABLE

-- ======= 3.3 UPDATE =======
UPDATE klient SET imie='Janusz',rok_urodzenia='2001-02-02' WHERE imie='Jan' AND nazwisko='Kowalewski';


-- Ćwieczenia
-- Dodać siebie do tablicy 'klient'
R: 
 INSERT INTO klient (  imie, nazwisko, rok_urodzenia, plec, data_zalozenia) 
 VALUES ( 'Michał', 'Szymański', '1970-01-01', 'M', '2014-09-01');  	

-- Dodać jeszce jeden wiersz w oparciu o właśnie stworzony wiersz z tym że w nowym wierszu imie ma się równać 'Jan'
R:
 INSERT INTO klient (  imie, nazwisko, rok_urodzenia, plec, data_zalozenia) 
	SELECT 'Jan', nazwisko, rok_urodzenia, plec, data_zalozenia FROM klient 
	 WHERE imie='Michał' AND nazwisko='Szymański';

-- Proszę zmodyfikować date urodzenia w nowo dodanym wierszy  dodajac miesiąc do tej co jest 
--(dodanie + interval '1 month'
R: 
 UPDATE klient SET rok_urodzenia=rok_urodzenia+interval '1 month' WHERE imie='Jan' AND nazwisko='Szymański'

-- Proszę skasować wiersz który utworzyliście dla siebie w tabeli klient
R:
 DELETE FROM klient WHERE imie='Michał' AND nazwisko='Szymański';

-- ===== 3.4 CREATE TABLE =========
CREATE TABLE klient_test (
	klient_id         BIGSERIAL PRIMARY KEY,
	imie                CHAR(100),
	nazwisko        CHAR(100)
);
INSERT INTO klient_test (imie, nazwisko) VALUES ('Zdzisław', 'Nowak');

------------- Ćwiczenia
/* Proszę założyć tabelę przchowujaca informacje filmach. Tak żeby przechowywała   
   kolumny:
	film_id, nazwa_filmu, rezyser, rok_produkcji, typ_filmu, dostepnosc_na_VOD (tak/nie)  
 */
 
R:
CREATE TABLE film (
	film_id			BIGSERIAL,
	nazwa_filmu		CHAR(200),
	rezyser                 CHAR(100),         
	rok_produkcji           DATE, 
	typ_filmu 		CHAR(100),
	dostepnosc_na_VOD       BOOLEAN 
	kwota 			NUMERIC(10,2)
); 

-- =========== 3.5 System kontrola ===> oddzielny plik ======= 

-- ============ 3.6 System kontrola ===> oddzielny plik