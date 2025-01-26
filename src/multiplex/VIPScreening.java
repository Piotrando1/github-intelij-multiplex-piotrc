package multiplex;

import java.time.LocalDate;
import java.time.LocalTime;

public class VIPScreening extends Screening {

    public VIPScreening(Movie movie, LocalDate date, LocalTime startTime, LocalTime endTime, CinemaHall hall) {
        super(movie, date, startTime, endTime, hall);
    }

    public double calculateTicketPrice(Seat seat) {
        return seat.getStandard().getBasePrice() + 15.0;
    }
}
