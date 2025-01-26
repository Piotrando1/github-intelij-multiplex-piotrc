package multiplex;


import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// -------------------------------------------------------------------------------------------
// TWORZE OBIEKTY KINA I SAL (3 Kina)
// -------------------------------------------------------------------------------------------

        List<Cinema> cinemas = new ArrayList<>();

        // Tworze kino w Krakowie oraz dodaje sale kinowe (hall):
        Cinema kinoPodBaranami = new Cinema("KR1", "Kino Pod Baranami", "Rynek Główny 27", "Kraków");

        SeatLayout kinoPodBaranamiLayout = LayoutConfigurator.createSmallHall();
        CinemaHall salaSmoka = new CinemaHall("KR_SALA1", "Sala Smoka", kinoPodBaranamiLayout);
        kinoPodBaranami.addHall(salaSmoka);

        SeatLayout kinoWislaLayout = LayoutConfigurator.createLargeHall();
        CinemaHall salaWisla = new CinemaHall("KR_SALA2", "Sala Wisla", kinoWislaLayout);
        kinoPodBaranami.addHall(salaWisla);


        // Tworze kino w Warszawie oraz dodaje sale kinowe:
        Cinema kinoSyrenka = new Cinema("WA1", "Kino Syrenka", "Warszawska 5", "Warszawa");

        SeatLayout kinoSyrenkaLayout = LayoutConfigurator.createMediumHall();
        CinemaHall salaSyrenki = new CinemaHall("WA_SALA1", "Sala Syrenki", kinoSyrenkaLayout);
        kinoSyrenka.addHall(salaSyrenki);

        SeatLayout kinoNarodoweLayout = LayoutConfigurator.createLargeHall();
        CinemaHall salaNarodowa = new CinemaHall("WA_SALA2", "Sala Narodowa", kinoNarodoweLayout);
        kinoSyrenka.addHall(salaNarodowa);


        // Tworze kino w Gdyni + sale:
        Cinema kinoMorze = new Cinema("GD1", "Kino Morze", "Gdynska 200", "Gdynia");

        SeatLayout kinoMorzeLayout = LayoutConfigurator.createLargeHall();
        CinemaHall salaNieMaFal = new CinemaHall("GD_SALA1", "Sala Fal Nie ma Fal", kinoMorzeLayout);
        kinoMorze.addHall(salaNieMaFal);


// -------------------------------------------------------------------------------------------
// DODAJE KINA DO LISTY CINEMAS
// -------------------------------------------------------------------------------------------

        cinemas.add(kinoPodBaranami);
        cinemas.add(kinoSyrenka);
        cinemas.add(kinoMorze);


// -------------------------------------------------------------------------------------------
// USTAWIAM HARMONOGRAM - DATY
// -------------------------------------------------------------------------------------------


        LocalDate startDate = LocalDate.now();
        startDate.plusDays(14);


// -------------------------------------------------------------------------------------------
// TWORZE SEANSE - DEFINIUJE FILMY
// -------------------------------------------------------------------------------------------

        Screening kr1_s1 = new StandardScreening(
                new Movie("Matrix"),
                startDate.plusDays(4),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0),
                salaSmoka
        );
        kr1_s1.initSeatsLayout();
        salaSmoka.addScreening(kr1_s1);


        Screening kr1_s2 = new VIPScreening(
                new Movie("Pulp Fiction"),
                startDate.plusDays(5),
                LocalTime.of(18, 0),
                LocalTime.of(20, 30),
                salaSmoka
        );
        kr1_s2.initSeatsLayout();
        salaSmoka.addScreening(kr1_s2);


        Screening kr1_s3 = new VRScreening(
                new Movie("VirtualFlight"),
                startDate.plusDays(6),
                LocalTime.of(20, 0),
                LocalTime.of(23, 30),
                salaWisla
        );
        kr1_s3.initSeatsLayout();
        salaWisla.addScreening(kr1_s3);


        Screening kr1_s4 = new StandardScreening(
                new Movie("Inception"),
                startDate.plusDays(6),
                LocalTime.of(12, 30),
                LocalTime.of(15, 0),
                salaWisla
        );
        kr1_s4.initSeatsLayout();
        salaWisla.addScreening(kr1_s4);


        Screening wa_s1 = new StandardScreening(
                new Movie("Doom"),
                startDate.plusDays(5),
                LocalTime.of(15, 0),
                LocalTime.of(17, 0),
                salaNarodowa
        );
        wa_s1.initSeatsLayout();
        salaNarodowa.addScreening(wa_s1);


        Screening wa_s2 = new VIPScreening(
                new Movie("Prometheus"),
                startDate.plusDays(5),
                LocalTime.of(20, 0),
                LocalTime.of(22, 0),
                salaSyrenki
        );
        wa_s2.initSeatsLayout();
        salaSyrenki.addScreening(wa_s2);


        Screening wa_s3 = new VIPScreening(
                new Movie("Kubuś Puchatek"),
                startDate.plusDays(7),
                LocalTime.of(15, 0),
                LocalTime.of(16, 30),
                salaNarodowa
        );
        wa_s3.initSeatsLayout();
        salaNarodowa.addScreening(wa_s3);


        Screening gd_s1 = new StandardScreening(
                new Movie("Alien 3"),
                startDate.plusDays(10),
                LocalTime.of(16, 0),
                LocalTime.of(18, 30),
                salaNieMaFal
        );
        gd_s1.initSeatsLayout();
        salaNieMaFal.addScreening(gd_s1);

// -------------------------------------------------------------------------------------------
// POKAŻ REPERTUAR czyli SCREANINGS
// -------------------------------------------------------------------------------------------

        System.out.println(" ======== REPERTUAR NA KOLEJNE 2 TYGODNIE ========");
        System.out.println();

        for (Cinema cinema : cinemas) {
            System.out.println(" ==== Kino: " + cinema.getNameCinema()
                    + " | Miasto: " + cinema.getCityName() + " ====");
            System.out.println();
            for (CinemaHall hall : cinema.getHalls()) {
                System.out.println("  Sala: " + hall.getName()
                        + " (ID: " + hall.getHallId() + ")");
                for (Screening screening : hall.getScreenings()) {
                    System.out.println("    Film: " + screening.getMovie().getTitle()
                            + " | Data: " + screening.getDate()
                            + " | Godzina: " + screening.getStartTime()
                            + " -> Ilość dostępnych miejsc: " + screening.getSeats().size());
                }
            }
            System.out.println();
        }

// -------------------------------------------------------------------------------------------
// URUCHAMIAM PROCES REZERWACJI
// -------------------------------------------------------------------------------------------

        System.out.println("Jesli chcesz dokonać rezerwacji wciśnij 1");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (!answer.equalsIgnoreCase("1")) {
            System.out.println("Zakończono bez rezerwacji.");
            return;
        }


        System.out.println("Wybierz numer seansu z poniższej listy:");
        int index = 1;
        List<Screening> allScreenings = new ArrayList<>();
        for (Cinema c : cinemas) {
            for (CinemaHall h : c.getHalls()) {
                for (Screening s : h.getScreenings()) {
                    System.out.println(index + ") " + s.getMovie().getTitle()
                            + " | " + s.getDate()
                            + " " + s.getStartTime()
                            + " (Kino: " + c.getNameCinema() + ", Sala: " + h.getName() + ")");
                    allScreenings.add(s);
                    index++;
                }
            }
        }

        System.out.print("Podaj numer seansu: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > allScreenings.size()) {
            System.out.println("Nieprawidłowy numer.");
            return;
        }

        Screening chosenScreening = allScreenings.get(choice - 1);

// -------------------------------------------------------------------------------------------
// OPCJONALNA MAPA WOLNYCH MIEJSC
// -------------------------------------------------------------------------------------------


        System.out.println("===== Wolne fotele w tym seansie: =====");
        List<Seat> seats = chosenScreening.getSeats();
        int i = 1;
        for (Seat seat : seats) {
            if (!seat.isReserved()) {
                double price = chosenScreening.calculateTicketPrice(seat);
                System.out.println(i + ") Fotel: " + seat.getId()
                        + ", Strefa: " + seat.getStandard()
                        + ", Cena: " + price + " zł");
                i++;
            }
        }


        System.out.print("Ile biletów chcesz kupić? ");
        int ticketCount = scanner.nextInt();
        scanner.nextLine();

        if (ticketCount <= 0) {
            System.out.println("Liczba biletów musi być większa od 0!");
            return;
        }


        System.out.print("Wybrałeś " + ticketCount + " miejsc. Wpisz identyfikatory (np. H4 H5 H6): ");
        String seatsLine = scanner.nextLine();
        String[] seatsArray = seatsLine.split(" ");
        if (seatsArray.length != ticketCount) {
            System.out.println("Podałeś " + seatsArray.length + " złą liczbe miejsc, powinieneś wybrać" + ticketCount);
            return;
        }

        List<String> seatIds = Arrays.asList(seatsArray);


// -------------------------------------------------------------------------------------------
// PROCES WYWOŁANIA REZERWACJI DLA KINOMANA
// -------------------------------------------------------------------------------------------

        SeatReservation seatReservation = new SeatReservation();
        Kinoman user = null;
        Reservation reservation = seatReservation.createReservation(chosenScreening, user, seatIds);

        System.out.println("===== Podsumowanie zakupionych biletów =====");
        for (Ticket ticket : reservation.getTickets()) {
            Seat seat = ticket.getSeat();
            double singlePrice = ticket.getPrice();
            System.out.println("Miejsce: " + seat.getId()
                    + ", Standard Miejsca: " + seat.getStandard()
                    + ", Cena biletu: " + singlePrice + " PLN");
        }

        double totalPrice = reservation.getTotalPrice();
        System.out.println("Cena wynosi: " + totalPrice + " PLN");
        System.out.println("Dziękujemy za dokonanie rezerwacji, oto twoje potwierdzenie");


// -------------------------------------------------------------------------------------------
// REZERWACJA DLA KONKRETNEGO KINOMANA PRZEZ SYSTEM
// -------------------------------------------------------------------------------------------


/*
        Kinoman userAndrzej = new Kinoman("U99", "Andrzej Nowak", "andrzej@nowak.com");
        List<String> seatIdsNowak = List.of("E1", "E2");

        SeatReservation seatReservation2 = new SeatReservation();
        Reservation reservationNowak = seatReservation2.createReservation(kr1_s1, userAndrzej, seatIdsNowak);

        System.out.println("===== Rezerwacja dla Andrzej Nowaka  =====");
        for (Ticket ticket : reservationNowak.getTickets()) {
            Seat seat = ticket.getSeat();
            double singlePrice = ticket.getPrice();
            System.out.println("Miejsce: " + seat.getId()
                    + ", Strefa: " + seat.getStandard()
                    + ", Cena biletu: " + singlePrice + " PLN");
        }
        double totalPriceNowak = reservationNowak.getTotalPrice();
        System.out.println("Razem do zapłaty za bilety: " + totalPriceNowak + " PLN");
        System.out.println("Dziękujemy, potwierdzenie wraz z biletem zostało przesłane na adres mailowy");
*/

    }
}