package multiplex;

import java.util.ArrayList;
import java.util.List;


public class CinemaHall {
    private final String hallId;
    private final String name;
    private final SeatLayout seatLayout;
    private final List<Screening> screenings;

    public CinemaHall(String hallId, String name,SeatLayout seatLayout) {
        this.hallId = hallId;
        this.name = name;
        this.seatLayout = seatLayout;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public String getHallId() {
        return hallId;
    }

    public String getName() {
        return name;
    }

    public SeatLayout getSeatLayout() {
        return seatLayout;
    }

}


