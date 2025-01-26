package multiplex;

public class Ticket {

    private final Screening screening;
    private final Seat seat;
    private final Kinoman owner;
    private final double price;

    public Ticket(Screening screening, Seat seat, Kinoman owner) {
        this.screening = screening;
        this.seat = seat;
        this.owner = owner;
        this.price = screening.calculateTicketPrice(seat);
    }

    public double getPrice() {
        return price;
    }

    public Kinoman getOwner() {
        return owner;
    }

    public Screening getScreening() {
        return screening;
    }

    public Seat getSeat() {
        return seat;
    }
}
