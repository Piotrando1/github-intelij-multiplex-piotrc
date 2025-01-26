package multiplex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private final String reservationId;
    private final Screening screening;
    private final Kinoman user;
    private final List<Ticket> tickets;
    private final LocalDateTime creationTime;

    public Reservation(String reservationId, Screening screening, Kinoman user) {
        this.reservationId = reservationId;
        this.screening = screening;
        this.user = user;
        this.tickets = new ArrayList<>();
        this.creationTime = LocalDateTime.now();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public double getTotalPrice() {
        double sum = 0.0;
        for (Ticket ticket : tickets) {
            sum += ticket.getPrice();
        }
        return sum;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Screening getScreening() {
        return screening;
    }

    public Kinoman getUser() {
        return user;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

