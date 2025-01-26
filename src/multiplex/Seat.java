package multiplex;

public class Seat {

    private final String row;
    private final int seatNumber;
    private final SeatStandard standard;
    private boolean isReserved;

    public Seat(String row, int seatNumber, SeatStandard standard) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.standard = standard;
        this.isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void freeSeat() {
        this.isReserved = false;
    }

    public void reserve() {
        this.isReserved = true;
    }

    public SeatStandard getStandard() {
        return standard;
    }

    public String getRow() {
        return row;
    }

    public int getSeatNumber() {
        return  seatNumber;
    }

    public String getId() {
        return row + seatNumber;
    }

}
