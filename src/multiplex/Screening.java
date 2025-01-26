package multiplex;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//Glowna klasa dla seansu filmowego, tutaj przechowuje film date godzine sale oraz liste siedzen. wykorzystuje tutaj polimorfizm do kalkulowania roznych cen

public abstract class Screening {
    protected Movie movie;
    protected LocalDate date;
    protected LocalTime startTime;
    protected LocalTime endTime;
    protected CinemaHall hall;
    protected List<Seat> seats;

    public Screening(Movie movie, LocalDate date, LocalTime startTime, LocalTime endTime, CinemaHall hall) {
        this.movie = movie;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.seats = new ArrayList<>();
    }


    public abstract double calculateTicketPrice(Seat seat);


    public void initSeatsLayout() {
        // 1. Pobieramy seatLayout z hali
        SeatLayout layout = hall.getSeatLayout();

        // 2. Iterujemy po rzędach i miejscach w rzędzie
        for (String rowLetter : layout.getRows()) {
            for (int seatNum = 1; seatNum <= layout.getSeatsPerRow(); seatNum++) {
                // 3. Pytamy layout o strefę (SeatStandard)
                SeatStandard std = layout.getStandardFor(rowLetter, seatNum);

                // 4. Tworzymy obiekt Seat i dodajemy do listy seats
                Seat seat = new Seat(rowLetter, seatNum, std);
                seats.add(seat);
            }
        }
    }


    public Movie getMovie() {
        return movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}