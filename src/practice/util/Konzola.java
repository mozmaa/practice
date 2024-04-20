package practice.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Klasa koja nudi funkcije za zaštićenu interakciju, oslanjajući se na
 * ispis putem {@code System.out} standardnog <i>stream</i>-a i unos putem
 * {@code System.in} standardnog <i>stream</i>-a.
 *
 * @author  Siniša Nikolić ({@link www.ftninformatika.com})
 * @author  Miloš Beočanin ({@link www.ftninformatika.com})
 * 
 */
public class Konzola {

	private static final String DATE_FORMAT = "dd.MM.yyyy.";
	private static final String TIME_FORMAT = "HH:mm";
	private static final String DATE_TIME_FORMAT = "dd.MM.yyyy. HH:mm";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

	private static Scanner in = new Scanner(System.in);

	private static void validirajPoruku(String poruka) throws IllegalArgumentException {
		if (poruka == null) {
			throw new IllegalArgumentException("poruka je null");
		}
		if (poruka.equals("")) {
			throw new IllegalArgumentException("poruka je prazna");
		}
	}
	
    /**
     * Zahteva od korisnika unos {@code String}-a, prikazujući
     * mu usput obaveštenje.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code String}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static String ocitajString(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		System.out.print(String.format("%s: ", poruka));
		return in.nextLine();
	}

    /**
     * Zahteva od korisnika unos {@code char}-a koji nije prazan, prikazujući
     * mu usput obaveštenje. Unos se ponavlja dok se ne unese {@code char}
     * koji nije prazan.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code char}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static char ocitajChar(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);
		
		System.out.println();
		while (true) {	
			System.out.print(String.format("%s: ", poruka));
			try {
				String sadrzaj = in.nextLine();
				if (sadrzaj.length() <= 1)
					return sadrzaj.charAt(0);
			} catch (IndexOutOfBoundsException ex) {}
		}
	}
	
    /**
     * Zahteva od korisnika unos {@code boolean}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna {@code boolean}
     * vrednost.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code boolean}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static boolean ocitajBoolean(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {	
			System.out.print(String.format("%s: ", poruka));
			String sadrzaj = in.nextLine();
			if (sadrzaj.equals("true") || sadrzaj.equals("false"))
				return Boolean.parseBoolean(sadrzaj);
		}
	}

    /**
     * Zahteva od korisnika unos {@code int}-a prikazujući mu usput obaveštenje.
     * Unos se ponavlja dok se ne unese validna {@code int} vrednost.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code int}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static int ocitajInt(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {	
			System.out.print(String.format("%s: ", poruka));
			try {
				return Integer.parseInt(in.nextLine());
			} catch (NumberFormatException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code long}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna {@code long}
     * vrednost.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code long}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static long ocitajLong(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {
			System.out.print(String.format("%s: ", poruka));
			try {
				return Long.parseLong(in.nextLine());
			} catch (NumberFormatException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code float}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna {@code float}
     * vrednost.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code float}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static float ocitajFloat(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {
			System.out.print(String.format("%s: ", poruka));
			try {
				return Float.parseFloat(in.nextLine());
			} catch (NumberFormatException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code double}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna {@code double}
     * vrednost.
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code double}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static double ocitajDouble(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {		
			System.out.print(String.format("%s: ", poruka));
			try {
				return Double.parseDouble(in.nextLine());
			} catch (NumberFormatException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code LocalDate}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna {@code LocalDate}
     * vrednost po formatu "dd.MM.yyyy.".
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code LocalDate}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static LocalDate ocitajDate(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {		
			System.out.print(String.format("%s (%s): ", poruka, DATE_FORMAT));
			try {
				return LocalDate.parse(in.nextLine(), DATE_FORMATTER);
			} catch (DateTimeParseException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code LocalTime}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna {@code LocalTime}
     * vrednost po formatu "HH:mm".
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code LocalTime}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static LocalTime ocitajTime(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {		
			System.out.print(String.format("%s (%s): ", poruka, TIME_FORMAT));
			try {
				return LocalTime.parse(in.nextLine(), TIME_FORMATTER);
			} catch (DateTimeParseException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code LocalDateTime}-a prikazujući mu usput
     * obaveštenje. Unos se ponavlja dok se ne unese validna
     * {@code LocalDateTime} vrednost po formatu "dd.MM.yyyy. HH:mm".
     *
     * @param      poruka  Poruka koja obaveštava korisnika o tome šta treba
     *                     da unese
     * @return     Uneseni {@code LocalDateTime}
     *
     * @throws  IllegalArgumentException Ako je {@code poruka} {@code null}
     *          ili je prazna
     * @throws  NoSuchElementException Ako se program prekine dok se čeka na unos
     * 
     */
	public static LocalDateTime ocitajDateTime(String poruka) throws IllegalArgumentException, NoSuchElementException {
		validirajPoruku(poruka);

		System.out.println();
		while (true) {		
			System.out.print(String.format("%s (%s): ", poruka, DATE_TIME_FORMAT));
			try {
				return LocalDateTime.parse(in.nextLine(), DATE_TIME_FORMATTER);
			} catch (DateTimeParseException ex) {}
		}
	}

    /**
     * Zahteva od korisnika unos {@code String}-a koji mora biti jednak
     * jednom od 2 ponuđena {@code String}-a rezervisanih za potvrdan ili
     * odričan odgovor na pitanje. Unos se ponavlja sve dok se ne unese jedan
     * od ponuÄ‘enih {@code String}-ova.
     *
     * @param      pitanje  Pitanje koje se prikazuje korisniku
     * @param      da  Ponuđeni {@code String} rezervisan za potvrdan odgovor
     * @param      ne  Ponuđeni {@code String} rezervisan za odričan odgovor
     * @return     odgovor korisnika u vidu {@code boolean} vrednosti
     *
     * @throws  IllegalArgumentException Ako su {@code pitanje}, {@code da}
     *          ili {@code ne} {@code null} ili prazni
     * 
     */
	public static boolean ocitajIzbor(String pitanje, String da, String ne) throws IllegalArgumentException, NoSuchElementException {
		if (pitanje == null) {
			throw new IllegalArgumentException("pitanje je null");
		}
		if (pitanje.equals("")) {
			throw new IllegalArgumentException("pitanje je prazno");
		}
		if (da == null) {
			throw new IllegalArgumentException("da je null");
		}
		if (da.equals("")) {
			throw new IllegalArgumentException("da je prazan");
		}
		if (ne == null) {
			throw new IllegalArgumentException("ne je null");
		}
		if (ne.equals("")) {
			throw new IllegalArgumentException("ne je prazan");
		}
		
		System.out.println();
		while (true) {	
			System.out.print(String.format("%s (%s/%s)? Unesite izbor: ", pitanje, da, ne));
			String sadrzaj = in.nextLine();
			if (sadrzaj.equals(da) || sadrzaj.equals(ne))
				return sadrzaj.equals(da);
		}
	}

    /**
     * Zahteva od korisnika unos {@code String}-a koji mora biti jednak
     * "d" ili "n" za potvrdan, odnosno odričan odgovor. Unos se ponavlja sve
     * dok se ne unese jedan od ponuÄ‘enih {@code String}-ova.
     *
     * @param      pitanje  Pitanje koje se prikazuje korisniku
     * @return     odgovor korisnika u vidu {@code boolean} vrednosti
     *
     * @throws  IllegalArgumentException Ako je {@code pitanje} {@code null}
     *          ili je prazno
     * 
     */
	public static boolean ocitajIzbor(String poruka) throws IllegalArgumentException, NoSuchElementException {
		return ocitajIzbor(poruka, "d", "n");
	}

    /**
     * Vraća šablon za formatiranje datuma "dd.MM.yyyy.".
     *
     * @return     {@code String} reprezentaciju šablona za formatiranje
     * 
     */
	public static String dateFormat() {
		return DATE_FORMAT;
	}

    /**
     * Vraća šablon za formatiranje vremena "HH:mm".
     *
     * @return     {@code String} reprezentaciju šablona za formatiranje
     * 
     */
	public static String timeFormat() {
		return TIME_FORMAT;
	}

    /**
     * Vraća šablon za formatiranje datuma i vremena "dd.MM.yyyy. HH:mm".
     *
     * @return     {@code String} reprezentaciju šablona za formatiranje
     * 
     */
	public static String dateTimeFormat() {
		return DATE_TIME_FORMAT;
	}

    /**
     * Formatira {@code LocalDate} po formatu "dd.MM.yyyy.".
     *
     * @param      datum  Datum koji je potrebno formatirati
     * @return     Formatiranu {@code String} reprezentaciju ulaznog parametra
     *
     * @throws  DateTimeException Ako {@code datum} ne može da se formatira
     * 
     */
	public static String formatiraj(LocalDate datum) throws DateTimeException {
		return DATE_FORMATTER.format(datum);
	}

    /**
     * Formatira {@code LocalTime} po formatu "HH:mm".
     *
     * @param      vreme  Vreme koje je potrebno formatirati
     * @return     Formatiranu {@code String} reprezentaciju ulaznog parametra
     *
     * @throws  DateTimeException Ako {@code vreme} ne može da se formatira
     * 
     */
	public static String formatiraj(LocalTime vreme) throws DateTimeException {
		return TIME_FORMATTER.format(vreme);
	}

    /**
     * Formatira {@code LocalDateTime} po formatu "dd.MM.yyyy. HH:mm".
     *
     * @param      datumIVreme  Datum i vreme koje je potrebno formatirati
     * @return     Formatiranu {@code String} reprezentaciju ulaznog parametra
     *
     * @throws  DateTimeException Ako {@code datumIVreme} ne može da se
     *          formatira
     * 
     */
	public static String formatiraj(LocalDateTime datumIVreme) throws DateTimeException {
		return DATE_TIME_FORMATTER.format(datumIVreme);
	}

    /**
     * Ispisuje poruku sa prethodećom praznom linijom.
     *
     * @param      poruka Poruka koja se prikazuje
     * 
     */
	public static void prikazi(String poruka) throws DateTimeException {
		System.out.println();
		System.out.println(poruka);
	}

}
