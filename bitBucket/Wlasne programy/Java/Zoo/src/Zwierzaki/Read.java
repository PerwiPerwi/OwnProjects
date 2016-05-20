package Zwierzaki;

import java.lang.NumberFormatException;
import java.lang.Float;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Read {
	// Deklaracja stalych Scanner i SimpleDateFormat
	static Scanner odczyt = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
	static ZooDAO zooDAO = new ZooDAO();
	static Zwierzaki zwierzaki = new Zwierzaki();

	//
	public static void main(String[] args) {

		final int dodanieZwierzaka = 0;
		final int wyswietlenieZwierzakow = 1;
		final int wyjscie = 2;
		int wybor;

		// Poczatek petli do while dla menu programu
		do {
			printOptions();

			wybor = getUserChoice();

			switch (wybor) {

			case dodanieZwierzaka:
				dodawanieNowegoZwierzaka();
				break;

			case wyswietlenieZwierzakow:
				wyswietlanieZwierzakow();
				break;

			case wyjscie:
				System.out.println("Wybrano zamkniecie programu");
				break;
			}
		} while (wybor != wyjscie);
	}

	public static void dodawanieNowegoZwierzaka() {
		
		// Dodawanie nowego Zwierzaka
		System.out.println("Zostala wybrana opcja dodania nowego Zwierzaka");
		System.out.println("---------------");

		// Pobieranie danych zwierzaka
		System.out.print("Podaj imie opiekuna Zwierzaka: ");
		zwierzaki.setImieWlasciciela(getUserInfo());

		System.out.print("Podaj imie Zwierzaka: ");
		zwierzaki.setImieZwierzaka(getUserInfo());

		System.out.print("Podaj rase Zwierzaka: ");
		zwierzaki.setRasaZwierzaka(getUserInfo());

		// Pobieranie masy Zwierzaka
		do {
			System.out.print("Podaj mase Zwierzaka w formacie 10.5: ");
			Pattern wzorMasyZwierzaka = Pattern.compile("[0-9]+(\\.[0-9]+)?");
			
			// Wzor masy Zwierzaka
																			

			String masaZwierzakaWczytana = getUserInfo();
			// Instrukcja warunkowa if
	

			if (wzorMasyZwierzaka.matcher(masaZwierzakaWczytana).matches()) { 

				try { // Bloki Try Catch
					zwierzaki.setMasaZwierzaka(Float.valueOf(masaZwierzakaWczytana));
				}

				catch (NumberFormatException nfe) {
					System.out.println("---------------");
					System.out.println("Ups, cos poszlo zle, popraw mase w formacie 10.5");
				} catch (PatternSyntaxException pse) {
					System.out.println("---------------");
					System.out.println("Blad syntax");
				}
			}
		} while (zwierzaki.getMasaZwierzaka() == null);

		// Okreslanie daty urodzenia Zwierzaka
		do {
			System.out.print("Podaj date urodzenia zwierzaka w formacie dd.MM.rrrr: ");
			Pattern wzorzecDatyUrodzeniaZwierzaka = Pattern.compile("[0-3]?[0-9].[0-1]?[0-9].[0-9]{4}");
			
			// Wzorzec daty urodzenia zwierzaka
																									 
			String dataUrodzeniaZwierzaka = getUserInfo();

			if (wzorzecDatyUrodzeniaZwierzaka.matcher(dataUrodzeniaZwierzaka).matches()) {

				try {
					zwierzaki.setData(sdf.parse(dataUrodzeniaZwierzaka)); 
					// parsowanie daty
				} catch (ParseException pe) {
					System.out.println("---------------");
					System.out.println("Cos z formatem daty, wprowadz jeszcze raz (dd.MM.rrrr");
				} catch (PatternSyntaxException pse) {
					System.out.println("---------------");
					System.out.println("Wystapil blad syntax w dacie urodzenia zwierzaka");
				}
			}
		} while (zwierzaki.getDataUrodzenia() == null);
		// Dodawanie zwierzaka do listy
		zooDAO.dodajZwierzaka(zwierzaki);
	}

	// Wyswietlanie zwierzakow
	public static void wyswietlanieZwierzakow() {
		System.out.println("----------------");
		System.out.println("Zostala wybrana opcja wyswietlania Zwierzakow");
		for (int i = 0; i < zooDAO.getZwierzak().size(); i++) {
			zwierzaki = zooDAO.getZwierzak().get(i);
			System.out.println(i + ":" + zwierzaki.getImieZwierzaka());
		}
		System.out.println();

		Pattern wzorWyboruZwierzaka = Pattern.compile("[0-9]+");
		String numerWczytany;
		do {
			System.out.print("Ktorego Zwierzaka chcesz poznac blizej?");
			System.out.println();
			numerWczytany = getUserInfo();
		} while (!wzorWyboruZwierzaka.matcher(numerWczytany).matches());
		Integer numerZwierzaka = Integer.parseInt(numerWczytany);
		if (zooDAO.getZwierzak().size() > numerZwierzaka) {
			Zwierzaki wybranyZwierzak = zooDAO.getZwierzak().get(numerZwierzaka);
			System.out.println("Zwierzak nazywa sie: " + wybranyZwierzak.getImieZwierzaka() + "\nJest rasy: " + wybranyZwierzak.getRasaZwierzaka()
					+ "\nUrodzil sie w: " + wybranyZwierzak.getDataUrodzenia() + "\nAktualnie wazy: " + wybranyZwierzak.getMasaZwierzaka()
					+ " i opiekuje sie nim: " + wybranyZwierzak.getImieWlasciciela());
			System.out.println("-----------------");
			System.out.println(" ");
		} else {
			System.out.println(
					"Cos poszlo nie tak. Taki zwierzaczek nie istnieje, sprobuj wybrac innego, lub po prostu go dodaj:)");

		}
	}

	public static void printOptions() {
		System.out.println("Witamy w programie ZOO!\nOto dostepne opcje!:");
		System.out.println("0: Dodawanie nowego Zwierzaka");
		System.out.println("1: Wyswietlanie Zwierzakow");
		System.out.println("2: Zamykanie programu");
	}

	public static String getUserInfo() {
		return odczyt.nextLine();
	}

	public static Integer getUserChoice() {
		Integer choice = odczyt.nextInt();
		odczyt.nextLine();
		return choice;
	}
}