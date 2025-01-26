package multiplex;


import java.util.List;

public class SeatReservation {

    public Reservation createReservation(Screening screening, Kinoman user, List<String> seatIds) {
        String reservationId = generateReservationId();
        Reservation reservation = new Reservation(reservationId, screening, user);

        for (String seatId : seatIds) {
            Seat seat = findSeatById(screening, seatId);
            if (seat != null && !seat.isReserved()) {

                seat.reserve();

                Ticket ticket = new Ticket(screening, seat, user);
                reservation.addTicket(ticket);
            }
        }

        if (user != null) {
            user.addReservation(reservation);
        }

        double totalPrice = reservation.getTotalPrice();
        System.out.println("Utworzono rezerwację " + reservationId
                + " dla seansu: " + screening.getMovie().getTitle()
                + ", miejsc: " + seatIds.size()
                + ", łączna cena: " + totalPrice + " zł");

        return reservation;
    }

    private Seat findSeatById(Screening screening, String seatId) {
        for (Seat seat : screening.getSeats()) {
            if (seat.getId().equalsIgnoreCase(seatId)) {
                return seat;
            }
        }
        return null;
    }

    private String generateReservationId() {
        return "R" + System.currentTimeMillis();
    }

}
