package multiplex;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private final String cinemaId;
    private final String nameCinema;
    private final String address;
    private final String cityName;
    private final List<CinemaHall> halls;

    public Cinema(String cinemaId, String nameCinema, String address, String cityName) {
        this.cinemaId = cinemaId;
        this.nameCinema = nameCinema;
        this.address = address;
        this.cityName = cityName;
        this.halls = new ArrayList<>();
    }

    public void addHall (CinemaHall hall) {
    halls.add(hall);
    }

    public List<CinemaHall> getHalls() {
        return halls;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public String getAddress() {
        return address;
    }

    public String getCityName() {
        return cityName;
    }

    public void listAllHalls() {
        System.out.println("Cinema: " + nameCinema + " (Cinema ID: " + cinemaId + " City: " + cityName);
        for (CinemaHall hall: halls) {
            System.out.println(("Sala: " + hall.getHallId() + " - " + hall.getName()));
        }
    }


    public String toString() {
        return "Cinema: " + nameCinema
                + ", ID: " + cinemaId
                + ", Address: " + address
                + ", City: " + cityName
                + ", Number of halls: " + halls.size();
    }

    public String getNameCinema() {
        return nameCinema;
    }
}

