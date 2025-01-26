package multiplex;

import java.util.ArrayList;
import java.util.List;

public class Kinoman {

    private final String userId;
    private final String name;
    private final String email;
    private final List<Reservation> reservations;

    public Kinoman(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
