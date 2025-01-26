package multiplex;

import java.time.LocalDate;
import java.time.LocalTime;

public class StandardScreening extends Screening {

    public StandardScreening(Movie movie, LocalDate date, LocalTime startTime, LocalTime endTime, CinemaHall hall) {
        super(movie, date, startTime, endTime, hall);
    }

    public double calculateTicketPrice(Seat seat) {

        return seat.getStandard().getBasePrice();
    }
}
