package multiplex;


public class SeatConfig {
        private final int fromSeat;
        private final int toSeat;
        private final SeatStandard standard;


    public SeatConfig (int fromSeat, int toSeat, SeatStandard standard) {
    this.fromSeat = fromSeat;
    this.toSeat = toSeat;
    this.standard = standard;
    }

    public int getFromSeat() {
        return fromSeat;
    }

    public int getToSeat() {
        return toSeat;
    }

    public SeatStandard getStandard() {
        return standard;
    }
}
